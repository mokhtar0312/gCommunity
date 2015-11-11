package repo;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.naming.event.EventDirContext;
import javax.swing.table.AbstractTableModel;

import delegate.EquipmentDelegate;
import delegate.EventServiceDelegate;
import entities.Equipment;
import entities.Event;

public class EquipmentModel extends AbstractTableModel {
	String[] col_names = { "ID", "Name", "Reference", "State"};
	Equipment e = new Equipment();

	ArrayList<Equipment> equipment = (ArrayList<Equipment>) EquipmentDelegate.findAllEquipment();

	public void EquipmentModel() throws NamingException {
		
	
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");

	}

	@Override
	public int getRowCount() {

		return equipment.size();
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
			return equipment.get(rowIndex).getId();
		case 1:
			return equipment.get(rowIndex).getName();
		case 2:
			return equipment.get(rowIndex).getReference();
		case 3:
			return equipment.get(rowIndex).getState();
//		case 3:
//			return events.get(rowIndex).isBan();

		default:
			return null;
		}

	}
	
	public void refresh() {
		equipment = ((ArrayList<Equipment>) EquipmentDelegate.findAllEquipment());
    }
	
}
