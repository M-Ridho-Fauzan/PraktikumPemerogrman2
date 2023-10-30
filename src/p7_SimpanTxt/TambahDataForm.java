/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7_SimpanTxt;

/**
 *
 * @author ridho
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TambahDataForm {

    private DataWindow dataWindow;
    private MyTableModel tableModel;
    private JFrame frame;

    public TambahDataForm(DataWindow dataWindow, MyTableModel tableModel) {
        this.dataWindow = dataWindow;
        this.tableModel = tableModel;

        frame = new JFrame("Tambah Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));

        JLabel namaLabel = new JLabel("Nama:");
        JTextField namaField = new JTextField(20);
        JLabel nimLabel = new JLabel("NIM:");
        JTextField nimField = new JTextField(10);

        inputPanel.add(namaLabel);
        inputPanel.add(namaField);
        inputPanel.add(nimLabel);
        inputPanel.add(nimField);

        JButton tambahButton = new JButton("Tambah Data");
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String nim = nimField.getText();

                Data newData = new Data(nama, nim);
                dataWindow.addData(newData);
                tableModel.addData(newData); // Menambahkan data ke model tabel

                // Kosongkan field input
                namaField.setText("");
                nimField.setText("");
            }
        });

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(tambahButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }
}
