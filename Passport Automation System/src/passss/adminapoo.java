package passss;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class adminapoo extends JFrame {
    private JTextField aidField;  
    private JTextField passportMessageField;
    private JTextField appointmentDateField;

    public adminapoo() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 447);
        JPanel contentPane = new JPanel();
        contentPane.setForeground(new Color(64, 0, 64));
        contentPane.setBackground(new Color(138, 45, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

     
        JLabel lblAID = new JLabel("Applicant ID:");
        lblAID.setForeground(new Color(128, 0, 0));
        lblAID.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 14));
        lblAID.setBounds(33, 83, 120, 14);
        contentPane.add(lblAID);

        aidField = new JTextField();
        aidField.setBackground(new Color(255, 255, 208));
        aidField.setBounds(163, 67, 414, 47);
        contentPane.add(aidField);
        aidField.setColumns(10);

        JLabel lblPassportMessage = new JLabel("Passport Message:");
        lblPassportMessage.setForeground(new Color(64, 0, 0));
        lblPassportMessage.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 14));
        lblPassportMessage.setBounds(25, 152, 143, 14);
        contentPane.add(lblPassportMessage);

        passportMessageField = new JTextField();
        passportMessageField.setBackground(new Color(255, 255, 208));
        passportMessageField.setBounds(163, 136, 420, 47);
        contentPane.add(passportMessageField);
        passportMessageField.setColumns(10);

        JLabel lblAppointmentDate = new JLabel("Appointment Date:");
        lblAppointmentDate.setForeground(new Color(64, 0, 0));
        lblAppointmentDate.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 14));
        lblAppointmentDate.setBounds(24, 223, 129, 14);
        contentPane.add(lblAppointmentDate);

        appointmentDateField = new JTextField();
        appointmentDateField.setBackground(new Color(255, 255, 208));
        appointmentDateField.setBounds(163, 207, 420, 47);
        contentPane.add(appointmentDateField);
        appointmentDateField.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.setBackground(new Color(208, 255, 255));
        btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveDataToDatabase();
            }
        });
        btnSave.setBounds(369, 303, 89, 57);
        contentPane.add(btnSave);

        JButton btnSMS = new JButton("SMS");
        btnSMS.setBackground(new Color(251, 206, 216));
        btnSMS.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        btnSMS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displaySMS();
            }
        });
        btnSMS.setBounds(484, 303, 82, 57);
        contentPane.add(btnSMS);
        
        JButton btnNewButton = new JButton("back to ");
        btnNewButton.setBackground(new Color(169, 205, 254));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 10));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		log AD = new log();
                AD.setVisible(true);
        	}
        });
        btnNewButton.setBounds(10, 10, 85, 33);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\f48e8e51-524d-4098-b0e5-3b0d6a0b95ac.png"));
        lblNewLabel.setBounds(0, 0, 614, 410);
        contentPane.add(lblNewLabel);
    }

    private void saveDataToDatabase() {
        try {
            dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();

            
            int aid = Integer.parseInt(aidField.getText());

            String passportMessage = passportMessageField.getText();
            String appointmentDate = appointmentDateField.getText();

            String sql = "INSERT INTO PassportData (AID, passport_message, appointment_date) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(sql)) {
                pstmt.setInt(1, aid);
                pstmt.setString(2, passportMessage);
                pstmt.setString(3, appointmentDate);
                pstmt.executeUpdate();

           
                JOptionPane.showMessageDialog(null, "Appointment Date added successfully!");
            }

            c.close();
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Error adding data. Please check the input fields.");
        }
    }

    private void displaySMS() {
        
        String message = "Your passport is ready! Appointment date: " + appointmentDateField.getText();
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    adminapoo frame = new adminapoo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
