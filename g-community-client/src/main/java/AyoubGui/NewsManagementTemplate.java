package AyoubGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

public class NewsManagementTemplate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewsManagementTemplate frame = new NewsManagementTemplate();
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
	public NewsManagementTemplate() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBounds(100, 100, 936, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		label_2.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(10, 149, 188, 53);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Game");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(10, 213, 188, 53);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Tournaments");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		label_4.setBackground(Color.ORANGE);
		label_4.setBounds(10, 277, 188, 57);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Vote");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBorder(new MatteBorder(1, 1, 3, 3,
						(Color) new Color(0, 0, 0)));
		label_5.setBackground(Color.ORANGE);
		label_5.setBounds(10, 345, 188, 53);
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
		
		JButton btnNews = new JButton("News");
		btnNews.setFont(new Font("Roboto", Font.PLAIN, 17));
		btnNews.setBackground(Color.BLACK);
		btnNews.setForeground(Color.DARK_GRAY);
		btnNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNews.setBounds(10, 409, 188, 53);
		panel.add(btnNews);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 196, 15));
		panel_1.setBounds(208, 0, 10, 581);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(218, 0, 702, 581);
		contentPane.add(panel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 71, 137, 20);
		panel_2.add(textField);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(52, 196, 187, 145);
		panel_2.add(textPane);
		
		JLabel label_7 = new JLabel("Title :");
		label_7.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		label_7.setBounds(42, 71, 46, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Date :");
		label_8.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		label_8.setBounds(42, 126, 46, 14);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Description :");
		label_9.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		label_9.setBounds(42, 171, 105, 14);
		panel_2.add(label_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 110, 420, 310);
		panel_2.add(scrollPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(105, 126, 134, 20);
		panel_2.add(dateChooser);
		
		JButton button = new JButton("Add");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		button.setBounds(52, 363, 187, 23);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.setForeground(Color.BLUE);
		button_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		button_1.setBounds(52, 397, 95, 23);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setForeground(Color.BLUE);
		button_2.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		button_2.setBounds(154, 397, 85, 23);
		panel_2.add(button_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(411, 71, 122, 20);
		panel_2.add(textField_1);
		
		JButton button_3 = new JButton("Search");
		button_3.setForeground(Color.BLUE);
		button_3.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		button_3.setBounds(553, 70, 75, 20);
		panel_2.add(button_3);
		
		JLabel label_10 = new JLabel("Look for :");
		label_10.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		label_10.setBounds(336, 77, 75, 14);
		panel_2.add(label_10);
		
		JButton button_4 = new JButton("ref");
		button_4.setBounds(634, 71, 35, 20);
		panel_2.add(button_4);
	}
}
