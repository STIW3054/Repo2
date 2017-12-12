package com.team2.clonerepo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class SelectFolder extends JPanel implements ActionListener {

    private JFileChooser chooser;
    private String path;

    public SelectFolder() {
        chooser = new JFileChooser();
    }

    public SelectFolder displayDialog() {
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Please select folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //chooser.getCurrentDirectory());
            path = chooser.getSelectedFile().toString();

        } else {
            System.out.println("No Selection. Exiting... ");
            System.exit(0);
        }
        return this;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //No action here. Thanks
    }
}
