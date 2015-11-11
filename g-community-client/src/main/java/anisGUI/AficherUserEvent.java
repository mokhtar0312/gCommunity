package anisGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.w3c.dom.Document;

import GuiInterfaces.AddTournament;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

import repo.AfficherEventAdapter;
import repo.StatEvent;
import repo.StatVote;
import delegate.ActiveMemberServicesDelegate;
import delegate.AuthentificationDelegate;
import delegate.EventServiceDelegate;
import entities.ActiveMember;
import entities.Event;

public class AficherUserEvent extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable accountingTable;
    static ActiveMember admin = AuthentificationDelegate.doGetConectedPerson();
    
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
	

    
	public AficherUserEvent(ActiveMember admin) throws NamingException {
		
		this.admin=admin;

		setLayout(null);
		try {
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 101, 639, 119);
			add(scrollPane);
			accountingTable = new JTable();
			scrollPane.setViewportView(accountingTable);
			accountingTable.setBackground(Color.WHITE);
			accountingTable.setModel(new AfficherEventAdapter((ActiveMember) admin) );
			
			JButton btnSub = new JButton("Subscribe to new event");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
//					AfficherEventRestant window;
//					try {	
//						window = new AfficherEventRestant();
//						window.frameaffich.setVisible(true);
//					} catch (NamingException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					try {
						new AfficherEventRestant().frameaffich.setVisible(true);
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

								}
			});
			btnSub.setBounds(435, 287, 190, 23);
			add(btnSub);
			
			JButton btnNewButton = new JButton("Event Map");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					final Geocoder geocoder = new Geocoder();
//					GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").getGeocoderRequest();
//					try {
//						GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
				
					
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
			btnNewButton.setBounds(79, 287, 109, 23);
			add(btnNewButton);
			
			JButton btnParticipationPourcentage = new JButton("Participation Pourcentage ");
			btnParticipationPourcentage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 int row = accountingTable.getSelectedRow();
					String eventname = accountingTable.getModel().getValueAt(row, 0).toString();
					System.out.println(eventname);
				Event	event = EventServiceDelegate.DoFindEventByName(eventname);

					StatEvent pchart = new StatEvent(event);
					pchart.setSize(600, 500);
					pchart.setVisible(true);

				}
			});
			btnParticipationPourcentage.setBounds(210, 287, 197, 23);
			add(btnParticipationPourcentage);

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
}
