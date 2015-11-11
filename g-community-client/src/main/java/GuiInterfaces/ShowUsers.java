package GuiInterfaces;

import gui.NewsCrud;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import repo.AccountListed;
import AyoubGui.TutorialCrud;
import anisGUI.UserProfil;

public class ShowUsers {

	public JFrame frame;
	private JTable table1;
	private AccountListed modele;
	int row;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowUsers window = new ShowUsers();
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
	public ShowUsers() throws NamingException {
		initialize();
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

		ShowUsersFrame panel_2 = new ShowUsersFrame();
		panel_2.setBackground(new Color(52, 73, 94));
		panel_2.setBounds(218, 0, 702, 581);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 208, 581);
		frame.getContentPane().add(panel);

		JLabel label_1 = new JLabel("Home");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(0, 0, 208, 53);
		panel.add(label_1);

		JLabel label = new JLabel("My Profile");
		label.addMouseListener(new MouseAdapter() {
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
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label.setBackground(Color.ORANGE);
		label.setBounds(10, 87, 188, 38);
		panel.add(label);

		JLabel label_2 = new JLabel("Members");
		label_2.addMouseListener(new MouseAdapter() {
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
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(10, 133, 188, 38);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Game");
		label_3.addMouseListener(new MouseAdapter() {
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
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(10, 182, 188, 38);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Tournaments");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				try {
					TournamentManagement a = new TournamentManagement();
					a.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_4.setBackground(Color.ORANGE);
		label_4.setBounds(10, 231, 188, 38);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Vote");
		label_5.addMouseListener(new MouseAdapter() {
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
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_5.setBackground(Color.ORANGE);
		label_5.setBounds(10, 280, 188, 38);
		panel.add(label_5);

		JLabel label_6 = new JLabel("News");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);

				NewsCrud a = new NewsCrud();
				a.setVisible(true);
			}
		});
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		label_6.setBounds(10, 329, 188, 38);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Tutorial");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);

				TutorialCrud a = new TutorialCrud();
				a.setVisible(true);
			}
		});
		label_7.setOpaque(true);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_7.setBackground(Color.ORANGE);
		label_7.setBounds(10, 378, 188, 38);
		panel.add(label_7);

		JLabel label_8 = new JLabel("Logistics");
		label_8.addMouseListener(new MouseAdapter() {
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
		label_8.setOpaque(true);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.DARK_GRAY);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_8.setBackground(Color.ORANGE);
		label_8.setBounds(10, 427, 188, 38);
		panel.add(label_8);

		JLabel label_9 = new JLabel("Log Out");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new Authentification().frmIdentification.setVisible(true);
			}
		});
		label_9.setOpaque(true);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_9.setBackground(Color.ORANGE);
		label_9.setBounds(21, 528, 164, 29);
		panel.add(label_9);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 196, 15));
		panel_1.setBounds(208, 0, 10, 581);
		frame.getContentPane().add(panel_1);

		modele = new AccountListed();
		System.out.println("aazz");

		// modele.setSimpleMembers(SimpleMemberdelegate.findAllSimpleMember());
		System.out.println("aa");
		table = new JTable(modele);
		System.out.println("oo");
		table.setAutoCreateRowSorter(true);
		System.out.println("ii");
		System.out.println(table.getRowCount());

	}
}
