package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class TournamenManagementMenu {
private int test;
	private JFrame trounamentM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TournamenManagementMenu window = new TournamenManagementMenu();
					window.trounamentM.setVisible(true);
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
	public TournamenManagementMenu() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize() throws NamingException {
		trounamentM = new JFrame();
		trounamentM.setTitle("        G Community");
		trounamentM.setBounds(100, 100, 936, 620);
		trounamentM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		trounamentM.getContentPane().setLayout(null);
		
		TournamentManagement panel_1 = new TournamentManagement();
		panel_1.setBounds(211, 0, 709, 581);
		panel_1.setBackground(new Color(52, 73, 94));
		trounamentM.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(241, 196, 15));
		panel_2.setBounds(208, 0, 3, 581);
		trounamentM.getContentPane().add(panel_2);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(52, 73, 94));
		panel_menu.setBounds(0, 0, 208, 581);
		trounamentM.getContentPane().add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMyProfile.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		lblMyProfile.setForeground(Color.DARK_GRAY);
		lblMyProfile.setBackground(new Color(255, 200, 0));
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setOpaque(true);
		lblMyProfile.setBounds(10, 85, 188, 53);
		panel_menu.add(lblMyProfile);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 208, 53);
		panel_menu.add(lblNewLabel);
		
		JLabel label = new JLabel("Members");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setBackground(Color.ORANGE);
		label.setBounds(10, 149, 188, 53);
		panel_menu.add(label);
		
		JLabel label_1 = new JLabel("Game");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setBackground(Color.ORANGE);
		label_1.setBounds(10, 213, 188, 53);
		panel_menu.add(label_1);
		
		JLabel label_2 = new JLabel("Tournaments");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(10, 277, 188, 57);
		panel_menu.add(label_2);
		
		JLabel lblVote = new JLabel("Vote");
		lblVote.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVote.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		lblVote.setOpaque(true);
		lblVote.setHorizontalAlignment(SwingConstants.CENTER);
		lblVote.setForeground(Color.DARK_GRAY);
		lblVote.setBackground(Color.ORANGE);
		lblVote.setBounds(10, 345, 188, 53);
		
		panel_menu.add(lblVote);
		
		JLabel lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogOut.setOpaque(true);
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(Color.DARK_GRAY);
		lblLogOut.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		lblLogOut.setBackground(Color.ORANGE);
		lblLogOut.setBounds(21, 526, 164, 29);
		panel_menu.add(lblLogOut);
	}
}