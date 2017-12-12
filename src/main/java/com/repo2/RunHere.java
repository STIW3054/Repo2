<<<<<<< HEAD:src/main/java/com/repo2/RunHere.java
package com.repo2;

import com.repo2.clonerepo.GithubAccount;
import com.repo2.clonerepo.GithubClone;
import com.repo2.clonerepo.SelectFolder;
import com.repo2.compilerepo.CompileAdapter;
import com.repo2.compilerepo.CompileCode;
import com.repo2.compilerepo.ListFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunHere {

    public static final String LISTPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "team2" + File.separator + "listname" + File.separator + "List.json";

    public static void main(String[] args) {

        String nameAccountList[];
        String urlAccountList[];

        String uniqueFolder = "" + System.nanoTime();

        SelectFolder selectfolder = new SelectFolder();
        final String CLONEPATH = selectfolder.displayDialog().getPath() + File.separator + uniqueFolder + File.separator + "STIW3054-A171";

        GithubAccount githubaccount = new GithubAccount(LISTPATH);
        nameAccountList = githubaccount.getNameAccountList();
        urlAccountList = githubaccount.getURLAccountList();

        GithubClone.cloneNow(urlAccountList, CLONEPATH, nameAccountList);
        String repoCompleted[] = GithubClone.completedarray;
        String repoNonCompleted[] = GithubClone.noncompletedarray;
        
        CompileAdapter compileadapter = new CompileAdapter();
        String listFile[] = compileadapter.getListFile(CLONEPATH, nameAccountList);
        
        compileadapter.doCompileJavaFile(listFile);

    }
}
=======
package com.team2;

import com.team2.clonerepo.GithubAccount;
import com.team2.clonerepo.GithubClone;
import com.team2.clonerepo.SelectFolder;
import com.team2.compilerepo.CompileCode;
import com.team2.compilerepo.ListFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunHere {

    public static final String LISTPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "team2" + File.separator + "listname" + File.separator + "List.json";

    public static void main(String[] args) {

        String nameAccountList[];
        String urlAccountList[];
        
        String uniqueFolder = "" + System.nanoTime();

        SelectFolder selectfolder = new SelectFolder();
        final String CLONEPATH = selectfolder.displayDialog().getPath() + File.separator + uniqueFolder + File.separator + "STIW3054-A171";

        GithubAccount githubaccount = new GithubAccount(LISTPATH);
        nameAccountList = githubaccount.getNameAccountList();
        urlAccountList = githubaccount.getURLAccountList();

        GithubClone.cloneNow(urlAccountList, CLONEPATH, nameAccountList);
        String repoCompleted[] = GithubClone.completedarray;
        String repoNonCompleted[] = GithubClone.noncompletedarray;
        
        ListFile a = new ListFile();
    }
}
>>>>>>> master:src/main/java/com/team2/RunHere.java
