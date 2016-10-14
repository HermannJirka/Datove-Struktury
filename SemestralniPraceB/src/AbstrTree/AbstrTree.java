/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrTree;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Jirka
 */
public class AbstrTree<E> implements IAbstrTree<E>,Serializable {
    private Prvek koren;
    private Prvek aktualni;
    private Prvek potomek;
    @Override
    public void zrus() {
       koren = null;
       aktualni = null;
    }

    @Override
    public boolean jePrazdny() {
        if(koren == null){
        return true;
        }else{
        return false;
        }
    }

    @Override
    public void vlozKoren(E objekt) {
        if(koren == null){
        Prvek pr = new Prvek(objekt);
        aktualni = pr;
        koren = pr;
        }
    }

    @Override
    public void vlozList(E object) {
        
    }

    @Override
    public E odeberKoren() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E odeberList(int poz) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E zpristupniKoren() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E zpristupniSyna() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator vytvorIterator(eTypProhl typ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private class Prvek implements Serializable{
        private Prvek predchozi;
        private E data;

        public Prvek(E data) {
            this.predchozi = null;
            this.data = data;
        }
        
    }
    
}
