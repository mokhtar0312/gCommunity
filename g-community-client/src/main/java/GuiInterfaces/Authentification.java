package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import delegate.ActiveMemberServicesDelegate;
import entities.ActiveMember;
import entities.SimpleMember;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Authentification {

	public JFrame frmIdentification;
	private JTextField tfname;
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
		panel.setBounds(0, 0, 404, 222);
		frmIdentification.getContentPane().add(panel);
		panel.setLayout(null);
		
		tfname = new JTextField();
		tfname.setBounds(177, 49, 146, 20);
		panel.add(tfname);
		tfname.setColumns(10);
		
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
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=tfname.getText();
				System.out.println(username);
				String password=passwordField.getText();
				ActiveMember found=new ActiveMember();
				List<ActiveMember>aa=ActiveMemberServicesDelegate.doFindAllActiveMember();
				for(ActiveMember a:aa){
					
					if(a.getUsername().equals(username)){
					found=a;}
				}
				
				if(found.getPassword().equals(password)){
					
					frmIdentification.setVisible(false);
					
				}
				
				
				
		
				
				
				
			}
		});
		btnLogIn.setBounds(211, 155, 112, 23);
		panel.add(btnLogIn);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIdentification.setVisible(false);
				new SignIn().frmSignIn.setVisible(true);
			}
		});
		btnSignIn.setBounds(79, 155, 112, 23);
		panel.add(btnSignIn);
		
		JLabel lblForgotYourPassword = new JLabel("Forgot your password?");
		lblForgotYourPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmIdentification.setVisible(false);
				new passwordFinder().frame.setVisible(true);
			}
		});
		lblForgotYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotYourPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				frmIdentification.setVisible(false);
				new passwordFinder().frame.setVisible(true);
			}
		});
		lblForgotYourPassword.setForeground(Color.WHITE);
		lblForgotYourPassword.setBounds(57, 123, 303, 28);
		panel.add(lblForgotYourPassword);
	}
}
