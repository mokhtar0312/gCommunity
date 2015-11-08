package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import delegate.ActiveMemberServicesDelegate;
import delegate.VoteServicesDelegate;
import entities.ActiveMember;
import entities.Vote;

public class VoteInterface {
	static ActiveMember member = new ActiveMember();
	JFrame frame;
	String choix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoteInterface window = new VoteInterface(member);
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
	public VoteInterface() throws NamingException {
		initialize();
	}

	public VoteInterface(ActiveMember member) throws NamingException {
		this.member = member;
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
		frame.getContentPane().setLayout(null);

		JButton btnCheckIfVote = new JButton("Check If Vote Is Possible");

		JButton btnNewButton = new JButton("Vote");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ActiveMember> accounting;
				ActiveMember voted = new ActiveMember();
				accounting = ActiveMemberServicesDelegate
						.doFindAllActiveMember();
				for (ActiveMember c : accounting) {
					if (c.getUsername().equals(choix)) {
						voted = c;
					}
				}
				VoteServicesDelegate.addVote(
						Calendar.getInstance().get(Calendar.YEAR),
						voted.getId(), member.getId());
			}
		});
		btnNewButton.setVisible(false);
		btnNewButton.setBounds(469, 263, 194, 33);
		frame.getContentPane().add(btnNewButton);

		JComboBox<String> comboType = new JComboBox<String>();
		frame.getContentPane().add(comboType);
		comboType.setVisible(false);
		comboType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<ActiveMember> accounting;
				accounting = ActiveMemberServicesDelegate
						.doFindAllActiveMember();
				for (ActiveMember c : accounting) {
					comboType.addItem(c.getUsername());

					choix = comboType.getSelectedItem().toString();
				}

			}
		});
		comboType.setBounds(357, 113, 410, 60);

		ConsulterCandidat panel = new ConsulterCandidat();
		panel.setBounds(218, 0, 699, 581);
		panel.setBackground(new Color(52, 73, 94));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		btnCheckIfVote.setBounds(228, 393, 287, 33);
		panel.add(btnCheckIfVote);

		btnCheckIfVote.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				System.out.println(member.getName() + member.getServer());

				Vote vote = new Vote();
				List<Vote> votes = VoteServicesDelegate.findAllVotes();
				System.out.println("kabougaaa");

				for (Vote a : votes) {

					if (a.getActivemembervoter().equals(member)
							&& a.getYear().equals(
									Calendar.getInstance().get(Calendar.YEAR))) {
						vote = a;
					}
				}

				// if(vote == null){
				panel.setVisible(false);
				btnCheckIfVote.setVisible(false);
				JPanel panel = new JPanel();
				panel.setBounds(218, 0, 699, 581);
				panel.setBackground(new Color(52, 73, 94));
				frame.getContentPane().add(panel);
				panel.setLayout(null);
				comboType.setVisible(true);
				btnNewButton.setVisible(true);
				// }
				// else{
				// JFrame parent = new JFrame();
				// JOptionPane.showMessageDialog(parent,
				// "You have even voted for this year");
				//
				//
				//
				// }

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(208, 0, 10, 581);
		panel_1.setBackground(new Color(241, 196, 15));
		frame.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 208, 581);
		panel_2.setBackground(new Color(52, 73, 94));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("My Profile");
		label.setBounds(10, 85, 188, 53);
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label.setBackground(Color.ORANGE);
		panel_2.add(label);

		JLabel label_1 = new JLabel("Home");
		label_1.setBounds(0, 0, 208, 53);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("Members");
		label_2.setBounds(10, 149, 188, 53);
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_2.setBackground(Color.ORANGE);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Game");
		label_3.setBounds(10, 213, 188, 53);
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_3.setBackground(Color.ORANGE);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("Tournaments");
		label_4.setBounds(10, 277, 188, 57);
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_4.setBackground(Color.ORANGE);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("Vote");
		label_5.setBounds(10, 345, 188, 53);
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_5.setBackground(Color.ORANGE);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("Log Out");
		label_6.setBounds(21, 526, 164, 29);
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		panel_2.add(label_6);

		JLabel lblNewLabel = new JLabel("Candidate List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(450, 52, 225, 33);
		frame.getContentPane().add(lblNewLabel);

	}
}
