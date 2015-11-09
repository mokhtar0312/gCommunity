package anisGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import delegate.ActiveMemberServicesDelegate;
import delegate.EventServiceDelegate;
import delegate.MailServicesDelegate;
import delegate.SimpleMemberdelegate;
import entities.ActiveMember;
import entities.Event;
import entities.SimpleMember;

import javax.swing.JScrollPane;

import org.hibernate.event.spi.MergeEvent;

import repo.ConsulterListeMessageAdminAdapter;
import repo.EventAffich;

public class EventShowRestant extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable accountingTable;
    static SimpleMember admin = SimpleMemberdelegate.doFindSimpleMemberById(12);
    int row ;
    String nomevent;


	/**
	 * Create the panel.
	 * @throws NamingException 
	 */
	

   
    
	public EventShowRestant(ActiveMember admin) throws NamingException {
		
		this.admin=admin;

		setLayout(null);
		try {
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(86, 107, 572, 119);
			add(scrollPane);
			accountingTable = new JTable();
			scrollPane.setViewportView(accountingTable);
			accountingTable.setBackground(Color.WHITE);
			accountingTable.setModel(new EventAffich((ActiveMember) admin) );
			
			JButton btnSubscribe = new JButton("subscribe");
			btnSubscribe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					row = accountingTable.getSelectedRow();
					nomevent = accountingTable.getModel().getValueAt(row, 0).toString();
					
					
					System.out.println(nomevent);
					
					Event event = EventServiceDelegate.DoFindEventByName(nomevent);
					SimpleMemberdelegate.DoaffectEventToSimpleMember(admin, event);
					try {
						MailServicesDelegate.doMail("inscription avec succes", "vous etes inscrit a l'event  "+event.getName(), admin.getEmail());
						JOptionPane.showMessageDialog(null, "Mail Send SucceSfully!!", "Good :D", JOptionPane.OK_CANCEL_OPTION);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error!!", "X", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
				}
			});
			btnSubscribe.setBounds(362, 303, 89, 23);
			add(btnSubscribe);

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
