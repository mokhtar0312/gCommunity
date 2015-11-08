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
import entities.Event;
import repo.EventModel;

public class TournamentManagement  extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("List of Account");
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
		scrollPane.setBounds(38, 62, 357, 138);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);

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
					//login.setText(account.getDescription());
					/*pseudo
					pwd*/
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
				upda.setBounds(306, 339, 89, 23);
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
				btnDelete.setBounds(195, 339, 89, 23);
				contentPane.add(btnDelete);
				
				login = new JTextField();
				login.setBounds(150, 211, 72, 20);
				contentPane.add(login);
				login.setColumns(10);
				
				pwd = new JTextField();
				pwd.setBounds(150, 242, 72, 20);
				contentPane.add(pwd);
				pwd.setColumns(10);
				
				pseudo = new JTextField();
				pseudo.setBounds(150, 273, 72, 20);
				contentPane.add(pseudo);
				pseudo.setColumns(10);
				
				dtrpnLogin = new JEditorPane();
				dtrpnLogin.setForeground(new Color(51, 0, 102));
				dtrpnLogin.setBackground(new Color(0, 102, 102));
				dtrpnLogin.setText("Description :");
				dtrpnLogin.setBounds(10, 211, 106, 20);
				contentPane.add(dtrpnLogin);
				
				dtrpnPassword = new JEditorPane();
				dtrpnPassword.setForeground(new Color(51, 0, 102));
				dtrpnPassword.setBackground(new Color(0, 102, 102));
				dtrpnPassword.setText("Fee :");
				dtrpnPassword.setBounds(10, 242, 106, 20);
				contentPane.add(dtrpnPassword);
				
				dtrpnPseudo = new JEditorPane();
				dtrpnPseudo.setForeground(new Color(51, 0, 102));
				dtrpnPseudo.setBackground(new Color(0, 102, 102));
				dtrpnPseudo.setText("Pseudo :");
				dtrpnPseudo.setBounds(10, 273, 106, 20);
				contentPane.add(dtrpnPseudo);
				
				JButton btnBack = new JButton("BACK");
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
				btnBack.setBounds(20, 339, 89, 23);
				contentPane.add(btnBack);}
			
			

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


