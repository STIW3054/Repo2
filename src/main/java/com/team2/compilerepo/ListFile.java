package com.team2.compilerepo;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class ListFile implements Callable<String[]> {

    public LinkedList<String> filename;
    private File folder;

    public ListFile(String pathFolder) {
        filename = new LinkedList<>();
        this.folder = new File(pathFolder);
    }

    public ListFile getList(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                getList(fileEntry);
            } else {
                filterOutNonJavaFiles(fileEntry.getAbsolutePath());
            }
        }
        return this;
    }

    public String getFileExtension(String fullName) {
        
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public void filterOutNonJavaFiles(String absolutePath) {

        if (getFileExtension(absolutePath).equalsIgnoreCase("Java")){
            filename.add(absolutePath);
        }
        
    }

    public String[] toArray() {
        String[] list = new String[filename.size()];
        for (int i = 0; i < filename.size(); i++) {
            list[i] = filename.get(i);
        }
        return list;
    }

    @Override
    public String[] call() throws Exception {
        getList(folder);
        return toArray();
    }

}
