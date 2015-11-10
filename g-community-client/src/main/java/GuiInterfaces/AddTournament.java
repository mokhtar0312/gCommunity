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
import java.awt.Color;
import java.awt.Font;

public class AddTournament extends JFrame{

	public JFrame frame;
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
		frame.getContentPane().setBackground(new Color(52,73,94));
		//frame.setBounds(100, 100, 462, 416);
		frame.setBounds(450, 250, 462, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Add an Event");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(256, 23, 95, 20);
		frame.getContentPane().add(dateChooser);
		
		JButton btnAddEvent = new JButton("ADD EVENT");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event= new Event();
			    
				event.setDate(dateChooser.getDate());
				event.setName(Nametext.getText());
				
				event.setDescription(DescritpionText.getText());
				Integer ControleNumber= Integer.parseInt(NumberofText.getText());
				Double ControleFee=Double.parseDouble(feesText.getText());
				if(ControleNumber>=2 &&ControleNumber <=32)
				{
				event.setNumberOfParticipants(ControleNumber);
				if(ControleFee>=5 )
				{
				event.setFee(ControleFee);
				EventServiceDelegate.DoAddEvent(event);
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "Added");
				frame.setVisible(false);
				}
                 else {
					
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Fee should not be higher than 5");
				}
				}
				
				else {
					
					JFrame parent = new JFrame();
					JOptionPane.showMessageDialog(parent, "Number of participants should be between 2 and 32");
				}
			}
		});
		btnAddEvent.setBounds(163, 314, 118, 23);
		frame.getContentPane().add(btnAddEvent);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(89, 23, 85, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(89, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNumberOParticipant = new JLabel("Number of participants");
		lblNumberOParticipant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOParticipant.setBounds(87, 129, 159, 14);
		frame.getContentPane().add(lblNumberOParticipant);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(89, 187, 85, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFees.setBounds(89, 235, 46, 14);
		frame.getContentPane().add(lblFees);
		
		Nametext = new JTextField();
		Nametext.setBounds(256, 80, 95, 20);
		frame.getContentPane().add(Nametext);
		Nametext.setColumns(10);
		
		NumberofText = new JTextField();
		NumberofText.setBounds(256, 128, 95, 20);
		frame.getContentPane().add(NumberofText);
		NumberofText.setColumns(10);
		
		DescritpionText = new JTextField();
		DescritpionText.setBounds(256, 186, 95, 20);
		frame.getContentPane().add(DescritpionText);
		DescritpionText.setColumns(10);
		
		feesText = new JTextField();
		feesText.setBounds(256, 234, 95, 20);
		frame.getContentPane().add(feesText);
		feesText.setColumns(10);
		
		JLabel error1 = new JLabel("number should be in (2-32)");
		error1.setForeground(Color.RED);
		error1.setBounds(87, 154, 145, 14);
		frame.getContentPane().add(error1);
		error1.setVisible(false);
		
		
	
		
	}
}
