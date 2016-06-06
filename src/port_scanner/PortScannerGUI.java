/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package port_scanner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Connor Pakenham D00166741
 */
public class PortScannerGUI {
    
    private static void createAndShowGUI() {
        //Create Frame
        JFrame frame = new JFrame("Port Scanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 700);
        
        //Create Label
        JLabel hostLabel = new JLabel("Host IP/Name:");
        hostLabel.setLocation(0, 0);
        
        //Add Components
        frame.add(hostLabel);
        
        //Display the Frame
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
