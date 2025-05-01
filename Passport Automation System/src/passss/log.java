package passss;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class log extends JFrame {

    private static final String APPLICANT_ROLE = "Applicant";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String POLICE_USERNAME = "police";
    private static final String POLICE_PASSWORD = "police123";

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> comboBox;
    private JLabel resultLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    log frame = new log();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public log() {
        setTitle("PassPort Automation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 752);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(58, 116, 116));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Login Type");
        lblNewLabel_1.setBounds(56, 138, 126, 36);
        lblNewLabel_1.setForeground(new Color(64, 0, 64));
        lblNewLabel_1.setBackground(new Color(64, 0, 64));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("User Name");
        lblNewLabel_2.setBounds(56, 217, 126, 27);
        lblNewLabel_2.setForeground(new Color(64, 0, 64));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Password");
        lblNewLabel_3.setBounds(56, 285, 143, 27);
        lblNewLabel_3.setForeground(new Color(64, 0, 64));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel_3);

        resultLabel = new JLabel("");
        resultLabel.setBounds(268, 440, 398, 30);
        resultLabel.setForeground(Color.RED);
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(resultLabel);

        usernameField = new JTextField();
        usernameField.setBackground(new Color(255, 255, 183));
        usernameField.setBounds(215, 224, 595, 26);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        comboBox = new JComboBox<String>();
        comboBox.setBackground(new Color(255, 255, 183));
        comboBox.setBounds(215, 138, 419, 36);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {APPLICANT_ROLE, "Administer", "Police"}));
        contentPane.add(comboBox);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 255, 183));
        passwordField.setBounds(215, 292, 595, 26);
        contentPane.add(passwordField);

JButton btnNewButton = new JButton("Login");
btnNewButton.setForeground(new Color(128, 0, 0));
btnNewButton.setBounds(268, 351, 398, 59);
        btnNewButton.setBackground(SystemColor.activeCaptionBorder);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
        	
        	
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                String selectedRole = comboBox.getSelectedItem().toString();

                switch (selectedRole) {
                    case APPLICANT_ROLE:
                        applicantLogin(enteredUsername, String.valueOf(enteredPassword));
                       
                        break;
                    case "Administer":
                        adminLogin(enteredUsername, String.valueOf(enteredPassword));
                        break;
                    case "Police":
                        policeLogin(enteredUsername, String.valueOf(enteredPassword));
                        break;
                    default:
                        resultLabel.setText("Invalid role selected.");
                }
            }
        });
        contentPane.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Sign Up");
        btnNewButton_2.setBounds(77, 456, 185, 50);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             signup signUpFrame = new signup();
                signUpFrame.setVisible(true);
            }
        });
        btnNewButton_2.setBackground(SystemColor.activeCaption);
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Exit");
        btnNewButton_3.setBounds(681, 456, 152, 50);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnNewButton_3.setBackground(SystemColor.activeCaption);
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("Passport Automation System Login");
        lblNewLabel.setBounds(161, 37, 628, 59);
        lblNewLabel.setForeground(new Color(128, 0, 64));
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 35));
        contentPane.add(lblNewLabel);
    }
    private void applicantLogin(String enteredUsername, String enteredPassword) {
        try  {
        	dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();
            String query = "SELECT Username, password FROM SingUp WHERE Username = ?";
            try (PreparedStatement statement = c.prepareStatement(query)) {
                statement.setString(1, enteredUsername);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        if (enteredPassword.equals(storedPassword)) {
                            resultLabel.setText("Applicant Login Successful!");
                            Main AD = new Main();
                            AD.setVisible(true);
                           
                        } else {
                            resultLabel.setText("Invalid password for Applicant role.");
                        }
                    } else {
                        resultLabel.setText("No applicant data found.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();


resultLabel.setText("Database connection error: " + e.getMessage());
        }
    }
    private void adminLogin(String enteredUsername, String enteredPassword) {
        
        if (enteredUsername.equals(ADMIN_USERNAME) && enteredPassword.equals(ADMIN_PASSWORD)) {
            resultLabel.setText("Administer Login Successful!");
            Adminform PD = new Adminform();
            PD.setVisible(true);
            
        } else {
            resultLabel.setText("Invalid username or password for Administer role.");
        }
    }

    private void policeLogin(String enteredUsername, String enteredPassword) {
       
        if (enteredUsername.equals(POLICE_USERNAME) && enteredPassword.equals(POLICE_PASSWORD)) {
            policeform PD = new policeform();
            PD.setVisible(true);
            resultLabel.setText("Police Login Successful!");
           
        } else {
            resultLabel.setText("Invalid username or password for Police role.");
        }
    }
}
