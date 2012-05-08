/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import se.etsf01.aesp.algo.Attribute;
import se.etsf01.aesp.algo.Project;
import se.etsf01.aesp.algo.Rating;

/**
 *
 * @author Henrik
 */
public class ImportProject {

    public Project importProj(String path) {
        Project proj = new Project();
        try {
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            proj.setLinesOfCode(Integer.parseInt(root.getAttribute("linesOfCode")));
            proj.setIdentifier(root.getAttribute("identifier"));
            HashMap<String, Attribute> attributes = new HashMap<String, Attribute>();
            for (Attribute attr : Attribute.values()) {
                attributes.put(attr.name(), attr);
            }

            NodeList nl = root.getElementsByTagName("attribute");
            if (nl.getLength() != 15) {
                System.out.println("Not enough attributes in the prj file");
            }
            for (int i = 0; i < 15; i++) {
                String value = nl.item(i).getAttributes().getNamedItem("value").getNodeValue();

                proj.attributes().put(attributes.get(nl.item(i).getAttributes().getNamedItem("name").getNodeValue()), Rating.fromString(value));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return proj;
    }
}
