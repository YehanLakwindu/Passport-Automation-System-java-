package passss;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class loging extends JFrame {

    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<Object> comboBox;

    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private static final String POLICE_USERNAME = "police";
    private static final String POLICE_PASSWORD = "police123";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loging frame = new loging();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loging() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 656, 414);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Passport Automation System Login");
        lblNewLabel.setForeground(new Color(2, 153, 141));
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 35));
        lblNewLabel.setBounds(30, 10, 602, 62);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_3_1 = new JLabel("User Type");
        lblNewLabel_3_1.setForeground(new Color(192, 192, 192));
        lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 17));
        lblNewLabel_3_1.setBounds(10, 103, 90, 22);
        contentPane.add(lblNewLabel_3_1);

        comboBox = new JComboBox<Object>();
        comboBox.setBackground(new Color(255, 255, 196));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Applicant", "Admin", "Police"}));
        comboBox.setBounds(164, 103, 429, 26);
        contentPane.add(comboBox);

        usernameField = new JTextField();
        usernameField.setBackground(new Color(255, 255, 196));
        usernameField.setBounds(164, 157, 429, 26);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 255, 196));
        passwordField.setBounds(164, 209, 429, 26);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(195, 195, 195));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();

                if (comboBox.getSelectedItem().equals("Applicant")) {
                    if (enteredUsername.equals(USER_USERNAME) && String.valueOf(enteredPassword).equals(USER_PASSWORD)) {
                        JOptionPane.showMessageDialog(loging.this, "User Login Successful!");
                        // Open Applicant Dashboard or perform actions
                        Main AD = new Main();
                        AD.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(loging.this, "Invalid username or password.");
                    }
                } else if (comboBox.getSelectedItem().equals("Admin")) {
                    if (enteredUsername.equals(ADMIN_USERNAME) && String.valueOf(enteredPassword).equals(ADMIN_PASSWORD)) {
                        JOptionPane.showMessageDialog(loging.this, "Admin Login Successful!");
                        // Open Admin Dashboard or perform actions
                        Adminform AD = new Adminform();
                        AD.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(loging.this, "Invalid username or password.");
                    }
                } else if (comboBox.getSelectedItem().equals("Police")) {
                    if (enteredUsername.equals(POLICE_USERNAME) && String.valueOf(enteredPassword).equals(POLICE_PASSWORD)) {
                        JOptionPane.showMessageDialog(loging.this, "Police Login Successful!");
                        // Open Police Dashboard or perform actions
                        policeform PD = new policeform();
                        PD.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(loging.this, "Invalid username or password.");
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(537, 313, 95, 47);
        contentPane.add(btnNewButton);

        Button button = new Button("User_Details");
        button.setBackground(new Color(195, 195, 195));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newloging NL = new newloging();
                NL.setVisible(true);
            }
        });
        button.setFont(new Font("Dialog", Font.BOLD, 13));
        button.setBounds(10, 313, 115, 47);
        contentPane.add(button);

        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(new Color(195, 195, 195));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnExit.setBounds(442, 313, 85, 47);
        contentPane.add(btnExit);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_5.setBounds(299, -5, 300, 173);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_6.setBounds(597, 0, 45, 159);
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_8.setBounds(299, 157, 294, 150);
        contentPane.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_9.setBounds(588, 157, 60, 150);
        contentPane.add(lblNewLabel_9);
        
        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_11.setBounds(299, 301, 294, 76);
        contentPane.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("");
        lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_12.setBounds(587, 301, 55, 76);
        contentPane.add(lblNewLabel_12);
        
        JLabel lblNewLabel_14 = new JLabel("User Name");
        lblNewLabel_14.setForeground(new Color(192, 192, 192));
        lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_14.setBackground(new Color(192, 192, 192));
        lblNewLabel_14.setBounds(10, 146, 100, 41);
        contentPane.add(lblNewLabel_14);
        
        JLabel lblNewLabel_14_1 = new JLabel("User Password");
        lblNewLabel_14_1.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_14_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_14_1.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_14_1.setBounds(10, 194, 131, 41);
        contentPane.add(lblNewLabel_14_1);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_4.setBounds(0, 103, 300, 159);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_7.setBounds(0, -5, 300, 109);
        contentPane.add(lblNewLabel_7);
        
        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_10.setBounds(0, 261, 300, 138);
        contentPane.add(lblNewLabel_10);
    }
}

class newloging extends JFrame {

    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField reenterPasswordField;

    public newloging() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("New User Signup");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(140, 10, 160, 22);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_1.setBounds(50, 70, 80, 17);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_2.setBounds(50, 110, 80, 17);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Re-enter Password:");
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel_3.setBounds(50, 150, 140, 17);
        contentPane.add(lblNewLabel_3);

        usernameField = new JTextField();
        usernameField.setBounds(190, 70, 180, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 110, 180, 20);
        contentPane.add(passwordField);

        reenterPasswordField = new JPasswordField();
        reenterPasswordField.setBounds(190, 150, 180, 20);
        contentPane.add(reenterPasswordField);

        JButton btnSignup = new JButton("Sign Up");
        btnSignup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                char[] reenteredPassword = reenterPasswordField.getPassword();

                // Check if passwords match
                if (!Arrays.equals(enteredPassword, reenteredPassword)) {
                    JOptionPane.showMessageDialog(newloging.this, "Passwords do not match!");
                    return;
                }

                try {
                    String username = "root";
                    String pwd = "200251";
                    String dbname = "TEST12";

                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, username, pwd);

                    System.out.println("Success");

                    String sql = "INSERT INTO SignUp(Username, password, reenter_password) VALUES (?, ?, ?)";

                    try {
                        PreparedStatement statement = conn.prepareStatement(sql);

                        statement.setString(1, enteredUsername);
                        statement.setString(2, String.valueOf(enteredPassword));
                        statement.setString(3, String.valueOf(reenteredPassword));

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0)
                            System.out.println("Data inserted successfully!");
                    } catch (SQLException ex) {
                        System.out.println("Data insertion Failed!");
                        System.out.println(ex);
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                JOptionPane.showMessageDialog(newloging.this, "Signup Successful!");
                dispose();
            }
        });
        btnSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignup.setBounds(190, 200, 89, 23);
        contentPane.add(btnSignup);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.setBounds(300, 200, 89, 23);
        contentPane.add(btnCancel);
    }
}


