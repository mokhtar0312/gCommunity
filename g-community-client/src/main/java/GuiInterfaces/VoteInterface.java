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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;

import repo.StatVote;
import delegate.ActiveMemberServicesDelegate;
import delegate.AuthentificationDelegate;
import delegate.VoteServicesDelegate;
import entities.ActiveMember;
import entities.Vote;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

public class VoteInterface {
	ActiveMember member = new ActiveMember();
	JFrame frame;
	String choix;
	private JTable table;
	private List<ActiveMember> memberssss = ActiveMemberServicesDelegate.doFindAllActiveMember();
	Integer id=null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoteInterface window = new VoteInterface();
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
		member = AuthentificationDelegate.doGetConectedPerson();
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
		JButton btnseeresult = new JButton("See Result");

		JPanel panel = new JPanel();
		panel.setBounds(218, 0, 702, 581);
		panel.setBackground(new Color(52, 73, 94));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JButton Elect_President = new JButton("Elect President");
		Elect_President.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(member.getRole().equals("President")){
					member.setRole("Event Member");
					ActiveMemberServicesDelegate.doUpdateActiveMember(member);
					ActiveMember newperz=ActiveMemberServicesDelegate.doFindActiveMemberById(id);
					newperz.setRole("President");
					ActiveMemberServicesDelegate.doUpdateActiveMember(newperz);
					
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "New President elected");	
				}
				else{
					
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Only the current president can do this operation");	
					
				}
			}
		});
		Elect_President.setBounds(230, 491, 287, 33);
		panel.add(Elect_President);
		

		btnseeresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StatVote pchart = new StatVote();
				pchart.setSize(600, 500);
				pchart.setVisible(true);

			}
		});
		btnseeresult.setBounds(230, 427, 287, 33);
		panel.add(btnseeresult);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(88, 97, 521, 193);
		panel.add(scrollPane);

		table = new JTable();
		ChangeEvent e = null;
		table.editingCanceled(e);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 1) {
					id=memberssss.get(table.getSelectedRow())
							.getId();
					
System.out.println(id);
				}
			}
		});
		scrollPane.setViewportView(table);
		JButton btnvote = new JButton("Vote");
		btnvote.setBounds(228, 359, 289, 33);
		panel.add(btnvote);
		
		
				JLabel lblNewLabel = new JLabel("Candidate List");
				lblNewLabel.setBounds(230, 32, 225, 33);
				panel.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setForeground(Color.WHITE);
		
		
		btnvote.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Boolean verif = false;
			
			List<Vote> votes = VoteServicesDelegate.findAllVotes();
			System.out.println("kabougaaa");

			for (Vote a : votes) {

				if (a.getActivemembervoter().getId().equals(member.getId())
						&& a.getYear().equals(
								Calendar.getInstance().get(Calendar.YEAR))) {
					verif = true;
					
				}
			}

			if (verif) {
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent,
						"You have even voted for this year");}
			
			
				else{
					List<ActiveMember> accounting;
				ActiveMember voted = ActiveMemberServicesDelegate.doFindActiveMemberById(id);
				
				
				VoteServicesDelegate.addVote(
						Calendar.getInstance().get(Calendar.YEAR),
						member.getId(), voted.getId());
				
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent,
						"Thank you for voting ");
				
				
				}
			
			
			
			
			
				

				
			}
		});
		//btnvote.setVisible(false);
		
		initDataBindings();

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
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				
				try {
					new VoteInterface().frame.setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				AuthentificationDelegate.doDisconnect();
				new Authentification().frmIdentification.setVisible(true);
			}
		});
		label_6.setBounds(21, 526, 164, 29);
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		panel_2.add(label_6);

	}
	protected void initDataBindings() {
		JTableBinding<ActiveMember, List<ActiveMember>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, memberssss, table);
		//
		BeanProperty<ActiveMember, String> activeMemberBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(activeMemberBeanProperty).setColumnName("Name");
		//
		BeanProperty<ActiveMember, String> activeMemberBeanProperty_1 = BeanProperty.create("surname");
		jTableBinding.addColumnBinding(activeMemberBeanProperty_1).setColumnName("Surname");
		//
		BeanProperty<ActiveMember, String> activeMemberBeanProperty_2 = BeanProperty.create("role");
		jTableBinding.addColumnBinding(activeMemberBeanProperty_2).setColumnName("Role");
		//
		jTableBinding.bind();
	}
}
