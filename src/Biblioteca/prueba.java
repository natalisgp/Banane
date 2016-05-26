import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jvnet.substance.SubstanceLookAndFeel;


public class MainWorker{ 
	
	static Logger logger = Logger.getLogger(MainWorker.class.getName());

	public static void main(String[] args){
		
		PropertyConfigurator.configure("main.properties");
	
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteGlassSkin");
	
		Access window = new Access( );
		window.setVisible( true );
	}
}




