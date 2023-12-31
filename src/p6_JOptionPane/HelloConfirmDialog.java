/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p6_JOptionPane;

/**
 *
 * @author ridho
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloConfirmDialog extends JFrame {

    public HelloConfirmDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Exit");
        button.setBounds(130, 100, 100, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(HelloConfirmDialog.this,
                        "Apakah anda yakin ingin keluar aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(HelloConfirmDialog.this, "Anda Menekan tombol No");
                }
            }
        });

        this.add(button);

        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloConfirmDialog h = new HelloConfirmDialog();
                h.setVisible(true);
            }
        });
    }
}
