package passss;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class appoimentcheck extends JFrame {
    private JPanel contentPane;
    private JTable appointmentsTable;
    private JTextField aidTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    appoimentcheck frame = new appoimentcheck();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public appoimentcheck() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 622, 385);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAID = new JLabel("Applicant ID:");
        lblAID.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
        lblAID.setBounds(20, 10, 109, 42);
        contentPane.add(lblAID);

        aidTextField = new JTextField();
        aidTextField.setBounds(112, 18, 100, 30);
        contentPane.add(aidTextField);
        aidTextField.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(174, 215, 215));
        btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchByAID();
            }
        });
        btnSearch.setBounds(234, 17, 80, 30);
        contentPane.add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 83, 560, 211);
        contentPane.add(scrollPane);

    
        appointmentsTable = new JTable(new DefaultTableModel());
        scrollPane.setViewportView(appointmentsTable);
        
        JButton btnNewButton = new JButton("Back to");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Main AD = new Main();
                 AD.setVisible(true);
        	}
        });
        btnNewButton.setBackground(new Color(169, 205, 254));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButton.setBounds(477, 22, 85, 21);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\6b910b21-dc2f-4d94-adbc-a486bee59a71.png"));
        lblNewLabel.setBounds(0, 0, 608, 348);
        contentPane.add(lblNewLabel);

        populateAppointmentsTable();
    }

    private void populateAppointmentsTable() {
      
    }

    private void searchByAID() {
        try {
            String aidText = aidTextField.getText().trim();
            if (!aidText.isEmpty()) {
                int aid = Integer.parseInt(aidText);
                dbconnection dbc = new dbconnection();
                Connection c = dbc.connectDB();

                String sql = "SELECT aid, passport_message, appointment_date FROM PassportData WHERE aid=?";
                try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                    pstmt.setInt(1, aid);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        Vector<Vector<Object>> data = new Vector<>();
                        Vector<String> columnNames = new Vector<>();
                        columnNames.add("Applicant ID");
                        columnNames.add("Passport Message");
                        columnNames.add("Appointment Date");

                        while (rs.next()) {
                            Vector<Object> row = new Vector<>();
                            row.add(rs.getInt("aid"));
                            row.add(rs.getString("passport_message"));
                            row.add(rs.getString("appointment_date"));
                            data.add(row);
                        }

                        DefaultTableModel model = new DefaultTableModel(data, columnNames);
                        appointmentsTable.setModel(model);
                    }
                }

                c.close();
            } else {
            	JOptionPane.showMessageDialog(null, "First enter the applicant ID ");
            }
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
