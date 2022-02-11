/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.gov.allamkincstar.oistvan.valutavalto;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Valutaárfolyamok objektum:
 *  valutak:az összes felolvasott valutanév;árfolyam
 *  valutanevek:csak a nevek listája
 * 
 * @author Oláh István
 */
public class Valutak {

    private ArrayList<Valuta> valutak = new ArrayList<>();
    private ArrayList<String> valutanevek = new ArrayList<>();

    public Valutak(XmlDocument xmldoc) {

        try {

            NodeList nlist = xmldoc.getDoc().getElementsByTagName("Cube");

            for (int i = 0; i < nlist.getLength(); i++) {

                if (nlist.item(i).getAttributes().getLength() == 2) {
                    // System.out.println(nlist.item(i).getAttributes().getNamedItem("currency").getNodeValue());                
                    // System.out.println(nlist.item(i).getAttributes().getNamedItem("rate").getNodeValue());                

                    this.valutak.add(new Valuta(
                            nlist.item(i).getAttributes().getNamedItem("currency").getNodeValue(),
                            Float.parseFloat(nlist.item(i).getAttributes().getNamedItem("rate").getNodeValue())));
                    this.valutanevek.add(nlist.item(i).getAttributes().getNamedItem("currency").getNodeValue());

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getValutanevek() {
        return valutanevek;
    }

    public ArrayList<Valuta> getValutak() {
        return valutak;
    }

}
