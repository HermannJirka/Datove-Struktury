/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KalendarUdalosti;

import java.util.Calendar;
import sun.misc.Compare;

/**
 *
 * @author George
 */
public interface IUdalost extends Compare {

    public Calendar getDatumUdalosti();

    public void setDatumUdalosti(Calendar datumUdalosti);

    public String getNazevUdalosti();

    public void setNazevUdalosti(String nazevUdalosti);

    public String getMistoKonani();

    public void setMistoKonani(String mistoKonani);
}
