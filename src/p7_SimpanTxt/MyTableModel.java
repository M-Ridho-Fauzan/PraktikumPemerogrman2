/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p7_SimpanTxt;

/**
 *
 * @author ridho
 */
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {

    private String[] columnNames = {"Nama", "NIM"};
    private ArrayList<Data> data = new ArrayList<>();

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
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

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void addData(Data newData) {
        data.add(newData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
