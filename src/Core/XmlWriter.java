package Core;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter {

	public static void WriteTree (String fileName, DialogueNode root) {
		try {
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance ().newDocumentBuilder ();
			
			Document doc = docBuilder.newDocument ();
			Element rootElement = doc.createElement ("dialogue");
			doc.appendChild (rootElement);
			
			//Root node
			RecurseWriteChild (root, rootElement, doc);
			
			Transformer transformer = TransformerFactory.newInstance ().newTransformer ();
			DOMSource source = new DOMSource (doc);
			StreamResult result = new StreamResult (new File (fileName));
			//StreamResult result = new StreamResult (System.out);
			
			transformer.transform (source, result);
		}
		catch (Exception ex) {
			System.out.println (ex.getMessage ());
		}
	}
	
	private static void RecurseWriteChild (DialogueNode node, Element eParent, Document doc) {
		Element eNode = doc.createElement ("node");
		eParent.appendChild (eNode);
		
		//id
		Element eId = doc.createElement ("id");
		eId.appendChild (doc.createTextNode ("" + node.id));
		eNode.appendChild (eId);
		
		//name
		Element eName = doc.createElement ("name");
		eName.appendChild (doc.createTextNode (node.playerName));
		eNode.appendChild (eName);
		
		//text
		Element eText = doc.createElement ("text");
		eText.appendChild (doc.createTextNode (node.text));
		eNode.appendChild (eText);
		
		//response
		Element eResponse = doc.createElement ("type");
		eResponse.appendChild (doc.createTextNode (node.type.toString ()));
		eNode.appendChild (eResponse);
		
		if (node.childrenNodes != null) {
			for (DialogueNode child : node.childrenNodes) {
				RecurseWriteChild (child, eNode, doc);
			}
		}
	}
}
