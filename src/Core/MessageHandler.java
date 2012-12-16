package Core;

import java.util.HashMap;

public class MessageHandler {

	private final Object lock = new Object ();
	private HashMap<String, MessageListener> response;

	public MessageHandler () {
		this.response = new HashMap<> ();
	}

	public void submitMessage (Message msg) {
		synchronized (lock) {
			response.get (msg.tag).messageReceived (msg);
		}
	}

	public void registerMessageListener (String msg, MessageListener msgListener) {
		synchronized (lock) {
			response.put (msg, msgListener);
		}
	}
}
