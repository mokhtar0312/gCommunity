package GuiInterfaces;

import java.awt.Color;

import com.thehowtotutorial.splashscreen.JSplash;

public class SplashS {

	public static void main(String[] args) {
		// TODO Auto-generated method stubtry{
		try{
		JSplash splash= new JSplash(SplashS.class.getResource("logg.png"), true, true, false, "V1",null,Color.RED,Color.BLUE);
		splash.splashOn();
	
		splash.setProgress(20, "Init");
		
		Thread.sleep(1000);
	
	splash.setProgress(40, "Loading");
	Thread.sleep(1000);
	splash.setProgress(60, "Applying Config");
	Thread.sleep(1000);
	splash.setProgress(80, "Starting App");
	Thread.sleep(1000);
	splash.splashOff();
	
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		

	}

}
