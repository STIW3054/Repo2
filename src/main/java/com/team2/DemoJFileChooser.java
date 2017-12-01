package com.team2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class DemoJFileChooser extends JPanel
        implements ActionListener {

    JButton go;

    JFileChooser chooser;
    String choosertitle;

    public DemoJFileChooser() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }

    }

    public static void main(String s[]) {
        DemoJFileChooser panel = new DemoJFileChooser();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //No action here. Thanks
    }
}
