/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p6_Tugas;

/**
 *
 * @author ridho
 */
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloTable extends JFrame {

    public HelloTable() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        ===================
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(HelloTable.this,
                        "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0); // Tutup aplikasi jika user memilih "Ya"
                }
            }
        });

//        =========
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(HelloTable.this,
                        "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0); // Tutup aplikasi jika user memilih "Ya"
                }
                // Tidak ada tindakan jika user memilih "Tidak"
            }
        });

//        ===================
        JLabel labelInput1 = new JLabel("Nama:");
        labelInput1.setBounds(15, 40, 450, 10);

        JTextField textField1 = new JTextField();
        textField1.setBounds(15, 60, 450, 30);

//        =================
        JLabel labelInput2 = new JLabel("No Telp:");
        labelInput2.setBounds(15, 100, 450, 15);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 120, 450, 30);

//        =================
        JLabel labelRadio = new JLabel("Jenis Kelamin: ");
        labelRadio.setBounds(15, 160, 450, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki");
        radioButton1.setBounds(15, 175, 450, 30);

        JRadioButton radioButton2 = new JRadioButton("Wanita");
        radioButton2.setBounds(15, 200, 450, 30);

        JRadioButton radioButton3 = new JRadioButton("Custom");
        radioButton3.setBounds(15, 225, 450, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

//       ==========================
        JCheckBox checkBox = new JCheckBox("WNA (Warga Negara Asing)");
        checkBox.setBounds(15, 255, 450, 30);

//       ==========================
        JButton button = new JButton("Simpan");
        button.setBounds(15, 295, 100, 40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 350, 450, 200);

        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

//       ===========================
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                if (radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisMember = radioButton2.getText();
                }
                if (radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText();
                }

                String nama = textField1.getText();
                String noTelp = textField2.getText();
                boolean isWNA = checkBox.isSelected();

                String wnaLabel = isWNA ? "WNA" : "Bukan WNA";

                tableModel.add(new ArrayList<>(Arrays.asList(nama, noTelp, jenisMember, wnaLabel)));

                // Mengosongkan form
                textField1.setText(""); // Mengosongkan field nama
                textField2.setText(""); // Mengosongkan field noTelp
                radioButton1.setSelected(false); // Mengosongkan pilihan jenisMember
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
                checkBox.setSelected(false); // Mengosongkan checkbox
            }
        });

        this.add(button);
        this.add(textField1);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(scrollableTable);
        this.add(checkBox);

        this.setSize(500, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTable h = new HelloTable();
                h.setVisible(true);
            }
        });
    }
}
