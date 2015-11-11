package repo;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.naming.event.EventDirContext;
import javax.swing.table.AbstractTableModel;

import delegate.EventServiceDelegate;
import entities.Event;

public class AccountBySearsh extends AbstractTableModel {
	String[] col_names = { "ID", "Description", "Fee", "Name"};
	Event g = new Event();
String name;
	ArrayList<Event> events = (ArrayList<Event>) EventServiceDelegate.DoFindbyTyped(name);
	

	public void AccountBySearsh() throws NamingException {
		
	
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");

	}
	public AccountBySearsh(String search) throws NamingException {
		this.name=search;
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");

	}

	@Override
	public int getRowCount() {

		return events.size();
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
			return events.get(rowIndex).getId();
		case 1:
			return events.get(rowIndex).getDescription();
		case 2:
			return events.get(rowIndex).getFee();
		case 3:
			return events.get(rowIndex).getName();
//		case 3:
//			return events.get(rowIndex).isBan();

		default:
			return null;
		}

	}
	
	public void refresh() {
		events = (ArrayList<Event>) EventServiceDelegate
				.DoFindbyTyped(name);
    }
}
