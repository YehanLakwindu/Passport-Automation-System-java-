package passss;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class Adminform extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminform frame = new Adminform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Adminform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 763);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin's Work.");
		lblNewLabel.setBounds(10, 23, 673, 89);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 66));
		lblNewLabel.setForeground(new Color(0, 64, 64));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("check Applicant status give approve");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(12, 104, 218));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admincheck AD = new admincheck();
                AD.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 318, 290, 77);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("dispatch the passport for applicant");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminapoo AD = new adminapoo();
                AD.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 431, 241, 77);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\317198512.jpg"));
		lblNewLabel_1.setBounds(-187, 10, 1042, 706);
		contentPane.add(lblNewLabel_1);
	}

}
