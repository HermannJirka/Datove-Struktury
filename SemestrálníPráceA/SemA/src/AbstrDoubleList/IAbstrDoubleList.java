/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstrDoubleList;

import VyrobniProces.IProces;
import java.util.Iterator;

/**
 *
 * @author Jirka
 */
public interface IAbstrDoubleList<T> {

    // metody pro vlozeni sezynamu
    void zrus();

    boolean jePradny();

    void vlozPrvni(T obj);

    void vlozPosledni(T obj);

    void vlozNaslednika(T obj);

    void vlozPredchudce(T obj);

    // metody pro zpristupneni seznamu
    T zpristupniAktualni();

    T zpristupniPrvni();

    T zpristupniPosledni();

    T zpristupniNaslednika();

    T zpristupniPrechudce();
    //metody pro zruseni seznamu

    T odeberAktualni();

    T odeberPrvni();

    T odeberPosledni();

    T odeberNaslednika();

    T odeberPrechudce();

    // metoda ktera vraci iterator
    Iterator vytvorIterator();

}
