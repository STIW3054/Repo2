package com.repo2.runrepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunAdapter {

    public static final int TERMINATIONTIME = 7;

    public void doRunJavaFile(String[] listFile) {
        if (listFile.length == 0) {
            System.out.println("There is no cloned repository. System exiting...");
            System.exit(0);
        }
        
        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(listFile.length);
        for (int i = 0; i < listFile.length; i++) {
            Future future = executor.submit(new RunCode(listFile[i]));
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
            executor.shutdownNow();
        }
    }

}
