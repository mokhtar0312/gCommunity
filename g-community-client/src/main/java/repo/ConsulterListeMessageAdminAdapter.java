package repo;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.MessageServicesDelegate;
import entities.ActiveMember;
import entities.Message;

public class ConsulterListeMessageAdminAdapter  extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] col_names = { "content", "subject","date"};
	Message g = new Message();

	List<Message> List ;
//	= (ArrayList<Message>) MessageServicesDelegate
	//		.findAllMessage();

    public ConsulterListeMessageAdminAdapter(ActiveMember admin ) throws NamingException {
    	int i =admin.getId();
		List=MessageServicesDelegate.readAllMessageByIDActiveMember(i);
	
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
			return List.get(rowIndex).getContent();
		case 1:
			return List.get(rowIndex).getSubject();

		case 3:
			return List.get(rowIndex).getDate();

		default:
			return null;
		}

	}
}
	