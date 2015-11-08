package GuiInterfaces;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import delegate.ActiveMemberServicesDelegate;
import entities.ActiveMember;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import repo.AfficherEventAdapter;

public class UserProfil {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ActiveMember am =
	// ActiveMemberServicesDelegate.doFindActiveMemberById(11);
	ActiveMember am = new ActiveMember();
	ActiveMember admin = ActiveMemberServicesDelegate.doFindActiveMemberById(12);
	String username=admin.getSurname();
	String password=admin.getPassword();




	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
					UserProfil window = new UserProfil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws NamingException 
	 */
	public UserProfil() throws NamingException {
		am.setName("ani");
		am.setSurname("aaa");
		am.setUsername("fghj");
		am.setPassword("fghj");
		am.setSummonerName("iu");
		am.setEmail("ajkbhjh");
		initialize();
		textField.setText(am.getName());
		textField_1.setText(am.getSurname());
		textField_2.setText(am.getUsername());
		textField_3.setText(am.getPassword());
		textField_4.setText(am.getSummonerName());
		textField_5.setText(am.getEmail());

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize() throws NamingException {
		frame = new JFrame();
		frame.setBounds(100, 100, 936, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 208, 581);
		frame.getContentPane().add(panel);

		JLabel label = new JLabel("My Profile");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label.setBackground(Color.ORANGE);
		label.setBounds(10, 85, 188, 53);
		panel.add(label);

		JLabel label_1 = new JLabel("Home");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(0, 0, 208, 53);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Members");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(10, 149, 188, 53);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Game");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(10, 213, 188, 53);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Tournaments");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_4.setBackground(Color.ORANGE);
		label_4.setBounds(10, 277, 188, 57);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Vote");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_5.setBackground(Color.ORANGE);
		label_5.setBounds(10, 345, 188, 53);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Log Out");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
					frame.setVisible(false);
					new Authentification().frmIdentification.setVisible(true);
					
					
			}
		});
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		label_6.setBounds(21, 526, 164, 29);
		panel.add(label_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(52, 73, 94));
		panel_1.setBounds(217, 2, 701, 581);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 689, 559);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(new Color(52, 73, 94));
		panel_1.add(tabbedPane);

		ConsulterMessageAdmin Message = new ConsulterMessageAdmin(admin);
		Message.setLayout(null);
		Message.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("  All Messages  ", null, Message, null);

		NewMessage nvmj = new NewMessage(admin , username, password);
		nvmj.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("New Message", null, nvmj, null);

		AficherEvent event = new AficherEvent(admin);
		event.setLayout(null);
		event.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("My Events", null, event, null);

		JPanel achievement = new JPanel();
		achievement.setLayout(null);
		achievement.setOpaque(true);
		achievement.setBorder(null);
		achievement.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("Achievement", null, achievement, null);

		JLabel lblimage = new JLabel("");
		lblimage.setIcon(new ImageIcon(UserProfil.class
				.getResource("/images/ghc.png")));
		lblimage.setBounds(77, 41, 76, 105);
		achievement.add(lblimage);

		JLabel label_7 = new JLabel("Name :");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setBounds(275, 91, 71, 21);
		achievement.add(label_7);

		JLabel lblSurname = new JLabel(" Surname :");
		lblSurname.setHorizontalAlignment(SwingConstants.LEFT);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(270, 137, 71, 21);
		achievement.add(lblSurname);

		JLabel label_9 = new JLabel("Username :");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setBounds(276, 185, 71, 21);
		achievement.add(label_9);

		JLabel label_12 = new JLabel("Password :");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setBounds(274, 232, 71, 21);
		achievement.add(label_12);

		JLabel label_14 = new JLabel("SunmonerName :");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setForeground(Color.WHITE);
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setBounds(272, 282, 112, 21);
		achievement.add(label_14);

		JLabel label_16 = new JLabel("Email :");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_16.setForeground(Color.WHITE);
		label_16.setHorizontalAlignment(SwingConstants.LEFT);
		label_16.setBounds(271, 328, 83, 21);
		achievement.add(label_16);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(401, 93, 138, 20);
		textField.setBackground(new Color(52, 73, 94));
		achievement.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(52, 73, 94));
		textField_1.setBounds(401, 139, 138, 20);
		achievement.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(52, 73, 94));
		textField_2.setBounds(401, 187, 138, 20);
		achievement.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(52, 73, 94));
		textField_3.setBounds(401, 234, 138, 20);
		achievement.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(52, 73, 94));
		textField_4.setBounds(401, 282, 138, 20);
		achievement.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(52, 73, 94));
		textField_5.setBounds(401, 328, 169, 20);
		achievement.add(textField_5);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String url = "https://www.facebook.com/pages/Codein-junkies/1380504912264014?skip_nax_wizard=true&ref_type=bookmark";

					Desktop dt = Desktop.getDesktop();
					URI uri = new URI(url);
					dt.browse(uri.resolve(uri));

				} catch (URISyntaxException ex) {

				} catch (IOException ex) {
				}
			}
		});
		button.setIcon(new ImageIcon(UserProfil.class
				.getResource("/images/fbc.png")));
		button.setBounds(52, 461, 45, 43);
		achievement.add(button);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(205, 0, 10, 581);
		frame.getContentPane().add(panel_6);
		panel_6.setBackground(new Color(241, 196, 15));
	}
}
