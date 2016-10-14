/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrFIFO;

import java.util.Iterator;

/**
 *
 * @author George
 */
public interface IAbstrFIFO<T> {
     void zrus();
    boolean jePrazdny();
    void vloz(T prvek);
    T odeber();
    void zobrazFrontu();
    Iterator dejIterator();
}
