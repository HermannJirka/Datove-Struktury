/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VyrobniProces;

import AbstrFIFO.IAbstrFIFO;
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author George
 */
public interface IVyrobniProces {

    void vlozProces(IProces proces, enumPozice pozice);

    IProces zpristupniProces(enumPozice pozice);

    IProces odeberProces(enumPozice pozice);

    void zobrazProcesy();

    IAbstrFIFO vytipujKandidatiReorg(int kriterium, enumReorg reorganizace);

    void reorganizace(enumReorg reorganizace, IAbstrFIFO fronta);

    public void nacti();

    public void uloz();
    
    public Iterator dejIterator();
    
    public Iterator dejIteratorFronta();

    void zrus();
}
