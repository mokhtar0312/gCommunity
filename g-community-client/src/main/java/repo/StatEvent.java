/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import entities.Event;

/**
 *
 * @author MOMO
 */
public class StatEvent extends JFrame {

	public StatEvent(Event event) {
		DefaultPieDataset dataset;// Dataset qui va contenir les Données

        dataset = new DefaultPieDataset();
		JFreeChart graphe; // Graphe
		ChartPanel cp; // Panel
		System.out.println(event.getId());
		int total = event.getNumberOfPlaces();
		int i = event.getNumberOfParticipants();
		System.out.println(i);
		int j = total - i;
		System.out.println(j);
		

		
		dataset.setValue(String.valueOf(i) + " reserved", i);
		dataset.setValue(String.valueOf(j) + " free ", j);
		graphe = ChartFactory.createPieChart3D("Stats", dataset, true, true,
				false);
		cp = new ChartPanel(graphe);
		this.add(cp);
	}

}
