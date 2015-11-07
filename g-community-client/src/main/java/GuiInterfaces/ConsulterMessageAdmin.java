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

import repo.ConsulterListeMessageAdminAdapter;

public class ConsulterMessageAdmin extends JPanel  {
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
	

    public void toExcel(JTable table, File file) {
        try {
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }

            excel.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }

            excel.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
	public ConsulterMessageAdmin(ActiveMember admin) throws NamingException {
		
		this.admin=admin;

		setLayout(null);
		try {
			
			JButton btnToExcel = new JButton("To excel");
			btnToExcel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 JFileChooser fc = new JFileChooser();
		                int option = fc.showSaveDialog(ConsulterMessageAdmin.this);
		                if(option == JFileChooser.APPROVE_OPTION){
		                    String filename = fc.getSelectedFile().getName(); 
		                    String path = fc.getSelectedFile().getParentFile().getPath();

							int len = filename.length();
							String ext = "";
							String file = "";

							if(len > 4){
								ext = filename.substring(len-4, len);
							}

							if(ext.equals(".xls")){
								file = path + "\\" + filename; 
							}else{
								file = path + "\\" + filename + ".doc"; 
							}
							toExcel(accountingTable, new File(file));
		        
		        
		                }
					
					
				}
			});
			
			btnToExcel.setBounds(331, 256, 89, 23);
			add(btnToExcel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(86, 107, 572, 119);
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
