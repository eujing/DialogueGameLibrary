package Core;

import java.util.EnumMap;

public class MessageHandler {

	private final Object receivelock = new Object ();
	private final Object sendLock = new Object ();
	private EnumMap <MessageTag, MessageListener> recResponse;
	private EnumMap <MessageTag, MessageListener> sendResponse;

	public MessageHandler () {
		this.recResponse = new EnumMap <> (MessageTag.class);
		this.sendResponse = new EnumMap <> (MessageTag.class);
	}

	public void submitReceivedMessage (Message msg) {
		synchronized (receivelock) {
			Logger.logDebug("[Message received]\t[" + msg.tag.toString() + "]\tfrom " + msg.from);
			MessageListener msgListener = recResponse.get (msg.tag);
			if (msgListener != null) {
				msgListener.messageReceived(msg);
			}
			else {
				Logger.logDebug("[RECEIVE] Could not find a mapped response for " + msg.tag.toString());
			}
		}
	}
	
	public void submitSendingMessage (Message msg) {
		synchronized (sendLock) {
			MessageListener msgListener = sendResponse.get (msg.tag);
			if (msgListener != null) {
				msgListener.messageReceived(msg);
			}
			else {
				Logger.logDebug("[SEND] Could not find a mapped response to " + msg.tag.toString());
			}
		}
	}

	public void registerReceiveMessageListener (MessageTag msg, MessageListener msgListener) {
		synchronized (receivelock) {
			recResponse.put (msg, msgListener);
		}
	}
	
	public void registerSendingMessageListener (MessageTag msg, MessageListener msgListener) {
		synchronized (sendLock) {
			sendResponse.put (msg, msgListener);
		}
	}
}
