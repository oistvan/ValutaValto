/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.gov.allamkincstar.oistvan.valutavalto;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * A paraméterként átvett file megnyitása és felolvasása dokumentumba
 * és parse-olása xml dokumentumként
 * @author Oláh István
 */
public class XmlDocument {

    private Document doc;

    public XmlDocument(String xmlFilename) throws ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            this.doc = db.parse(new File(xmlFilename));
            this.doc.getDocumentElement().normalize();
        } 
        catch (IOException e) {            
            throw new RuntimeException("A paraméterben megadott file nem elérhető.");
        }       
        catch (ParserConfigurationException | SAXException e) {            
            e.printStackTrace();            
        }
    }

    XmlDocument(Document doc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Document getDoc() {
        return doc;
    }
    
}
