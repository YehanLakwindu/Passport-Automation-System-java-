package passss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class passport extends JFrame {

    public passport() {
        setTitle("Passport Dispatch Form");
        setSize(520, 385);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(4, 1));
        mainPanel.setBackground(new Color(159, 213, 236));

        JButton createPassportButton = new JButton("Create Passport");
        createPassportButton.setFont(new Font("SimSun", Font.BOLD, 18));
        createPassportButton.setBackground(new Color(245, 201, 139));
        createPassportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to create a passport
                JOptionPane.showMessageDialog(passport.this,
                        "Passport created successfully!",
                        "Passport Created",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton notifyApplicantButton = new JButton("Notify Applicant");
        notifyApplicantButton.setFont(new Font("SimSun", Font.BOLD, 18));
        notifyApplicantButton.setBackground(new Color(206, 255, 206));
        notifyApplicantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to notify the applicant
                String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String message = "Applicant, your passport is ready! Please come and collect it. Date and Time: " + currentDate;
                JOptionPane.showMessageDialog(passport.this,
                        message,
                        "Passport Ready",
                        JOptionPane.INFORMATION_MESSAGE);

                // Simulate sending an SMS (display message box with date and time)
                sendSMS("Applicant's phone number", message);
            }
        });

        JButton sendSMSButton = new JButton("Send SMS");
        sendSMSButton.setFont(new Font("SimSun", Font.BOLD, 18));
        sendSMSButton.setBackground(new Color(252, 192, 215));
        sendSMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate sending an SMS (display message box with date and time)
                sendSMS("Applicant's phone number", "Your passport is ready! Come and get it.");
            }
        });

        mainPanel.add(createPassportButton);
        mainPanel.add(notifyApplicantButton);
        mainPanel.add(sendSMSButton);

        getContentPane().add(mainPanel);
    }

    // Simulated method to send an SMS and display message box
    private void sendSMS(String phoneNumber, String message) {
        // Simulate sending an SMS (display message box with date and time)
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String smsMessage = "Sending SMS to " + phoneNumber + ": " + message + "\nDate and Time: " + currentDate;
        JOptionPane.showMessageDialog(passport.this,
                smsMessage,
                "SMS Sent",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new passport().setVisible(true);
            }
        });
    }
}
