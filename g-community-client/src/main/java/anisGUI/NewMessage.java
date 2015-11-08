package anisGUI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;



import delegate.ActiveMemberServicesDelegate;
import delegate.MessageServicesDelegate;
import entities.ActiveMember;
import entities.Message;
import entities.Notification;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;

import anis.interfaces.MessageServiceRemote;
import services.interfaces.ActiveMemberServicesRemote;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewMessage extends JPanel {
	private JTextField jsubject;
	ActiveMemberServicesRemote proxy ;
	ActiveMember a ;
    ActiveMember em = ActiveMemberServicesDelegate.doFindActiveMemberById(12);
	
    String username= em.getUsername();
//	Context context ;
	//String jndiName = "/g-community-ejb/ActiveMemberServices!services.interfaces.ActiveMemberServicesRemote";
	String password = em.getPassword();
	/**
	 * Create the panel.
	 */
	public NewMessage(ActiveMember em,String username,String password) {
		System.out.println("d5al");

		setLayout(null);
		this.em=em;
		this.username=username;
		this.password=password;
		

		JLabel label_2 = new JLabel("Send a message to");
		label_2.setBounds(238, 50, 128, 14);
		add(label_2);
		JLabel labelid = new JLabel("New label");
		labelid.setForeground(new Color(52, 73, 94));
		labelid.setBounds(501, 68, 46, 14);
		add(labelid);
		JComboBox<String> comboType = new JComboBox<String>();
		comboType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<ActiveMember> accounting;
				accounting = ActiveMemberServicesDelegate.doFindAllActiveMember();
				for (ActiveMember c : accounting) {
					comboType.addItem(c.getUsername());
				//	labelid.setText(c.getId().toString());
					String choix =	comboType.getSelectedItem().toString();
					labelid.setText(ActiveMemberServicesDelegate.doFindActiveMemberByUserName(choix).getId().toString());
				}
				

			}
		});


		comboType.setBounds(443, 47, 145, 20);
		add(comboType);




		JLabel label_4 = new JLabel("Subject");
		label_4.setBounds(238, 130, 63, 14);
		add(label_4);

		jsubject = new JTextField();
		jsubject.setColumns(10);
		jsubject.setBounds(443, 127, 171, 20);
		add(jsubject);

		JLabel label_5 = new JLabel("Content");
		label_5.setBounds(238, 233, 46, 14);
		add(label_5);

		JTextPane jcontent = new JTextPane();
		jcontent.setBounds(424, 223, 171, 69);
		add(jcontent);

		JButton btnSent = new JButton("Sent");
		btnSent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Message message = new Message();
				Date date = new Date(2015-1900,8-1,9);
				ActiveMember e1 = new ActiveMember();
		//		ActiveMember admin = new ActiveMember();
				//Notification notif = new Notification();
				e1 = ActiveMemberServicesDelegate.doFindActiveMemberById(Integer.parseInt(labelid.getText()));
				message.setContent(jcontent.getText());
				message.setDate(date);
				//admin = ActiveMemberServicesDelegate.doFindActiveMemberById(em.getId());
				message.setSubject(jsubject.getText());
				message.setActiveMember(e1);
				
//				notif.setDescription("new Message");
//				notif.setEtat(0);
//				notif.setActiveMember(admin);
//				notif.setMessage(message);
				try {
					MessageServicesDelegate.ajouterMessage(message);

					JOptionPane.showMessageDialog(null, "Success!!", "Good :D", JOptionPane.OK_CANCEL_OPTION);
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error!!", "X", JOptionPane.ERROR_MESSAGE);
				}
				
			}
//				MessageServiceRemote proxy1 = null;
//				Context context = null;
//				try {
//					context = new InitialContext();
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				String jndiName = "/g-community-ejb/MessageService!anis.interfaces.MessageServiceRemote";
//
//				try {
//					proxy1	 = (MessageServiceRemote) context
//							.lookup(jndiName);
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//                 
//				Message message = new Message();
//
//
//				Date date = new Date(2015-1900,8-1,9);
//				System.out.println(date);
//				//  Accounting_Manager accounting_Manager = new Accounting_Manager();
//				
//				ActiveMember e1 = new ActiveMember();
//				
//
//				Notification notif = new Notification();
//				ActiveMember admin = new ActiveMember();
//				admin = proxy1.findActiveMemberById(em.getId());
//				admin.setId(em.getId());
//
//				// message.setAccouting_manager(employee);    
//				//Admin admin = new Admin();
//				
//				//System.out.println(e.getId_employee(3L));
//		         
//				e1 = proxy1.findActiveMemberById(Integer.parseInt(labelid.getText()));
//				System.out.println(e1.getId());
//				message.setContent(jcontent.getText());
//				message.setDate(date);
//				message.setSubject(jsubject.getText());
//				message.setActiveMember(admin);
//				notif.setDescription("new Message");
//				notif.setEtat(0);
//				notif.setActiveMember(admin);
//				notif.setMessage(message);
//				try {
//					proxy1.ajouterMessage(message,notif);
//					JOptionPane.showMessageDialog(null, "Success!!", "Good :D", JOptionPane.OK_CANCEL_OPTION);
//
//					
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, "Error!!", "X", JOptionPane.ERROR_MESSAGE);
//				}
//		
//
//					// message.setAccouting_manager(employee);    
//					//Admin admin = new Admin();
//					
//					//System.out.println(e.getId_employee(3L));
//			         
//					e1 = proxy1.findActiveMemberById(Integer.parseInt(labelid.getText()));
//					System.out.println(e1.getId());
//					message.setContent(jcontent.getText());
//					message.setDate(date);
//					message.setSubject(jsubject.getText());
//					message.setActiveMember(admin);
//					notif.setDescription("new Message");
//					notif.setEtat(0);
//					notif.setActiveMember(admin);
//					notif.setMessage(message);
//					
//					proxy1.ajouterMessage(message,notif);
//				}
			
		});
		btnSent.setBounds(643, 284, 89, 23);
		add(btnSent);
	}
}
