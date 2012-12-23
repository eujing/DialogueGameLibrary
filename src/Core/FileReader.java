package Core;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class FileReader {
	public static ArrayList <String> getLines (InputStream stream) {
		ArrayList <String> lines = new ArrayList <> ();
		
		try {
			BufferedReader reader = new BufferedReader (new InputStreamReader (stream));
			String line;
			
			while ((line = reader.readLine ()) != null) {
				lines.add (line);
			}
		}
		catch (Exception ex) {
			Logger.logDebug (ex.getMessage ());
		}
		
		return lines;
	}
	
	public static Image getImage (URL url, int width, int height) {
		Image image = new ImageIcon (url).getImage ();
		if (width != 0 && height != 0) {
			image = image.getScaledInstance (width, height, 5);
		}
		
		return image;
	}
}

