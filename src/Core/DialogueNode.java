package Core;

import Core.ResponseHandler.Response;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class DialogueNode extends DefaultMutableTreeNode implements Comparable {
	private static int count = 0;
	public int id;
	public int parentId;
	public String playerName;
	public String text;
	public Response type;
	public ArrayList<DialogueNode> childrenNodes;
	public GamePanel gPanel;
	
	public DialogueNode (int parentId, String playerName, String text, Response type) {
		this (++count, parentId, playerName, text, type);
	}
	
	public DialogueNode (int id, int parentId, String playerName, String text, Response type) {
		if (id > count) {
			count = id;
		}
		this.id = id;
		this.parentId = parentId;
		this.playerName = playerName;
		this.text = text;
		this.type = type;
		this.childrenNodes = new ArrayList <> ();
		this.gPanel = new GamePanel (this);
	}
	
	@Override
	public int compareTo (Object obj) {
		DialogueNode o = (DialogueNode) obj;
		return this.id - o.id;
	}
}

