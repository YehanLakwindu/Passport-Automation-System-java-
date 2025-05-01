package passss;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class policeform extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					policeform frame = new policeform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public policeform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POLICE");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblNewLabel.setBounds(124, 82, 200, 92);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CHECK THE APPLICANTS  CRIMINAL RECORDS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				police AD = new police();
                AD.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(64, 0, 0));
		btnNewButton.setBackground(new Color(159, 213, 236));
		btnNewButton.setBounds(38, 168, 364, 52);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (1).jfif"));
		lblNewLabel_1.setBounds(0, -29, 307, 190);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\images (6).jfif"));
		lblNewLabel_2.setBounds(0, 134, 436, 129);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\images (4).jfif"));
		lblNewLabel_3.setBounds(256, 69, 180, 211);
		contentPane.add(lblNewLabel_3);
		
		JButton button = new JButton("New button");
		button.setBounds(10, 10, 85, 21);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log AD = new log();
                AD.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(213, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(341, 23, 85, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download (1).jfif"));
		lblNewLabel_4.setBounds(262, -21, 248, 109);
		contentPane.add(lblNewLabel_4);
	}

}
