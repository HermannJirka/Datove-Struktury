/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrPriorityQueue;

import java.util.Iterator;

/**
 *
 * @author George
 */
public interface IAbstrPriorityQueue<E> {

    public void zrus();

    public boolean jePrazdny();

    public void vloz(E data);

    public E odeberMax();

    public E zpristupni();

    public Iterator vytvorIterator();

    public Iterator vytvorIteratorPriority();

    public Iterator vytvorIteratorNeutridene();
    
    public void reorganizace();
    
     public int getMohutnostFronty();
     
    public void setMohutnostFronty(int mohutnostFronty);
}
