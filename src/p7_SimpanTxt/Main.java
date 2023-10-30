/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7_SimpanTxt;

/**
 *
 * @author ridho
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.*;

public class Main extends JFrame {

    private String txtFilePath = "data.txt";
    private DataWindow dataWindow;

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dataWindow = new DataWindow();
        MyTableModel tableModel = new MyTableModel();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton tambahBtn = new JButton("Tambah Data");
        JButton txtBtn = new JButton("Simpan Ke .Txt");

        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(tambahBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(txtBtn);

        JPanel tableMarginPanelBtn = new JPanel();
        tableMarginPanelBtn.setLayout(new BoxLayout(tableMarginPanelBtn, BoxLayout.PAGE_AXIS));
        tableMarginPanelBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableMarginPanelBtn.add(buttonPanel);
        tableMarginPanelBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering buttons

        JFrame frame = new JFrame("Tabel Data Mahasiswa");

        JPanel tablePanel = new JPanel();

        JTable table = new JTable(tableModel);

        JPanel tableMarginPanel = new JPanel();
        tableMarginPanel.setLayout(new BoxLayout(tableMarginPanel, BoxLayout.PAGE_AXIS));
        tableMarginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableMarginPanel.add(tablePanel);

        this.add(tableMarginPanel, BorderLayout.CENTER);
        this.add(tableMarginPanelBtn, BorderLayout.SOUTH);
        this.add(new JScrollPane(table));// table di window
        this.setSize(450, 650);
        this.setLocationRelativeTo(null);

        tambahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahDataForm tambahDataForm = new TambahDataForm(dataWindow, tableModel); // form tambah data
            }
        });

        txtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSaveFileDialog();
            }
        });

    }

    private void saveDataToTxtFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Data rowData : dataWindow.getDataList()) {
                writer.println(rowData.getNama() + "\t" + rowData.getNim());
            }
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke " + filePath, "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void showSaveFileDialog() {
        FileDialog fileDialog = new FileDialog(new Frame(), "Simpan Data Ke .Txt", FileDialog.SAVE);
        fileDialog.setFile("data.txt"); // Nama file default
        fileDialog.setFilenameFilter(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        fileDialog.setVisible(true);

        String selectedFilePath = fileDialog.getDirectory() + fileDialog.getFile();
        if (fileDialog.getDirectory() != null && fileDialog.getFile() != null) {
            saveDataToTxtFile(selectedFilePath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main g = new Main();
            g.setVisible(true);
        });
    }
}
