package repo;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.swing.table.AbstractTableModel;

import delegate.ActiveMemberServicesDelegate;
import delegate.SimpleMemberdelegate;
import services.interfaces.SimpleMemberServicesRemote;
import entities.ActiveMember;
import entities.SimpleMember;


public class AccountListed extends AbstractTableModel {
	private final String[] titels = {"ID", "email", "name", "Approved" };
	ArrayList<ActiveMember> simpleMembers= (ArrayList<ActiveMember>)ActiveMemberServicesDelegate.doFindAllActiveMember();

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
			return simpleMembers.get(rowIndex).getEmail();

		case 2:
			// Prenom
			return simpleMembers.get(rowIndex).getName();
		case 3:
			// Password
			return simpleMembers.get(rowIndex).getApproved();
		
		
		default:
			throw new IllegalArgumentException();
		}
	}


	public List<ActiveMember> getSimpleMembers() {
		return simpleMembers;
	}

	public void setSimpleMembers(List<ActiveMember> simpleMembers) {
		this.simpleMembers = (ArrayList<ActiveMember>) simpleMembers;
	}
	public void refresh() {
		simpleMembers = (ArrayList<ActiveMember>) ActiveMemberServicesDelegate.doFindAllActiveMember();
				
    }



}