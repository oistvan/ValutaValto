/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.gov.allamkincstar.oistvan.valutavalto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * A valutaváltással kapcsolatos technikai metódusok
 *
 * @author Oláh István
 */
public class ValutaTools {

    /**
     * Grafikus üzenetek egységes megjeleítése
     */
    public void uzen(String uzenet, int tipus) {
        JOptionPane.showMessageDialog(new JFrame(), uzenet, "Valutaváltó üzenet:", tipus);
    }

    /**
     * A paraméterként átvett devizanemekhez tartozó árfolyamokból és a vásárolt mennyiségből
     * kiszámolja a vásárló valuta mennyiségét és visszaadja.
     */
    public float valt(String vasarolt_mennyiseg_str, String vasarolt_valuta_str, String fizeto_valuta_str, Valutak v) {

        int vasarolt_mennyiseg;
        float vasarolt_arfolyam = 0f;
        float fizeto_arfolyam = 0f;

        try {
            vasarolt_mennyiseg = Integer.parseInt(vasarolt_mennyiseg_str);

        } catch (NumberFormatException ex) { // handle your exception
            return -1f;
        }

        for (Valuta valuta : v.getValutak()) {
            if (valuta.getNev().equals(vasarolt_valuta_str)) {
                vasarolt_arfolyam = valuta.getArfolyam();
            }

            if (valuta.getNev().equals(fizeto_valuta_str)) {
                fizeto_arfolyam = valuta.getArfolyam();
            }

        }

        if (vasarolt_arfolyam <= 0) {
            return -2f;
        }

        if (fizeto_arfolyam <= 0) {
            return -3f;
        }

        if (vasarolt_mennyiseg <= 0) {
            return -4f;
        }

        return vasarolt_mennyiseg * fizeto_arfolyam / vasarolt_arfolyam;

    }

    /**
     * Napi árfolyam xml letöltésekor előforduló ssl hiba kezelése
     */
    private void CertificatValidator() {

        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }
    }

    /**
     * Napi árfolyam xml letöltése a paraméterként kapott url-ről és lementése a
     * paraméterként kapott lokális file-be.
     */
    public void arfolyamXmldownload(String urlStr, String filename) {
        URL url;
        CertificatValidator();
        try {
            url = new URL(urlStr);
            try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream())) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
                    FileChannel fileChannel = fileOutputStream.getChannel();
                    fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                }
            }
        } catch (MalformedURLException ex) {
            //ex.printStackTrace();
        } catch (IOException ex) {
            //ex.printStackTrace();
        }

    }


    
}

