package Core;

import java.util.Calendar;

public class Logger {

	private static final boolean DEBUG = true;
	
	public static void log (String msg) {
		System.out.println ("[" + Calendar.getInstance ().getTime ().toString () + "]\t" + msg);
	}

	public static void logDebug (String msg) {
		if (DEBUG) {
			log ("[DEBUG]\t" + msg);
		}
	}
}
