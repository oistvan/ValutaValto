/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.gov.allamkincstar.oistvan.valutavalto;

/**
 * Valuta objektom névvel, árfolyammal
 * @author Oláh István
 */
public class Valuta {
    private String Nev;
    private Float Arfolyam;

    public Valuta(String Nev, Float Arfolyam) {
        this.Nev = Nev;
        this.Arfolyam = Arfolyam;
    }


  
    
    public void setNev(String Nev) {
        this.Nev = Nev;
    }

    public void setArfolyam(Float Arfolyam) {
        this.Arfolyam = Arfolyam;
    }

    public String getNev() {
        return Nev;
    }

    public Float getArfolyam() {
        return Arfolyam;
    }
    
    
}
