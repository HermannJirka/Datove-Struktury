/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrFIFO;

import AbstrDoubleList.AbstrDoubleList;
import AbstrDoubleList.IAbstrDoubleList;
import VyrobniProces.IProces;
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author George
 */
public class AbstrFIFO<E> implements IAbstrFIFO<E>, Serializable {
    
    IAbstrDoubleList<E> fronta = new AbstrDoubleList<>();

    @Override
    public void zrus() {
        fronta.zrus();
    }

    @Override
    public boolean jePrazdny() {
        return fronta.jePradny();
    }

    @Override
    public void vloz(E prvek) {
    fronta.vlozPrvni(prvek);
    }

    @Override
    public E odeber() {
       return fronta.odeberPosledni();
    }

    @Override
    public void zobrazFrontu() {
       IProces p = null;
        Iterator it = null;
       it = fronta.vytvorIterator();
       while(it.hasNext()){
         p = (IProces) it.next();
           System.out.println(p.toString());
       }
    }

    @Override
    public Iterator dejIterator() {
        Iterator it = null;
        it = fronta.vytvorIterator();
        return it;
    }

    
}
