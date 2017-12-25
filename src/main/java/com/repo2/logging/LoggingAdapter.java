package com.repo2.logging;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingAdapter {

    public static final String CLONELOG = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "clone.log";
    public static final String COMPILELOG = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "compile.log";
    public static final String RUNLOG = System.getProperty("user.dir") + File.separator + "STIW3054-Result" + File.separator + "run.log";

    public static void cloneLog(String text) {
        log(text, CLONELOG);
    }

    public static void compileLog(String text) {
        log(text, COMPILELOG);
    }

    public static void runLog(String text) {
        log(text, RUNLOG);
    }

    private static void log(String text, String clonePath) {
        File file = new File(clonePath);
        Logging cloning = new Logging(file);
        cloning.setText(getTime() + " : " + text);
        new Thread(cloning).start();
    }

    public static String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date); //2016/11/16 12:08:43
    }
}
