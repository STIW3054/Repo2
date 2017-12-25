package com.repo2.compilerepo;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompileAdapter {

    public static final int TERMINATIONTIME = 7;

    public String[] getListFile(String clonePath, String[] nameAccountList) {

        List<Future<String[]>> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(nameAccountList.length);

        for (int i = 0; i < nameAccountList.length; i++) {
            Future future = executor.submit(new ListFile(clonePath + File.separator + nameAccountList[i]));
            list.add(future);
        }

        LinkedList<String> allJavaFileName = new LinkedList<>();

        for (Future<String[]> fut : list) {
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                for (String filename : fut.get()) {
                    allJavaFileName.add(filename);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        String[] javaFileNameArray = new String[allJavaFileName.size()];

        for (int i = 0; i < allJavaFileName.size(); i++) {
            javaFileNameArray[i] = allJavaFileName.get(i);
        }

        return javaFileNameArray;
    }

    public void doCompileJavaFile(String[] listFile) {
        if (listFile.length == 0) {
            System.out.println("There is no cloned repository. System exiting...");
            System.exit(0);
        }
        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(listFile.length);
        for (int i = 0; i < listFile.length; i++) {
            Future future = executor.submit(new CompileCode(listFile[i]));
            list.add(future);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TERMINATIONTIME, TimeUnit.SECONDS)) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).cancel(true);
                }
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
        }
    }
}
