/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrTree;

import java.util.Iterator;

/**
 *
 * @author Jirka
 */
public interface IAbstrTree<E> {

    void zrus();

    boolean jePrazdny();

    void vlozKoren(E objekt);

    void vlozList(E object);

    E odeberKoren();

    E odeberList(int poz);

    E zpristupniKoren();

    E zpristupniSyna();
    
    Iterator vytvorIterator(eTypProhl typ);
}
