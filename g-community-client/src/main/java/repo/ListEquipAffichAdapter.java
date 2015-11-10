package repo;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.EquipmentDelegate;
import delegate.MessageServicesDelegate;
import entities.ActiveMember;
import entities.Equipment;
import entities.Message;

public class ListEquipAffichAdapter  extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] col_names = { "Name", "Reference","State"};
	Message g = new Message();

	List<Equipment> List ;
//	= (ArrayList<Message>) MessageServicesDelegate
	//		.findAllMessage();

    public ListEquipAffichAdapter(Equipment equipement ) throws NamingException {
		List=EquipmentDelegate.findAllEquipment();
	
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
			return List.get(rowIndex).getReference();

		case 3:
			return List.get(rowIndex).getState();

		default:
			return null;
		}

	}
}
	