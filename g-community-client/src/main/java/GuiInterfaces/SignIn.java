package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import delegate.ActiveMemberServicesDelegate;
import entities.ActiveMember;

public class SignIn {

	public JFrame frmSignIn;
	private JTextField tfSurname;
	private JTextField tfUsername;
	private JTextField tfSumoner;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JTextField tfEmail;
	private JTextField tfName;
	private JTextField tfphone;

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

		tfSurname = new JTextField();
		tfSurname.setBounds(147, 84, 126, 20);
		panel.add(tfSurname);
		tfSurname.setColumns(10);

		tfUsername = new JTextField();
		tfUsername.setBounds(147, 125, 126, 20);
		panel.add(tfUsername);
		tfUsername.setColumns(10);

		tfSumoner = new JTextField();
		tfSumoner.setBounds(514, 125, 126, 20);
		panel.add(tfSumoner);
		tfSumoner.setColumns(10);

		JLabel erreurusername = new JLabel("The Username Exist !!!");
		erreurusername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		erreurusername.setHorizontalAlignment(SwingConstants.CENTER);
		erreurusername.setForeground(Color.RED);
		erreurusername.setBounds(260, 302, 150, 14);
		erreurusername.setVisible(false);
		panel.add(erreurusername);

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

		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(147, 211, 126, 20);
		panel.add(passwordFieldConfirm);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setBounds(32, 211, 105, 14);
		panel.add(lblConfirmPassword);

		tfEmail = new JTextField();
		tfEmail.setBounds(147, 254, 126, 20);
		panel.add(tfEmail);
		tfEmail.setColumns(10);

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

		JComboBox cbServer = new JComboBox();
		cbServer.setModel(new DefaultComboBoxModel(new String[] {
				"North America", "Eu West", "Eu Nordic & East",
				"Latin America North", "Latin America South", "Brazil",
				"Turkey", "Russia", "Oceania" }));
		cbServer.setBounds(514, 166, 126, 20);
		panel.add(cbServer);

		tfName = new JTextField();
		tfName.setBounds(147, 42, 126, 20);
		panel.add(tfName);
		tfName.setColumns(10);

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

		tfphone = new JTextField();
		tfphone.setBounds(514, 43, 126, 20);
		panel.add(tfphone);
		tfphone.setColumns(10);

		JComboBox cbRole = new JComboBox();
		cbRole.setModel(new DefaultComboBoxModel(new String[] { "Event Member",
				"Technical Member", "Media Member",
				"Partners & Management Member", "Trainer" }));
		cbRole.setBounds(514, 84, 126, 20);
		panel.add(cbRole);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignIn.setVisible(false);
				new Authentification().frmIdentification.setVisible(true);

			}
		});
		btnNewButton.setBounds(147, 342, 126, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				// //////

				ActiveMember memberCreated = new ActiveMember();

				// ///////////////////
				String name = tfName.getText();
				String surname = tfSurname.getText();
				String username = tfUsername.getText();
				String password = passwordField.getText();
				String passwordcnfirm = passwordFieldConfirm.getText();
				String summonerName = tfSumoner.getText();
				String server = (String) cbServer.getSelectedItem();
				String email = tfEmail.getText();
				Integer phone = Integer.parseInt((tfphone.getText()));
				String role = (String) cbRole.getSelectedItem();

				// ///
				memberCreated.setApproved(true);
				memberCreated.setName(name);
				memberCreated.setSurname(surname);
				memberCreated.setUsername(username);
				memberCreated.setPassword(password);
				memberCreated.setSummonerName(summonerName);
				memberCreated.setServer(server);
				memberCreated.setEmail(email);
				memberCreated.setPhone(phone);
				memberCreated.setRole(role);

				Boolean tester=false;
				List<ActiveMember> aa = ActiveMemberServicesDelegate
						.doFindAllActiveMember();
				for (ActiveMember a : aa) {

					if (a.getUsername().equals(username)) {
						tester=true;
					}
				}
				if (tester) {
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Existing Username");
					

				} else {
					ActiveMemberServicesDelegate
							.doAddActiveMember(memberCreated);
					frmSignIn.setVisible(false);
					new Authentification().frmIdentification.setVisible(true);

				}
			}
		});
		btnNewButton_1.setBounds(385, 342, 126, 23);
		panel.add(btnNewButton_1);

	}
}
