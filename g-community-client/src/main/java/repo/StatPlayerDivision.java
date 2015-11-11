package repo;

import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import delegate.ActiveMemberServicesDelegate;
import delegate.SimpleMemberdelegate;
import delegate.VoteServicesDelegate;
import entities.ActiveMember;
import entities.SimpleMember;
import entities.Vote;

public class StatPlayerDivision extends JFrame {
	DefaultPieDataset dataset;// Dataset qui va contenir les Données
	JFreeChart graphe; // Graphe
	ChartPanel cp; // Panel

	public StatPlayerDivision() {
		dataset = new DefaultPieDataset();
		
		int bronze = 0, silver = 0, gold = 0;

		List<SimpleMember> touslesmembre = SimpleMemberdelegate.doFindAllSimpleMember();
		Integer nbremembres = touslesmembre.size();
		for (SimpleMember membre : touslesmembre) {
			if (membre.getXp()<25) {

				bronze++;
			}
			else if (membre.getXp()>=25 && membre.getXp()<50) {

				silver++;
			}
			else if(membre.getXp()>=50 )   {

				gold++;
			}
		}
		List<ActiveMember> touslesmember = ActiveMemberServicesDelegate
				.doFindAllActiveMember();
		dataset = new DefaultPieDataset();

		

		double pourj=(double)bronze/nbremembres * 100;
        double poura=(double)silver/nbremembres * 100;
        double pourb=(double)gold/nbremembres * 100;
        dataset = new DefaultPieDataset();
        dataset.setValue(String.valueOf(pourj)+"  Bronze ",pourj);
        dataset.setValue(String.valueOf( poura)+"  Silver", poura );
        dataset.setValue(String.valueOf( pourb)+"  Gold",pourb );

		
		
		graphe = ChartFactory.createPieChart3D("Tiers " , dataset, true, true,
				false);
		cp = new ChartPanel(graphe);
		this.add(cp);
	}
}
