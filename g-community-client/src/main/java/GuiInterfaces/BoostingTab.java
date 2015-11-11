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
import repo.BoostingModel;
import repo.StatPlayerDivision;
import repo.StatVote;
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

import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		JLabel BronzeIcone = new JLabel("New label");
		BronzeIcone.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/BronzeBadgeSeason2.png")));
		BronzeIcone.setBounds(156, 397, 102, 56);
		add(BronzeIcone);
		BronzeIcone.setVisible(false);
		
		JLabel GoldIcone = new JLabel("New label");
		GoldIcone.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/gold_5.png")));
		GoldIcone.setBounds(156, 397, 102, 56);
		add(GoldIcone);
		GoldIcone.setVisible(false);
		
		JLabel GoldIcone1 = new JLabel("New label");
		GoldIcone1.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/gold_5.png")));
		GoldIcone1.setBounds(381, 397, 102, 56);
		add(GoldIcone1);
		GoldIcone1.setVisible(false);
		
		JLabel BronzeIcone1 = new JLabel("New label");
		BronzeIcone1.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/BronzeBadgeSeason2.png")));
		BronzeIcone1.setBounds(381, 397, 102, 56);
		add(BronzeIcone1);
		BronzeIcone.setVisible(false);
		
		JLabel SilverIcone1 = new JLabel("New label");
		SilverIcone1.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/SilverBadgeSeason2.png")));
		SilverIcone1.setBounds(381, 397, 102, 56);
		add(SilverIcone1);
		SilverIcone1.setVisible(false);
		
		JLabel SilverIcone = new JLabel("New label");
		SilverIcone.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/SilverBadgeSeason2.png")));
		SilverIcone.setBounds(156, 397, 102, 56);
		add(SilverIcone);
		SilverIcone.setVisible(false);
		
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
		

		scrollPane.setBounds(47, 105, 415, 173);

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
				if (textFieldNow.getText().equals("Bronze 5")){
					BronzeIcone.setVisible(true);
					SilverIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Bronze 4")){
					BronzeIcone.setVisible(true);
					SilverIcone.setVisible(false);
					GoldIcone.setVisible(false);
					
				}
				else if (textFieldNow.getText().equals("Bronze 3")){
					BronzeIcone.setVisible(true);
					SilverIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Bronze 2")){
					BronzeIcone.setVisible(true);
					SilverIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Bronze 1")){
					BronzeIcone.setVisible(true);
					SilverIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Silver 5")){
					SilverIcone.setVisible(true);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Silver 4")){
					SilverIcone.setVisible(true);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Silver 3")){
					SilverIcone.setVisible(true);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Silver 2")){
					SilverIcone.setVisible(true);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Silver 1")){
					SilverIcone.setVisible(true);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(false);
				}
				else if (textFieldNow.getText().equals("Gold 5")){
					SilverIcone.setVisible(false);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(true);
				}
				else if (textFieldNow.getText().equals("Gold 4")){
					SilverIcone.setVisible(false);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(true);
				}
				else if (textFieldNow.getText().equals("Gold 3")){
					SilverIcone.setVisible(false);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(true);
				}
				else if (textFieldNow.getText().equals("Gold 2")){
					SilverIcone.setVisible(false);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(true);
				}
				else if (textFieldNow.getText().equals("Gold 1")){
					SilverIcone.setVisible(false);
					BronzeIcone.setVisible(false);
					GoldIcone.setVisible(true);
				}
				
				

			}
		});
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setModel(new BoostingModel());
		
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
		
		String wanted = (String) comboBoxWanted.getSelectedItem();
		if (wanted.equals("Bronze 5")){
			BronzeIcone1.setVisible(true);
			SilverIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Bronze 4")){
			BronzeIcone1.setVisible(true);
			SilverIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
			
		}
		else if (wanted.equals("Bronze 3")){
			BronzeIcone1.setVisible(true);
			SilverIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Bronze 2")){
			BronzeIcone1.setVisible(true);
			SilverIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Bronze 1")){
			BronzeIcone1.setVisible(true);
			SilverIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Silver 5")){
			SilverIcone1.setVisible(true);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Silver 4")){
			SilverIcone1.setVisible(true);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Silver 3")){
			SilverIcone1.setVisible(true);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Silver 2")){
			SilverIcone1.setVisible(true);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Silver 1")){
			SilverIcone1.setVisible(true);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(false);
		}
		else if (wanted.equals("Gold 5")){
			SilverIcone1.setVisible(false);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(true);
		}
		else if (wanted.equals("Gold 4")){
			SilverIcone1.setVisible(false);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(true);
		}
		else if (wanted.equals("Gold 3")){
			SilverIcone1.setVisible(false);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(true);
		}
		else if (wanted.equals("Gold 2")){
			SilverIcone1.setVisible(false);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(true);
		}
		else if (wanted.equals("Gold 1")){
			SilverIcone1.setVisible(false);
			BronzeIcone1.setVisible(false);
			GoldIcone1.setVisible(true);
		}
		
		JButton btnNewButton = new JButton("Estimation");
		
		btnNewButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String wanted = comboBoxWanted.getSelectedItem().toString().trim();
				if (wanted.equals("Bronze 5")){
					BronzeIcone1.setVisible(true);
					SilverIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Bronze 4")){
					BronzeIcone1.setVisible(true);
					SilverIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
					
				}
				else if (wanted.equals("Bronze 3")){
					BronzeIcone1.setVisible(true);
					SilverIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Bronze 2")){
					BronzeIcone1.setVisible(true);
					SilverIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Bronze 1")){
					BronzeIcone1.setVisible(true);
					SilverIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Silver 5")){
					SilverIcone1.setVisible(true);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Silver 4")){
					SilverIcone1.setVisible(true);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Silver 3")){
					SilverIcone1.setVisible(true);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Silver 2")){
					SilverIcone1.setVisible(true);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Silver 1")){
					SilverIcone1.setVisible(true);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(false);
				}
				else if (wanted.equals("Gold 5")){
					SilverIcone1.setVisible(false);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(true);
				}
				else if (wanted.equals("Gold 4")){
					SilverIcone1.setVisible(false);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(true);
				}
				else if (wanted.equals("Gold 3")){
					SilverIcone1.setVisible(false);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(true);
				}
				else if (wanted.equals("Gold 2")){
					SilverIcone1.setVisible(false);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(true);
				}
				else if (wanted.equals("Gold 1")){
					SilverIcone1.setVisible(false);
					BronzeIcone1.setVisible(false);
					GoldIcone1.setVisible(true);
				}
				Double b=BoostingApproximation.XPFinder(wanted);
				Double a=BoostingApproximation.XPFinder(textFieldNow.getText());
				System.out.println("aaaaa    :"+a);
				Integer c=BoostingApproximation.numberOfDays(a, b);
				System.out.println("le nombre de jours est "+c);
				Integer facture=BoostingApproximation.Facture(c);
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent,"The number of days estimated is :"+c
						+"  and he have to pay : "+facture+"euros");
			}
		});
		btnNewButton.setBounds(251, 477, 132, 34);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Players Division");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StatPlayerDivision pchart = new StatPlayerDivision();
				pchart.setSize(600, 500);
				pchart.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(489, 174, 132, 23);
		add(btnNewButton_1);

//		
//		JLabel BronzeIcone = new JLabel("New label");
//		BronzeIcone.setIcon(new ImageIcon(BoostingTab.class.getResource("/images/BronzeBadgeSeason2.png")));
//		BronzeIcone.setBounds(156, 397, 102, 56);
		
		//

		

	}
}