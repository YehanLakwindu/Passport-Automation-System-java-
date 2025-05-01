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

public class admincheck extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchTextField;
    private JTable resultTable;

    private DefaultTableModel tableModel;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    admincheck frame = new admincheck();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public admincheck() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Admin Search");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(228, 201, 90));
        contentPane.add(searchPanel, BorderLayout.CENTER);
        searchPanel.setLayout(null);

        searchTextField = new JTextField();
        searchTextField.setBounds(290, 6, 96, 19);
        searchTextField.setColumns(10);
        searchPanel.add(searchTextField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(391, 5, 65, 21);
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        searchButton.setForeground(new Color(255, 255, 255));
        searchButton.setBackground(new Color(0, 0, 160));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchTextField.getText();
                if (!searchTerm.isEmpty()) {
                    // Implement database search based on the search term
                    displayApplicantDetails(searchTerm);
                }
            }
        });
        searchPanel.add(searchButton);

        JButton approveButton = new JButton("Approve");
        approveButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        approveButton.setBackground(new Color(0, 128, 255));
        approveButton.setBounds(20, 22, 85, 21);
        approveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dbconnection dbc = new dbconnection();
                    Connection c = dbc.connectDB();

                    String sql = "INSERT INTO admin_data (AID, NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email, ApprovalStatus) " +
                            "SELECT AID, NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email, 'Approved' " +
                            "FROM police WHERE AID = ?";
                    PreparedStatement pst = c.prepareStatement(sql);
                    pst.setString(1, searchTextField.getText()); 

                    int rowsInserted = pst.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Data saved to admin_data successfully!");
                        JOptionPane.showMessageDialog(null, "approve successfully saved!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("Failed to save data to admin_data.");
                        JOptionPane.showMessageDialog(null, "Failed to save data to admin_data!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        searchPanel.add(approveButton);

        JButton notApproveButton = new JButton("Not Approve");
        notApproveButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        notApproveButton.setBackground(new Color(249, 50, 21));
        notApproveButton.setBounds(120, 22, 115, 21);
        notApproveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 try {
                     dbconnection dbc = new dbconnection();
                     Connection c = dbc.connectDB();

                     String sql = "INSERT INTO admin_data (AID, NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email, ApprovalStatus) " +
                             "SELECT AID, NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email, ' not Approved' " +
                             "FROM police WHERE AID = ?";
                     PreparedStatement pst = c.prepareStatement(sql);
                     pst.setString(1, searchTextField.getText()); 

                     int rowsInserted = pst.executeUpdate();
                     if (rowsInserted > 0) {
                         System.out.println("Data saved to admin_data successfully!");
                         JOptionPane.showMessageDialog(null, "Not Approve successfully saved!", "Success",
                                 JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         System.out.println("Failed to save data to admin_data.");
                         JOptionPane.showMessageDialog(null, "Failed to save data to admin_data!", "Success",
                                 JOptionPane.INFORMATION_MESSAGE);
                     }

                 } catch (SQLException e1) {
                     e1.printStackTrace();
               
                }
            }
        });
        searchPanel.add(notApproveButton);

        JLabel lblNewLabel_1 = new JLabel("ID num");
        lblNewLabel_1.setBounds(406, 9, 45, 13);
        searchPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\images (2).jfif"));
        lblNewLabel_2.setBounds(450, 0, 275, 131);
        searchPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\images (2).jfif"));
        lblNewLabel_3.setBounds(0, 0, 280, 131);
        searchPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\images (3).jfif"));
        lblNewLabel_4.setBounds(245, 0, 228, 131);
        searchPanel.add(lblNewLabel_4);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.SOUTH);

       
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"NIC", "Surname", "OName", "PermanetAddress", "DoB", "PlaceOfBirth", "Gender", "Occupation", "MobileNo", "Email","ApprovalStatus"});

        resultTable = new JTable(tableModel);
        scrollPane.setViewportView(resultTable);

        JButton exitButton = new JButton("Exit");
        exitButton.setForeground(new Color(192, 192, 192));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        exitButton.setBackground(new Color(64, 64, 64));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Adminform AD = new Adminform();
                AD.setVisible(true);
            }
        });
        contentPane.add(exitButton, BorderLayout.EAST);
    }

   
    private void displayApplicantDetails(String searchTerm) {
        try {
            dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();

            String sql = "SELECT NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email,ApprovalStatus FROM police WHERE AID = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, searchTerm);

            ResultSet rs = pst.executeQuery();

         
            tableModel.setRowCount(0);

            if (!rs.next()) {
              
                tableModel.addRow(new Object[]{"No data found", "", "", "", "", "", "", "", "", ""});
            } else {
               
                tableModel.addRow(new Object[]{
                        rs.getString("NIC"),
                        rs.getString("Surname"),
                        rs.getString("OName"),
                        rs.getString("PermanetAddress"),
                        rs.getString("DoB"),
                        rs.getString("PlaceOfBirth"),
                        rs.getString("Gender"),
                        rs.getString("Occupation"),
                        rs.getString("MobileNo"),
                        rs.getString("Email"),
                        rs.getString("ApprovalStatus")
                       
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while searching.");
        }
    }

    
    private void updateApprovalStatus(String nic, String status) {
        try {
            dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();

            String sql = "UPDATE police SET approvalStatus = ? WHERE NIC = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, status);
            pst.setString(2, nic);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Approval status updated successfully!");
            } else {
                System.out.println("Failed to update approval status.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    private void saveToAdminData(String nic, String status) {
        try {
            dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();

            String sql = "INSERT INTO admin_data (NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email, ApprovalStatus) " +
                    "SELECT NIC, Surname, OName, PermanetAddress, DoB, PlaceOfBirth, Gender, Occupation, MobileNo, Email, ? " +
                    "FROM police WHERE NIC = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, status);
            pst.setString(2, nic);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data saved to admin_data successfully!");
            } else {
                System.out.println("Failed to save data to admin_data.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
