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

public class HelloMessageDialog extends JFrame {

    public HelloMessageDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Klik!");
        button.setBounds(130, 100, 100, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Macam-macam jenis mesaage
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Hello bitch", "Error", JOptionPane.ERROR_MESSAGE, null);
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Hello bitch", "Error", JOptionPane.INFORMATION_MESSAGE, null);
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Hello bitch", "Error", JOptionPane.WARNING_MESSAGE, null);
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Hello bitch", "Error", JOptionPane.QUESTION_MESSAGE, null);
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Hello bitch", "Error", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

        this.add(button);

        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloMessageDialog h = new HelloMessageDialog();
                h.setVisible(true);
            }
        });
    }

}
