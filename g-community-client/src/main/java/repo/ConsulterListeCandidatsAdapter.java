package repo;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.ActiveMemberServicesDelegate;
import entities.ActiveMember;

public class ConsulterListeCandidatsAdapter extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	String[] col_names = { "name", "surname", "role" };

	java.util.List<ActiveMember> List;

	// = (ArrayList<Message>) MessageServicesDelegate
	// .findAllMessage();

	public ConsulterListeCandidatsAdapter() throws NamingException {
		List = ActiveMemberServicesDelegate.doFindAllActiveMember();

		System.out.println("aaaaaaaaaaaaaaaaaaaaa");

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
			return List.get(rowIndex).getSurname();

		case 2:
			return List.get(rowIndex).getRole();

		default:
			return null;
		}

	}

}
