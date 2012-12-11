package Core;



import Core.ResponseHandler.Response;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {

	public static DialogueNode ReadTree(String fileName) {
		try {
			File file = new File(fileName);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getChildNodes();
			Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nNode;
				DialogueNode rootNode = parseDialogueNode (e);
				RecurseReadChildren (e, rootNode);
				
				return rootNode;
			}
			else {
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}

	private static void RecurseReadChildren(Element e, DialogueNode parentNode) {
		NodeList nList = e.getChildNodes();
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eTmp = (Element) nNode;
				DialogueNode dNode = parseDialogueNode (eTmp);
				parentNode.children.add(dNode);
				RecurseReadChildren(eTmp, dNode);
			}
		}
	}

	private static DialogueNode parseDialogueNode(Element e) {
		int id = Integer.parseInt(getTagValue("id", e));
		String name = getTagValue("name", e);
		String text = getTagValue("text", e);
		Response type = Response.valueOf(getTagValue("type", e));
		
		return new DialogueNode(id, name, text, type);
	}

	private static String getTagValue(String tagName, Element e) {
		NodeList nList = e.getElementsByTagName(tagName).item(0).getChildNodes();
		Node nValue = (Node) nList.item(0);
		return nValue.getNodeValue();
	}
}
