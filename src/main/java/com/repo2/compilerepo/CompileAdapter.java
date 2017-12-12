package com.repo2.compilerepo;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompileAdapter {

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
        ExecutorService executor = Executors.newFixedThreadPool(listFile.length);
        for (int i = 0; i < listFile.length; i++) {
            executor.submit(new CompileCode(listFile[i]));

        }
        executor.shutdown();
    }
}
