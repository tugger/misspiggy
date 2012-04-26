/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp;

import org.w3c.dom.*;
import java.io.*;
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
    private String path;
    
    /**
     * Construct the HTML generator
     * @param path the HTML path
     * @param result the estimation result to build the report from
     */
    public ExportHTML(String path, EstimationResult result)
    {
        this.path = path;
        this.result = result;
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

        Element root = doc.createElement("root");
        doc.appendChild(root);

        //TODO: Remove this test code and enter the real stuff!
        
        for(int i = 0; i < 100; i++)
        {
            Element item = doc.createElement("example");
            item.setAttribute("key", "alpha" + String.valueOf(i));
            root.appendChild(item);
        }
        
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
