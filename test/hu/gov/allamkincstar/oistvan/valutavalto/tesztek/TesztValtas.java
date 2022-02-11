/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.gov.allamkincstar.oistvan.valutavalto.tesztek;

import hu.gov.allamkincstar.oistvan.valutavalto.ValutaStartJFrame;
import hu.gov.allamkincstar.oistvan.valutavalto.ValutaTools;
import hu.gov.allamkincstar.oistvan.valutavalto.Valutak;
import hu.gov.allamkincstar.oistvan.valutavalto.XmlDocument;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
     * Teszteléshez      
     * test1: valutak méret tesztelése
     * test2: hibásan megadott vásárolt devizanem tesztelése
     * test3: hibásan megadott fizető devizanem tesztelése
     * test4: hibásan megadott vásárolt összeg tesztelése
     * test5: hibátlanul megadott paraméterekre adott eredmény tesztelése
     * 
     * @throws javax.xml.transform.TransformerConfigurationException
     * author Oláh István
     */


public class TesztValtas {

    public Valutak valutak;
    ValutaStartJFrame vs = new ValutaStartJFrame();

    /**
     * Példányosít és inicializál egy valutak objektumot
     * 2 db konstans xml node-al, ezzel folynak a tesztek.
     */
    public void testInit() throws TransformerConfigurationException, TransformerException {

        XmlDocument xmldoc = null;

        try {
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("Cube");
            doc.appendChild(rootElement);

            // supercars element
            Element cube1 = doc.createElement("Cube");
            Attr attr1 = doc.createAttribute("currency");
            attr1.setValue("USD");
            Attr attr2 = doc.createAttribute("rate");
            attr2.setValue("1.1138");
            cube1.setAttributeNode(attr1);
            cube1.setAttributeNode(attr2);
            rootElement.appendChild(cube1);
            
            Element cube2 = doc.createElement("Cube");
            Attr attr3 = doc.createAttribute("currency");
            attr3.setValue("HUF");
            Attr attr4 = doc.createAttribute("rate");
            attr4.setValue("358.42");
            cube2.setAttributeNode(attr3);
            cube2.setAttributeNode(attr4);
            rootElement.appendChild(cube2);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transf = transformerFactory.newTransformer();

            transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transf.setOutputProperty(OutputKeys.INDENT, "yes");
            transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);

            File myFile = new File("test.xml");

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(myFile);

            transf.transform(source, console);
            transf.transform(source, file);

            try {
                xmldoc = new XmlDocument("test.xml");
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(ValutaStartJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            valutak = new Valutak(xmldoc);


        } catch (ParserConfigurationException | DOMException e) {
        }
    }
    
    @Test
    public void test1() throws TransformerException {
        testInit();
        assertEquals(2, valutak.getValutak().size());

    }
   
    @Test
    public void test2() throws TransformerException {
        int eredmeny;
        ValutaTools vt = new ValutaTools();
        testInit();    
        eredmeny = Math.round(vt.valt("100", "XXX", "HUF", valutak));
        assertEquals(-2, eredmeny);
    }
    
    @Test
    public void test3() throws TransformerException {
        int eredmeny;
        ValutaTools vt = new ValutaTools();
        testInit();    
        eredmeny = Math.round(vt.valt("100", "USD", "XXX", valutak));
        assertEquals(-3, eredmeny);
    }
    
    @Test
    public void test4() throws TransformerException {
        int eredmeny;
        ValutaTools vt = new ValutaTools();
        testInit();    
        eredmeny = Math.round(vt.valt("-123", "USD", "HUF", valutak));
        assertEquals(-4, eredmeny);
    }
    
    @Test
    public void test5() throws TransformerException {
        int eredmeny;
        ValutaTools vt = new ValutaTools();
        testInit();    
        eredmeny = Math.round(vt.valt("100", "USD", "HUF", valutak));
        assertEquals(32180, eredmeny);
    }
    
    
}
