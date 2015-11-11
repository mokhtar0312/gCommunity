package AyoubGui;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.transaction.Transactional.TxType;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegate.SimpleMemberdelegate;
import delegate.TutorialServicesDelegate;
import entities.SimpleMember;
import entities.TutoLevel;
import entities.Tutorial;
import javax.swing.ImageIcon;

public class TutorialCrud extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Tutorial> tutorials;
	private JTextField textFieldTutoTitle;
	private JTextField textField_searchTuto;
	private JTextField textFieldselectedmember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorialCrud frame = new TutorialCrud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TutorialCrud() {
		setTitle("Tutorial Management");
		tutorials = new ArrayList<Tutorial>();
		tutorials = TutorialServicesDelegate.FindAllTutorial();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(52, 73, 94));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnF = new JTextPane();
		txtpnF.setBounds(252, 312, 187, 179);
		contentPane.add(txtpnF);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.ORANGE);
		lblDescription.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblDescription.setBounds(252, 287, 95, 14);
		contentPane.add(lblDescription);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 208, 581);
		contentPane.add(panel);

		JLabel label = new JLabel("My Profile");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(0, 0, 0)));
		label.setBackground(Color.ORANGE);
		label.setBounds(10, 58, 188, 53);
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
		label_2.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(10, 122, 188, 53);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Game");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(10, 186, 188, 53);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Tournaments");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_4.setBackground(Color.ORANGE);
		label_4.setBounds(10, 250, 188, 57);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Vote");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_5.setBackground(Color.ORANGE);
		label_5.setBounds(10, 318, 188, 53);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Log Out");
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		label_6.setBounds(21, 526, 164, 29);
		panel.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.BLACK);
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(10, 382, 192, 57);
		panel.add(label_7);

		JButton buttonNews = new JButton("News");
		buttonNews.setForeground(Color.DARK_GRAY);
		buttonNews.setFont(new Font("Roboto", Font.PLAIN, 17));
		buttonNews.setBackground(Color.ORANGE);
		buttonNews.setBounds(10, 382, 188, 53);
		panel.add(buttonNews);

		JLabel label_8 = new JLabel("");
		label_8.setForeground(Color.BLACK);
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(10, 446, 192, 57);
		panel.add(label_8);

		JButton buttonTuto = new JButton("Tutorials");
		buttonTuto.setForeground(Color.DARK_GRAY);
		buttonTuto.setFont(new Font("Roboto", Font.PLAIN, 17));
		buttonTuto.setBackground(Color.ORANGE);
		buttonTuto.setBounds(10, 446, 188, 53);
		panel.add(buttonTuto);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 196, 15));
		panel_1.setBounds(208, 0, 10, 581);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 124, 444, 435);
		contentPane.add(scrollPane);
		JComboBox<TutoLevel> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(TutoLevel.values()));
		comboBox.setBounds(325, 177, 114, 20);

		contentPane.add(comboBox);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					textFieldTutoTitle.setText(tutorials.get(
							table.getSelectedRow()).getName());
					textFieldselectedmember.setText(tutorials
							.get(table.getSelectedRow()).getSimplemember()
							.getName());
					txtpnF.setText(tutorials.get(table.getSelectedRow()).getDescription());
					comboBox.setSelectedItem(tutorials.get(table.getSelectedRow()).getTutolev());
				}
			}
		});
		scrollPane.setViewportView(table);
		textFieldselectedmember = new JTextField();
		textFieldselectedmember.setColumns(10);
		textFieldselectedmember.setBounds(304, 219, 135, 20);
		contentPane.add(textFieldselectedmember);

		textFieldTutoTitle = new JTextField();
		textFieldTutoTitle.setBounds(304, 135, 135, 20);
		contentPane.add(textFieldTutoTitle);
		textFieldTutoTitle.setColumns(10);

		JLabel label_9 = new JLabel("Look for :");
		label_9.setForeground(Color.ORANGE);
		label_9.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		label_9.setBounds(577, 87, 75, 14);
		contentPane.add(label_9);

		textField_searchTuto = new JTextField();
		textField_searchTuto.setColumns(10);
		textField_searchTuto.setBounds(652, 81, 122, 20);
		contentPane.add(textField_searchTuto);

		JButton btnSearchTuto = new JButton("Search");
		btnSearchTuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutorials = TutorialServicesDelegate.findByTyped(textField_searchTuto.getText());
				initDataBindings();
			}
		});
		btnSearchTuto.setForeground(Color.BLUE);
		btnSearchTuto.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnSearchTuto.setBounds(794, 80, 75, 20);
		contentPane.add(btnSearchTuto);

		JButton btnRefTuto = new JButton("ref");
		btnRefTuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutorials = TutorialServicesDelegate.FindAllTutorial();
				textField_searchTuto.setText(null);
				initDataBindings();
			}
		});
		btnRefTuto.setBounds(875, 81, 35, 20);
		contentPane.add(btnRefTuto);

		JLabel label_10 = new JLabel("Title :");
		label_10.setForeground(Color.ORANGE);
		label_10.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		label_10.setBounds(252, 135, 46, 14);
		contentPane.add(label_10);

		JLabel lblDifficulty = new JLabel("Difficulty :");
		lblDifficulty.setForeground(Color.ORANGE);
		lblDifficulty.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblDifficulty.setBounds(251, 177, 75, 14);
		contentPane.add(lblDifficulty);

		

		JLabel lblBy = new JLabel("By :");
		lblBy.setForeground(Color.ORANGE);
		lblBy.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblBy.setBounds(252, 221, 46, 14);
		contentPane.add(lblBy);

		Button btnSelectWriter = new Button("Select Writer");
		btnSelectWriter.setForeground(Color.BLUE);
		btnSelectWriter.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnSelectWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog userdialog = new selectuser();
				userdialog.setVisible(true);
				userdialog.addWindowFocusListener(new WindowFocusListener() {
					public void windowLostFocus(WindowEvent e) {
						textFieldselectedmember.setText(selectuser.esm);
						userdialog.setVisible(false);
					}

					public void windowGainedFocus(WindowEvent e) {
					}
				});
				textFieldselectedmember.setText(selectuser.esm);

			}
		});
		btnSelectWriter.setBounds(304, 245, 135, 22);
		contentPane.add(btnSelectWriter);

		JButton btnUpdateTuto = new JButton("Update");
		btnUpdateTuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorial tuto = new Tutorial();
				tuto.setName(textFieldTutoTitle.getText());
				tuto.setDescription(txtpnF.getText());
				tuto.setTutolev((TutoLevel) comboBox.getSelectedItem());
				tuto.setSimplemember(tutorials
						.get(table.getSelectedRow()).getSimplemember());
				TutorialServicesDelegate.updateTutorial(tuto);
				tutorials = TutorialServicesDelegate.FindAllTutorial();
				initDataBindings();
				
				textFieldTutoTitle.setText(null);
				txtpnF.setText(null);
				textFieldselectedmember.setText(null);
			}
		});
		btnUpdateTuto.setForeground(Color.BLUE);
		btnUpdateTuto.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnUpdateTuto.setBounds(252, 536, 95, 23);
		contentPane.add(btnUpdateTuto);

		JButton btnDeleteTuto = new JButton("Delete");
		btnDeleteTuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorial tuto = tutorials.get(table.getSelectedRow());
				TutorialServicesDelegate.deleteTutorial(tuto);
				
				tutorials = TutorialServicesDelegate.FindAllTutorial();
				initDataBindings();
				textFieldTutoTitle.setText(null);
				txtpnF.setText(null);
				textFieldselectedmember.setText(null);
			}
		});
		btnDeleteTuto.setForeground(Color.BLUE);
		btnDeleteTuto.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnDeleteTuto.setBounds(354, 536, 85, 23);
		contentPane.add(btnDeleteTuto);

		
		initDataBindings();

		if (tutorials.size() == 0) {
			btnUpdateTuto.setVisible(false);
			btnDeleteTuto.setVisible(false);
		} else {
			btnUpdateTuto.setVisible(true);
			btnDeleteTuto.setVisible(true);
		}
		JButton btnAddTuto = new JButton("Add");
		btnAddTuto.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnAddTuto.setForeground(Color.BLUE);
		btnAddTuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorial tuto = new Tutorial();
				SimpleMember actv = new SimpleMember();
				actv = SimpleMemberdelegate
						.doFindSimpleMemberById(AyoubGui.selectuser.lookfor);
				tuto.setDescription(txtpnF.getText());
				tuto.setName(textFieldTutoTitle.getText());
				tuto.setTutolev((TutoLevel) comboBox.getSelectedItem());
				tuto.setSimplemember(actv);
				TutorialServicesDelegate.addTutorial(tuto, actv);
				txtpnF.setText(null);
				textFieldselectedmember.setText(null);
				textFieldTutoTitle.setText(null);
				String stringnotif = "Tutorial by : " + actv.getName()
						+ " was added !";
				JOptionPane.showMessageDialog(null, stringnotif, "Success", 1);
				btnUpdateTuto.setVisible(true);
				btnDeleteTuto.setVisible(true);
				tutorials = TutorialServicesDelegate.FindAllTutorial();
				initDataBindings();
			}
		});
		btnAddTuto.setBounds(252, 502, 187, 23);
		contentPane.add(btnAddTuto);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(TutorialCrud.class.getResource("/images/logogcom.png")));
		label_11.setBounds(228, 11, 300, 60);
		contentPane.add(label_11);

	}

	protected void initDataBindings() {
		JTableBinding<Tutorial, List<Tutorial>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, tutorials, table);
		//
		BeanProperty<Tutorial, String> tutorialBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(tutorialBeanProperty).setColumnName(
				"Title");
		//
		BeanProperty<Tutorial, TutoLevel> tutorialBeanProperty_1 = BeanProperty
				.create("tutolev");
		jTableBinding.addColumnBinding(tutorialBeanProperty_1).setColumnName(
				"Level");
		//
		BeanProperty<Tutorial, String> tutorialBeanProperty_2 = BeanProperty
				.create("simplemember.name");
		jTableBinding.addColumnBinding(tutorialBeanProperty_2).setColumnName(
				"By");
		//
		BeanProperty<Tutorial, String> tutorialBeanProperty_3 = BeanProperty
				.create("description");
		jTableBinding.addColumnBinding(tutorialBeanProperty_3).setColumnName(
				"Description");
		//
		jTableBinding.bind();
	}
}
