package GuiInterfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import repo.AccountListed;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import delegate.ActiveMemberServicesDelegate;
import delegate.EventServiceDelegate;
import delegate.SimpleMemberdelegate;
import entities.ActiveMember;
import entities.Event;
import entities.SimpleMember;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

public class ShowUsersFrame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable accountingTable;
	int row;
	private JTextField update;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
	 */

	public ShowUsersFrame() throws NamingException {

		AccountListed model= new AccountListed();
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(103, 134, 474, 173);

		add(scrollPane);
		accountingTable = new JTable();
		scrollPane.setViewportView(accountingTable);
		accountingTable.setBackground(Color.WHITE);
		accountingTable.setModel(new AccountListed());
		
accountingTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("d5alt");
				row = accountingTable.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = accountingTable.getModel().getValueAt(row, 0).toString();
				System.out.println(test);
				int id = Integer.parseInt(test);
				System.out.println("l9itttttttttttttt");
				ActiveMember account = new ActiveMember();
				account = ActiveMemberServicesDelegate.doFindActiveMemberById(id);
				update.setText(Boolean.toString(account.getApproved()));
				System.out.println(id);
				
				}});
		
		

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Document document = new Document(PageSize.A4.rotate());
			    try {
			      PdfWriter pdf_writer = PdfWriter.getInstance(document, 
			      	new FileOutputStream("D:\\JEE\\users.pdf"));
			 System.out.println("cv");
			      document.open();
			      PdfContentByte cb = pdf_writer.getDirectContent();
			 
			      cb.saveState();
			      Graphics2D g2 = cb.createGraphicsShapes(500, 500);
			 
			      java.awt.Shape oldClip = g2.getClip();
			      g2.clipRect(0, 0, 500, 500);
			 
			      accountingTable.print(g2);
			      g2.setClip(oldClip);
			 
			      g2.dispose();
			      cb.restoreState();
			      JOptionPane.showMessageDialog(null, "User List sucessefully exported to PDF");
			    } catch (Exception e1) {
			      System.err.println(e1.getMessage());
			    }
			    document.close();
			}
		});
		btnPrint.setBounds(297, 362, 89, 23);
		add(btnPrint);
		
		JLabel lblApprovedValue = new JLabel("Approved Value:");
		lblApprovedValue.setForeground(Color.YELLOW);
		lblApprovedValue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApprovedValue.setBounds(140, 109, 131, 14);
		add(lblApprovedValue);
		
		update = new JTextField();
		update.setBounds(281, 108, 116, 20);
		add(update);
		update.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,
						"Do you really wan't to suspend the account", "ban",
						JOptionPane.YES_NO_OPTION);
				String test = accountingTable.getModel().getValueAt(row, 0).toString();
				int id = Integer.parseInt(test);
				ActiveMember account = new ActiveMember();
				account = ActiveMemberServicesDelegate.doFindActiveMemberById(id);
				//update.setText(Boolean.toString(account.getApproved()));
				Boolean ghazi=Boolean.valueOf(update.getText());
				System.out.println("hedhi valeurrrr"+ghazi);
				account.setApproved(ghazi);
				ActiveMemberServicesDelegate.doUpdateActiveMember(account);
				model.refresh();
				model.fireTableDataChanged();
				
			}
		});
		btnUpdate.setBounds(440, 107, 89, 23);
		add(btnUpdate);

	}
}
