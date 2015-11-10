package GuiInterfaces;

import java.awt.EventQueue;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoostingTemplate {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoostingTemplate window = new BoostingTemplate();
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
	public BoostingTemplate() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 */
	private void initialize() throws NamingException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(52, 73, 94));
		frame.setBounds(100, 100, 859, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Elo Boosting");
		
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
		label_2.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(10, 149, 188, 53);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Game");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(10, 213, 188, 53);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Tournaments");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.setVisible(false);
				 try {
					TournamentManagement a=new TournamentManagement();
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
		label_4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label_4.setBackground(Color.ORANGE);
		label_4.setBounds(10, 277, 188, 57);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Vote");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
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
		label_6.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		label_6.setBounds(21, 526, 164, 29);
		panel.add(label_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 196, 15));
		panel_1.setBounds(207, 0, 3, 581);
		frame.getContentPane().add(panel_1);
		
		BoostingTab showUsersFrame = new BoostingTab();
		showUsersFrame.setBackground(new Color(52, 73, 94));
		showUsersFrame.setBounds(211, 0, 709, 581);
		frame.getContentPane().add(showUsersFrame);
	}
}
