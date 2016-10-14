/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VyrobniProces;

/**
 *
 * @author George
 */
public interface IProcesManu extends IProces{

    void generovaniCasuVykonuProcesu();

    void generovaniPoctuLidskychJednotek();

    int getCasVykonuProcesu();

    String getIdObsluzneJednotky();

    int getPocetLidskychJednotek();

    void setCasVykonuProcesu(int casVykonuProcesu);

    void setIdObsluzneJednotky(String idObsluzneJednotky);

    void setPocetLidskychJednotek(int pocetLidskychJednotek);

    String toString();
    
}
