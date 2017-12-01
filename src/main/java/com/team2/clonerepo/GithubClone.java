package com.team2.clonerepo;

import java.io.File;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.impl.StaticLoggerBinder;  //It's look useless but it is needed for GitAPIException.

public class GithubClone {

    private Git git;
    private CloneCommand cc;
    private String[] accountList;

    public GithubClone(String[] urlAccountList) {
        cc = Git.cloneRepository();
        this.accountList = urlAccountList;
    }

    public GithubClone() {

    }

    public void setAccountList(String[] accountList) {
        cc = Git.cloneRepository();
        this.accountList = accountList;
    }

    public void cloneNow(String clonepath, String[] nameAccountList) {
        File localPath = null;
        for (int i = 0; i < accountList.length; i++) {
            localPath = new File(clonepath + File.separator + nameAccountList[i]);
            try {
                CloneCommand cc2 = cc.setURI(accountList[i]);
                Repository repo = cc2.getRepository();
                cc2.setDirectory(localPath).call();

            } catch (GitAPIException ex) {
                ex.printStackTrace();
            }
        }
    }
}
