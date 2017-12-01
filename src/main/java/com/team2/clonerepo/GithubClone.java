package com.team2.clonerepo;

import java.io.File;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.impl.StaticLoggerBinder;  //It's look useless but it is needed for GitAPIException.

public class GithubClone implements Runnable {

    private String urlAccount;
    private String clonePath;
    private String nameAccount;

    public GithubClone(String urlAccount, String clonePath, String nameAccount) {
        this.urlAccount = urlAccount;
        this.clonePath = clonePath;
        this.nameAccount = nameAccount;
    }

    public void cloneNow(String clonePath, String nameAccount) {
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
        }
    }

    @Override
    public void run() {
        cloneNow(clonePath, nameAccount);
    }

}
