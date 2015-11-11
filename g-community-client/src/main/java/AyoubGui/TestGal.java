package AyoubGui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;

public class TestGal extends JPanel implements ActionListener {

	private static final int MAX = 20;
	private static final Font sans = new Font("SansSerif", Font.PLAIN, 16);
	private static final Border border = BorderFactory.createMatteBorder(4, 16,
			4, 16, Color.ORANGE);
	private ArrayList<String> list = new ArrayList<String>(MAX);
	private ArrayList<String> listimg = new ArrayList<String>(MAX);
	private ArrayList<ImageIcon> listimgspell = new ArrayList<ImageIcon>(MAX);
	private List<ImageIcon> cache = new ArrayList<ImageIcon>(MAX);
	private List<String> lorett = new ArrayList<String>(MAX);
	public List<String> spell = new ArrayList<String>(MAX);
	private JLabel imageLabel = new JLabel();
	private JButton prevButton = new JButton();
	private JButton nextButton = new JButton();
	private JComboBox favorites;
	private final JLabel lblChampionName = new JLabel("Champion name :");
	private final JTextPane esmChamp = new JTextPane();
	private final JLabel spel0lab = new JLabel("");
	private final JLabel lblChampionSpell = new JLabel("Champion spell :");
	private final JLabel spel1lab = new JLabel("");
	private final JLabel spel2lab = new JLabel("");
	private final JLabel spel3lab = new JLabel("");
	private final JLabel spel4lab = new JLabel("");
	private final JLabel spel5lab = new JLabel("");

