package passss;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Application extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nicField;
    private JTextField surnameField;
    private JTextField otherNamesField;
    private JTextField addressField;
    private JTextField dobField;
    private JTextField professionField;
    private JTextField mobilePhoneField;
    private JTextField emailField;
    private JTextField placeofBirthField;
    private static JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Application frame = new Application();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static int increment() {
        int n = 0;

        try {
            dbconnection dbc = new dbconnection();
            Connection c = dbc.connectDB();

            System.out.println("Success");

            String sql = "Select AID from applicants order by AID DESC";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                n = id + 1;
                textField.setText(Integer.toString(n));

            }

        } catch (Exception e) {

        }
        return n;
    }

    public Application() {
        increment();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 812);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(159, 213, 236));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Application For Passport");
        lblNewLabel.setBounds(168, 28, 586, 98);
        lblNewLabel.setBackground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 48));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1_1 = new JLabel("NIC");
        lblNewLabel_1_1.setBounds(69, 165, 175, 19);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Surname");
        lblNewLabel_1_1_1.setBounds(69, 203, 175, 19);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Other Names");
        lblNewLabel_1_1_1_1.setBounds(69, 245, 175, 19);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("Permanet Address");
        lblNewLabel_1_1_1_2.setBounds(69, 299, 175, 19);
        lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1_2);

        JLabel lblNewLabel_1_1_1_3 = new JLabel("Date of Birth");
        lblNewLabel_1_1_1_3.setBounds(69, 342, 175, 19);
        lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1_3);

        JLabel lblNewLabel_1_1_1_5 = new JLabel("Place of Birth");
        lblNewLabel_1_1_1_5.setBounds(69, 424, 175, 19);
        lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1_5);

        JLabel lblNewLabel_1_1_1_6 = new JLabel("Sex");
        lblNewLabel_1_1_1_6.setBounds(69, 472, 175, 19);
        lblNewLabel_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1_6);

        JLabel lblNewLabel_1_1_1_7 = new JLabel("Occupation");
        lblNewLabel_1_1_1_7.setBounds(69, 516, 192, 19);
        lblNewLabel_1_1_1_7.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_1_1_7);

        nicField = new JTextField();
        nicField.setBounds(263, 166, 295, 19);
        contentPane.add(nicField);
        nicField.setColumns(10);

        surnameField = new JTextField();
        surnameField.setBounds(263, 204, 636, 19);
        surnameField.setColumns(10);
        contentPane.add(surnameField);

        otherNamesField = new JTextField();
        otherNamesField.setBounds(263, 246, 636, 19);
        otherNamesField.setColumns(10);
        contentPane.add(otherNamesField);

        addressField = new JTextField();
        addressField.setBounds(263, 300, 636, 19);
        addressField.setColumns(10);
        contentPane.add(addressField);

        dobField = new JTextField();
        dobField.setBounds(263, 343, 295, 19);
        dobField.setColumns(10);
        contentPane.add(dobField);

        professionField = new JTextField();
        professionField.setBounds(263, 517, 295, 19);
        professionField.setColumns(10);
        contentPane.add(professionField);

        JCheckBox maleCheckBox = new JCheckBox("Male");
        maleCheckBox.setBounds(263, 472, 93, 21);
        contentPane.add(maleCheckBox);

        JCheckBox femaleCheckBox = new JCheckBox("Female");
        femaleCheckBox.setBounds(404, 472, 93, 21);
        contentPane.add(femaleCheckBox);

        JLabel lblNewLabel_1_2 = new JLabel("Phone No");
        lblNewLabel_1_2.setBounds(69, 638, 175, 19);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("E-mail address");
        lblNewLabel_1_3.setBounds(69, 675, 175, 19);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_1_3);

        mobilePhoneField = new JTextField();
        mobilePhoneField.setBounds(263, 639, 295, 19);
        mobilePhoneField.setColumns(10);
        contentPane.add(mobilePhoneField);

        emailField = new JTextField();
        emailField.setBounds(263, 676, 295, 19);
        emailField.setColumns(10);
        contentPane.add(emailField);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBounds(788, 675, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dbconnection dbc = new dbconnection();
                    Connection c = dbc.connectDB();

                    System.out.println("Success");


                    String NIC = nicField.getText();
                    String Surname = surnameField.getText();
                    String OName = otherNamesField.getText();
                    String PermanteAddress = addressField.getText();
                    String DoB = dobField.getText();
                    String PlaceOfBirth = placeofBirthField.getText();
                    String gender = maleCheckBox.isSelected() ? "Male" : "Female";
                    String Occupation = professionField.getText();
                    String MobileNo = mobilePhoneField.getText();
                    String Email = emailField.getText();

                    String sql = "insert into applicants(NIC,Surname,OName,PermanetAddress,DoB,PlaceOfBirth,gender,Occupation,MobileNo,Email)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";

                    PreparedStatement statement = c.prepareStatement(sql);

                    statement.setString(1, NIC);
                    statement.setString(2, Surname);
                    statement.setString(3, OName);
                    statement.setString(4, PermanteAddress);
                    statement.setString(5, DoB);
                    statement.setString(6, PlaceOfBirth);
                    statement.setString(7, gender);
                    statement.setString(8, Occupation);
                    statement.setString(9, MobileNo);
                    statement.setString(10, Email);

                    int update = statement.executeUpdate();

                    if (update > 0) {
                      
                        String generatedAID = "";
                        String getAIDQuery = "SELECT AID FROM applicants WHERE NIC = ?";
                        PreparedStatement getAIDStatement = c.prepareStatement(getAIDQuery);
                        getAIDStatement.setString(1, NIC);
                        ResultSet rs = getAIDStatement.executeQuery();
                        if (rs.next()) {
                            generatedAID = rs.getString("AID");
                        }

                        System.out.println("Data updated successfully!");
                        JOptionPane.showMessageDialog(null, "Data updated successfully! Remember this Your AID: " + generatedAID , "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("Data update Failed!");
                        JOptionPane.showMessageDialog(null, "Data update Failed!", "Failed",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println("Update Failed");
                    System.out.println(ex);

                    JOptionPane.showMessageDialog(null, "Form submitted successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(788, 706, 85, 21);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                	log AD = new log();
                    AD.setVisible(true);
                }
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(btnExit);

        placeofBirthField = new JTextField();
        placeofBirthField.setBounds(263, 425, 295, 19);
        placeofBirthField.setColumns(10);
        contentPane.add(placeofBirthField);

        textField = new JTextField();
        textField.setBackground(new Color(97, 202, 252));
        textField.setBounds(125, 10, 96, 19);
        textField.setEditable(false);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Application ");
        lblNewLabel_2.setBounds(10, 9, 115, 19);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(lblNewLabel_2);
    }
}
