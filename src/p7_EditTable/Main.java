/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7_EditTable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author ridho
 */
import javax.swing.*;
import javax.swing.table.TableColumn;

public class Main extends JFrame {

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DataWindow dataWindow = new DataWindow();
        MyTableModel tableModel = new MyTableModel();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton tambahBtn = new JButton("Tambah Data");
        JButton editBtn = new JButton("Edit");
        JButton simpanBtn = new JButton("Simpan"); // Tombol baru untuk menyimpan perubahan

        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(tambahBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(editBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(simpanBtn);

        JPanel tableMarginPanelBtn = new JPanel();
        tableMarginPanelBtn.setLayout(new BoxLayout(tableMarginPanelBtn, BoxLayout.PAGE_AXIS));
        tableMarginPanelBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableMarginPanelBtn.add(buttonPanel);
        tableMarginPanelBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering buttons

//        editBtn.setEnabled(false);
        simpanBtn.setEnabled(false);

//          ====================
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
                TambahDataForm tambahDataForm = new TambahDataForm(dataWindow, tableModel);
            }
        });

        table.setEnabled(false);

//        ===============
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktifkan mode pengeditan
                table.setEnabled(true);
                editBtn.setEnabled(false);
                simpanBtn.setEnabled(true);

                // Setel editor untuk kolom "Nama"
                TableColumn namaColumn = table.getColumnModel().getColumn(0);
                namaColumn.setCellEditor(new DefaultCellEditor(new JTextField()));

                // Setel editor untuk kolom "NIM"
                TableColumn nimColumn = table.getColumnModel().getColumn(1);
                nimColumn.setCellEditor(new DefaultCellEditor(new JTextField()));
            }
        });

//        ====================
        simpanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menghentikan pengeditan sel aktif
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                    table.setEnabled(false);
                    simpanBtn.setEnabled(false);
                    editBtn.setEnabled(true);
                }

                // Menyimpan perubahan dari tabel ke objek Data
                int rowCount = table.getRowCount();
                int colCount = table.getColumnCount();

                // Menyimpan perubahan dari tabel ke objek Data
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < colCount; col++) {
                        Object value = table.getValueAt(row, col);
                        Data rowData = dataWindow.getDataList().get(row);

                        if (col == 0) {
                            rowData.setNama(value.toString());
                        } else if (col == 1) {
                            rowData.setNim(value.toString());
                        }
                    }
                }

                // Memperbarui model tabel
                tableModel.fireTableDataChanged();
            }
        });

//        simpanBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Menonaktifkan mode pengeditan
//                table.setEnabled(false);
//                simpanBtn.setEnabled(false);
//                editBtn.setEnabled(true);
//
//                // Mendapatkan jumlah baris dan kolom dalam tabel
//                int rowCount = table.getRowCount();
//                int colCount = table.getColumnCount();
//
//                // Menyimpan perubahan dari tabel ke objek Data
//                for (int row = 0; row < rowCount; row++) {
//                    for (int col = 0; col < colCount; col++) {
//                        Object value = table.getValueAt(row, col);
//                        Data rowData = dataWindow.getDataList().get(row);
//
//                        if (col == 0) {
//                            rowData.setNama(value.toString());
//                        } else if (col == 1) {
//                            rowData.setNim(value.toString());
//                        }
//                    }
//                }
//
//                // Memperbarui model tabel
//                tableModel.fireTableDataChanged(); // Memastikan tampilan tabel diperbarui dengan data yang disimpan
//            }
//        });
//============================
        tambahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahDataForm tambahDataForm = new TambahDataForm(dataWindow, tableModel); // form tambah data
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main g = new Main();
            g.setVisible(true);
        });
    }
}
