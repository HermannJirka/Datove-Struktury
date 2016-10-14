/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KalendarUdalosti;

import AbstrPriorityQueue.AbstrPriorityQueue;
import AbstrPriorityQueue.IAbstrPriorityQueue;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class KalendarUdalosti implements IKalendarUdalosti,Serializable{

    IAbstrPriorityQueue<IUdalost> kalendar = new AbstrPriorityQueue<>();

    @Override
    public void vlozAkci(IUdalost udalost) {
        kalendar.vloz(udalost);
    }

    @Override
    public void vlozAkce(IUdalost[] udalosti) {
        for (int i = 0; i < udalosti.length; i++) {
            kalendar.vloz(udalosti[i]);
        }

    }

    @Override
    public IUdalost[] dejAkce() {
        int pocetPrvku = kalendar.getMohutnostFronty();
        IUdalost[] poleAkci = new Udalost[pocetPrvku];
        int pomocna = 0;
        for (Iterator it = kalendar.vytvorIterator(); it.hasNext();) {
            IUdalost udalost = (IUdalost) it.next();
            if(pomocna < pocetPrvku){
                poleAkci[pomocna] = udalost;
            }
            pomocna++;
        }
        return poleAkci;
    }

    @Override
    public void preplanujAkci(Calendar date) {
        IUdalost udalost = null;
        udalost = kalendar.odeberMax();
        udalost.setDatumUdalosti(date);
        kalendar.vloz(udalost);
    }

    @Override
    public Iterator dejIterator() {
        return kalendar.vytvorIterator();
    }

    @Override
    public Iterator dejIteratorPriority() {
        return kalendar.vytvorIteratorPriority();
    }

    @Override
    public Iterator dejIteratorNeutridene() {
        return kalendar.vytvorIteratorNeutridene();
    }

    @Override
    public int dejMohutnost() {
        return kalendar.getMohutnostFronty();
    }

    @Override
    public void nastavMohutnost(int cislo) {
        kalendar.setMohutnostFronty(cislo);
    }

    @Override
    public void generujUdalosti() {
        String nazevUdalost[] = {"Magnetic Festival", "Hokej", "Fotbal", "ThaiBox", "Box", "Metalica", "Trancemisson", "Rugby", "Majales", "Americky Fotbal", "DevFest", "GeekGroup"};
        String mistoUdalost[] = {"Praha", "Pardubice", "Brno", "Hradec Kralove", "Zlin", "Znojmo", "Liberec", "Kladno", "Plzen", "Usti nad Labem", "Ceske Budejovice", "Ostrava"};
        int genDen = 0;
        int genMesic = 0;
        int genNazev = 0;
        int genMisto = 0;
        int rok = 2012;
        int genPocetUdalosti = (int) (Math.random() * 15) + 3;
        for (int i = 0; i < genPocetUdalosti; i++) {
            genDen = (int) (Math.random() * 30) + 1;
            genMesic = (int) (Math.random() * 11);
            genNazev = (int) (Math.random() * 11);
            genMisto = (int) (Math.random() * 11);
            Calendar datum = new GregorianCalendar(rok, genMesic, genDen);
            IUdalost udalost = new Udalost(datum, nazevUdalost[genNazev], mistoUdalost[genMisto]);
            kalendar.vloz(udalost);
        }

    }

    @Override
    public void zrus() {
        kalendar = null;
    }

    @Override
    public void uloz(String nazev) {
        try {
            ObjectOutputStream uloz = new ObjectOutputStream(new FileOutputStream(nazev));
            uloz.writeObject(kalendar);
            uloz.close();
        } catch (IOException ex) {
            Logger.getLogger(KalendarUdalosti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void nacti(String nazev) {
        try {
            ObjectInputStream nacti = new ObjectInputStream(new FileInputStream(nazev));
            kalendar = (IAbstrPriorityQueue<IUdalost>) nacti.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KalendarUdalosti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KalendarUdalosti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public IUdalost zpristupni() {
        return kalendar.zpristupni();
    }

    @Override
    public IUdalost odeber() {
        return kalendar.odeberMax();
    }
}
