package com.team2.clonerepo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GithubAccount {

    private String listPath;
    private FileReader reader;
    private JSONParser jsonParser;
    private JSONArray jsonObject;
    private String[] accountList;

    public GithubAccount(){
        
    }
    
    public GithubAccount(String listPath) {
        this.listPath = listPath;
        readFile();
        convertToArray();
    }

    public void setPath(String listPath) {
        this.listPath = listPath;
        readFile();
        convertToArray();
    }

    private void readFile() {
        try {
            reader = new FileReader(this.listPath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        jsonParser = new JSONParser();
        try {
            jsonObject = (JSONArray) jsonParser.parse(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }

    private String[] convertToArray() {
        accountList = new String[jsonObject.size()];

        for (int i = 0; i < accountList.length; i++) {
            accountList[i] = jsonObject.get(i).toString();
        }
        return accountList;
    }

    public String[] getNameAccountList() {
        String[] accountList = new String[this.accountList.length];

        for (int i = 0; i < this.accountList.length; i++) {
            int slash = this.accountList[i].lastIndexOf('/');
            accountList[i] = (this.accountList[i].substring(slash + 1, slash + 7));
        }
        return accountList;
    }

    public String[] getURLAccountList() {
        return accountList;
    }
}
