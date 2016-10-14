/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrDoubleList;

import VyrobniProces.IProces;
import java.io.Serializable;
import java.util.Iterator;
import javax.print.attribute.standard.MediaSize;

/**
 *
 * @author Jirka
 */
public class AbstrDoubleList<E> implements IAbstrDoubleList<E>, Serializable {

    private Prvek prvni = null;
    private Prvek aktualni = null;
    private Prvek posledni = null;

    @Override
    public void zrus() {
        prvni = null;
        posledni = null;
        aktualni = null;
    }

    @Override
    public boolean jePradny() {
        if (prvni == null) {
            return true;
        } else {
            return false;
        }
    }
//--------------------------Vkladaci metodzy--------------------------

    @Override
    public void vlozPrvni(E obj) {
        Prvek prvekSeznamu = new Prvek(obj);
        if (prvni == null) {
            prvekSeznamu.naslednik = prvekSeznamu;
            prvekSeznamu.predchudce = prvekSeznamu;
            prvni = prvekSeznamu;
            aktualni = prvekSeznamu;
            posledni = prvekSeznamu;
        } else {
            prvekSeznamu.naslednik = prvni;
            prvni.predchudce = prvekSeznamu;

            posledni.naslednik = prvekSeznamu;
            prvekSeznamu.predchudce = posledni;

            prvni = prvekSeznamu;
            aktualni = prvni;
        }
    }

    @Override
    public void vlozPosledni(E obj) {
        Prvek prvekSeznamu = new Prvek(obj);
        if (prvni == null) {
            vlozPrvni(obj);
        } else {
            posledni.naslednik = prvekSeznamu;
            prvekSeznamu.predchudce = posledni;

            prvekSeznamu.naslednik = prvni;
            prvni.predchudce = prvekSeznamu;

            posledni = prvekSeznamu;
            aktualni = posledni;
        }
    }

    @Override
    public void vlozNaslednika(E obj) {
        Prvek prvekSeznamu = new Prvek(obj);

        if (aktualni == posledni) {
            vlozPosledni(obj);
        } else if (prvni == null) {
            vlozPrvni(obj);
        } else {
            aktualni.naslednik.predchudce = prvekSeznamu;
            prvekSeznamu.naslednik = aktualni.naslednik;

            prvekSeznamu.predchudce = aktualni;
            aktualni.naslednik = prvekSeznamu;

            aktualni = prvekSeznamu;
        }
    }

    @Override
    public void vlozPredchudce(E obj) {
        Prvek prvekSeznamu = new Prvek(obj);
        if (aktualni == prvni) {
            vlozPrvni(obj);
        } else if (prvni == null) {
            vlozPrvni(obj);
        } else {
            aktualni.predchudce.naslednik = prvekSeznamu;
            prvekSeznamu.predchudce = aktualni.predchudce;

            prvekSeznamu.naslednik = aktualni;
            aktualni.predchudce = prvekSeznamu;

            aktualni = prvekSeznamu;
        }
    }
//--------------------------Zpristupnovaci metody--------------------------

    @Override
    public E zpristupniAktualni() {
        if (aktualni == null) {
            return null;
        } else {
            return aktualni.data;
        }
    }

    @Override
    public E zpristupniPrvni() {
        if (prvni == null) {
            return null;
        } else {
            aktualni = prvni;
            return prvni.data;
        }
    }

    @Override
    public E zpristupniPosledni() {
        if (posledni == null) {
            return null;
        } else {
            aktualni = posledni;
            return posledni.data;
        }
    }

    @Override
    public E zpristupniNaslednika() {
        Prvek prvek;
        if (aktualni == null) {
            return null;
        } else if (aktualni.naslednik == aktualni) {
            prvek = aktualni;
        } else {
            prvek = aktualni.naslednik;
            aktualni = aktualni.naslednik;
        }
        return prvek.data;
    }

