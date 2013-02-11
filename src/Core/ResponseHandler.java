package Core;

import java.util.EnumMap;
import java.util.Map;

public class ResponseHandler {
	public enum ResponseType {
		SEED ("Seeds"), 
		QUESTION ("Questions"), 
		INFORMATION ("Informs"), 
		CHALLENGE ("Challenges"), 
		AGREEMENT ("Agrees with"), 
		SUPPORT ("Supports");
		
		private String verb;
		private ResponseType (String verb) {
			this.verb = verb;
		}
		
		public String getVerb () {
			return this.verb;
		}
	
	};
	
	private static ResponseType[] allResponse = new ResponseType[] {ResponseType.QUESTION, ResponseType.INFORMATION, ResponseType.CHALLENGE, ResponseType.AGREEMENT, ResponseType.SUPPORT};
	private Map <ResponseType, ResponseType[]> map = new EnumMap <> (ResponseType.class);
	
	public ResponseHandler () {
		map.put(ResponseType.SEED, allResponse);
		map.put (ResponseType.QUESTION, allResponse);
		map.put (ResponseType.INFORMATION, allResponse);
		map.put (ResponseType.CHALLENGE, allResponse);
		map.put (ResponseType.AGREEMENT, allResponse);
		map.put (ResponseType.SUPPORT, allResponse);
	}
	
	public ResponseType[] getResponses (ResponseType type) {
		return map.get (type);
	}
}
