package AyoubGui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import GuiInterfaces.Authentification;
import GuiInterfaces.BoostingTemplate;
import GuiInterfaces.Logistics;
import GuiInterfaces.ShowUsers;
import GuiInterfaces.TournamentManagement;
import GuiInterfaces.VoteInterface;
import anisGUI.UserProfil;

import com.toedter.calendar.JDateChooser;

import delegate.NewsServicesDelegate;
import entities.News;

public class NewsCrud extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNewsTitle;
	private JTable table;
	private List<News> news;
	private JTextField textFieldSearchNews;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsCrud frame = new NewsCrud();
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
	public NewsCrud() {

		JButton btnAddNews = new JButton("Add");
		btnAddNews.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnAddNews.setForeground(Color.BLUE);

		JButton btnUpdateNews = new JButton("Update");
		btnUpdateNews.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnUpdateNews.setForeground(Color.BLUE);

		JButton btnDeleteNews = new JButton("Delete");
		btnDeleteNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				News n = news.get(table.getSelectedRow());
				// news.remove(n);
				NewsServicesDelegate.deleteNews(n);
				news = NewsServicesDelegate.DisplayAllNews();
				initDataBindings();
			}
		});
		btnDeleteNews.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnDeleteNews.setForeground(Color.BLUE);

		setFont(new Font("Roboto", Font.BOLD, 16));
		setTitle("News Management");
		news = new ArrayList<News>();
		news = NewsServicesDelegate.DisplayAllNews();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 620);
		contentPane = new JPanel();
		contentPane.setBounds(100, 100, 936, 620);
		contentPane.setBackground(new Color(52, 73, 94));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNewsTitle = new JTextField();
		textFieldNewsTitle.setBounds(299, 97, 137, 20);
		contentPane.add(textFieldNewsTitle);
		textFieldNewsTitle.setColumns(10);

		JTextPane txtpanelNewsDescription = new JTextPane();
		txtpanelNewsDescription.setBounds(249, 222, 187, 257);
		contentPane.add(txtpanelNewsDescription);

		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblTitle.setBounds(239, 97, 46, 14);
		contentPane.add(lblTitle);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setForeground(Color.ORANGE);
		lblDate.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblDate.setBounds(239, 152, 46, 14);
		contentPane.add(lblDate);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.ORANGE);
		lblDescription.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblDescription.setBounds(239, 197, 105, 14);
		contentPane.add(lblDescription);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 97, 437, 450);
		contentPane.add(scrollPane);
		JDateChooser dateChooser_news = new JDateChooser();
		dateChooser_news.setBounds(302, 152, 134, 20);
		contentPane.add(dateChooser_news);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					textFieldNewsTitle.setText(news.get(table.getSelectedRow())
							.getTitle());
					dateChooser_news.setDate(news.get(
							table.getSelectedRowCount()).getDate());
					txtpanelNewsDescription.setText(news.get(
							table.getSelectedRow()).getDescription());
					btnAddNews.setVisible(true);

				}
			}
		});
		scrollPane.setViewportView(table);

		btnAddNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				News n = new News();
				n.setTitle(textFieldNewsTitle.getText());
				n.setDate(dateChooser_news.getDate());
				n.setDescription(txtpanelNewsDescription.getText());
				NewsServicesDelegate.addNews(n);
				textFieldNewsTitle.setText(null);
				txtpanelNewsDescription.setText(null);
				dateChooser_news.setDate(null);
				news = NewsServicesDelegate.DisplayAllNews();
				btnUpdateNews.setVisible(true);
				btnDeleteNews.setVisible(true);
				JOptionPane.showMessageDialog(null, "News Added", "Success", 1);
				initDataBindings();

			}
		});
		btnAddNews.setBounds(249, 490, 187, 23);
		contentPane.add(btnAddNews);

		btnUpdateNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				News n = news.get(table.getSelectedRow());
				n.setTitle(textFieldNewsTitle.getText());
				n.setDate(dateChooser_news.getDate());
				n.setDescription(txtpanelNewsDescription.getText());
				NewsServicesDelegate.updateNews(n);
				news = NewsServicesDelegate.DisplayAllNews();
				initDataBindings();
				textFieldNewsTitle.setText(null);
				txtpanelNewsDescription.setText(null);
				dateChooser_news.setDate(null);
			}
		});
		btnUpdateNews.setBounds(249, 524, 95, 23);
		contentPane.add(btnUpdateNews);

		btnDeleteNews.setBounds(351, 524, 85, 23);
		contentPane.add(btnDeleteNews);

		textFieldSearchNews = new JTextField();
		textFieldSearchNews.setBounds(637, 68, 122, 20);
		contentPane.add(textFieldSearchNews);
		textFieldSearchNews.setColumns(10);
		if (news.size() == 0) {
			btnDeleteNews.setVisible(false);
			btnUpdateNews.setVisible(false);
		} else {
			btnDeleteNews.setVisible(true);
			btnUpdateNews.setVisible(true);
		}
		;
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				news = NewsServicesDelegate.findByTyped(textFieldSearchNews
						.getText());
				initDataBindings();

			}
		});
		btnSearch.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setBounds(779, 67, 75, 20);
		contentPane.add(btnSearch);

		JLabel lblLookFor = new JLabel("Look for :");
		lblLookFor.setForeground(Color.ORANGE);
		lblLookFor.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblLookFor.setBounds(562, 74, 75, 14);
		contentPane.add(lblLookFor);

		JButton btnRef = new JButton("ref");
		btnRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				news = NewsServicesDelegate.DisplayAllNews();
				textFieldSearchNews.setText(null);
				initDataBindings();
			}
		});
		btnRef.setBounds(860, 68, 35, 20);
		contentPane.add(btnRef);
		;

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 196, 15));
		panel_1.setBounds(208, 0, 10, 581);
		contentPane.add(panel_1);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(NewsCrud.class
				.getResource("/images/logogcom.png")));
		label_8.setBounds(237, 11, 300, 60);
		contentPane.add(label_8);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(52, 73, 94));
		panel.setBounds(0, 0, 208, 581);
		contentPane.add(panel);

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
		panel.add(label);

		JLabel label_1 = new JLabel("Home");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(0, 0, 208, 53);
		panel.add(label_1);

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
		label_3.setBounds(10, 180, 188, 38);
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
		label_4.setBounds(10, 229, 188, 38);
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
		label_5.setBounds(10, 278, 188, 38);
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
		label_6.setBorder(new MatteBorder(1, 1, 3, 3,
				(Color) new Color(0, 0, 0)));
		label_6.setBackground(Color.ORANGE);
		label_6.setBounds(21, 526, 164, 29);
		panel.add(label_6);

		JLabel label_7 = new JLabel("News");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);

				NewsCrud a = new NewsCrud();
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
		panel.add(label_7);

		JLabel label_9 = new JLabel("Tutorial");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 frame.setVisible(false);
					
					TutorialCrud a=	new TutorialCrud() ;
					a.setVisible(true);
			}
		});
		label_9.setOpaque(true);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_9.setBackground(Color.ORANGE);
		label_9.setBounds(10, 376, 188, 38);
		panel.add(label_9);

		JLabel label_10 = new JLabel("Logistics");
		label_10.addMouseListener(new MouseAdapter() {
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
		label_10.setOpaque(true);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.DARK_GRAY);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBorder(new MatteBorder(1, 1, 3, 3,

		(Color) new Color(0, 0, 0)));
		label_10.setBackground(Color.ORANGE);
		label_10.setBounds(10, 425, 188, 38);
		panel.add(label_10);

		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<News, List<News>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, news, table);
		//
		BeanProperty<News, String> newsBeanProperty = BeanProperty
				.create("title");
		jTableBinding.addColumnBinding(newsBeanProperty).setColumnName("Title");
		//
		BeanProperty<News, String> newsBeanProperty_1 = BeanProperty
				.create("description");
		jTableBinding.addColumnBinding(newsBeanProperty_1).setColumnName(
				"Description");
		//
		BeanProperty<News, Date> newsBeanProperty_2 = BeanProperty
				.create("date");
		jTableBinding.addColumnBinding(newsBeanProperty_2)
				.setColumnName("Date");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
