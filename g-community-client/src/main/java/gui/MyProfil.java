package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MyProfil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfil window = new MyProfil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyProfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelGlobal = new JPanel();
		panelGlobal.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelGlobal);
		panelGlobal.setLayout(null);
		
		JLabel lbphoto = new JLabel("");
		lbphoto.setIcon(new ImageIcon("C:\\Users\\A S U S\\Desktop\\anis\\b7ar\\11753917_10152946675657124_1825375117_n.jpg"));
		lbphoto.setBounds(10, 54, 73, 95);
		panelGlobal.add(lbphoto);
		
		JPanel panel = new JPanel();
		panel.setBounds(120, 54, 291, 196);
		panelGlobal.add(panel);
		panel.setLayout(null);
		
		JLabel lblnom = new JLabel("Name :");
		lblnom.setHorizontalAlignment(SwingConstants.LEFT);
		lblnom.setBounds(10, 11, 71, 21);
		panel.add(lblnom);
		
		JLabel lblname = new JLabel("");
		lblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblname.setBounds(138, 11, 71, 21);
		panel.add(lblname);
		
		JLabel lblprenom = new JLabel(" Surname :");
		lblprenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblprenom.setBounds(10, 43, 71, 21);
		panel.add(lblprenom);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(10, 75, 71, 21);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(10, 107, 71, 21);
		panel.add(lblPassword);
		
		JLabel lblsunmonernom = new JLabel("SunmonerName :");
		lblsunmonernom.setHorizontalAlignment(SwingConstants.LEFT);
		lblsunmonernom.setBounds(10, 139, 93, 21);
		panel.add(lblsunmonernom);
		
		JLabel lblsurname = new JLabel("");
		lblsurname.setHorizontalAlignment(SwingConstants.LEFT);
		lblsurname.setBounds(138, 43, 71, 21);
		panel.add(lblsurname);
		
		JLabel lblusername = new JLabel("");
		lblusername.setHorizontalAlignment(SwingConstants.LEFT);
		lblusername.setBounds(138, 75, 71, 21);
		panel.add(lblusername);
		
		JLabel lblpassword = new JLabel("");
		lblpassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblpassword.setBounds(138, 107, 71, 21);
		panel.add(lblpassword);
		
		JLabel lblsunmonername = new JLabel("");
		lblsunmonername.setHorizontalAlignment(SwingConstants.LEFT);
		lblsunmonername.setBounds(138, 139, 83, 21);
		panel.add(lblsunmonername);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(10, 164, 83, 21);
		panel.add(lblEmail);
		
		JLabel lblemail = new JLabel("");
		lblemail.setHorizontalAlignment(SwingConstants.LEFT);
		lblemail.setBounds(138, 164, 124, 21);
		panel.add(lblemail);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 414, 32);
		panelGlobal.add(panel_1);
		panel_1.setLayout(null);
	}
}
