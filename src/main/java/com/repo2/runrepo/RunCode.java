package com.repo2.runrepo;

import com.repo2.logging.LoggingAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunCode implements Runnable {

    private File file;
    private String pathFile;

    private String firstCommand;
    private String secondCommand;

    public RunCode(String pathFile) {
        file = new File(pathFile);
        this.pathFile = pathFile;
        replaceJavaExtension();
    }

    private void replaceJavaExtension() {
        pathFile = pathFile.replace("java", "class");
    }

    public boolean detectPackageType() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                if (line.contains("package ")) {
                    String[] items = line.split(" ");
                    int dotIndex = items[1].lastIndexOf(';');
                    String packagename = items[1].substring(0, dotIndex);
                    String packageDir = packagename.replace(".", File.separator);//Penting

                    String dirXPackage = pathFile.replace(packageDir + File.separator, "");

                    int slashLast = dirXPackage.lastIndexOf(File.separator);
                    int dotjava = dirXPackage.lastIndexOf(".class");
                    String namaClass = dirXPackage.substring(slashLast + 1, dotjava);
                    String namaFile = dirXPackage.substring(slashLast + 1);

                    firstCommand = dirXPackage.replace(namaFile, "");
                    secondCommand = packageDir + File.separator + namaFile;

                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RunCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RunCode.class.getName()).log(Level.SEVERE, null, ex);
        }

        int slashLast = pathFile.lastIndexOf(File.separator);
        String namaFile = pathFile.substring(slashLast + 1); // Command 2
        String path = pathFile.replace(namaFile, "");

        firstCommand = path;
        secondCommand = namaFile;

        return false;
    }

    public void runTerminal(String path, String commandString, String action) {
        commandString = commandString.replace(".class", "");
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"" + path + "\" && " + action + " " + commandString);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String simpanLine = "";
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                } else {
                    simpanLine += line;
                }
            }
            LoggingAdapter.runLog(path + "\" && " + action + " " + commandString);
            LoggingAdapter.runLog(simpanLine);
            LoggingAdapter.runLog("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (detectPackageType()) {
            runTerminal(firstCommand, secondCommand, "java");
        } else {
            runTerminal(firstCommand, secondCommand, "java ");
        }
    }

}
