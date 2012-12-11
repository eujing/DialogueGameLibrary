package Core;

import java.io.Serializable;

public class Message implements Serializable {

	public String tag;
	public String from;
	public Object data;
	
	public Message (String tag, String from, Object data) {
		this.tag = tag;
		this.from = from;
		this.data = data;
	}
	
	public static Message cast (Object obj) {
		try {
			if (obj instanceof Message) {
				return (Message) obj;
			}
		}
		catch (Exception ex) {}
		
		return null;
	}
}
