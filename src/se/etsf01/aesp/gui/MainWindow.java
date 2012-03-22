package se.etsf01.aesp.gui;

import java.awt.*;
import javax.swing.*;

/**
 * The Main Window
 */
public class MainWindow extends JFrame 
{
    public MainWindow()
    {
        super("ETSF01: AESP Algorithm");
        setPreferredSize(new Dimension(640, 480));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //TODO: use the MVC pattern!
    }
    
}
