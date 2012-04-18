/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp;

import javax.swing.UIManager;
import se.etsf01.aesp.gui.*;

/**
 * The entry point of the AESP tool
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This sets the look and feel of all UI controls to native when 
        //not using Mac OS X.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex) {
            System.out.println("Unsupported style, ignoring.");
        }
        
        new EffortGui(); //ugly solution I know, but it works fine!
    }
}
