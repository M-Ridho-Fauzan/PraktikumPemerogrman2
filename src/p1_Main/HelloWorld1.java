/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1_Main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ridho
 */
public class HelloWorld1 {
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hello World Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.red);

//        frame.pack();
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
