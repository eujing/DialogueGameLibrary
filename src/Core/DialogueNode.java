package Core;

import Core.ResponseHandler.Response;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class DialogueNode extends DefaultMutableTreeNode implements Comparable, Serializable {
	private static final long serialVersionUID = 2241503899723137729L;
	private static int count = 0;
	public transient MessageHandler msgHandler;
	public int id;
	public int parentId;
	public String playerName;
	public String text;
	public Response type;
	public ArrayList<DialogueNode> childrenNodes;
	
	public DialogueNode (int parentId, String playerName, String text, Response type, MessageHandler msgHandler) {
		this (++count, parentId, playerName, text, type, msgHandler);
	}
	
	public DialogueNode (int id, int parentId, String playerName, String text, Response type, MessageHandler msgHandler) {
		this.msgHandler = msgHandler;
		if (id > count) {
			count = id;
		}
		this.id = id;
		this.parentId = parentId;
		this.playerName = playerName;
		this.text = text;
		this.type = type;
		this.childrenNodes = new ArrayList <> ();
	}
	
	public GamePanel createGamePanel () {
		return new GamePanel (this);
	}
	
	public DialogueNode newChild (String playerName, String text, Response type) {
		return new DialogueNode (this.id, playerName, text, type, this.msgHandler);
	}
	
	@Override
	public int compareTo (Object obj) {
		DialogueNode o = (DialogueNode) obj;
		return this.id - o.id;
	}
}

