package anisGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import AyoubGui.TutorialCrud;
import GuiInterfaces.Authentification;
import GuiInterfaces.BoostingTemplate;
import GuiInterfaces.Logistics;
import GuiInterfaces.ShowUsers;
import GuiInterfaces.TournamentManagement;
import GuiInterfaces.VoteInterface;
import delegate.AuthentificationDelegate;
import delegate.SimpleMemberdelegate;
import entities.ActiveMember;
import gui.NewsCrud;

public class UserProfil {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ActiveMember am =
	// ActiveMemberServicesDelegate.doFindActiveMemberById(11);
	ActiveMember admin = AuthentificationDelegate.doGetConectedPerson();
	String username = admin.getSurname();
	String password = admin.getPassword();

	public JFrame frame;
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
	 * 
	 * @throws NamingException
	 */
	public UserProfil() throws NamingException {

		initialize();
		textField.setText(admin.getName());
		textField_1.setText(admin.getSurname());
		textField_2.setText(admin.getUsername());
		textField_3.setText(admin.getPassword());
		textField_4.setText(admin.getSummonerName());
		textField_5.setText(admin.getEmail());

	}

	/**
	 * Initialize the contents of the frame.
	 * 
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

		JLabel lblProfile = new JLabel("My Profile");
		lblProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					frame.setVisible(false);
					new UserProfil().frame.setVisible(true);			
					} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblProfile.setOpaque(true);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(Color.DARK_GRAY);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfile.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		lblProfile.setBackground(Color.ORANGE);
		lblProfile.setBounds(10, 85, 188, 38);
		panel.add(lblProfile);

		JLabel label_1 = new JLabel("Home");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(0, 0, 208, 53);
		panel.add(label_1);

		JLabel lblmember = new JLabel("Members");
		lblmember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					frame.setVisible(false);
					new ShowUsers().frame.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblmember.setOpaque(true);
		lblmember.setHorizontalAlignment(SwingConstants.CENTER);
		lblmember.setForeground(Color.DARK_GRAY);
		lblmember.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblmember.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		lblmember.setBackground(Color.ORANGE);
		lblmember.setBounds(10, 131, 188, 38);
		panel.add(lblmember);

		JLabel lbGame = new JLabel("Game");
		lbGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				try {
					new BoostingTemplate().frame.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbGame.setOpaque(true);
		lbGame.setHorizontalAlignment(SwingConstants.CENTER);
		lbGame.setForeground(Color.DARK_GRAY);
		lbGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGame.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		lbGame.setBackground(Color.ORANGE);
		lbGame.setBounds(10, 180, 188, 38);
		panel.add(lbGame);

		JLabel lblTournament = new JLabel("Tournaments");
		lblTournament.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				try {
				TournamentManagement a=	new TournamentManagement() ;
				a.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblTournament.setOpaque(true);
		lblTournament.setHorizontalAlignment(SwingConstants.CENTER);
		lblTournament.setForeground(Color.DARK_GRAY);
		lblTournament.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTournament.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		lblTournament.setBackground(Color.ORANGE);
		lblTournament.setBounds(10, 229, 188, 38);
		panel.add(lblTournament);

		JLabel lblVote = new JLabel("Vote");
		lblVote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				try {
					new VoteInterface().frame.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblVote.setOpaque(true);
		lblVote.setHorizontalAlignment(SwingConstants.CENTER);
		lblVote.setForeground(Color.DARK_GRAY);
		lblVote.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVote.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		lblVote.setBackground(Color.ORANGE);
		lblVote.setBounds(10, 278, 188, 38);
		panel.add(lblVote);

		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.setVisible(false);
				new Authentification().frmIdentification.setVisible(true);

			}
		});
		lblLogout.setOpaque(true);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.DARK_GRAY);
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogout.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		lblLogout.setBackground(Color.ORANGE);
		lblLogout.setBounds(21, 526, 164, 29);
		panel.add(lblLogout);
		
		JLabel lblNews = new JLabel("News");
		lblNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				
				NewsCrud a=	new NewsCrud() ;
				a.setVisible(true);
				
			}
		});
		lblNews.setOpaque(true);
		lblNews.setHorizontalAlignment(SwingConstants.CENTER);
		lblNews.setForeground(Color.DARK_GRAY);
		lblNews.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNews.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		lblNews.setBackground(Color.ORANGE);
		lblNews.setBounds(10, 327, 188, 38);
		panel.add(lblNews);
		
		JLabel lblTutorial = new JLabel("Tutorial");
		lblTutorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
               frame.setVisible(false);
				
				TutorialCrud a=	new TutorialCrud() ;
				a.setVisible(true);
				
			}
		});
		lblTutorial.setOpaque(true);
		lblTutorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTutorial.setForeground(Color.DARK_GRAY);
		lblTutorial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTutorial.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		lblTutorial.setBackground(Color.ORANGE);
		lblTutorial.setBounds(10, 376, 188, 38);
		panel.add(lblTutorial);
		
		JLabel lblLogistics = new JLabel("Logistics");
		lblLogistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				try {
					new Logistics().frame.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblLogistics.setOpaque(true);
		lblLogistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogistics.setForeground(Color.DARK_GRAY);
		lblLogistics.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogistics.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		lblLogistics.setBackground(Color.ORANGE);
		lblLogistics.setBounds(10, 425, 188, 38);
		panel.add(lblLogistics);

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

		JPanel achievement = new JPanel();
		achievement.setLayout(null);
		achievement.setOpaque(true);
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
		textField.setEditable(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(401, 93, 169, 20);
		textField.setBackground(new Color(52, 73, 94));
		achievement.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(52, 73, 94));
		textField_1.setBounds(401, 139, 169, 20);
		achievement.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(52, 73, 94));
		textField_2.setBounds(401, 187, 169, 20);
		achievement.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(52, 73, 94));
		textField_3.setBounds(401, 234, 169, 20);
		achievement.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(52, 73, 94));
		textField_4.setBounds(401, 282, 169, 20);
		achievement.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(52, 73, 94));
		textField_5.setBounds(401, 328, 169, 20);
		achievement.add(textField_5);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.setName(textField.getText());
				admin.setSurname(textField_1.getText());
				admin.setUsername(textField_2.getText());
				admin.setPassword(textField_3.getText());
				admin.setSummonerName(textField_4.getText());
				admin.setEmail(textField_5.getText());
				try {
					SimpleMemberdelegate.doUpdateSimpleMember(admin);

					JOptionPane.showMessageDialog(null, "Success!!", "Good :D",
							JOptionPane.OK_CANCEL_OPTION);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error!!", "X",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnNewButton.setBounds(527, 403, 89, 23);
		achievement.add(btnNewButton);

		AfficherMessage Message = new AfficherMessage(admin);
		Message.setLayout(null);
		Message.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("  All Messages  ", null, Message, null);

		NewMessage nvmj = new NewMessage(admin, username, password);
		nvmj.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("New Message", null, nvmj, null);

		AficherUserEvent event = new AficherUserEvent(admin);
		event.setLayout(null);
		event.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("My Events", null, event, null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(205, 0, 15, 581);
		frame.getContentPane().add(panel_6);
		panel_6.setBackground(new Color(241, 196, 15));
	}
}
