package com.team2;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.impl.StaticLoggerBinder;

public class RepoClone {

    private static final String REMOTE_URL = "https://github.com/MarJr/phoneDirectory.git";

    public static void main(String[] args) throws IOException, GitAPIException {

        File localPath = new File(System.getProperty("user.dir") + File.separator + "cloneFile");

        System.out.println("Cloning from " + REMOTE_URL + " to " + localPath);
        try (Git result = Git.cloneRepository()
                .setURI(REMOTE_URL)
                .setDirectory(localPath)
                .call()) {
            System.out.println("Done Clone: " + result.getRepository().getDirectory());
        }
    }
}
