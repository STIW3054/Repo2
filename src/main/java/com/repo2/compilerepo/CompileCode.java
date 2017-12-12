package com.repo2.compilerepo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompileCode implements Runnable {

    private File file;
    private String pathFile;

    private String firstCommand;
    private String secondCommand;

    public CompileCode(String pathFile) {
        file = new File(pathFile);
        this.pathFile = pathFile;
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
                    int dotjava = dirXPackage.lastIndexOf(".java");
                    String namaClass = dirXPackage.substring(slashLast + 1, dotjava);
                    String namaFile = dirXPackage.substring(slashLast + 1);

                    firstCommand = dirXPackage.replace(namaFile, "");
                    secondCommand = packageDir + File.separator + namaFile;

                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompileCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompileCode.class.getName()).log(Level.SEVERE, null, ex);
        }

        int slashLast = pathFile.lastIndexOf(File.separator);
        String namaFile = pathFile.substring(slashLast + 1); // Command 2
        String path = pathFile.replace(namaFile, "");

        firstCommand = path;
        secondCommand = namaFile;

        return false;
    }

    public void runTerminal(String path, String commandString, String action) {

        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"" + path + "\" && " + action + " " + commandString);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (detectPackageType()) {
            runTerminal(firstCommand, secondCommand, "javac");
        } else {
            runTerminal(firstCommand, secondCommand, "javac -d . ");
        }
    }

}
