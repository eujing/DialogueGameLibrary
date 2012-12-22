package Core;

import java.util.EnumMap;
import java.util.Map;

public class ResponseHandler {
	public enum ResponseType {SEED, QUESTION, INFORMATION, CHALLENGE, AGREEMENT, SUPPORT};
	
	private Map <ResponseType, ResponseType[]> map = new EnumMap <> (ResponseType.class);
	
	public ResponseHandler () {
		ResponseType[] allResponse = new ResponseType[] {ResponseType.QUESTION, ResponseType.INFORMATION, ResponseType.CHALLENGE, ResponseType.AGREEMENT, ResponseType.SUPPORT};
		/*map.put(ResponseType.SEED, new ResponseType[] {ResponseType.QUESTION});
		map.put (ResponseType.QUESTION, new ResponseType[] {ResponseType.INFORMATION, ResponseType.CHALLENGE});
		map.put (ResponseType.INFORMATION, new ResponseType[] {ResponseType.QUESTION, ResponseType.CHALLENGE, ResponseType.AGREEMENT, ResponseType.SUPPORT});
		map.put (ResponseType.CHALLENGE, new ResponseType[] {ResponseType.QUESTION, ResponseType.AGREEMENT, ResponseType.SUPPORT});
		map.put (ResponseType.AGREEMENT, new ResponseType[] {ResponseType.AGREEMENT});
		map.put (ResponseType.SUPPORT, new ResponseType[] {ResponseType.QUESTION, ResponseType.CHALLENGE, ResponseType.AGREEMENT});*/
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
