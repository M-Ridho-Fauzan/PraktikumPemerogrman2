/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ridho
 */
public class Tugas extends JFrame {

    public Tugas() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        panel.setSize(300, 400);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
//==========================

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nama:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 60;
        panel.add(new JTextField(), gbc);

//=========================
        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.ipady = 20;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Button 3"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JButton("Button 4"), gbc);

//==========================  
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        panel.add(new JButton("Button 5"), gbc);

//==========================
        controlPanel.add(panel);

        this.setLayout(new GridLayout(2, 1));
        this.add(headerLabel);
        this.add(controlPanel);
        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas h = new Tugas();
                h.setVisible(true);
            }
        });
    }
}
