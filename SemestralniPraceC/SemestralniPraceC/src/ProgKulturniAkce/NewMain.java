/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgKulturniAkce;

import AbstrPriorityQueue.IAbstrPriorityQueue;
import KalendarUdalosti.IKalendarUdalosti;
import KalendarUdalosti.IUdalost;
import KalendarUdalosti.KalendarUdalosti;
import KalendarUdalosti.Udalost;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 *
 * @author George
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
//        Calendar cal = new GregorianCalendar(2012, 6, 15);
//        Calendar cal2 = new GregorianCalendar(2012, 2, 15);
//        Calendar cal3 = new GregorianCalendar(2012, 5, 15);
//        Calendar cal4 = new GregorianCalendar(2012, 3, 15);
//        Calendar cal5 = new GregorianCalendar(2012, 8, 15);
//        Calendar cal6 = new GregorianCalendar(2012, 9, 15);
//        Calendar cal7 = new GregorianCalendar(2012, 10, 15);
//        Calendar cal8 = new GregorianCalendar(2012, 0, 24);
//        Calendar cal9 = new GregorianCalendar(2012, 1, 24);
//        Udalost ud1 = new Udalost(cal, "Metalika", "Praha");
//        Udalost ud2 = new Udalost(cal2, "Magnetic", "Praha");
//        Udalost ud3 = new Udalost(cal3, "Hokej", "Praha");
//        Udalost ud4 = new Udalost(cal4, "Fotbal", "Praha");
//        Udalost ud5 = new Udalost(cal5, "Futsal", "Praha");
//        Udalost ud6 = new Udalost(cal6, "Florbal", "Praha");
//        Udalost ud7 = new Udalost(cal7, "Hazena", "Praha");
//        Udalost ud8 = new Udalost(cal8, "Plavani", "Praha");
//        Udalost ud9 = new Udalost(cal9, "Plavani", "Praha");
        IKalendarUdalosti kalendar = new KalendarUdalosti();
//        IUdalost[] udalost = new Udalost[kalendar.dejMohutnost()];
//        kalendar.vlozAkci(ud1);
//        kalendar.vlozAkci(ud2);
//        kalendar.vlozAkci(ud3);
//        kalendar.vlozAkci(ud4);
//        kalendar.vlozAkci(ud5);
//        kalendar.vlozAkci(ud6);
//        kalendar.vlozAkci(ud7);
//        kalendar.vlozAkci(ud8);
//        kalendar.vlozAkci(ud9);
//        udalost = kalendar.dejAkce();
      
//        kalendar.dejAkce();
        kalendar.generujUdalosti();
            for (Iterator it = kalendar.dejIterator(); it.hasNext();) {
            System.out.println(it.next().toString());
        }
        System.out.println("============================");
        kalendar.odeber();
        kalendar.odeber();
        kalendar.odeber();
        kalendar.odeber();
       
        for (Iterator it = kalendar.dejIterator(); it.hasNext();) {
            System.out.println(it.next().toString());
        }
        System.out.println("==============================");
//        for (Iterator it1 = kalendar.dejIteratorNeutridene(); it1.hasNext();) {
//            System.out.println(it1.next().toString());
//        }


//        System.out.println( ud1.doCompare(ud1, ud2));
//        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
//        System.out.println(cal2.get(Calendar.WEEK_OF_YEAR));
//       
    }
}
