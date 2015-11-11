package repo;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.swing.table.AbstractTableModel;

import delegate.SimpleMemberdelegate;
import services.interfaces.SimpleMemberServicesRemote;
import entities.SimpleMember;


public class BoostingModel extends AbstractTableModel {
	private final String[] titels = {"ID","Summoner Name", "Username", "Experience"};
	ArrayList<SimpleMember> simpleMembers= (ArrayList<SimpleMember>)SimpleMemberdelegate.doFindAllSimpleMember();

	@Override
	public int getRowCount() {

		return simpleMembers.size();
	}

	@Override
	public int getColumnCount() {
		return titels.length;

	}

	@Override
	public String getColumnName(int i) {
		return titels[i];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

case 0:
			
			return simpleMembers.get(rowIndex).getId();
		
		case 1:
			// Email
			return simpleMembers.get(rowIndex).getSummonerName();

		case 2:
			// Prenom
			return simpleMembers.get(rowIndex).getUsername();
		case 3:
			// Password
			return simpleMembers.get(rowIndex).getXp();
		
		
		
		default:
			throw new IllegalArgumentException();
		}
	}


	public List<SimpleMember> getSimpleMembers() {
		return simpleMembers;
	}

	public void setSimpleMembers(List<SimpleMember> simpleMembers) {
		this.simpleMembers = (ArrayList<SimpleMember>) simpleMembers;
	}
	public void refresh() {
		simpleMembers = (ArrayList<SimpleMember>) SimpleMemberdelegate.doFindAllSimpleMember();
				
    }



}