package passss;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Main extends JFrame {
	 

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Apply for Passport ");
		btnNewButton.setBackground(new Color(159, 213, 236));
		btnNewButton.setFont(new Font("Segoe UI Variable", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application k = new Application();
				k.setVisible(rootPaneCheckingEnabled);
				
			}
		});
		btnNewButton.setBounds(122, 82, 171, 42);
		contentPane.add(btnNewButton);
		
		JButton btnCheckstatus = new JButton("Check Application Status ");
		btnCheckstatus.setBackground(new Color(208, 211, 251));
		btnCheckstatus.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 13));
		btnCheckstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applicantstatuscheck AD = new applicantstatuscheck();
                AD.setVisible(true);
			}
		});
		btnCheckstatus.setBounds(93, 134, 242, 58);
		contentPane.add(btnCheckstatus);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 200, 200));
		btnLogout.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 10));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				dispose();
			}
		});
		btnLogout.setBounds(355, 430, 85, 42);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Menu Applicant");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
		lblNewLabel.setForeground(new Color(0, 64, 64));
		lblNewLabel.setBounds(76, 10, 296, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\images (8).jfif"));
		lblNewLabel_1.setBounds(76, 297, 259, 210);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(93, 82, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Check Appointment Status");
		btnNewButton_1.setBackground(new Color(213, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appoimentcheck frame = new 	appoimentcheck();
			     frame.setVisible(true);
				
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(122, 202, 171, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(213, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log AD = new log();
                AD.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBounds(356, 389, 84, 31);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\fbd35cce-976e-4c18-a62f-3e2b4e08e7f7.png"));
		lblNewLabel_2.setBounds(0, 0, 449, 507);
		contentPane.add(lblNewLabel_2);
	}
}

