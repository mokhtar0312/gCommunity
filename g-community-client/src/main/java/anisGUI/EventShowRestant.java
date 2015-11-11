package anisGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import delegate.ActiveMemberServicesDelegate;
import delegate.AuthentificationDelegate;
import delegate.EventServiceDelegate;
import delegate.MailServicesDelegate;
import delegate.SimpleMemberdelegate;
import entities.ActiveMember;
import entities.Event;
import entities.SimpleMember;

import javax.swing.JScrollPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.hibernate.event.spi.MergeEvent;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.w3c.dom.Document;

import repo.ConsulterListeMessageAdminAdapter;
import repo.EventAffich;

public class EventShowRestant extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable accountingTable;
    static SimpleMember admin = AuthentificationDelegate.doGetConectedPerson();
    int row ;
    String nomevent;
    public static String[] getLatLongPositions(String address) throws Exception
    {
      int responseCode = 0;
      String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
      System.out.println("URL : "+api);
      URL url = new URL(api);
      HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
      httpConnection.connect();
      responseCode = httpConnection.getResponseCode();
      if(responseCode == 200)
      {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
        Document document = builder.parse(httpConnection.getInputStream());
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("/GeocodeResponse/status");
        String status = (String)expr.evaluate(document, XPathConstants.STRING);
        if(status.equals("OK"))
        {
           expr = xpath.compile("//geometry/location/lat");
           String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
           expr = xpath.compile("//geometry/location/lng");
           String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
           return new String[] {latitude, longitude};
        }
        else
        {
           throw new Exception("Error from the API - response status: "+status);
        }
      }
      return null;
    }

	/**
	 * Create the panel.
	 * @throws NamingException 
	 */
	

   
    
	public EventShowRestant(ActiveMember admin) throws NamingException {
		
		this.admin=admin;

		setLayout(null);
		try {
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 110, 572, 119);
			add(scrollPane);
			accountingTable = new JTable();
			scrollPane.setViewportView(accountingTable);
			accountingTable.setBackground(Color.WHITE);
			accountingTable.setModel(new EventAffich((ActiveMember) admin) );
			
			JButton btnSubscribe = new JButton("subscribe");
			btnSubscribe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					row = accountingTable.getSelectedRow();
					nomevent = accountingTable.getModel().getValueAt(row, 0).toString();
					
					
					System.out.println(nomevent);
					
					Event event = EventServiceDelegate.DoFindEventByName(nomevent);
					SimpleMemberdelegate.DoaffectEventToSimpleMember(admin, event);

					try {
						MailServicesDelegate.doMail("inscription avec succes", "vous etes inscrit a l'event  "+event.getName(), admin.getEmail());
						JOptionPane.showMessageDialog(null, "Mail Send SucceSfully!!", "Good :D", JOptionPane.OK_CANCEL_OPTION);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error!!", "X", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}

					
				}
			});
			btnSubscribe.setBounds(489, 287, 89, 23);
			add(btnSubscribe);
			
			JButton btnEventMap = new JButton("Event Map");
			btnEventMap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					final JMapViewer map = new JMapViewer();
//					Map map = new Map();
					 int row = accountingTable.getSelectedRow();
						System.out.println("aaaa" + row);
						String adress = accountingTable.getModel().getValueAt(row, 5).toString();
						System.out.println("aaa" + adress + row);
						try {
							String[] longlat =getLatLongPositions( adress);
							float longitude = Float.parseFloat(longlat [0]);
							float latitude = Float.parseFloat(longlat [1]);
							 map.addMapMarker(new MapMarkerDot(longitude,latitude));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        //map.setLocation(36.899996, 10.189235);
				       
	//			        map.addMapMarker(new MapMarkerDot(36.708665, 10.373218));
				        map.setDisplayToFitMapMarkers();
				        map.setZoom(10);
				        JFrame frame = new JFrame();
				        frame.getContentPane().add(map);
				        frame.setVisible(true);
				        frame.setSize(600, 520);
				}
			});
			btnEventMap.setBounds(79, 287, 101, 23);
			add(btnEventMap);

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
