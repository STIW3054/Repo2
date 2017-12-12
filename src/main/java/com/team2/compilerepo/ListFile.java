package com.team2.compilerepo;

import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class ListFile implements Callable {

    private LinkedList<String> filename;
    private File folder;

    public ListFile(File folder) {
        filename = new LinkedList<>();
        this.folder = folder;
    }

    public ListFile getList(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getList(fileEntry);
            } else {
                filename.add(fileEntry.getAbsolutePath());
            }
        }
        return this;
    }

    @Override
    public String[] call() throws Exception {
        getList(folder);
        String[] list = new String[filename.size()];
        for (int i=0; i<filename.size(); i++){
            list[i] = filename.get(i);
        }
        
        return list;
    }

}
