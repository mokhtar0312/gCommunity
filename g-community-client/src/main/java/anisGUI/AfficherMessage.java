package anisGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import delegate.ActiveMemberServicesDelegate;
import delegate.AuthentificationDelegate;
import entities.ActiveMember;

import javax.swing.JScrollPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import repo.ConsulterListeMessageAdminAdapter;

public class AfficherMessage extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable accountingTable;
    static ActiveMember admin = AuthentificationDelegate.doGetConectedPerson();


	/**
	 * Create the panel.
	 * @throws NamingException 
	 */
	


//    public void toExcel(JTable table, File file) {
//        try {
//            TableModel model = table.getModel();
//            FileWriter excel = new FileWriter(file);
//        	System.out.println(model.toString());
//
//            for (int i = 0; i < model.getColumnCount(); i++) {
//                excel.write(model.getColumnName(i) + "\t");
//            }
//
//            excel.write("\n");
//
//            for (int i = 0; i < model.getRowCount(); i++) {
//                for (int j = 0; j < model.getColumnCount(); j++) {
//                    excel.write(model.getValueAt(i, j).toString() + "\t");
//                }
//                excel.write("\n");
//            }
//
//            excel.close();
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }

	public AfficherMessage(ActiveMember admin) throws NamingException {
		
		this.admin=admin;

		setLayout(null);
		try {
			
			JButton btnToExcel = new JButton("Extract To PDF");
			btnToExcel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Document document = new Document(PageSize.A4.rotate());
					try {
						PdfWriter pdf_writer = PdfWriter.getInstance(document,
								new FileOutputStream("D:\\Messages.pdf"));
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
						JOptionPane.showMessageDialog(null,
								"Message List sucessefully exported to PDF");
					} catch (Exception e1) {
						System.err.println(e1.getMessage());
					}
					document.close();
				}
//					 JFileChooser fc = new JFileChooser();
//		                int option = fc.showSaveDialog(AfficherMessage.this);
//		                if(option == JFileChooser.APPROVE_OPTION){
//		                    String filename = fc.getSelectedFile().getName(); 
//		                    String path = fc.getSelectedFile().getParentFile().getPath();
//
//							int len = filename.length();
//							String ext = "";
//							String file = "";
//
//							if(len > 4){
//								ext = filename.substring(len-4, len);
//							}
//
//							if(ext.equals(".xls")){
//								file = path + "\\" + filename; 
//							}else{
//								file = path + "\\" + filename + ".doc"; 
//							}
//							toExcel(accountingTable, new File(file));
//		        
//		        
//		                }
//					
//					
//				}
			});
			
			btnToExcel.setBounds(283, 256, 137, 23);
			add(btnToExcel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 89, 572, 119);
			add(scrollPane);
			accountingTable = new JTable();
			scrollPane.setViewportView(accountingTable);
			accountingTable.setBackground(Color.WHITE);
			accountingTable.setModel(new ConsulterListeMessageAdminAdapter((ActiveMember) admin) );

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
