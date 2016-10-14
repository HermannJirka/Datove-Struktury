/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KalendarUdalosti;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author George
 */
public class Udalost implements IUdalost, Serializable {

    private Calendar datumUdalosti;
    private String nazevUdalosti;
    private String mistoKonani;

    public Udalost(Calendar datumUdalosti, String nazevUdalosti, String mistoKonani) {
        this.datumUdalosti = datumUdalosti;
        this.nazevUdalosti = nazevUdalosti;
        this.mistoKonani = mistoKonani;
    }

    public Calendar getDatumUdalosti() {
        return datumUdalosti;
    }

    public void setDatumUdalosti(Calendar datumUdalosti) {
        this.datumUdalosti = datumUdalosti;
    }

    public String getNazevUdalosti() {
        return nazevUdalosti;
    }

    public void setNazevUdalosti(String nazevUdalosti) {
        this.nazevUdalosti = nazevUdalosti;
    }

    public String getMistoKonani() {
        return mistoKonani;
    }

    public void setMistoKonani(String mistoKonani) {
        this.mistoKonani = mistoKonani;
    }

    @Override
    public int doCompare(Object o, Object o1) {
        
        IUdalost udalost1 = (IUdalost) o;
        IUdalost udalost2 = (IUdalost) o1;

        Calendar datum1 = new GregorianCalendar();
        Calendar datum2 = new GregorianCalendar();

        datum1 = udalost1.getDatumUdalosti();
        datum2 = udalost2.getDatumUdalosti();
        int mesic1 = datum1.get(Calendar.WEEK_OF_YEAR);
        int mesic2 = datum2.get(Calendar.WEEK_OF_YEAR);

        int resault = Integer.compare(mesic1, mesic2);
        
        return resault;



    }

    @Override
    public String toString() {
        return "Udalost:\n" 
                + "Datum: " + datumUdalosti.get(Calendar.DAY_OF_MONTH)+"."+datumUdalosti.get(Calendar.MONTH)+"."+datumUdalosti.get(Calendar.YEAR) +"\n"
                + "Cislo tydnu: "+datumUdalosti.get(Calendar.WEEK_OF_YEAR)+"\n"
                + "Udalost: " + nazevUdalosti +"\n"
                + "Misto: " + mistoKonani + "\n";
    }

    
    
}
