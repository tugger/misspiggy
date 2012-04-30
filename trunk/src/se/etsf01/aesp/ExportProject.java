/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp;

import org.w3c.dom.*;
import java.io.*;
import java.util.Map;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import se.etsf01.aesp.algo.*;

/**
 * Generate HTML Report
 */
public class ExportProject {
    private Project project;
    private String path;
    
    /**
     * Construct the XML generator
     * @param path the XML path
     * @param result the project to build the file from
     */
    public ExportProject(String path, Project project)
    {
        this.path = path;
        this.project = project;
    }
    
    /**
     * Build the XML document
     * @return Document
     * @throws ParserConfigurationException 
     */
    private Document buildReport() throws ParserConfigurationException {
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element root = doc.createElement("project");
        root.setAttribute("identifier", project.getIdentifier());
        root.setAttribute("linesOfCode", Integer.toString(project.getLinesOfCode()));
        root.setAttribute("similarity", Double.toString(project.getSimilarity()));
        doc.appendChild(root);
        
        Map<Attribute,Rating> attributes = project.attributes();
        
        for (Attribute attr: attributes.keySet())
        {
            Element attribute = doc.createElement("attribute");
            attribute.setAttribute(attr.getDescription(), attributes.get(attr).toString());
        }

        return doc;
    }
    
    /**
     * Export to XML
     * @return true if successfull, false if it failed.
     */
    public boolean export() {
        try {
            Source xmlSource = new DOMSource(buildReport());

            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer();

            trans.transform(xmlSource, new StreamResult(new File(path)));
            return true;
        }
        catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        catch(TransformerConfigurationException tce) {
            tce.printStackTrace();
        }
        catch(TransformerException te) {
            te.printStackTrace();
        }
        return false;
    }
}