    @Override
    public E zpristupniPrechudce() {
        Prvek prvek;
        if (aktualni == null) {
            return null;
        } else if (aktualni.predchudce == aktualni) {
            prvek = aktualni;
        } else {
            prvek = aktualni.predchudce;
            aktualni = aktualni.predchudce;
        }
        return prvek.data;

    }
//--------------------------Odebiraci metody--------------------------

    @Override
    public E odeberAktualni() {
        E pomocna;
        if (prvni == null) {
            return null;
        }
        if (aktualni == prvni) {
            return odeberPrvni();
        } else if (aktualni == posledni) {
            return odeberPosledni();
        } else if (prvni == posledni) {
            pomocna = aktualni.data;
            zrus();
            return pomocna;
        } else {
            pomocna = aktualni.data;
            aktualni.naslednik.predchudce = aktualni.predchudce;
            aktualni.predchudce.naslednik = aktualni.naslednik;
            
            aktualni = prvni;
            return pomocna;
        }
    }

    @Override
    public E odeberPrvni() {
        E pomocna;
        if (prvni == null) {
            return null;
        }else{
        if (aktualni == prvni) {
            aktualni = aktualni.naslednik;
        } 
            pomocna = prvni.data;
            prvni.naslednik.predchudce = prvni.predchudce;
            prvni.predchudce.naslednik = prvni.naslednik;
            prvni = prvni.naslednik;
            
            return pomocna;
        }
    }

    @Override
    public E odeberPosledni() {
        E pomocna;
        if (prvni == null) {
            return null;
        } else {
            if (aktualni == posledni) {
                aktualni = aktualni.predchudce;
            }
            pomocna = posledni.data;
            posledni.naslednik.predchudce = posledni.predchudce;
            posledni.predchudce.naslednik = posledni.naslednik;
            posledni = posledni.predchudce;
            return pomocna;

        }
    }

    @Override
    public E odeberNaslednika() {
        E pomocna;
        if (prvni == null) {
            return null;
        }
        if (aktualni.naslednik == posledni) {
            return odeberPosledni();
        } else if (aktualni.naslednik == prvni) {
            return odeberPrvni();
        } else {
            pomocna = aktualni.naslednik.data;
            aktualni.naslednik.naslednik.predchudce = aktualni;
            aktualni.naslednik = aktualni.naslednik.naslednik;
            return pomocna;
//            aktualni.naslednik = aktualni.naslednik.naslednik;
//            aktualni.naslednik.naslednik.predchudce = aktualni;

        }


    }

    @Override
    public E odeberPrechudce() {
        E pomocna;
        if (prvni == null) {
            return null;
        }
        if (aktualni.predchudce == prvni) {
            return odeberPrvni();
        } else if (aktualni.predchudce == posledni) {
            return odeberPosledni();
        } else {
            pomocna = aktualni.predchudce.data;

            aktualni.predchudce.predchudce.naslednik = aktualni;
            aktualni.predchudce = aktualni.predchudce.predchudce;
            return pomocna;

        }
    }
//--------------------------Iterator--------------------------

    @Override
    public Iterator vytvorIterator() {

        aktualni = posledni;
        Iterator<E> it = new Iterator<E>() {

            boolean proslo = false;

            @Override
            public boolean hasNext() {
 // zde zkoumame zda li nám prosel iterátor celou strukturu naplněného ADL
                if (aktualni != null && posledni != null && prvni != null) {
                    if (aktualni != posledni || proslo == false) {
                        aktualni = aktualni.naslednik;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public E next() {
                proslo = true;
                return aktualni.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        return it;

    }

    
//--------------------------Vnitrni trida--------------------------

    private class Prvek implements Serializable {

        private E data;
        private Prvek naslednik;
        private Prvek predchudce;

        public Prvek(E data) {
            this.data = data;
            this.naslednik = null;
            this.predchudce = null;
        }
    }
}
