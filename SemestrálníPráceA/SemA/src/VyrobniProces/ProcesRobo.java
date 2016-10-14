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
public class ProcesRobo implements Serializable, IProcesRobo{
    private static int cisloRob = 0;
    private String idRobota;
    private int casVykonuProcesu;

    public ProcesRobo() {
        cisloRob++;
        setIdRobota("RO"+cisloRob);
        generovaniCasuVykonuProcesu();
    }
    
    

    public ProcesRobo(String idRobota, int casVykonuProces) {
        this.idRobota = idRobota;
        this.casVykonuProcesu = casVykonuProces;
    }

 
    public String getIdRobota() {
        return idRobota;
    }

   public void setIdRobota(String idRobota) {
        this.idRobota = idRobota;
    }

   
    public int getCasVykonuProces() {
        return casVykonuProcesu;
    }

 
    public void setCasVykonuProces(int casVykonuProces) {
        this.casVykonuProcesu = casVykonuProces;
    }

    
    public void generovaniCasuVykonuProcesu(){
    casVykonuProcesu = (int) Math.round(Math.random()* 15 + 1);
    }
    @Override
    public String toString() {
        return "Robot: " + "id=" + idRobota + ", dobaTrvani=" + casVykonuProcesu;
    }

}
