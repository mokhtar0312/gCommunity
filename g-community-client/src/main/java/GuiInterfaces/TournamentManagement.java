package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.naming.NamingException;
import javax.naming.event.EventDirContext;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import delegate.EventServiceDelegate;
import delegate.NewsServicesDelegate;
import entities.Event;
import gui.NewsCrud;
import repo.AccountBySearsh;
import repo.EventModel;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Font;

import javax.swing.SwingConstants;

import AyoubGui.TutorialCrud;
import anisGUI.UserProfil;

public class TournamentManagement  extends JFrame {

	public JPanel contentPane;
//	private JTable table_1;
	private JTable table;
	int row;
	int cb_number;
	
	
	Calendar TodayCalendar = Calendar.getInstance();
	private JButton btnDelete;
	private JTextField login;
	private JTextField pwd;
	private JTextField pseudo;
	private JEditorPane dtrpnLogin;
	private JEditorPane dtrpnPassword;
	private JEditorPane dtrpnPseudo;
	private JTextField searchh;
	public  JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TournamentManagement frame = new TournamentManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	
	/**
	 * Create the frame.
	 * 
	 * @throws NamingException
	 */
	public TournamentManagement() throws NamingException {
		EventModel modele = new EventModel();

		// ArrayList<Gamer> List_Gamers=(ArrayList<Gamer>)
		// proxyGamer.readAllGamer();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52, 73, 94));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Tournament Management");
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println("aaa" + test + row);
			}
		});
		scrollPane.setBounds(467, 124, 340, 217);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);
				
				int id = Integer.parseInt(test);
				Event account = new Event();
				account = EventServiceDelegate.DoFindEventById(id);
				login.setText(account.getDescription());
				pwd.setText(Integer.toString(account.getNumberOfParticipants()));
				pseudo.setText(Double.toString(account.getFee()));

			}
		});
		
		scrollPane.setViewportView(table);
		table.setModel(modele);
		
		
			
			JButton upda = new JButton("UPDATE");
			upda.setForeground(new Color(0, 0, 102));
			upda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String test = table.getModel().getValueAt(row, 0).toString();
					int id = Integer.parseInt(test);
					Event account = new Event();
					account = EventServiceDelegate.DoFindEventById(id);
					
					
					
					//pwd*/
				Event account_found = new Event();
	              //  account_found = Accountdelegate.findAccountById(id);
			account.setDescription(login.getText());
					account.setFee(Double.parseDouble(pwd.getText()));
					account.setName(pseudo.getText());
					System.out.println("cbn");
				
				
					EventServiceDelegate.DoUpdateEvent(account);
					System.out.println("kizebbi");
					modele.refresh();
					modele.fireTableDataChanged();
					
				
			}});
				upda.setBounds(352, 318, 89, 23);
				contentPane.add(upda);
				
				btnDelete = new JButton("DELETE");
				btnDelete.setForeground(new Color(51, 0, 102));
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						int action = JOptionPane.showConfirmDialog(null,
								"Do you really wan't to suspend the account", "ban",
								JOptionPane.YES_NO_OPTION);
						String test = table.getModel().getValueAt(row, 0).toString();
						int id = Integer.parseInt(test);
						System.out.println(test);
						Event account_found = new Event();
						account_found = EventServiceDelegate.DoFindEventById(id);
						EventServiceDelegate.DoDeleteEventById(id);
					  table.setModel(modele);
					  modele.refresh();
					  modele.fireTableDataChanged();
						
						
					}
				});
				btnDelete.setBounds(598, 423, 89, 23);
				contentPane.add(btnDelete);
				
				login = new JTextField();
				login.setBounds(352, 169, 89, 20);
				contentPane.add(login);
				login.setColumns(10);
				
				pwd = new JTextField();
				pwd.setBounds(352, 215, 89, 20);
				contentPane.add(pwd);
				pwd.setColumns(10);
				
				pseudo = new JTextField();
				pseudo.setBounds(352, 259, 89, 20);
				contentPane.add(pseudo);
				pseudo.setColumns(10);
				
				dtrpnLogin = new JEditorPane();
				dtrpnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
				dtrpnLogin.setForeground(Color.YELLOW);
				dtrpnLogin.setBackground(new Color(52, 73, 94));
				dtrpnLogin.setText("Description  :");
				dtrpnLogin.setBounds(239, 169, 106, 20);
				contentPane.add(dtrpnLogin);
				
				dtrpnPassword = new JEditorPane();
				dtrpnPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
				dtrpnPassword.setForeground(Color.YELLOW);
				dtrpnPassword.setBackground(new Color(52, 73, 94));
				dtrpnPassword.setText("Participants :");
				dtrpnPassword.setBounds(239, 215, 106, 20);
				contentPane.add(dtrpnPassword);
				
				dtrpnPseudo = new JEditorPane();
				dtrpnPseudo.setFont(new Font("Tahoma", Font.BOLD, 14));
				dtrpnPseudo.setForeground(Color.YELLOW);
				dtrpnPseudo.setBackground(new Color(52, 73, 94));
				dtrpnPseudo.setText("Fee value     :");
				dtrpnPseudo.setBounds(239, 259, 106, 20);
				contentPane.add(dtrpnPseudo);
				
				JButton btnBack = new JButton("REFRESH");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TournamentManagement frame = null;
						try {
							frame = new TournamentManagement();
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        setVisible(false);
				        frame.setVisible(true);
				    }
					
				});
				btnBack.setForeground(new Color(0, 0, 102));
				btnBack.setBounds(491, 423, 89, 23);
				contentPane.add(btnBack);
				
				JButton btnAdd = new JButton("ADD");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						new AddTournament().frame.setVisible(true);
						
					}
				});
				btnAdd.setForeground(new Color(0, 0, 102));
				btnAdd.setBounds(704, 423, 89, 23);
				contentPane.add(btnAdd);
				
				JLabel lblSeashBy = new JLabel("Searsh By :");
				lblSeashBy.setForeground(Color.YELLOW);
				lblSeashBy.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSeashBy.setBounds(467, 77, 89, 23);
				contentPane.add(lblSeashBy);
				
				searchh = new JTextField();
				searchh.setBounds(566, 80, 89, 20);
				contentPane.add(searchh);
				searchh.setColumns(10);
				
				JButton btnSearsh = new JButton("SEARSH");
				btnSearsh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s=searchh.getText();
				
						try {
							System.out.println("hedhi s "+s);
							AccountBySearsh mod=new AccountBySearsh(s);
							System.out.println("dkhalllt");
							table.setModel(mod);
							mod.refresh();
							mod.fireTableDataChanged();
							
						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnSearsh.setForeground(Color.BLUE);
				btnSearsh.setFont(new Font("Tahoma", Font.PLAIN, 11));
				btnSearsh.setBounds(684, 79, 89, 23);
				contentPane.add(btnSearsh);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(241, 196, 15));
				panel.setBounds(205, 0, 15, 581);
				contentPane.add(panel);
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(52, 73, 94));
				panel_1.setBounds(0, 0, 208, 581);
				contentPane.add(panel_1);
				
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
				label.setBounds(10, 85, 188, 38);
				panel_1.add(label);
				
				JLabel label_1 = new JLabel("Home");
				label_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_1.setBounds(0, 0, 208, 53);
				panel_1.add(label_1);
				
				JLabel label_2 = new JLabel("Members");
				label_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						try {
							
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
				label_2.setBounds(10, 131, 188, 38);
				panel_1.add(label_2);
				
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
				label_3.setBounds(10, 180, 188, 38);
				panel_1.add(label_3);
				
				JLabel label_4 = new JLabel("Tournaments");
				label_4.addMouseListener(new MouseAdapter() {
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
				label_4.setOpaque(true);
				label_4.setHorizontalAlignment(SwingConstants.CENTER);
				label_4.setForeground(Color.DARK_GRAY);
				label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_4.setBorder(new MatteBorder(1, 1, 3, 3,
								(Color) new Color(0, 0, 0)));
				label_4.setBackground(Color.ORANGE);
				label_4.setBounds(10, 229, 188, 38);
				panel_1.add(label_4);
				
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
				label_5.setBounds(10, 278, 188, 38);
				panel_1.add(label_5);
				
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
				panel_1.add(label_6);
				
				JLabel label_7 = new JLabel("News");
				label_7.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						
						NewsCrud a=	new NewsCrud() ;
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
				label_7.setBounds(10, 327, 188, 38);
				panel_1.add(label_7);
				
				JLabel label_8 = new JLabel("Tutorial");
				label_8.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.setVisible(false);
						
						TutorialCrud a=	new TutorialCrud() ;
						a.setVisible(true);
					}
				});
				label_8.setOpaque(true);
				label_8.setHorizontalAlignment(SwingConstants.CENTER);
				label_8.setForeground(Color.DARK_GRAY);
				label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_8.setBorder(new MatteBorder(1, 1, 3, 3,
										(Color) new Color(0, 0, 0)));
				label_8.setBackground(Color.ORANGE);
				label_8.setBounds(10, 376, 188, 38);
				panel_1.add(label_8);
				
				JLabel label_9 = new JLabel("Logistics");
				label_9.addMouseListener(new MouseAdapter() {
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
				label_9.setOpaque(true);
				label_9.setHorizontalAlignment(SwingConstants.CENTER);
				label_9.setForeground(Color.DARK_GRAY);
				label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
				label_9.setBorder(new MatteBorder(1, 1, 3, 3,
										(Color) new Color(0, 0, 0)));
				label_9.setBackground(Color.ORANGE);
				label_9.setBounds(10, 425, 188, 38);
				panel_1.add(label_9);}
			
			

			private void refresh_table() {
				EventModel modele = new EventModel();

				// ArrayList<Gamer> List_Gamers=(ArrayList<Gamer>)
				// proxyGamer.readAllGamer();

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(table);
				table.setModel(modele);
			
			
			}
	}


