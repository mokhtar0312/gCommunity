package repo;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.ActiveMemberServicesDelegate;
import delegate.EventServiceDelegate;
import delegate.MessageServicesDelegate;
import entities.ActiveMember;
import entities.Event;
import entities.Message;

public class AfficherEventAdapter  extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] col_names = { "name", "description","date","fee","numberOfParticipants","lieu"};
	Event event = new Event();
	
	List<Event> List ;


    public AfficherEventAdapter(ActiveMember admin ) throws NamingException {

    		List=admin.getEvents();

	
		System.out.println(List.toString());

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

		case 2:
			return List.get(rowIndex).getDate();
		case 3:
			return List.get(rowIndex).getFee();
		case 4:
			return List.get(rowIndex).getNumberOfParticipants();
		case 5:
			return List.get(rowIndex).getLieu();
		default:
			return null;
		}

	}
}
	