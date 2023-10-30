/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7_BiodataAll;

/**
 *
 * @author ridho
 */
import java.awt.Font;
import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DataWindow extends JFrame {

    public DataWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        //        ===================
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(DataWindow.this,
                        "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0); // Tutup aplikasi jika user memilih "Ya"
                }
            }
        });

//        ===================
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Form Biodata");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        headerPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering header

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton tambahBtn = new JButton("Tambah Data");
        JButton editBtn = new JButton("Edit");
        JButton hapusBtn = new JButton("Hapus");
        JButton txtBtn = new JButton("Simpan Ke .Txt");

//====================
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(tambahBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(editBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(hapusBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(txtBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));

//=================== Membuat JPanel luar untuk menambahkan margin ke tablePanel
        JPanel tableMarginPanelBtn = new JPanel();
        tableMarginPanelBtn.setLayout(new BoxLayout(tableMarginPanelBtn, BoxLayout.PAGE_AXIS));
        tableMarginPanelBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableMarginPanelBtn.add(buttonPanel);
        tableMarginPanelBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering buttons

//================================ margin
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.PAGE_AXIS));
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        tablePanel.add(scrollableTable);
        JPanel tableMarginPanel = new JPanel();
        tableMarginPanel.setLayout(new BoxLayout(tableMarginPanel, BoxLayout.PAGE_AXIS));
        tableMarginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableMarginPanel.add(tablePanel);
        tableMarginPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Mengatur posisi tengah untuk tableMarginPanel

        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

//=================== Aksi Btn
        tambahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat dan menampilkan form tambah data ketika tombol "Tambah Data" diklik

                HelloTable tambahDataForm = new HelloTable();
                tambahDataForm.setVisible(true);
            }
        });

//================== akhir Aksi Btn
        this.add(headerPanel);
        this.add(tableMarginPanelBtn);
        this.add(tableMarginPanel);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataWindow dataWindow = new DataWindow();
            dataWindow.setVisible(true);
        });
    }
}
