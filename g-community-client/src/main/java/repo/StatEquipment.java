package repo;

import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import delegate.ActiveMemberServicesDelegate;
import delegate.EquipmentDelegate;
import delegate.VoteServicesDelegate;
import entities.ActiveMember;
import entities.Equipment;
import entities.Vote;

public class StatEquipment extends JFrame {
	CategoryDataset dataset;// Dataset qui va contenir les Données
	JFreeChart graphe; // Graphe
	ChartPanel cp; // Panel

	public StatEquipment() {
		
		int total = 1;
		int j = 0, a = 0, b = 0;

		List<Equipment> touslesEquipments = EquipmentDelegate.findAllEquipment();
		Integer nbreequipments = touslesEquipments.size();
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int nbr = 0;
		int nbr2 = 0;
		for (Equipment equi : touslesEquipments) {
			
			if(equi.getState()){
				nbr++;
				
			}

			

			

		}
		dataset.setValue(nbr, "", "Available");	
for (Equipment equi : touslesEquipments) {
			
			if(!equi.getState()){
				nbr2++;
				
			}

			

			

		}
		dataset.setValue(nbr2, "", "In use");
		
		graphe = ChartFactory.createBarChart3D("", "", "",dataset, PlotOrientation.VERTICAL, false, false, false);
		cp = new ChartPanel(graphe);
		this.add(cp);
	}
}
