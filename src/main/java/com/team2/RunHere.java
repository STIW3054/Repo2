package com.team2;

import com.team2.clonerepo.GithubAccount;
import com.team2.clonerepo.GithubClone;
import java.io.File;

public class RunHere {

    public static final String LISTPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "team2" + File.separator + "listname" + File.separator + "List.json";
    public static final String CLONEPATH = System.getProperty("user.dir") + File.separator + "cubaan";
    
    public static void main(String[] args) {
        
        String nameAccountList[];
        String urlAccountList[];
        
        GithubAccount githubaccount = new GithubAccount(LISTPATH);
        nameAccountList = githubaccount.getNameAccountList();
        urlAccountList = githubaccount.getURLAccountList();
        
        GithubClone githubclone = new GithubClone(urlAccountList);
        githubclone.cloneNow(CLONEPATH);
        
    }
}
