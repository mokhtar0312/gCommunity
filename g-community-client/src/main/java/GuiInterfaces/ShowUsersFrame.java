package GuiInterfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import repo.AccountListed;
import repo.ConsulterListeCandidatsAdapter;

import javax.swing.JButton;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;

public class ShowUsersFrame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable accountingTable;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
	 */

	public ShowUsersFrame() throws NamingException {

		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 56, 476, 173);
		add(scrollPane);
		accountingTable = new JTable();
		scrollPane.setViewportView(accountingTable);
		accountingTable.setBackground(Color.WHITE);
		accountingTable.setModel(new AccountListed());
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Document document = new Document(PageSize.A4.rotate());
			    try {
			      PdfWriter pdf_writer = PdfWriter.getInstance(document, 
			      	new FileOutputStream("D:\\PiGcom\\users.pdf"));
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
		btnPrint.setBounds(252, 292, 89, 23);
		add(btnPrint);

	}
}

