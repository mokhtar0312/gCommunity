package AyoubGui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegate.ActiveMemberServicesDelegate;
import delegate.SimpleMemberdelegate;
import entities.SimpleMember;

public class selectuser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private List<SimpleMember> simplemembers;
	public static Integer lookfor;
	public static String esm;
	public selectuser dialog;
	public static Boolean closeit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			selectuser dialog = new selectuser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public selectuser() {
		setTitle("Select from Members");
		simplemembers = new ArrayList<SimpleMember>();
		simplemembers = SimpleMemberdelegate.doFindAllSimpleMember();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 229);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 1) {
							closeit = false;
							lookfor = simplemembers.get(
									table.getSelectedRow()).getId();
						 esm = simplemembers.get(
									table.getSelectedRow()).getName();
						closeit = true;
						 
							//new TutorialCrud().show();
						 
						}
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<SimpleMember, List<SimpleMember>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, simplemembers, table);
		//
		BeanProperty<SimpleMember, String> simpleMemberBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(simpleMemberBeanProperty).setColumnName(
				"Member name");
		//
		BeanProperty<SimpleMember, String> simpleMemberBeanProperty_1 = BeanProperty
				.create("username");
		jTableBinding.addColumnBinding(simpleMemberBeanProperty_1)
				.setColumnName("Member lastname");
		//
		BeanProperty<SimpleMember, String> simpleMemberBeanProperty_2 = BeanProperty
				.create("email");
		jTableBinding.addColumnBinding(simpleMemberBeanProperty_2)
				.setColumnName("Email");
		//
		jTableBinding.bind();
	}
}
