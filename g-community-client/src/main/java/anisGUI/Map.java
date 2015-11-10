
package anisGUI;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.OsmMercator;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOpenAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.MapQuestOsmTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 *
 * @author A S U S
 */
public class Map extends JPanel implements JMapViewerEventListener  {

    private JMapViewerTree treeMap = null;

    private JLabel zoomLabel=null;
    private JLabel zoomValue=null;

    private JLabel mperpLabelName=null;
    private JLabel mperpLabelValue = null;

    double lon = 0.0;
    double lat = 0.0;
 
    //MapMarkerDot mapMarkerDot = new MapMarkerDot( lat, lon);
    /**
     * Constructs the {@code Demo}.
     */
    public Map()  {
        treeMap = new JMapViewerTree("Zones");

        // Listen to the map viewer for user operations so components will
        // recieve events and update
        map().addJMVListener(this);

        // final JMapViewer map = new JMapViewer(new MemoryTileCache(),4);
        // map.setTileLoader(new OsmFileCacheTileLoader(map));
        // new DefaultMapController(map);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JPanel panelTop = new JPanel();
        JPanel helpPanel = new JPanel();

        mperpLabelName=new JLabel("Meters/Pixels: ");
        mperpLabelValue=new JLabel(String.format("%s",map().getMeterPerPixel()));

        zoomLabel=new JLabel("Zoom: ");
        zoomValue=new JLabel(String.format("%s", map().getZoom()));

        add(panel, BorderLayout.NORTH);
        add(helpPanel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout());
        panel.add(panelTop, BorderLayout.NORTH);
        JLabel helpLabel = new JLabel("Use right mouse button to move,\n "+"left double click or mouse wheel to zoom.");
        helpPanel.add(helpLabel);
        
        JComboBox tileSourceSelector = new JComboBox(new TileSource[] { new OsmTileSource.Mapnik(),
                new OsmTileSource.CycleMap(), new MapQuestOsmTileSource(), new MapQuestOpenAerialTileSource() });
        tileSourceSelector.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                map().setTileSource((TileSource) e.getItem());
            }
        });
        
     /*   JComboBox tileLoaderSelector;
        tileLoaderSelector = new JComboBox(new TileLoader[] { new OsmFileCacheTileLoader(map()),
            new OsmTileLoader(map()) });
        tileLoaderSelector.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                map().setTileLoader((TileLoader) e.getItem());
            }
        });*/
  //      map().setTileLoader((TileLoader) tileLoaderSelector.getSelectedItem());
        panelTop.add(tileSourceSelector);
//        panelTop.add(tileLoaderSelector);


        panelTop.add(zoomLabel);
        panelTop.add(zoomValue);
        panelTop.add(mperpLabelName);
        panelTop.add(mperpLabelValue);

        add(treeMap, BorderLayout.CENTER);
        map().setZoom(6);
        map().setCenter(new Point(8605, 6427));
       


        map().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int X = e.getPoint().x;
                    int Y = e.getPoint().y + 30;
                    int centreX = map().getCenter().x;
                    int centreY = map().getCenter().y;
                    int w = getSize().width;
                    int h = getSize().height;
                    lon = OsmMercator.XToLon(map().getCenter().x - w/2 + X, map().getZoom());
                    lat = OsmMercator.YToLat(map().getCenter().y - h/2 + Y, map().getZoom());
                    /*mapMarkerDot.setLat(lat);
                    mapMarkerDot.setLon(lon);
                    map().removeAllMapMarkers();
                    map().addMapMarker(mapMarkerDot);
                */
                }
            }
        });
    }
    private JMapViewer map(){
        return treeMap.getViewer();
    }
    private static Coordinate c(double lat, double lon){
        return new Coordinate(lat, lon);
    }


    private void updateZoomParameters() {
        if (mperpLabelValue!=null)
            mperpLabelValue.setText(String.format("%s",map().getMeterPerPixel()));
        if (zoomValue!=null)
            zoomValue.setText(String.format("%s", map().getZoom()));
    }

    @Override
    public void processCommand(JMVCommandEvent command) {
        if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
            updateZoomParameters();
        }
    }
   
    /*
    public Localisation getLocalisation(){
        return new Localisation(lat, lon);
    }
*/
    /*
    public void addMapMarkerDot(Localisation l) {
        mapMarkerDot.setLat(l.getLat());
        mapMarkerDot.setLon(l.getLon());
        map().addMapMarker(mapMarkerDot);
    }
*/
    /*@Override
    public void processCommand(JMVCommandEvent jmvce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    



    /**
     * Exemple : JGoogleMapEditorPan dans un JFrame
     */
        public static void main(String [] args) throws SecurityException, IOException{
             final Map map= new Map();  
           SwingUtilities.invokeLater(new Runnable() {
            public void run() {
          //
        //map.setLocation(36.899996, 10.189235);
        //map.addMapMarker(new MapMarkerDot(36.899996, 10.189235));
        //map.setDisplayToFitMapMarkers();
//map.setZoom(10);
                  JFrame frame = new JFrame();
frame.add(map);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(600, 520);
frame.setLocation(100, 100);
frame.setVisible(true);

            }
           });/*
        Map map= new Map();
       
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(map);
        frame.setSize(600, 520);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    */
}
}