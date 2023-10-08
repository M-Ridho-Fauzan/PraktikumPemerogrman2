/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p3;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ridho
 */
public class TugasP3 extends JFrame {

    private boolean checkBoxSelected;

    public TugasP3() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

//      =====================  
        JLabel labelNohp = new JLabel("No Hp:");
        labelNohp.setBounds(15, 90, 350, 15);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 110, 350, 30);

//        ===================
        JLabel labelRadio = new JLabel("Jenis Kelamin: ");
        labelRadio.setBounds(15, 160, 350, 10);

//        ===================
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 180, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan", true);
        radioButton2.setBounds(15, 210, 350, 30);

        JRadioButton radioButton3 = new JRadioButton("Khusus", true);
        radioButton3.setBounds(15, 240, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

//       ==========================
        JCheckBox checkBox = new JCheckBox("WNA (Warga Negara Asing)");
        checkBox.setBounds(15, 275, 350, 30);

//       ==========================
        JButton button = new JButton("Simpan");
        button.setBounds(15, 320, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 370, 650, 120);

//        =========================
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

//       ===========================
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                if (radioButton3.isSelected()) {
                    jenisKelamin = radioButton3.getText();
                }

                String nama = textField.getText();
                String noHp = textField2.getText();
                txtOutput.append("Nama           : " + nama + "\n");
                txtOutput.append("No hp           : " + noHp + "\n");
                txtOutput.append("Jenis Kelamin  : " + jenisKelamin + "\n");
                if (checkBoxSelected) {
                    txtOutput.append("WNA (Outsider)  : Iya Outsider" + "\n");
                } else {
                    txtOutput.append("WNA (Outsider)  : Bukan Outsider" + "\n");
                }
                textField.setText("");
                txtOutput.append("============================================" + "\n");
            }
        });

        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelNama);
        this.add(labelNohp);
        this.add(txtOutput);
        this.add(checkBox);

        this.setSize(700, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TugasP3 h = new TugasP3();
                h.setVisible(true);
            }
        });
    }
}
