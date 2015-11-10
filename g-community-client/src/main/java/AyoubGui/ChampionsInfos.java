package AyoubGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;

public class ChampionsInfos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChampionsInfos frame = new ChampionsInfos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ChampionsInfos() throws IOException {

		RiotAPI.setMirror(Region.EUW);
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");
		List<Champion> champions = RiotAPI.getChampions();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println(champions.size());
		int last = champions.size()-122;
		System.out.println(last);
		int p = 0,h = 0;
		for (int i = 0; i < last; i++) {
			
		String image = champions.get(i).getImage().getFull();
		String champname = champions.get(i).getName();
		System.out.println(image);
		System.out.println(champname);
		String championimg = "http://ddragon.leagueoflegends.com/cdn/5.9.1/img/champion/"+image;
		
		 URL url = new URL(championimg);
		BufferedImage img = ImageIO.read(url);
		ImageIcon icon = new ImageIcon(img);
		JLabel lblLol = new JLabel(champname, icon, JLabel.CENTER);
		JPanel panel = new JPanel();
		panel.add(lblLol, BorderLayout.CENTER);
		if ((i & 1) == 0) {
			
			 p = p+130;
		} else {
			 h = h+140;
			 
		}
		System.out.println(p+","+h);
		panel.setBounds(10, 130, 140, 165);
		contentPane.add(panel);
		}
		JPanel panel = new JPanel();
		//panel.add( BorderLayout.CENTER);
		panel.setBounds(20, 20, 350, 250);
		contentPane.add(panel);
	}
}
