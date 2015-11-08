package GuiInterfaces;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionListener;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.swing.JEditorPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.awt.geom.Shape;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import delegate.SimpleMemberdelegate;
import entities.SimpleMember;
import repo.AccountListed;

public class ShowAlone extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JTable table_1;
	private JTable table;
	int row;
	int cb_number;
	
	Border BlackBorder = new LineBorder(Color.BLACK);
	Calendar TodayCalendar = Calendar.getInstance();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAlone frame = new ShowAlone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	
	/**
	 * Create the frame.
	 * 
	 * @throws NamingException
	 */
	public ShowAlone() throws NamingException {
		AccountListed modele = new AccountListed();

		// ArrayList<Gamer> List_Gamers=(ArrayList<Gamer>)
		// proxyGamer.readAllGamer();

	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setTitle("List of Account");
		//setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println("aaa" + test + row);
			}
		});
		scrollPane.setBounds(38, 62, 357, 138);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);

			}
		});
		
		scrollPane.setViewportView(table);
		table.setModel(modele);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Document document = new Document(PageSize.A4.rotate());
			    try {
			      PdfWriter pdf_writer = PdfWriter.getInstance(document, 
			      	new FileOutputStream("D:\\PidevFinal\\users.pdf"));
			 System.out.println("cv");
			      document.open();
			      PdfContentByte cb = pdf_writer.getDirectContent();
			 
			      cb.saveState();
			      Graphics2D g2 = cb.createGraphicsShapes(500, 500);
			 
			      java.awt.Shape oldClip = g2.getClip();
			      g2.clipRect(0, 0, 500, 500);
			 
			      table.print(g2);
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
				
		
		btnPrint.setBounds(163, 251, 89, 23);
		contentPane.add(btnPrint);
		
	}
			
			

			private void refresh_table() {
				AccountListed modele = new AccountListed();

				// ArrayList<Gamer> List_Gamers=(ArrayList<Gamer>)
				// proxyGamer.readAllGamer();

				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				//setContentPane(contentPane);
				contentPane.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(table);
				table.setModel(modele);
			
			
			}
	}
