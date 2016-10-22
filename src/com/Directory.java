/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Directory extends JPanel
   implements ActionListener{
    String directory;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
    
    public String FindDirectory(){
        JFileChooser chooser = new JFileChooser();
        String title = null;
        chooser.setCurrentDirectory(new java.io.File(".")); 
        
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(this)  == JFileChooser.APPROVE_OPTION) { 
            this.directory = chooser.getCurrentDirectory().getPath();      
            }
        else {
            System.out.println("No Selection ");
        }
     
        return directory;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
