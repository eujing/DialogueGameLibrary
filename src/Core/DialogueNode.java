package Core;



import Core.ResponseHandler.Response;
import java.util.ArrayList;

public class DialogueNode {
	private static int count = 0;
	public int id;
	public int parentId;
	public String playerName;
	public String text;
	public Response type;
	public ArrayList<DialogueNode> children;
	
	public DialogueNode (int parentId, String playerName, String text, Response type) {
		this (++count, parentId, playerName, text, type);
	}
	
	public DialogueNode (int id, int parentId, String playerName, String text, Response type) {
		if (id > count) {
			count = id;
		}
		this.id = id;
		this.parentId = id;
		this.playerName = playerName;
		this.text = text;
		this.type = type;
		this.children = new ArrayList <> ();
	}
}

