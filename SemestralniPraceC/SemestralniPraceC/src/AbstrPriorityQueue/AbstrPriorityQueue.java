/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrPriorityQueue;

import AbstrDoubleList.AbstrDoubleList;
import AbstrDoubleList.IAbstrDoubleList;
import KalendarUdalosti.IUdalost;
import java.io.Serializable;
import java.util.Iterator;
import sun.misc.Compare;

/**
 *
 * @author George
 */
public class AbstrPriorityQueue<E extends Compare> implements IAbstrPriorityQueue<E>, Serializable {

    IAbstrDoubleList<E> frontaPomocna = new AbstrDoubleList<>();
    IAbstrDoubleList<E> frontaPriorita = new AbstrDoubleList<>();
    private int mohutnostFronty = 3;
    private int pocet = 0;

    @Override
    public void zrus() {
        frontaPomocna = null;
        frontaPriorita = null;
    }

    @Override
    public boolean jePrazdny() {
        if (frontaPriorita != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void vloz(E data) {

        if (frontaPriorita.jePradny()) {
            frontaPriorita.vlozPrvni(data);
            pocet++;
            return;
        }
        if (data.doCompare(frontaPriorita.zpristupniPosledni(), data) == -1) {
            frontaPomocna.vlozNaslednika(data);
            return;
        }
        frontaPriorita.zpristupniPrvni();
        int pocetPrvku = getMohutnostFronty();
        for (int i = 0; i < pocetPrvku; i++) {
            int vysledek = data.doCompare(frontaPriorita.zpristupniAktualni(), data);
            if (vysledek == 1) {
                frontaPriorita.vlozPredchudce(data);
                pocet++;
                System.out.println(pocet);
                break;

            } else if (vysledek == -1) {
                frontaPriorita.zpristupniNaslednika();

            } else {
                frontaPriorita.vlozPredchudce(data);
                break;
            }


        }
        if (getMohutnostFronty() < pocet) {
            frontaPomocna.vlozNaslednika(frontaPriorita.odeberPosledni());
            return;
        }
    }

    @Override
    public E odeberMax() {

        if (!frontaPriorita.jePradny()) {
            return frontaPriorita.odeberPrvni();
        } else {
            reorganizace();
            return frontaPriorita.odeberPrvni();
        }
    }

    @Override
    public E zpristupni() {
        if (!frontaPriorita.jePradny()) {
            return frontaPriorita.zpristupniPrvni();
        } else {
            reorganizace();
            return frontaPriorita.zpristupniPrvni();
        }
    }

    @Override
    public Iterator vytvorIterator() {
        Iterator<E> it = new Iterator<E>() {

            Iterator itPriorita = frontaPriorita.vytvorIterator();
            Iterator itPomocna = frontaPomocna.vytvorIterator();
            boolean vycerpanaFrontaPriorita = false;
            boolean vycerpanaFrontaPomocna = false;

            @Override
            public E next() {
                if (vycerpanaFrontaPriorita == false) {
                    frontaPriorita.zpristupniNaslednika();
                    return (E) itPriorita.next();
                } else {
                    frontaPomocna.zpristupniNaslednika();
                    return (E) itPomocna.next();
                }


            }

            @Override
            public boolean hasNext() {
                if (vycerpanaFrontaPriorita == false) {
                    vycerpanaFrontaPomocna = itPriorita.hasNext();
                    if (vycerpanaFrontaPomocna == false) {
                        vycerpanaFrontaPriorita = true;
                    }
                    if (vycerpanaFrontaPomocna == true) {
                        return true;
                    }
                }
                return itPomocna.hasNext();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return it;
    }

    @Override
    public int getMohutnostFronty() {
        return mohutnostFronty;
    }

    @Override
    public void setMohutnostFronty(int mohutnostFronty) {
        this.mohutnostFronty = mohutnostFronty;
    }

    @Override
    public Iterator vytvorIteratorPriority() {
        return frontaPriorita.vytvorIterator();
    }

    @Override
    public Iterator vytvorIteratorNeutridene() {
        return frontaPomocna.vytvorIterator();
    }

    @Override
    public void reorganizace() {
        int pocet = 0;
        IAbstrDoubleList<E> Frpomocna = new AbstrDoubleList<>();
        if (!frontaPomocna.jePradny()) {
            for (int i = 0; i < getMohutnostFronty(); i++) {
                E pomocna = frontaPomocna.zpristupniPrvni();
                if (pocet <= getMohutnostFronty()) {
                    for (Iterator it = frontaPomocna.vytvorIterator(); it.hasNext();) {
                        E iter = (E) it.next();
                        int cislo = pomocna.doCompare(pomocna, iter);
                        if (cislo >= 0) {
                            pomocna = iter;

                        }
                    }
                }
                for (Iterator it = frontaPomocna.vytvorIterator(); it.hasNext();) {

                    if (pomocna.doCompare(pomocna, frontaPomocna.zpristupniAktualni()) == 0) {
                        System.out.println(frontaPomocna.odeberAktualni().toString() + "odeb");
                        Frpomocna.vlozPrvni(pomocna);

                    } else {
                        frontaPomocna.zpristupniNaslednika();
                    }
                    it.next();
                }
                pocet++;

            }
            for (Iterator it = Frpomocna.vytvorIterator(); it.hasNext();) {
                frontaPriorita.vlozPosledni(Frpomocna.odeberPosledni());
            }
        }
    }
}