	public TestGal() throws IOException {
		setBackground((new Color(52, 73, 94)));
		
		RiotAPI.setMirror(Region.EUW);
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");
		List<Champion> champions = RiotAPI.getChampions();
		setLayout(null);
		lblChampionName.setForeground(Color.ORANGE);
		lblChampionName.setBounds(418, 52, 126, 27);
		spel0lab.setBounds(170, 361, 65, 65);

		add(spel0lab);
		add(lblChampionName);

		int last = champions.size();
		System.out.println(last);
		// List<com.robrua.orianna.type.core.staticdata.ChampionSpelll> spellall
		// =
		for (int i = 0; i < last; i++) {
			String image = champions.get(i).getImage().getFull();
			listimg.add(i, image);
			List<com.robrua.orianna.type.core.staticdata.ChampionSpell> spellall = RiotAPI
					.getChampions().get(i).getSpells();
			int howmanyspells = spellall.size();
			for (int j = 0; j < howmanyspells; j++) {
				// System.out.println("getting spells");
				String imagespell = spellall.get(j).getImage().getFull();

				spell.add(j, imagespell);
			}
			String champname = champions.get(i).getName();
			String lore = champions.get(i).getLore();
			lorett.add(i, lore);
			list.add(i, champname);
		}
		for (int i = 0; i < list.size(); i++)
			cache.add(i, null);

		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(0, 0, 770, 41);
		titleLabel.setForeground(Color.ORANGE);
		titleLabel.setText("Champions Gallery");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
		titleLabel.setBorder(border);
		this.add(titleLabel);
		imageLabel.setBounds(63, 52, 286, 282);

		imageLabel.setIcon(getImage(0));
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setBorder(border);
		this.add(imageLabel);

		favorites = new JComboBox(list.toArray(new String[list.size()]));
		favorites.setActionCommand("favs");
		favorites.addActionListener(this);
		prevButton.setForeground(Color.BLUE);

		prevButton.setText("\u22b2Prev");
		prevButton.setFont(sans);
		prevButton.setActionCommand("prev");
		prevButton.addActionListener(this);
		nextButton.setForeground(Color.BLUE);

		nextButton.setText("Next\u22b3");
		nextButton.setFont(sans);
		nextButton.setActionCommand("next");
		nextButton.addActionListener(this);

		JPanel controlPanel = new JPanel();
		controlPanel.setBounds(0, 508, 770, 47);
		controlPanel.add(prevButton);
		controlPanel.add(favorites);
		controlPanel.add(nextButton);
		controlPanel.setBorder(border);
		this.add(controlPanel);
		lblChampionName.setFont(new Font("Gotham Light", Font.PLAIN, 14));
		esmChamp.setBounds(428, 90, 332, 374);
		add(esmChamp);
		esmChamp.setFont(new Font("Gotham Light", Font.PLAIN, 14));
		lblChampionSpell.setForeground(Color.ORANGE);
		lblChampionSpell.setFont(new Font("Gotham Light", Font.PLAIN, 14));
		lblChampionSpell.setBounds(34, 361, 126, 27);

		add(lblChampionSpell);
		spel1lab.setBounds(245, 361, 65, 65);

		add(spel1lab);
		spel2lab.setBounds(331, 361, 65, 65);

		add(spel2lab);
		spel3lab.setBounds(170, 432, 65, 65);

		add(spel3lab);
		spel4lab.setBounds(245, 432, 65, 65);

		add(spel4lab);
		spel5lab.setBounds(331, 432, 65, 65);

		add(spel5lab);

	}

	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		if ("favs".equals(cmd)) {
			int sizspell = spell.size();
			int index = favorites.getSelectedIndex();
			System.out.println(index);
			ImageIcon image = null;
			String currentlore = null;
			// List<ImageIcon> spellicon = null;
			ImageIcon spelliconone = null;
			try {
				image = getImage(index);
				currentlore = getLore(index);
				System.out.println("hi");
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < 3; j++) {
				try {
					System.out.println("hello");
					spelliconone = getSpellone(1);
					spel0lab.setIcon(spelliconone);
					spelliconone = getSpellone(2);
					spel1lab.setIcon(spelliconone);
					spelliconone = getSpellone(3);
					spel3lab.setIcon(spelliconone);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			imageLabel.setIcon(image);
			esmChamp.setText(currentlore);

			if (image != null)
				imageLabel.setText("");
			else
				imageLabel.setText("Image not available.");
		}
		if ("prev".equals(cmd)) {
			int index = favorites.getSelectedIndex() - 1;
			if (index < 0)
				index = list.size() - 1;
			favorites.setSelectedIndex(index);
		}
		if ("next".equals(cmd)) {
			int index = favorites.getSelectedIndex() + 1;
			System.out.println(index);
			if (index > list.size() - 1)
				index = 0;
			favorites.setSelectedIndex(index);
		}
	}

	private ImageIcon getSpellone(int j) throws IOException {
		String currentSpell = spell.get(j);
		System.out.println(currentSpell);
		String championspell = "http://ddragon.leagueoflegends.com/cdn/5.2.1/img/spell/"
				+ currentSpell;
		URL url = new URL(championspell);
		BufferedImage img = ImageIO.read(url);
		ImageIcon spelliconone = new ImageIcon(img);

		return spelliconone;
	}

	public JButton getDefault() {
		return nextButton;
	}

	// Return the (possibly cached) image having the given index.
	private ImageIcon getImage(int index) throws IOException {
		/*
		 * RiotAPI.setMirror(Region.EUW); RiotAPI.setRegion(Region.EUW);
		 * RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");
		 * List<Champion> champions = RiotAPI.getChampions();
		 */
		String image = listimg.get(index);

		String championimg = "http://ddragon.leagueoflegends.com/cdn/5.9.1/img/champion/"
				+ image;

		URL url = new URL(championimg);
		BufferedImage img = ImageIO.read(url);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}

	@SuppressWarnings("unused")
	private String getLore(int index) {
		String currentlore = lorett.get(index);
		return currentlore;
	}
	int sizspell = spell.size();
	/*private List<ImageIcon> getSpell(int index) throws IOException {

		for (int j = 0; j < sizspell; j++) {
			String currentSpell = spell.get(index);
			System.out.println(currentSpell);
			String championspell = "http://ddragon.leagueoflegends.com/cdn/5.2.1/img/spell/"
					+ currentSpell;
			URL url = new URL(championspell);
			BufferedImage img = ImageIO.read(url);
			ImageIcon spellicon = new ImageIcon(img);
			listimgspell.add(spellicon);

		}
		return listimgspell;
	}*/

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				TestGal go = null;
				try {
					go = new TestGal();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.getContentPane().add(go);
				frame.setTitle("Champions Gallery");
				frame.setSize(820, 600);
				frame.setBackground(new Color(52, 73, 94));
				frame.setVisible(true);
				go.getDefault().requestFocusInWindow();
			}
		});
	}
}