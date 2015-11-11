package anisGUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.naming.NamingException;
import javax.swing.JFrame;

import delegate.AuthentificationDelegate;
import entities.ActiveMember;

public class AfficherEventRestant {
	static ActiveMember admin = AuthentificationDelegate.doGetConectedPerson();

	public JFrame frameaffich;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherEventRestant window = new AfficherEventRestant();
					window.frameaffich.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws NamingException
	 */
	public AfficherEventRestant() throws NamingException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws NamingException
	 */
	private void initialize() throws NamingException {
		frameaffich = new JFrame();
		frameaffich.getContentPane().setBackground(new Color(52, 73, 94));
		frameaffich.setBounds(120, 120, 800, 500);
		frameaffich.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameaffich.getContentPane().setLayout(null);

		EventShowRestant panel = new EventShowRestant(admin);
		panel.setBounds(52, 68, 688, 340);
		frameaffich.getContentPane().add(panel);
	}
}
