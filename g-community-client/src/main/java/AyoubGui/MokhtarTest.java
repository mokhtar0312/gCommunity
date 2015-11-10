package AyoubGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegate.ActiveMemberServicesDelegate;
import entities.ActiveMember;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollPane;

public class MokhtarTest extends JFrame {

	private JPanel contentPane;
	private List<ActiveMember> members = new ArrayList<ActiveMember>();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MokhtarTest frame = new MokhtarTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MokhtarTest() {
		members = ActiveMemberServicesDelegate.doFindAllActiveMember();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 25, 377, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<ActiveMember, List<ActiveMember>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, members, table);
		//
		BeanProperty<ActiveMember, String> activeMemberBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(activeMemberBeanProperty).setColumnName("Name");
		//
		BeanProperty<ActiveMember, String> activeMemberBeanProperty_1 = BeanProperty.create("surname");
		jTableBinding.addColumnBinding(activeMemberBeanProperty_1).setColumnName("Surname");
		//
		BeanProperty<ActiveMember, String> activeMemberBeanProperty_2 = BeanProperty.create("role");
		jTableBinding.addColumnBinding(activeMemberBeanProperty_2).setColumnName("Role");
		//
		jTableBinding.bind();
	}
}
