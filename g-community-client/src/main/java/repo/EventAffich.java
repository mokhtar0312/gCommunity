package repo;

import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.EventServiceDelegate;
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

	List<Event> List;
	List<SimpleMember> List1;

	public EventAffich(ActiveMember admin) throws NamingException {
		List = EventServiceDelegate.findAllEvents();
		// System.out.println(List.toString());
		for (Event e : List) {
			List1 = e.getSimpleMember();
			System.out.println(admin.toString());
			System.out.println(List1.toString());

			for (SimpleMember S : List1) {
				if (S.equals(admin)) {
					List.remove(e.getId());
				}
			}
			// if(List1.contains(admin))
			// {
			// System.out.println("karrazt");
			//
			// List.remove(e.getId());
			// // System.out.println(List.toString());
			//
			//
			// }
		}
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
