package repo;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.EventServiceDelegate;
import delegate.SimpleMemberdelegate;
import entities.ActiveMember;
import entities.Event;
import entities.SimpleMember;

public class EventAffich extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] col_names = { "name", "description", "date", "fee",
			"numberOfParticipants" };
	Event event = new Event();

	ArrayList<Event> List;



	public EventAffich(ActiveMember admin) throws NamingException {

		System.out.println(admin.getId());
		List = (ArrayList<Event>) EventServiceDelegate.DofindAllEventsRestants(admin);
	


	}
	

	@Override
	public int getRowCount() {

		return List.size();
	}

	@Override
	public int getColumnCount() {
		return col_names.length;

	}

	@Override
	public String getColumnName(int i) {
		return col_names[i];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return List.get(rowIndex).getName();
		case 1:
			return List.get(rowIndex).getDescription();

		case 3:
			return List.get(rowIndex).getDate();
		case 4:
			return List.get(rowIndex).getFee();
		case 5:
			return List.get(rowIndex).getNumberOfParticipants();

		default:
			return null;
		}

	}
}
