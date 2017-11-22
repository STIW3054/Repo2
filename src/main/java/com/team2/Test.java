package com.team2;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.impl.StaticLoggerBinder;


public class Test {

    public static void main(String[] args) {

        File localPath = new File(System.getProperty("user.dir") + File.separator + "cubaan");

        try {
            Git git = Git.cloneRepository()
                    .setURI("https://github.com/wzul/Billplz-for-Minisite.git")
                    .setDirectory(localPath)
                    .call();
        } catch (GitAPIException ex) {
            ex.printStackTrace();
        }
    }
}
