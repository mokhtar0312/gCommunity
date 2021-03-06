package GuiInterfaces;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import repo.EquipmentModel;
import repo.EventModel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import junit.framework.Test;

import com.thehowtotutorial.splashscreen.JSplash;
import com.toedter.calendar.JDateChooser;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableModel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import repo.EquipmentModel;
import repo.StreamModel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import delegate.StreamServicesDelegate;
import entities.Equipment;
import entities.Streams;

import javax.swing.table.AbstractTableModel;

public class Stream {

	private JFrame frame;
	private JTextField idEquip;
	
	private JTextField urlStream;
	private JTable table;
	int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stream window = new Stream();
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
	public Stream() {
		InputStream in;
		initialize();
		StreamModel model = new StreamModel();
		 try {
	            SystemTrayTest test = new SystemTrayTest();
	        } catch (AWTException ex) {
	            Logger.getLogger(Logistics.class.getName()).log(Level.SEVERE, null, ex);
	        }
		 
		 try {

	            in = new FileInputStream(new File("C:\\Users\\Poste\\git\\gCommunity\\g-community-client\\nu.wav"));
	            AudioStream audios = new AudioStream(in);

	            AudioPlayer.player.start(audios);

	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);}
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		StreamModel model = new StreamModel();

		frame = new JFrame();
		frame.setTitle("        G Community");
		frame.setBounds(100, 100, 936, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(214, 0, 706, 581);
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
					String test = ((JTable) table.getModel()).getValueAt(row, 0).toString();
					int id = Integer.parseInt(test);
					System.out.println(test);
					Streams account_found = new Streams();
					account_found = StreamServicesDelegate.findStreamById(id);
					StreamServicesDelegate.deleteStream(id);
				  table.setModel(model);
				  model.refresh();
				  model.fireTableDataChanged();
			}
		});
		btnDelete.setForeground(new Color(51, 0, 102));
		btnDelete.setBounds(433, 57, 99, 23);
		Tab1.add(btnDelete);
		
		
		JPanel Tab = new JPanel();
		Tab.setLayout(null);
		Tab.setBackground(new Color(52, 73, 94));
		tabbedPane.addTab("Add/Update", null, Tab, null);
	
		
JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(59, 189, 473, 282);
		
		Tab1.add(scrollPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(253, 153, 95, 20);
		Tab.add(dateChooser);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);
				int id_select = (int) (table.getModel().getValueAt(row, 0));
				
				Streams selected=new Streams();
				selected=StreamServicesDelegate.findStreamById(id_select);
				idEquip.setText(selected.getId().toString());
				dateChooser.setDate(selected.getDate_diffusion());
				urlStream.setText(selected.getUrl());
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		
		idEquip = new JTextField();
		idEquip.setEditable(false);
		idEquip.setColumns(10);
		idEquip.setBounds(253, 117, 37, 20);
		Tab.add(idEquip);
		
		JLabel label_3 = new JLabel("Id");
		label_3.setBounds(177, 115, 52, 25);
		Tab.add(label_3);
		
		
		
		JButton button_5 = new JButton("Add");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Streams added=new Streams();
				 	
				 String reference=urlStream.getText();
				 
				 added.setDate_diffusion(dateChooser.getDate());
				 added.setUrl(reference);
		
				 
				
					StreamServicesDelegate.addStream(added);
					
					urlStream.setText("");
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
				Streams account = new Streams();
				account = StreamServicesDelegate.findStreamById(id);
				//login.setText(account.getDescription());
				/*pseudo
				pwd*/
			Streams account_found = new Streams();
              //  account_found = Accountdelegate.findAccountById(id);
			
				account.setDate_diffusion(dateChooser.getDate());
				account.setUrl(urlStream.getText());
				
				System.out.println("cbn");
			
			
				StreamServicesDelegate.updateStream(account);
				System.out.println("kizebbi");
				
				urlStream.setText("");
				model.refresh();
				model.fireTableDataChanged();
			}
		});
		upda.setForeground(new Color(0, 0, 102));
		upda.setBounds(249, 341, 89, 23);
		Tab.add(upda);
		
		
		
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(175, 205, 50, 14);
		Tab.add(lblUrl);
		
		urlStream = new JTextField();
		urlStream.setColumns(10);
		urlStream.setBounds(253, 203, 246, 20);
		Tab.add(urlStream);
		
		
		
		JLabel lblDateDiffusion = new JLabel("Date diffusion");
		lblDateDiffusion.setBounds(177, 159, 77, 14);
		Tab.add(lblDateDiffusion);
		
		JButton button_7 = new JButton("Clear");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				urlStream.setText("");
			}
		});
		button_7.setBounds(430, 341, 69, 23);
		Tab.add(button_7);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(new Color(52, 73, 94));
		tabbedPane.setBounds(10, 11, 689, 559);
		panel.add(tabbedPane);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 196, 15));
		panel_1.setBounds(208, 0, 10, 581);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(52, 73, 94));
		panel_menu.setBounds(0, 0, 208, 581);
		frame.getContentPane().add(panel_menu);
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
		
		
		JButton button_4 = new JButton("New");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tab1.hide();
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tab.hide();
				Tab1.setVisible(true);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		Tab.add(btnBack);
	}
}
