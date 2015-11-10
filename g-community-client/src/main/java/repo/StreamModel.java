package repo;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import delegate.StreamServicesDelegate;

import entities.Streams;

public class StreamModel extends AbstractTableModel{
	String[] col_names = { "ID", "Date diffusion", "Url"};
	Streams e = new Streams();

	ArrayList<Streams> source = (ArrayList<Streams>) StreamServicesDelegate.findAllStreams();

	public void StreamModel() throws NamingException {
		
	
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");

	}

	public int getRowCount() {

		return source.size();
	}

	public int getColumnCount() {
		return col_names.length;

	}

	public String getColumnName(int i) {
		return col_names[i];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return source.get(rowIndex).getId();
		case 1:
			return source.get(rowIndex).getDate_diffusion();
		case 2:
			return source.get(rowIndex).getUrl();

//		case 3:
//			return events.get(rowIndex).isBan();

		default:
			return null;
		}

	}
	
	public void refresh() {
		source = ((ArrayList<Streams>) StreamServicesDelegate.findAllStreams());
    }
}
