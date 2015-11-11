package GuiInterfaces;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import repo.EquipmentModel;
import repo.StatEquipment;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import AyoubGui.TutorialCrud;
import anisGUI.UserProfil;
import delegate.EquipmentDelegate;
import entities.Equipment;
import gui.NewsCrud;

public class Logistics {

	public JFrame frame;
	private JTextField idEquip;
	private JTextField nameEquip;
	private JTextField referenceEquip;
	private JTable table;
	int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				SplashS splash = new SplashS();
				splash.main(args);
				try {
					Logistics window = new Logistics();
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
	public Logistics() throws NamingException {
		InputStream in;
		initialize();
		EquipmentModel model = new EquipmentModel();
		try {
			SystemTrayTest test = new SystemTrayTest();
		} catch (AWTException ex) {
			Logger.getLogger(Logistics.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		try {

			in = new FileInputStream(
					new File(
							"C:\\Users\\Poste\\git\\gCommunity\\g-community-client\\nu.wav"));
			AudioStream audios = new AudioStream(in);

			AudioPlayer.player.start(audios);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EquipmentModel model = new EquipmentModel();

		frame = new JFrame();
		frame.setTitle("        G Community");
		frame.setBounds(100, 100, 936, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(218, 0, 702, 581);
		panel.setBackground(new Color(52, 73, 94));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel Tab1 = new JPanel();
		Tab1.setLayout(null);
		Tab1.setOpaque(true);
		Tab1.setBorder(null);
		Tab1.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("Equipments", null, Tab1, null);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int action = JOptionPane.showConfirmDialog(null,
						"Do you really want to delete this item", "Delete",
						JOptionPane.YES_NO_OPTION);
				String test = table.getModel().getValueAt(row, 0).toString();
				int id = Integer.parseInt(test);
				System.out.println(test);
				Equipment account_found = new Equipment();
				account_found = EquipmentDelegate.findEquipmentById(id);
				EquipmentDelegate.DeleteEquipment(id);
				table.setModel(model);
				model.refresh();
				model.fireTableDataChanged();
			}
		});
		btnDelete.setForeground(new Color(51, 0, 102));
		btnDelete.setBounds(433, 57, 99, 23);
		Tab1.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(59, 122, 473, 282);

		Tab1.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);
				int id_select = (int) (table.getModel().getValueAt(row, 0));

				Equipment selected = new Equipment();
				selected = EquipmentDelegate.findEquipmentById(id_select);
				idEquip.setText(selected.getId().toString());
				nameEquip.setText(selected.getName());
				referenceEquip.setText(selected.getReference());

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);

		JPanel Tab = new JPanel();
		Tab.setLayout(null);
		Tab.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("Add/Update", null, Tab, null);

		idEquip = new JTextField();
		idEquip.setEditable(false);
		idEquip.setColumns(10);
		idEquip.setBounds(253, 117, 126, 20);
		Tab.add(idEquip);

		JLabel label_3 = new JLabel("Id");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(146, 115, 83, 25);
		Tab.add(label_3);

		JComboBox stateCB = new JComboBox();
		stateCB.setModel(new DefaultComboBoxModel(new String[] { "Available",
				"Out of Stock" }));
		stateCB.setToolTipText("");
		stateCB.setBounds(253, 252, 126, 20);
		Tab.add(stateCB);

		JButton button_5 = new JButton("Add");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = stateCB.getSelectedIndex();
				Equipment added = new Equipment();
				String name = nameEquip.getText();
				String reference = referenceEquip.getText();

				added.setName(name);
				added.setReference(reference);
				if (i == 0) {
					added.setState(true);
				} else {
					added.setState(false);
				}

				EquipmentDelegate.addEquipment(added);
				nameEquip.setText("");
				referenceEquip.setText("");
				model.refresh();
				model.fireTableDataChanged();

			}
		});
		button_5.setBounds(348, 341, 72, 23);
		Tab.add(button_5);

		JButton upda = new JButton("UPDATE");
		upda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = table.getModel().getValueAt(row, 0).toString();
				int id = Integer.parseInt(test);
				Equipment account = new Equipment();
				account = EquipmentDelegate.findEquipmentById(id);
				// login.setText(account.getDescription());
				/*
				 * pseudo pwd
				 */
				Equipment account_found = new Equipment();
				// account_found = Accountdelegate.findAccountById(id);
				int i = stateCB.getSelectedIndex();
				account.setName(nameEquip.getText());
				account.setReference(referenceEquip.getText());
				if (i == 0) {
					account.setState(true);
				} else {
					account.setState(false);
				}
				System.out.println("cbn");

				EquipmentDelegate.UpdateEquipment(account);
				System.out.println("kizebbi");
				nameEquip.setText("");
				referenceEquip.setText("");
				model.refresh();
				model.fireTableDataChanged();
			}
		});
		upda.setForeground(new Color(0, 0, 102));
		upda.setBounds(249, 341, 89, 23);
		Tab.add(upda);

		nameEquip = new JTextField();
		nameEquip.setColumns(10);
		nameEquip.setBounds(253, 158, 126, 20);
		Tab.add(nameEquip);

		JLabel label_4 = new JLabel("Reference");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(146, 205, 79, 14);
		Tab.add(label_4);

		referenceEquip = new JTextField();
		referenceEquip.setColumns(10);
		referenceEquip.setBounds(253, 203, 126, 20);
		Tab.add(referenceEquip);

		JLabel label_5 = new JLabel("State");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(146, 255, 59, 14);
		Tab.add(label_5);

		JLabel label_6 = new JLabel("Name");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(146, 159, 58, 14);
		Tab.add(label_6);

		JButton button_7 = new JButton("Clear");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameEquip.setText("");
				referenceEquip.setText("");
			}
		});
		button_7.setBounds(430, 341, 69, 23);
		Tab.add(button_7);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(new Color(52, 73, 94));
		tabbedPane.setBounds(10, 11, 689, 559);
		panel.add(tabbedPane);

		JButton button_4 = new JButton("New");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tab1.hide();
				Tab.setVisible(true);
			}
		});
		button_4.setBounds(230, 57, 96, 23);
		Tab1.add(button_4);

		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tab1.hide();
				Tab.show();
			}
		});
		button_3.setBounds(336, 57, 87, 23);
		Tab1.add(button_3);

		JButton btnEquipmentDisponibility = new JButton(
				"Equipment disponibility");
		btnEquipmentDisponibility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatEquipment pchart = new StatEquipment();
				pchart.setSize(600, 500);
				pchart.setVisible(true);
			}
		});
		btnEquipmentDisponibility.setBounds(306, 466, 226, 23);
		Tab1.add(btnEquipmentDisponibility);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tab.hide();
				Tab1.setVisible(true);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		Tab.add(btnBack);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(52, 73, 94));
		panel_1.setBounds(0, 0, 208, 581);
		frame.getContentPane().add(panel_1);

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
		label_2.setBounds(10, 131, 188, 38);
		panel_1.add(label_2);

		JLabel label_7 = new JLabel("Game");
		label_7.addMouseListener(new MouseAdapter() {
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
		label_7.setOpaque(true);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_7.setBackground(Color.ORANGE);
		label_7.setBounds(10, 180, 188, 38);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("Tournaments");
		label_8.addMouseListener(new MouseAdapter() {
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
		label_8.setOpaque(true);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.DARK_GRAY);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_8.setBackground(Color.ORANGE);
		label_8.setBounds(10, 229, 188, 38);
		panel_1.add(label_8);

		JLabel label_9 = new JLabel("Vote");
		label_9.addMouseListener(new MouseAdapter() {
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
		label_9.setOpaque(true);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_9.setBackground(Color.ORANGE);
		label_9.setBounds(10, 278, 188, 38);
		panel_1.add(label_9);

		JLabel label_10 = new JLabel("Log Out");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new Authentification().frmIdentification.setVisible(true);
			}
		});
		label_10.setOpaque(true);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.DARK_GRAY);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_10.setBackground(Color.ORANGE);
		label_10.setBounds(21, 526, 164, 29);
		panel_1.add(label_10);

		JLabel label_11 = new JLabel("News");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);

				NewsCrud a = new NewsCrud();
				a.setVisible(true);
			}
		});
		label_11.setOpaque(true);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.DARK_GRAY);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_11.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_11.setBackground(Color.ORANGE);
		label_11.setBounds(10, 327, 188, 38);
		panel_1.add(label_11);

		JLabel label_12 = new JLabel("Tutorial");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);

				TutorialCrud a = new TutorialCrud();
				a.setVisible(true);
			}
		});
		label_12.setOpaque(true);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.DARK_GRAY);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_12.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_12.setBackground(Color.ORANGE);
		label_12.setBounds(10, 376, 188, 38);
		panel_1.add(label_12);

		JLabel label_13 = new JLabel("Logistics");
		label_13.addMouseListener(new MouseAdapter() {
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
		label_13.setOpaque(true);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.DARK_GRAY);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_13.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_13.setBackground(Color.ORANGE);
		label_13.setBounds(10, 425, 188, 38);
		panel_1.add(label_13);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(241, 196, 15));
		panel_2.setBounds(205, 0, 15, 581);
		frame.getContentPane().add(panel_2);
	}
}
