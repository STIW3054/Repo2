package com.team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.impl.StaticLoggerBinder;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "team2" + File.separator + "listname" + File.separator + "List.json");
        System.out.println(System.getProperty("user.dir") + File.separator + "List.json");
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonObject = (JSONArray) jsonParser.parse(reader);
        
        String firstName = (String) jsonObject.get(0);
        System.out.println("The first name is: " + firstName);
        System.exit(0);

        Git git = null;
        try {
            CloneCommand cr = Git.cloneRepository();
            for (int i = 0; i < gituri.length; i++) {
                CloneCommand suri = cr.setURI(gituri[i]);
                Repository repo = suri.getRepository();
                suri.setDirectory(localPath).call();

            }
        } catch (GitAPIException ex) {
            ex.printStackTrace();
        }
    }

}
