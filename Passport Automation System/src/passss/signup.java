package passss;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class signup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textFieldUsername;
    private JLabel textFieldFullName;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_1;

 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup frame = new signup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 680, 453);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("SIGN UP");
        lblNewLabel.setForeground(new Color(64, 128, 128));
        lblNewLabel.setBackground(new Color(102, 0, 0));
        lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 49));
        lblNewLabel.setBounds(239, 10, 274, 68);
        contentPane.add(lblNewLabel);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEmail.setBounds(43, 142, 81, 20);
        contentPane.add(lblEmail);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(43, 227, 81, 20);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(43, 269, 145, 20);
        contentPane.add(lblNewLabel_1_2);

        textField = new JTextField();
        textField.setBounds(213, 105, 360, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Sign UP");
        btnNewButton.setBackground(SystemColor.controlShadow);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             PASsignup sp = new PASsignup();
                String FullName = textField.getText();
                String Email = textField_2.getText();
                String Username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(passwordField_1.getPassword());

                // Call the sign-up method
                sp.newlogin(FullName, Email, Username, password, confirmPassword);
                JOptionPane.showMessageDialog(null, "Data saved successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                log LD = new log();
                LD.setVisible(true);
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(377, 347, 136, 38);
        contentPane.add(btnNewButton);

        passwordField = new JPasswordField();
        passwordField.setBounds(213, 230, 360, 19);
        contentPane.add(passwordField);


passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(213, 272, 360, 19);
        contentPane.add(passwordField_1);

        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(SystemColor.controlShadow);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnExit.setBounds(523, 347, 107, 38);
        contentPane.add(btnExit);

        textFieldUsername = new JTextField();
        textFieldUsername.setColumns(10);
        textFieldUsername.setBounds(213, 189, 360, 19);
        contentPane.add(textFieldUsername);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(213, 145, 360, 19);
        contentPane.add(textField_2);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBackground(new Color(255, 255, 255));
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsername.setBounds(43, 186, 81, 20);
        contentPane.add(lblUsername);

        textFieldFullName = new JLabel("Full Name");
        textFieldFullName.setForeground(new Color(255, 255, 255));
        textFieldFullName.setFont(new Font("Tahoma", Font.BOLD, 15));
        textFieldFullName.setBounds(43, 102, 81, 20);
        contentPane.add(textFieldFullName);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_2.setBounds(0, 88, 268, 180);
        contentPane.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_3.setBounds(261, 218, 312, 233);
        contentPane.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_4.setBounds(261, 88, 312, 176);
        contentPane.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_5.setBounds(0, -12, 270, 113);
        contentPane.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_6.setBounds(261, 0, 300, 95);
        contentPane.add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_7.setBounds(559, -19, 117, 198);
        contentPane.add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_8.setBounds(559, 160, 107, 131);
        contentPane.add(lblNewLabel_8);
        
        lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_9.setBounds(559, 285, 107, 131);
        contentPane.add(lblNewLabel_9);
        
        btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		log AD = new log();
                AD.setVisible(true);
        	}
        });
        btnNewButton_1.setBackground(new Color(211, 211, 211));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(59, 347, 117, 38);
        contentPane.add(btnNewButton_1);
        
        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (6).jfif"));
        lblNewLabel_1.setBounds(0, 262, 268, 154);
        contentPane.add(lblNewLabel_1);
    }
}