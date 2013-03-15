package Core;

import Core.ResponseHandler.ResponseType;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;

public class DialogueNode extends DefaultMutableTreeNode implements Comparable, Serializable {

	private static final long serialVersionUID = 2241503899723137729L;
	public static int count = 1;
	public transient MessageHandler msgHandler;
	public int id;
	public int parentId;
	public String playerName;
	public String text;
	public ResponseType type;
	public ArrayList<DialogueNode> childrenNodes;
	public ImageIcon avatar;
	public String avatarLocation;
	public boolean isMostRecent;

	public DialogueNode(int parentId, String playerName, String text, ResponseType type, MessageHandler msgHandler) {
		this(count, parentId, playerName, text, type, msgHandler);
	}

	public DialogueNode(int id, int parentId, String playerName, String text, ResponseType type, MessageHandler msgHandler) {
		this.msgHandler = msgHandler;
		if (id > count) {
			count = id;
		}
		this.id = id;
		this.parentId = parentId;
		this.playerName = playerName;
		this.text = text;
		this.type = type;
		this.childrenNodes = new ArrayList<>();
		this.avatar = null;
		this.isMostRecent = false;
	}

	public DialogueNode newChild(String playerName, String text, ResponseType type) {
		return new DialogueNode(this.id, playerName, text, type, this.msgHandler);
	}

	public void setIsMostRecent(boolean b) {
		this.isMostRecent = b;
	}

	public void setAvatar(String location) {
		this.avatarLocation = location;
		this.avatar = new ImageIcon(this.avatarLocation);
	}

	@Override
	public int compareTo(Object obj) {
		DialogueNode o = (DialogueNode) obj;
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", "
				+ "parentId=" + parentId + ", "
				+ "playerName=" + playerName + ", "
				+ "text=" + text + ", "
				+ "type=" + type + "]";

	}
}
