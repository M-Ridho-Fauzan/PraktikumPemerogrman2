package p5;

/**
 *
 * @author ridho
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class BiodataForm extends JFrame {

    private boolean checkBoxSelected;

    public BiodataForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Biodata");

        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

// ============== Bagian kiri
        JPanel leftPanel = new JPanel(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(new JLabel("Nama:"), gbc);

        gbc.gridy = 1;
        JTextField namaField = new JTextField(10);
        leftPanel.add(namaField, gbc);

        gbc.gridy = 2;
        leftPanel.add(new JLabel("No. Telepon:"), gbc);

        gbc.gridy = 3;
        JTextField noTelpField = new JTextField(10);
        leftPanel.add(noTelpField, gbc);

// ============== Bagian kanan
        JPanel rightPanel = new JPanel(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(new JLabel("Jenis Kelamin:"), gbc);

        gbc.gridy = 1;
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki");
        rightPanel.add(radioButton1, gbc);

        gbc.gridy = 2;
        JRadioButton radioButton2 = new JRadioButton("Wanita");
        rightPanel.add(radioButton2, gbc);

// =============== Checkbox WNA
        gbc.gridy = 3;
        JCheckBox checkBox = new JCheckBox("WNA");
        rightPanel.add(checkBox, gbc);

        ButtonGroup jenisKelaminGroup = new ButtonGroup();
        jenisKelaminGroup.add(radioButton1);
        jenisKelaminGroup.add(radioButton2);

// =============== Tombol Simpan
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton simpanButton = new JButton("Simpan");
        buttonPanel.add(simpanButton);

// =============== Menyusun elemen-elemen ke dalam panel utama
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(leftPanel, gbc);

        gbc.gridx = 1;
        mainPanel.add(rightPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

// ====================
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 370, 650, 100);

// ====================
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

// Mesin nya
        simpanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                String nama = namaField.getText();
                String noHp = noTelpField.getText();
                txtOutput.append("Nama           : " + nama + "\n");
                txtOutput.append("No hp           : " + noHp + "\n");
                txtOutput.append("Jenis Kelamin  : " + jenisKelamin + "\n");
                if (checkBoxSelected) {
                    txtOutput.append("WNA (Outsider)  : Iya Outsider" + "\n");
                } else {
                    txtOutput.append("WNA (Outsider)  : Bukan Outsider" + "\n");
                }

                txtOutput.append("====================================" + "\n");
            }
        });

        this.setLayout(new GridLayout(3, 1));
        this.add(headerLabel);
        this.add(mainPanel);
        this.add(txtOutput);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataForm form = new BiodataForm();
            }
        });
    }
}
