package GuiInterfaces;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import repo.ConsulterListeCandidatsAdapter;

public class ConsulterCandidat extends JPanel {
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

	public ConsulterCandidat() throws NamingException {

		setLayout(null);
		try {
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(86, 107, 572, 119);
			add(scrollPane_1);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane_1.setViewportView(scrollPane);
			accountingTable = new JTable();
			scrollPane.setViewportView(accountingTable);
			accountingTable.setBackground(Color.WHITE);
			accountingTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = accountingTable.getSelectedRow();
					System.out.println("aaaa" + row);
					String test = accountingTable.getModel().getValueAt(row, 0).toString();
					System.out.println(test);

				}
			});
			accountingTable.setModel(new ConsulterListeCandidatsAdapter());
			

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
