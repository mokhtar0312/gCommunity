package GuiInterfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner.DateEditor;

import delegate.EventServiceDelegate;
import entities.Event;









import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.DayOfWeek;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

public class AddTournament {

	private JFrame frame;
	private JTextField Nametext;
	private JTextField NumberofText;
	private JTextField DescritpionText;
	private JTextField feesText;
	

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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(145, 26, 95, 20);
		frame.getContentPane().add(dateChooser);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event= new Event();
			    
				event.setDate(dateChooser.getDate());
				event.setName(Nametext.getText());
				event.setDescription(DescritpionText.getText());
				event.setNumberOfParticipants(Integer.parseInt(NumberofText.getText()));
				event.setFee(Double.parseDouble(feesText.getText()));
				EventServiceDelegate.DoAddEvent(event);
				
				
			}
		});
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
		
		Nametext = new JTextField();
		Nametext.setBounds(145, 78, 86, 20);
		frame.getContentPane().add(Nametext);
		Nametext.setColumns(10);
		
		NumberofText = new JTextField();
		NumberofText.setBounds(145, 126, 86, 20);
		frame.getContentPane().add(NumberofText);
		NumberofText.setColumns(10);
		
		DescritpionText = new JTextField();
		DescritpionText.setBounds(145, 184, 86, 20);
		frame.getContentPane().add(DescritpionText);
		DescritpionText.setColumns(10);
		
		feesText = new JTextField();
		feesText.setBounds(145, 232, 86, 20);
		frame.getContentPane().add(feesText);
		feesText.setColumns(10);
		
		
	
		
	}
}
