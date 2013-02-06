package Core;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter {

	public static void WriteTree (File file, DialogueNode root) {
		if (root == null) {
			return;
		}

		try {
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance ().newDocumentBuilder ();

			Document doc = docBuilder.newDocument ();
			Element rootElement = doc.createElement ("dialogue");
			doc.appendChild (rootElement);

			//Root node
			RecurseWriteChild (root, rootElement, doc);

			Transformer transformer = TransformerFactory.newInstance ().newTransformer ();
			DOMSource source = new DOMSource (doc);
			StreamResult result = new StreamResult (file);

			transformer.transform (source, result);
		}
		catch (ParserConfigurationException | DOMException | TransformerException ex) {
			Logger.logException ("XmlWriter::WriteTree", ex);
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
