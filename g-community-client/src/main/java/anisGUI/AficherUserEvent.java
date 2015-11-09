package anisGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import delegate.ActiveMemberServicesDelegate;
import entities.ActiveMember;

import javax.swing.JScrollPane;

import GuiInterfaces.Authentification;
import repo.AfficherEventAdapter;
import repo.ConsulterListeMessageAdminAdapter;

public class AficherUserEvent extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable accountingTable;
    static ActiveMember admin = ActiveMemberServicesDelegate.doFindActiveMemberById(12);


	/**
	 * Create the panel.
	 * @throws NamingException 
	 */
	

    
	public AficherUserEvent(ActiveMember admin) throws NamingException {
		
		this.admin=admin;

		setLayout(null);
		try {
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(86, 107, 572, 119);
			add(scrollPane);
			accountingTable = new JTable();
			scrollPane.setViewportView(accountingTable);
			accountingTable.setBackground(Color.WHITE);
			accountingTable.setModel(new AfficherEventAdapter((ActiveMember) admin) );
			
			JButton btnSub = new JButton("Subscribe to new event");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					AfficherEventRestant window;
					try {	
						window = new AfficherEventRestant();
						window.frameaffich.setVisible(true);
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								}
			});
			btnSub.setBounds(468, 284, 190, 23);
			add(btnSub);

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
}
