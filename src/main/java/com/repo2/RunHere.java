package com.repo2;

import com.itextpdf.text.DocumentException;
import com.repo2.clonerepo.GithubAccount;
import com.repo2.clonerepo.GithubClone;
import com.repo2.clonerepo.SelectFolder;
import com.repo2.compilerepo.CompileAdapter;
import com.repo2.compilerepo.CompileCode;
import com.repo2.compilerepo.ListFile;
import com.repo2.generateexcel.ExcelAdapter;
import com.repo2.generatepdf.GeneratePDF;
import com.repo2.runrepo.RunAdapter;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunHere {

    public static final String LISTPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "repo2" + File.separator + "listname" + File.separator + "List.json";

    public static void main(String[] args) throws DocumentException, IOException {

        //Commment the line below for production
        //GithubClone.TERMINATIONTIME = 10;

        String nameAccountList[];
        String urlAccountList[];

        String uniqueFolder = "" + System.nanoTime();

        SelectFolder selectfolder = new SelectFolder();
        final String CLONEPATH = selectfolder.displayDialog().getPath() + File.separator + uniqueFolder + File.separator + "STIW3054-A171";

        System.out.println("Cloning Repository.....");

        GithubAccount githubaccount = new GithubAccount(LISTPATH);
        nameAccountList = githubaccount.getNameAccountList();
        urlAccountList = githubaccount.getURLAccountList();

        GithubClone.cloneNow(urlAccountList, CLONEPATH, nameAccountList);
        String repoCompleted[] = GithubClone.completedarray;
        String repoNonCompleted[] = GithubClone.noncompletedarray;

        System.out.println("Done!");

        CompileAdapter compileadapter = new CompileAdapter();
        String listFile[] = compileadapter.getListFile(CLONEPATH, nameAccountList);

        System.out.println("Compiling Java Files...");
        compileadapter.doCompileJavaFile(listFile);
        System.out.println("Done!");
        System.out.println("Running Bytecode....");
        RunAdapter runadapter = new RunAdapter();
        runadapter.doRunJavaFile(listFile);
        System.out.println("Done!");
        
        System.out.println("Generating PDF Files...");
        GeneratePDF gen = new GeneratePDF();
        System.out.println("Done!");
        
        System.out.println("Generate Excel Files...");
        ExcelAdapter.generate(listFile);
        System.out.println("Done!");
        
        System.out.println("Completed");
        System.exit(0);
        
    }
}
