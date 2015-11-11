package AyoubGui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;


public class TestGal extends JPanel implements ActionListener {
	
	
    private static final int MAX = 20;
    private static final Font sans = new Font("SansSerif", Font.PLAIN, 16);
    private static final Border border =
        BorderFactory.createMatteBorder(4, 16, 4, 16, Color.lightGray);
    private ArrayList<String> list = new ArrayList<String>(MAX);
    private ArrayList<String> listimg = new ArrayList<String>(MAX);
    private List<ImageIcon> cache = new ArrayList<ImageIcon>(MAX);
    private JLabel imageLabel = new JLabel();
    private JButton prevButton = new JButton();
    private JButton nextButton = new JButton();
    private JComboBox favorites;

    
    public TestGal() throws IOException {
        this.setLayout(new BorderLayout());

        RiotAPI.setMirror(Region.EUW);
    	RiotAPI.setRegion(Region.EUW);
    	RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");
        List<Champion> champions = RiotAPI.getChampions();
		
		int last = champions.size();
		System.out.println(last);
		
		for (int i = 0; i < last; i++) {
		String image = champions.get(i).getImage().getFull();
		listimg.add(i, image);
		String champname = champions.get(i).getName();
		list.add(i, champname);
		}
        for (int i = 0; i < list.size(); i++) cache.add(i, null);

        JLabel titleLabel = new JLabel();
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setText("Champions Gallery");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 28));
        titleLabel.setBorder(border);
        this.add(titleLabel, BorderLayout.NORTH);

        imageLabel.setIcon(getImage(0));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setBounds(20, 20, 350, 250);
        imageLabel.setBorder(border);
        this.add(imageLabel, BorderLayout.CENTER);

        favorites = new JComboBox(
            list.toArray(new String[list.size()]));
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
        controlPanel.add(prevButton);
        controlPanel.add(favorites);
        controlPanel.add(nextButton);
        controlPanel.setBorder(border);
        this.add(controlPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        if ("favs".equals(cmd)) {
            int index = favorites.getSelectedIndex();
            System.out.println(index);
            ImageIcon image = null;
			try {
				image = getImage(index);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            imageLabel.setIcon(image);
            if (image != null) imageLabel.setText("");
            else imageLabel.setText("Image not available.");
        }
        if ("prev".equals(cmd)) {
            int index = favorites.getSelectedIndex() - 1;
            if (index < 0) index = list.size() - 1;
            favorites.setSelectedIndex(index);
        }
        if ("next".equals(cmd)) {
            int index = favorites.getSelectedIndex() + 1;
            System.out.println(index);
            if (index > list.size() - 1) index = 0;
            favorites.setSelectedIndex(index);
        }
    }

    public JButton getDefault() { return nextButton; }

    // Return the (possibly cached) image having the given index.
    private ImageIcon getImage(int index) throws IOException {
    	/*RiotAPI.setMirror(Region.EUW);
    	RiotAPI.setRegion(Region.EUW);
    	RiotAPI.setAPIKey("e42452b3-20e3-4401-87e6-d86926e5ffac");
        List<Champion> champions = RiotAPI.getChampions();*/
        String image = listimg.get(index);
        System.out.println(image);
        System.out.println(index);
        String championimg = "http://ddragon.leagueoflegends.com/cdn/5.9.1/img/champion/"+image;
		
		 URL url = new URL(championimg);
		BufferedImage img = ImageIO.read(url);
		ImageIcon icon = new ImageIcon(img);
    	return icon;
    }

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
                frame.setSize(400, 300);
                frame.setVisible(true);
                go.getDefault().requestFocusInWindow();
            }
        });
    }
}