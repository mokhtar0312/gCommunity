package GuiInterfaces;

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

import repo.AfficherEventAdapter;
import repo.ConsulterListeMessageAdminAdapter;

public class AficherEvent extends JPanel  {
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
	

    
	public AficherEvent(ActiveMember admin) throws NamingException {
		
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

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
