/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7_EditTable;

/**
 *
 * @author ridho
 */
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MyTableModel extends DefaultTableModel {

    private String[] columnNames = {"Nama", "NIM"};
    private ArrayList<Data> data = new ArrayList<>();

    public MyTableModel() {
        super(new Object[]{"Nama", "NIM"}, 0); // Menambahkan kolom ke model tabel
    }

    public Object getValueAt(int row, int col) {
        Data rowData = data.get(row);
        if (col == 0) {
            return rowData.getNama();
        } else if (col == 1) {
            return rowData.getNim();
        }
        return null;
    }

    public void addData(Data newData) {
        data.add(newData);
        addRow(new Object[]{newData.getNama(), newData.getNim()});
    }

    public boolean isCellEditable(int row, int col) {
        return col == 0 || col == 1; // Kolom "Nama" (0) dan "NIM" (1) dapat diedit
//        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        Data rowData = data.get(row);
        if (col == 0) {
            rowData.setNama(value.toString());
        } else if (col == 1) {
            rowData.setNim(value.toString());
        }
        fireTableCellUpdated(row, col); // Memperbarui tampilan tabel
    }
}
