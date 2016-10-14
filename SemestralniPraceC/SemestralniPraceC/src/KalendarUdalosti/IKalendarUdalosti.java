/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KalendarUdalosti;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Jirka
 */
public interface IKalendarUdalosti {

    public void vlozAkci(IUdalost udalost);

    public void vlozAkce(IUdalost udalosti[]);

    public IUdalost[] dejAkce();

    public void preplanujAkci(Calendar datum);

    public Iterator dejIterator();

    public Iterator dejIteratorPriority();

    public Iterator dejIteratorNeutridene();

    public int dejMohutnost();

    public void nastavMohutnost(int cislo);

    public void generujUdalosti();

    public void zrus();

    public void uloz(String nazev);

    public void nacti(String nazev);

    public IUdalost zpristupni();

    public IUdalost odeber();
}
