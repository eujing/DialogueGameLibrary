package Core;

import java.util.EnumMap;
import java.util.Map;

public class ResponseHandler {
	public enum Response {QUESTION, INFORMATION, CHALLENGE, AGREEMENT, SUPPORT};
	
	private Map <Response, Response[]> map = new EnumMap <> (Response.class);
	
	public ResponseHandler () {
		map.put (Response.QUESTION, new Response[] {Response.INFORMATION, Response.CHALLENGE});
		map.put (Response.INFORMATION, new Response[] {Response.QUESTION, Response.CHALLENGE, Response.AGREEMENT, Response.SUPPORT});
		map.put (Response.CHALLENGE, new Response[] {Response.QUESTION, Response.AGREEMENT, Response.SUPPORT});
		map.put (Response.AGREEMENT, new Response[] {Response.AGREEMENT});
		map.put (Response.SUPPORT, new Response[] {Response.QUESTION, Response.CHALLENGE, Response.AGREEMENT});
	}
	
	public Response[] getResponses (Response type) {
		return map.get (type);
	}
}
