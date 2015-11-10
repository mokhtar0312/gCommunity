/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import delegate.ActiveMemberServicesDelegate;
import delegate.VoteServicesDelegate;
import entities.ActiveMember;
import entities.Vote;

/**
 *
 * @author MOMO
 */
public class StatVote extends JFrame {
	DefaultPieDataset dataset;// Dataset qui va contenir les Données
	JFreeChart graphe; // Graphe
	ChartPanel cp; // Panel

	public StatVote() {
		dataset = new DefaultPieDataset();
		int total = 1;
		int j = 0, a = 0, b = 0;

		List<Vote> touslesvotes = VoteServicesDelegate.findAllVotes();
		Integer nbrevotes = 0;
		for (Vote tester1 : touslesvotes) {
			if (tester1.getYear() == Calendar.getInstance().get(Calendar.YEAR)) {

				nbrevotes++;
			}
		}
		List<ActiveMember> touslesmember = ActiveMemberServicesDelegate
				.doFindAllActiveMember();
		dataset = new DefaultPieDataset();

		for (ActiveMember thefamousmember : touslesmember) {
			int mesvotes = 0;
			for (Vote tester2 : touslesvotes) {

				if (tester2.getActivemembervoted().getId() == thefamousmember
						.getId()) {
					mesvotes++;

				}
				int pourj = mesvotes ;
				dataset.setValue(
						String.valueOf(pourj) + "Have voted for : " + thefamousmember.getName()
								+ " " + thefamousmember.getSurname(), pourj);
			}

			

		}
		
		graphe = ChartFactory.createPieChart3D("Votes " , dataset, true, true,
				false);
		cp = new ChartPanel(graphe);
		this.add(cp);
	}
}
