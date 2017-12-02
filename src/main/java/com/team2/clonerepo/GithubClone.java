package com.team2.clonerepo;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.impl.StaticLoggerBinder;  //It's look useless but it is needed for GitAPIException.

public class GithubClone implements Runnable {

    private String urlAccount;
    private String clonePath;
    private String nameAccount;

    public static LinkedList<String> timetaken; //Only log for successful clone
    public static String[] noncompletedarray;
    public static String[] completedarray;

    public GithubClone(String urlAccount, String clonePath, String nameAccount) {
        this.urlAccount = urlAccount;
        this.clonePath = clonePath;
        this.nameAccount = nameAccount;
    }

    public static void cloneNow(String[] urlAccountList, String clonePath, String[] nameAccountList) {
        
        LinkedList<String> completed = new LinkedList<>();
        LinkedList<String> noncompleted = new LinkedList<>();

        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(urlAccountList.length);

        long[] start = new long[urlAccountList.length];

        for (int i = 0; i < urlAccountList.length; i++) {
            Runnable worker = new GithubClone(urlAccountList[i], clonePath, nameAccountList[i]);
            start[i] = System.currentTimeMillis();
            Future future = executor.submit(worker);
            list.add(future);
        }
        executor.shutdown();
        timetaken = new LinkedList<>();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).isDone()) {
                        noncompleted.add(nameAccountList[i]);
                        list.get(i).cancel(true);
                        //System.out.println("dah lebih 10 saat iaitu: " + nameAccountList[i]);
                        //Buat program untuk masuk dalam log kata kita cancel
                        //Senaraikan lah maklumat yg patut dalam log contohnya:
                        //Repo name (iaitu matric number) dan tarikh dan jam beserta saat
                        //System.out.println("Jumlah masa ambik: " + (System.currentTimeMillis() - start[i]) + "ms");
                    } else {
                        completed.add(nameAccountList[i]);
                        timetaken.add("" + (System.currentTimeMillis() - start[i]));
                    }
                }

                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        noncompletedarray = new String[noncompleted.size()];
        completedarray = new String[completed.size()];

        for (int i = 0; i < noncompletedarray.length; i++) {
            noncompletedarray[i] = noncompleted.get(i).toString();
        }
        for (int i = 0; i < completedarray.length; i++) {
            completedarray[i] = completed.get(i).toString();
        }

    }

    @Override
    public void run() {
        CloneCommand cc = Git.cloneRepository();

        File localPath = null;
        localPath = new File(clonePath + File.separator + nameAccount);

        try {
            CloneCommand cc2 = cc.setURI(urlAccount);
            Repository repo = cc2.getRepository();
            cc2.setDirectory(localPath).call();

        } catch (GitAPIException ex) {
            //ex.printStackTrace();
            //ex.getMessage();

            //Buat program untuk log error message (contoh: connection timeout)
        }
    }

}
