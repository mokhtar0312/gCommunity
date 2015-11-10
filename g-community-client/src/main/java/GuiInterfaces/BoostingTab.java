package GuiInterfaces;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.naming.NamingException;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import repo.AccountListed;
import algorithm.BoostingApproximation;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import delegate.SimpleMemberdelegate;
import entities.SimpleMember;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class BoostingTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	int row;
	private JTextField textFieldNow;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
	 */

	public BoostingTab() throws NamingException {

		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		System.out.println("dkhalt");
		scrollPane.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);
				int id = Integer.parseInt(test);
				SimpleMember account = new SimpleMember();
				account = SimpleMemberdelegate.doFindSimpleMemberById(id);
				System.out.println(id);
				Double a = account.getXp();
				String Xp=BoostingApproximation.DivisionFinder(a);
				System.out.println(Xp);
				textFieldNow.setText(Xp);

			}
		});
		

		scrollPane.setBounds(107, 109, 415, 173);

		add(scrollPane);
		table = new JTable();
table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.getSelectedRow();
				System.out.println("aaaa" + row);
				String test = table.getModel().getValueAt(row, 0).toString();
				System.out.println(test);
				int id = Integer.parseInt(test);
				SimpleMember account = new SimpleMember();
				account = SimpleMemberdelegate.doFindSimpleMemberById(id);
				System.out.println(id);
				Double a = account.getXp();
				String Xp=BoostingApproximation.DivisionFinder(a);
				System.out.println(Xp);
				textFieldNow.setText(Xp);
				
				

			}
		});
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setModel(new AccountListed());
		
		JComboBox comboBoxWanted = new JComboBox();
		comboBoxWanted.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxWanted.setModel(new DefaultComboBoxModel(new String[] {"Bronze 5", "Bronze 4", "Bronze 3", "Bronze 2", "Bronze 1", "Silver 5", "Silver 4", "Silver 3", "Silver 2", "Silver 1", "Gold 5", "Gold 4", "Gold 3", "Gold 2", "Gold 1"}));
		comboBoxWanted.setMaximumRowCount(15);
		comboBoxWanted.setBounds(381, 350, 102, 34);
		add(comboBoxWanted);
		
		textFieldNow = new JTextField();
		textFieldNow.setBounds(156, 352, 102, 34);
		add(textFieldNow);
		textFieldNow.setColumns(10);
		
		JButton btnNewButton = new JButton("Estimation");
		
		btnNewButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String wanted = (String) comboBoxWanted.getSelectedItem();
				Double b=BoostingApproximation.XPFinder(wanted);
				Double a=BoostingApproximation.XPFinder(textFieldNow.getText());
				System.out.println("aaaaa    :"+a);
				Integer c=BoostingApproximation.numberOfDays(a, b);
				System.out.println("le nombre de jours est "+c);
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent,"The number of days estimated is :"+c);
			}
		});
		btnNewButton.setBounds(248, 452, 132, 34);
		add(btnNewButton);

		

	}
}