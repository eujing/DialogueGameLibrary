package Core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
}

