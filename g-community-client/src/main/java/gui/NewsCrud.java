package gui;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import com.toedter.calendar.JDateChooser;

import delegate.NewsServicesDelegate;
import entities.News;

public class NewsCrud extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNewsTitle;
	private JTable table;
	private List<News> news;
	private JTextField textFieldSearchNews;

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
				//news.remove(n);
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
		setBounds(100, 100, 663, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNewsTitle = new JTextField();
		textFieldNewsTitle.setBounds(70, 38, 137, 20);
		contentPane.add(textFieldNewsTitle);
		textFieldNewsTitle.setColumns(10);

		JTextPane txtpanelNewsDescription = new JTextPane();
		txtpanelNewsDescription.setBounds(20, 163, 187, 145);
		contentPane.add(txtpanelNewsDescription);

		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblTitle.setBounds(10, 38, 46, 14);
		contentPane.add(lblTitle);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblDate.setBounds(10, 93, 46, 14);
		contentPane.add(lblDate);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblDescription.setBounds(10, 138, 105, 14);
		contentPane.add(lblDescription);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 77, 420, 310);
		contentPane.add(scrollPane);
		JDateChooser dateChooser_news = new JDateChooser();
		dateChooser_news.setBounds(73, 93, 134, 20);
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
				initDataBindings();

			}
		});
		btnAddNews.setBounds(20, 330, 187, 23);
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
		btnUpdateNews.setBounds(20, 364, 95, 23);
		contentPane.add(btnUpdateNews);

		btnDeleteNews.setBounds(122, 364, 85, 23);
		contentPane.add(btnDeleteNews);

		textFieldSearchNews = new JTextField();
		textFieldSearchNews.setBounds(379, 38, 122, 20);
		contentPane.add(textFieldSearchNews);
		textFieldSearchNews.setColumns(10);
		if (news.size()==0) {
			btnDeleteNews.setVisible(false);
			btnUpdateNews.setVisible(false);
			} else {
				btnDeleteNews.setVisible(true);
				btnUpdateNews.setVisible(true);
			};
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
		btnSearch.setBounds(521, 37, 75, 20);
		contentPane.add(btnSearch);

		JLabel lblLookFor = new JLabel("Look for :");
		lblLookFor.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		lblLookFor.setBounds(304, 44, 75, 14);
		contentPane.add(lblLookFor);

		JButton btnRef = new JButton("ref");
		btnRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				news = NewsServicesDelegate.DisplayAllNews();
				initDataBindings();
			}
		});
		btnRef.setBounds(602, 38, 35, 20);
		contentPane.add(btnRef);

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
