package GuiInterfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Canvas;

public class SignIn {

	private JFrame frmSignIn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frmSignIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignIn = new JFrame();
		frmSignIn.setTitle("        Sign In");
		frmSignIn.setBounds(100, 100, 704, 449);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignIn.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(44, 62, 80));
		panel.setBounds(0, 0, 688, 410);
		frmSignIn.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(147, 84, 126, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 125, 126, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(514, 125, 126, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(32, 42, 73, 20);
		panel.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(32, 84, 73, 14);
		panel.add(lblSurname);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(32, 125, 77, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(32, 168, 77, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 168, 126, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(147, 211, 126, 20);
		panel.add(passwordField_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setBounds(32, 211, 105, 14);
		panel.add(lblConfirmPassword);
		
		textField_3 = new JTextField();
		textField_3.setBounds(147, 254, 126, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(32, 257, 105, 14);
		panel.add(lblEmail);
		
		JLabel lblSumonerName = new JLabel("Sumoner Name");
		lblSumonerName.setForeground(Color.WHITE);
		lblSumonerName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSumonerName.setBounds(385, 124, 99, 20);
		panel.add(lblSumonerName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"North America", "Eu West", "Eu Nordic & East", "Latin America North", "Latin America South", "Brazil", "Turkey", "Russia", "Oceania"}));
		comboBox.setBounds(514, 166, 126, 20);
		panel.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 42, 126, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setForeground(Color.WHITE);
		lblServer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblServer.setBounds(385, 165, 73, 20);
		panel.add(lblServer);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(385, 42, 99, 20);
		panel.add(lblPhone);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRole.setBounds(385, 87, 99, 20);
		panel.add(lblRole);
		
		textField_5 = new JTextField();
		textField_5.setBounds(514, 43, 126, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Event Member", "Technical Member", "Media Member", "Partners & Management Member", "Trainer"}));
		comboBox_1.setBounds(514, 84, 126, 20);
		panel.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(147, 342, 126, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(385, 342, 126, 23);
		panel.add(btnNewButton_1);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(340, 243, 156, 18);
		panel.add(canvas);
	}
}
