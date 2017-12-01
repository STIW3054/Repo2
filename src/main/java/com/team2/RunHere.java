package com.team2;

import com.team2.clonerepo.GithubAccount;
import com.team2.clonerepo.GithubClone;
import com.team2.clonerepo.SelectFolder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunHere {

    public static final String LISTPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "team2" + File.separator + "listname" + File.separator + "List.json";

    public static void main(String[] args) throws InterruptedException {

        String nameAccountList[];
        String urlAccountList[];

        SelectFolder selectfolder = new SelectFolder();
        final String CLONEPATH = selectfolder.getPath() + File.separator + System.nanoTime() + File.separator + "STIW3054-A171";

        GithubAccount githubaccount = new GithubAccount(LISTPATH);
        nameAccountList = githubaccount.getNameAccountList();
        urlAccountList = githubaccount.getURLAccountList();

        List<Future> list = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(urlAccountList.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < urlAccountList.length; i++) {
            Runnable worker = new GithubClone(urlAccountList[i], CLONEPATH, nameAccountList[i]);
            start = System.currentTimeMillis();
            Future future = executor.submit(worker);
            list.add(future);
        }
        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isDone()) {
                    list.get(i).cancel(true);
                    //System.out.println("dah lebih 60 saat iaitu: " + nameAccountList[i]);
                    //Buat program untuk masuk dalam log kata kita cancel
                    //Senaraikan lah maklumat yg patut dalam log contohnya:
                    //Repo name (iaitu matric number) dan tarikh dan jam beserta saat
                }
            }
            //System.out.println("Jumlah masa ambik: " + (System.currentTimeMillis() - start) + "ms");
            executor.shutdownNow();
        }

    }
}
