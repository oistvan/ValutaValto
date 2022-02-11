/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hu.gov.allamkincstar.oistvan.valutavalto;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Valutaváltás interaktív felület
 *
 * @author Oláh István
 */
public class ValutaStartJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ValutaJFrame
     */
    public ValutaStartJFrame() {
        initComponents();
    }

    public Valutak valutak;

    static final String[] uzenetek = {
        "A mennyiség nem szám formátumú",
        "A vásárolt valuta árfolyama nem meghatározható.",
        "A fizető valuta árfolyama nem meghatározható.",
        "A vásárolt mennyiség pozitív száma lehet."
    };

    /**
     * A program indulásakor a felület objektumainak az inicializálása
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        arfolyamValasztoButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        arfolyamFileNev = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vasarolt_devizanemCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fizeto_devizanemCombo = new javax.swing.JComboBox<>();
        arfolyamURL = new javax.swing.JTextField();
        urlValasztoButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        vasaroltMennyisegStr = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        szamolasButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fizenetoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Valutaváltó alkalmazás (Oláh István)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        arfolyamValasztoButton.setText("Árfolyam betöltés fileból");
        arfolyamValasztoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arfolyamValasztoButtonActionPerformed(evt);
            }
        });

        arfolyamFileNev.setText("...");

        jLabel2.setText("Vásárolt valuta devizaneme:");

        jLabel4.setText("Fizető valuta:");

        arfolyamURL.setText("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml?7602c992dd79b611d0c08e7a0f48b556");

        urlValasztoButton.setText("Árfolyam betöltés URL-ről");
        urlValasztoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlValasztoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vasarolt_devizanemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(fizeto_devizanemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(arfolyamValasztoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(urlValasztoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arfolyamFileNev)
                            .addComponent(arfolyamURL, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arfolyamURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urlValasztoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arfolyamValasztoButton)
                    .addComponent(arfolyamFileNev))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vasarolt_devizanemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(fizeto_devizanemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel3.setText("Vásárolt valuta mennyisége:");

        vasaroltMennyisegStr.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        vasaroltMennyisegStr.setText("0");

        szamolasButton.setText("Átvált");
        szamolasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szamolasButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Fizenetdő: ");

        fizenetoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fizenetoLabel.setForeground(new java.awt.Color(0, 102, 255));
        fizenetoLabel.setText("..");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(szamolasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(fizenetoLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vasaroltMennyisegStr, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(vasaroltMennyisegStr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(szamolasButton)
                    .addComponent(jLabel5)
                    .addComponent(fizenetoLabel))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Árfolyam-file választó nyomógomb által indított metódus, file browser
     * ablakból kiválasztható az árfolyam xml
     */
    private void arfolyamValasztoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arfolyamValasztoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            arfolyamFileNev.setText("Kiválasztott állomány :" + file.getName());
            filebolValuta(file);
        } else {
            vt.uzen("Kiválasztás megszakítva", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * A paraméterként átvett file-ból parse-olt xml dokumentum objektumot, majd
     * ebből egy Valutak objektumot pédányosít. Siker esetén a nevekkel feltölti a képernyőn lévő
     * combo boxokat.
     */
    private void filebolValuta(File file) {

        XmlDocument xmldoc = null;
        try {
            xmldoc = new XmlDocument(file.getAbsolutePath());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ValutaStartJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        valutak = new Valutak(xmldoc);
        if (valutak.getValutak().isEmpty()) {
            vt.uzen("A valutárfolyam állomány feldolgozása sikertelen.", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Valuta v : valutak.getValutak()) {
                vasarolt_devizanemCombo.addItem(v.getNev());
                fizeto_devizanemCombo.addItem(v.getNev());
            }
        }
    }//GEN-LAST:event_arfolyamValasztoButtonActionPerformed

    /**
     * Számolás nyomógomb által indított metódus, a combo-boxok kiválasztott értékeivel
     * és input mezőbe írt értékkel meghívja a valuatool.valt() metódust
     */
    private void szamolasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szamolasButtonActionPerformed

        if (valutak != null) {
            int eredmeny;
            eredmeny = Math.round(vt.valt(vasaroltMennyisegStr.getText(), vasarolt_devizanemCombo.getSelectedItem().toString(), fizeto_devizanemCombo.getSelectedItem().toString(), valutak));
            if (eredmeny > 0) {
                fizenetoLabel.setText(String.valueOf(eredmeny) + " " + fizeto_devizanemCombo.getSelectedItem().toString());
            } else {
                vt.uzen(uzenetek[-1 * eredmeny - 1], JOptionPane.ERROR_MESSAGE);
                fizenetoLabel.setText("...");
            }
        } else {
            vt.uzen("A valutaárfolyam xml még nincs betöltve.", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_szamolasButtonActionPerformed

    /**
     * Árfolyam-urls választó nyomógomb által indított metódus, az input mezőben
     * lévő url-ről letölti az árfolyam xml-t egy lokális munka file-ba.
     */
    private void urlValasztoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlValasztoButtonActionPerformed

        vt.arfolyamXmldownload(arfolyamURL.getText(), "arfolyam_tmp.xml");
        try {
            File file = new File("arfolyam_tmp.xml");
            filebolValuta(file);
        } catch (Exception e) {
            vt.uzen("A valutaárfolyam xml letöltése sikertelen", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_urlValasztoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ValutaStartJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValutaStartJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValutaStartJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValutaStartJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValutaStartJFrame().setVisible(true);
            }
        });
    }

    private ValutaTools vt = new ValutaTools();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arfolyamFileNev;
    private javax.swing.JTextField arfolyamURL;
    private javax.swing.JButton arfolyamValasztoButton;
    private javax.swing.JLabel fizenetoLabel;
    private javax.swing.JComboBox<String> fizeto_devizanemCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton szamolasButton;
    private javax.swing.JButton urlValasztoButton;
    private javax.swing.JTextField vasaroltMennyisegStr;
    private javax.swing.JComboBox<String> vasarolt_devizanemCombo;
    // End of variables declaration//GEN-END:variables
}
