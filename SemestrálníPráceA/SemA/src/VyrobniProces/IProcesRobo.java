/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VyrobniProces;

/**
 *
 * @author George
 */
public interface IProcesRobo extends IProces{

    void generovaniCasuVykonuProcesu();

    int getCasVykonuProces();

    String getIdRobota();

    void setCasVykonuProces(int casVykonuProces);

    void setIdRobota(String idRobota);

    String toString();
    
}
