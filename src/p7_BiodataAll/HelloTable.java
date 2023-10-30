package p7_BiodataAll;

/**
 *
 * @author ridho
 */
//import p6_coba.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class HelloTable extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private DefaultTableModel tableModel; // Model tabel yang digunakan untuk menambahkan data

    public HelloTable() {
        this.tableModel = tableModel;
        this.setTitle("Form Biodata");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField1 = new JTextField();
        textField1.setBounds(15, 60, 500, 30);
        JLabel labelInput1 = new JLabel("Nama:");
        labelInput1.setBounds(15, 40, 500, 10);
        JLabel labelRequired1 = new JLabel("Field Wajib Diisi");
        labelRequired1.setBounds(415, 95, 450, 10);
        labelRequired1.setForeground(Color.RED);
        labelRequired1.setVisible(false); // Set label awalnya tidak terlihat

        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (textField1.getText().isEmpty()) {
                    labelRequired1.setVisible(true);
                } else {
                    labelRequired1.setVisible(false);
                }
            }
        });

        textField2 = new JTextField();
        textField2.setBounds(15, 120, 500, 30);
        JLabel labelInput2 = new JLabel("No Telp:");
        labelInput2.setBounds(15, 100, 500, 15);
        JLabel labelRequired2 = new JLabel("Field Wajib Diisi");
        labelRequired2.setBounds(415, 155, 450, 10);
        labelRequired2.setForeground(Color.RED);
        labelRequired2.setVisible(false); // Set label awalnya tidak terlihat

        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (textField2.getText().isEmpty()) {
                    labelRequired2.setVisible(true);
                } else {
                    labelRequired2.setVisible(false);
                }
            }
        });
        // ... (kode lainnya tetap sama)

        //        =================
        JLabel labelRadio = new JLabel("Jenis Kelamin: ");
        labelRadio.setBounds(15, 160, 500, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki");
        radioButton1.setBounds(15, 175, 500, 30);

        JRadioButton radioButton2 = new JRadioButton("Wanita");
        radioButton2.setBounds(15, 200, 500, 30);

        JRadioButton radioButton3 = new JRadioButton("Custom", true);
        radioButton3.setBounds(15, 225, 500, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

//       ==========================
        JCheckBox checkBox = new JCheckBox("WNA (Warga Negara Asing)");
        checkBox.setBounds(15, 255, 500, 30);
        checkBox.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Jika tombol Enter ditekan, simulasi klik tombol Simpan
                    checkBox.doClick();
                }
            }
        });

        // ... (kode lainnya tetap sama)
        JButton button = new JButton("Simpan");
        button.setBounds(15, 295, 100, 40);
        button.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Jika tombol Enter ditekan, simulasi klik tombol Simpan
                    button.doClick();
                }
            }
        });

//  ===================================
        JButton button2 = new JButton("Edit");
        button2.setBounds(125, 295, 100, 40);

        JButton button3 = new JButton("Hapus");
        button3.setBounds(235, 295, 100, 40);

        JButton button4 = new JButton("Simpan Ke .Txt");
        button4.setBounds(345, 295, 150, 40);
//  ====================================
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 350, 500, 200);

        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);
//        =======================
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validasi saat tombol "Simpan" ditekan
                String nama = textField1.getText().trim();
                String noTelp = textField2.getText().trim();
                String errorMessage = "Field ";

                if (nama.isEmpty() && noTelp.isEmpty()) {

                    errorMessage += "Nama & No Telp wajib diisi";

                    JOptionPane.showMessageDialog(HelloTable.this,
                            errorMessage, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } else if (nama.isEmpty()) {
                    errorMessage += "Nama wajib diisi";
                    JOptionPane.showMessageDialog(HelloTable.this,
                            errorMessage, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } else if (noTelp.isEmpty()) {
                    errorMessage += "No Telp wajib diisi";
                    JOptionPane.showMessageDialog(HelloTable.this,
                            errorMessage, "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } else {
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

                    boolean isWNA = checkBox.isSelected();
                    String wnaLabel = isWNA ? "WNA" : "Bukan WNA";

//============================== Tambahkan data ke dalam model tabel di TableWindow
                    ArrayList<String> rowData = new ArrayList<>();
                    rowData.add(nama);
                    rowData.add(noTelp);
                    rowData.add(jenisMember);
                    rowData.add(wnaLabel);
                    tableModel.addRow(rowData);
//===============================
                    textField1.setText("");
                    textField2.setText("");
                    radioButton1.setSelected(false);
                    radioButton2.setSelected(false);
                    radioButton3.setSelected(false);
                    checkBox.setSelected(false);
                }
            }
        });

        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(textField1);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(labelRequired1);
        this.add(labelRequired2);
//        this.add(scrollableTable);
        this.add(checkBox);

        this.setSize(550, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }
}
