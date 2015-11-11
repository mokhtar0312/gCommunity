package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import delegate.ActiveMemberServicesDelegate;
import delegate.MailServicesDelegate;
import entities.ActiveMember;

public class passwordFinder {

	JFrame frame;
	private JTextField tfemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passwordFinder window = new passwordFinder();
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
	public passwordFinder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(44, 62, 80));
		panel.setBounds(0, 0, 434, 205);
		frame.getContentPane().add(panel);

		JLabel lblEnterYourEmail = new JLabel("Enter your Email ");
		lblEnterYourEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterYourEmail.setForeground(Color.WHITE);
		lblEnterYourEmail.setBounds(35, 66, 123, 14);
		panel.add(lblEnterYourEmail);

		tfemail = new JTextField();
		tfemail.setBounds(204, 65, 180, 20);
		panel.add(tfemail);
		tfemail.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = tfemail.getText();
				Random ran = new Random();
				int top = 10;
				char data = ' ';
				String dat = "";

				for (int i = 0; i < top; i++) {
					data = (char) (ran.nextInt(25) + 97);
					dat = data + dat;
				}
				String newpass = dat;

				ActiveMember found = new ActiveMember();
				List<ActiveMember> aa = ActiveMemberServicesDelegate
						.doFindAllActiveMember();
				for (ActiveMember a : aa) {

					if (a.getEmail().equals(email)) {
						found = a;
					}
				}

				found.setPassword(newpass);
				ActiveMemberServicesDelegate.doUpdateActiveMember(found);
				try {
					MailServicesDelegate.doMail("Password changing",
							"Here u re new password    " + newpass, email);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;
				frame.setVisible(false);
				new Authentification().frmIdentification.setVisible(true);

			}
		});
		btnSend.setBounds(229, 119, 89, 23);
		panel.add(btnSend);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Authentification().frmIdentification.setVisible(true);
			}
		});
		btnBack.setBounds(89, 119, 89, 23);
		panel.add(btnBack);
	}
}
