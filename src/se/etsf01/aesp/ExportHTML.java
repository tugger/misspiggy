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
public class ExportHTML {
    private EstimationResult result;
    private Project proj;
    private String path;
    
    /**
     * Construct the HTML generator
     * @param path the HTML path
     * @param estimated the project that was estimated
     * @param result the estimation result to build the report from
     */
    public ExportHTML(String path, Project proj, EstimationResult result)
    {
        this.proj = proj;
        this.path = path;
        this.result = result;
    }
    
    private Element createElement(Document doc, String name, String content) {
        Element elem = doc.createElement(name);
        elem.appendChild(doc.createTextNode(content));
        return elem;
    }
    
    /**
     * Build the XML document that is used as a basis for the report generation
     * @return Document
     * @throws ParserConfigurationException 
     */
    private Document buildReport() throws ParserConfigurationException {
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element root = doc.createElement("estimation");
        doc.appendChild(root);

        Element project = doc.createElement("project");
        Element effort = doc.createElement("effort");
        
        if(result.getEstimatedEffort() == null)
        {
            effort.appendChild(createElement(doc, "pd", "N/A"));
            effort.appendChild(createElement(doc, "pm", "N/A"));
            effort.appendChild(createElement(doc, "py", "N/A"));
            effort.appendChild(createElement(doc, "notes", "Not enough data to make an estimate."));
        }
        else
        {
            effort.appendChild(createElement(doc, "ph", String.valueOf(Math.round(result.getEstimatedEffort().toPersonHours() * 100.0) / 100.0)));
            effort.appendChild(createElement(doc, "pd", String.valueOf(Math.round(result.getEstimatedEffort().toPersonDays() * 100.0) / 100.0)));
            effort.appendChild(createElement(doc, "pm", String.valueOf(Math.round(result.getEstimatedEffort().toPersonMonths() * 100.0) / 100.0)));
            effort.appendChild(createElement(doc, "py", String.valueOf(Math.round(result.getEstimatedEffort().toPersonYear() * 100.0) / 100.0)));
            effort.appendChild(createElement(doc, "notes", result.getMessage()));
        }
        
        project.appendChild(effort);
        
        for(Map.Entry<Attribute,Rating> charec : proj.attributes().entrySet())
        {
            Element charachteristic = doc.createElement("characteristic");
            charachteristic.setAttribute("name", charec.getKey().name() + " (" + charec.getKey().getDescription() + ")");
            charachteristic.setAttribute("value", charec.getValue().name());
            project.appendChild(charachteristic);
        }
        
        project.appendChild(createElement(doc, "size", String.valueOf(proj.getLinesOfCode() / 1000.0)));
        
        root.appendChild(project);
        
        Element similar = doc.createElement("similar");
        Element characteristics = doc.createElement("characteristics");
        
        for(Attribute attr : Attribute.values()) {
            Element item = doc.createElement("item");
            item.setAttribute("name", attr.name());
            characteristics.appendChild(item);
        }
        
        similar.appendChild(characteristics);
        
        int i = 1;
        for(Project sproj : result.getAdaptiationSource())
        {
            Element simproject = doc.createElement("project");
            simproject.setAttribute("number", String.valueOf(i));
            simproject.setAttribute("similarity", String.valueOf(Math.round(sproj.getSimilarity() * 1000.0)/10.0));
            simproject.setAttribute("size", String.valueOf(sproj.getLinesOfCode() / 1000.0));
            simproject.setAttribute("effort", String.valueOf(Math.round(sproj.getActualEffort().toPersonMonths() * 100.0) / 100.0));
            
            Attribute[] attrlist = Attribute.values();
            for(int j = 0; j < attrlist.length; j++)
            {
                Element simchar = doc.createElement("characteristic");
                simchar.setAttribute("value", sproj.attributes().get(attrlist[j]).name());
                simproject.appendChild(simchar);
            }
            
            i++;
            
            similar.appendChild(simproject);
        }
        
        root.appendChild(similar);
        
        return doc;
    }
    
    /**
     * Export to HTML
     * @return true if successfull, false if it failed.
     */
    public boolean export() {
        try {
            InputStream is = this.getClass().getResourceAsStream("report.xsl");
            if(is == null) {
                System.out.println("ERROR!");
                return false;
            }
            else {
                Source xmlSource = new DOMSource(buildReport());
                Source xsltSource = new StreamSource(is);
                
                TransformerFactory transFact = TransformerFactory.newInstance();
                Transformer trans = transFact.newTransformer(xsltSource);
                
                trans.transform(xmlSource, new StreamResult(new File(path)));
                return true;
            }
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
