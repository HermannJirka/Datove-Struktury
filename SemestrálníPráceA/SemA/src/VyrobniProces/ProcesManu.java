/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VyrobniProces;

import java.io.Serializable;

/**
 *
 * @author George
 */
public class ProcesManu implements Serializable,IProcesManu{
   private String idObsluzneJednotky;
   private int pocetLidskychJednotek;
   private int casVykonuProcesu;
   private static int cisloObluzneJednotky = 0;

    public ProcesManu(String idObsluzneJednotky, int pocetLidskychJednotek, int casVykonuProcesu) {
        this.idObsluzneJednotky = idObsluzneJednotky;
        this.pocetLidskychJednotek = pocetLidskychJednotek;
        this.casVykonuProcesu = casVykonuProcesu;
    }

    public ProcesManu() {
        cisloObluzneJednotky++;
        setIdObsluzneJednotky("O"+cisloObluzneJednotky);
        generovaniCasuVykonuProcesu();
        generovaniPoctuLidskychJednotek();
    }

  
    public String getIdObsluzneJednotky() {
        return idObsluzneJednotky;
    }

   
    public void setIdObsluzneJednotky(String idObsluzneJednotky) {
        this.idObsluzneJednotky = idObsluzneJednotky;
    }

   
    public int getPocetLidskychJednotek() {
        return pocetLidskychJednotek;
    }

    
    public void setPocetLidskychJednotek(int pocetLidskychJednotek) {
        this.pocetLidskychJednotek = pocetLidskychJednotek;
    }

   
    public int getCasVykonuProcesu() {
        return casVykonuProcesu;
    }

    
    public void setCasVykonuProcesu(int casVykonuProcesu) {
        this.casVykonuProcesu = casVykonuProcesu;
    }

   
    @Override
    public String toString() {
        return "Manulni: " + "id=" + idObsluzneJednotky + ", pocetLidi=" + pocetLidskychJednotek + ", dobaTrvani=" + casVykonuProcesu;
    }
    
   public void generovaniCasuVykonuProcesu(){
   casVykonuProcesu = (int) Math.round(Math.random()* 20 + 1);
   }
    
   public void generovaniPoctuLidskychJednotek(){
   pocetLidskychJednotek = (int) Math.round(Math.random()*10 + 1);
   }
}
