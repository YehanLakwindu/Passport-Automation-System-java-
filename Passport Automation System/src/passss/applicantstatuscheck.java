package passss;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class applicantstatuscheck extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchTextField;
    private JTable resultTable;

   
    private DefaultTableModel tableModel;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    applicantstatuscheck frame = new applicantstatuscheck();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public applicantstatuscheck() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Applicant Status Check");
        lblNewLabel.setBackground(new Color(128, 255, 255));
        lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 17));
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(255, 128, 64));
        contentPane.add(searchPanel, BorderLayout.CENTER);
        searchPanel.setLayout(null);

        searchTextField = new JTextField();
        searchTextField.setBounds(290, 6, 96, 37);
        searchTextField.setColumns(10);
        searchPanel.add(searchTextField);

        JButton searchButton = new JButton("Check Status");
        searchButton.setBackground(new Color(64, 128, 128));
        searchButton.setForeground(new Color(0, 0, 0));
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        searchButton.setBounds(391, 5, 120, 38);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchTextField.getText();
                if (!searchTerm.isEmpty()) {
                   
                    displayApplicantStatus(searchTerm);
                }
            }
        });
        searchPanel.add(searchButton);
        
        JLabel lblNewLabel_1 = new JLabel("Give ID Number");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1.setForeground(new Color(128, 0, 0));
        lblNewLabel_1.setBackground(new Color(0, 128, 192));
        lblNewLabel_1.setBounds(521, 9, 143, 34);
        searchPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(199, 53, 45, 13);
        searchPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (4).jfif"));
        lblNewLabel_3.setBounds(0, 0, 511, 127);
        searchPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (5).jfif"));
        lblNewLabel_4.setBounds(275, 0, 259, 127);
        searchPanel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(599, 90, 45, 13);
        searchPanel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (5).jfif"));
        lblNewLabel_6.setBounds(458, 0, 259, 127);
        searchPanel.add(lblNewLabel_6);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.SOUTH);

        
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"AID", "Name", "ApprovalStatus"});

        resultTable = new JTable(tableModel);
        scrollPane.setViewportView(resultTable);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        exitButton.setBackground(new Color(128, 128, 128));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main AD = new Main();
                AD.setVisible(true);
            }
        });
        contentPane.add(exitButton, BorderLayout.EAST);
    }

    
    private void displayApplicantStatus(String searchTerm) {
        try {
            dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();

            String sql = "SELECT AID, CONCAT(Surname, ' ', OName) AS Name, approvalStatus FROM admin_data WHERE AID = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, searchTerm);

            ResultSet rs = pst.executeQuery();

          
            tableModel.setRowCount(0);

            if (!rs.next()) {
              
                tableModel.addRow(new Object[]{"No data found", "", ""});
            } else {
              
                tableModel.addRow(new Object[]{
                        rs.getString("AID"),
                        rs.getString("Name"),
                        rs.getString("approvalStatus")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while searching.");
        }
    }
}
