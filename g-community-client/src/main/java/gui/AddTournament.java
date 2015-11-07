package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddTournament {

	private JFrame frame;
	private JTextField DateText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTournament window = new AddTournament();
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
	public AddTournament() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.setBounds(145, 316, 118, 23);
		frame.getContentPane().add(btnAddEvent);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(23, 26, 85, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(23, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNumberOParticipant = new JLabel("Number o participant");
		lblNumberOParticipant.setBounds(23, 129, 118, 14);
		frame.getContentPane().add(lblNumberOParticipant);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(23, 187, 85, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setBounds(23, 235, 46, 14);
		frame.getContentPane().add(lblFees);
		
		DateText = new JTextField();
		DateText.setBounds(145, 27, 86, 20);
		frame.getContentPane().add(DateText);
		DateText.setColumns(10);
	}
}
