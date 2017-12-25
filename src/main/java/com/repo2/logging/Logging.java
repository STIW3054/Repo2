package com.repo2.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logging implements Runnable {

    private File file;
    private String text;

    public Logging(File file) {
        this.file = file;
    }

    public Logging(File file, String text) {
        this.text = text;
        this.file = file;
    }

    public Logging setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public void run() {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fileWriter);
            bw.write(text);
            bw.newLine();
            bw.close();
            fileWriter.close();
        } catch (IOException ex) {
        }
    }

}
