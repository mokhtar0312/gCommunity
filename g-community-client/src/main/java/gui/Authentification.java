package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Authentification {

	private JFrame frmIdentification;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
					window.frmIdentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdentification = new JFrame();
		frmIdentification.setTitle("           Identification");
		frmIdentification.setBounds(100, 100, 420, 261);
		frmIdentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdentification.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 62, 80));
		panel.setBounds(0, 0, 455, 261);
		frmIdentification.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(177, 49, 146, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(79, 52, 65, 14);
		panel.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(79, 95, 65, 14);
		panel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 92, 146, 20);
		panel.add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(211, 155, 112, 23);
		panel.add(btnLogIn);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(79, 155, 112, 23);
		panel.add(btnSignIn);
		
		JLabel lblForgotYourPassword = new JLabel("Forgot your password?");
		lblForgotYourPassword.setForeground(Color.WHITE);
		lblForgotYourPassword.setBounds(201, 123, 122, 14);
		panel.add(lblForgotYourPassword);
	}
}
