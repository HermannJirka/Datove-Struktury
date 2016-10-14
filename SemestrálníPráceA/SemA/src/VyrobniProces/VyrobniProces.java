/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VyrobniProces;

import AbstrDoubleList.AbstrDoubleList;
import AbstrFIFO.AbstrFIFO;
import AbstrDoubleList.IAbstrDoubleList;
import AbstrFIFO.IAbstrFIFO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class VyrobniProces implements IVyrobniProces, Serializable {

    private IAbstrDoubleList<IProces> vyrobniProces = new AbstrDoubleList<>();
    private IAbstrFIFO<IProces> fronta = new AbstrFIFO<>();

    @Override
    public void vlozProces(IProces proces, enumPozice pozice) {
        switch (pozice) {
            case PRVNI:
                vyrobniProces.vlozPrvni(proces);
                break;
            case POSLEDNI:
                vyrobniProces.vlozPosledni(proces);
                break;
            case PREDCHUDCE:
                vyrobniProces.vlozPredchudce(proces);
                break;
            case NASLEDNIK:
                vyrobniProces.vlozNaslednika(proces);
                break;
        }

    }

    @Override
    public IProces zpristupniProces(enumPozice pozice) {
        IProces pom = null;
        switch (pozice) {
            case PRVNI:
                pom = vyrobniProces.zpristupniPrvni();
                break;
            case POSLEDNI:
                pom = vyrobniProces.zpristupniPosledni();
                break;
            case PREDCHUDCE:
                pom = vyrobniProces.zpristupniPrechudce();
                break;
            case NASLEDNIK:
                pom = vyrobniProces.zpristupniNaslednika();
                break;
            case AKTUALNI:
                pom = vyrobniProces.zpristupniAktualni();
                break;
        }
        return pom;

    }

    @Override
    public IProces odeberProces(enumPozice pozice) {
        IProces pom = null;
        switch (pozice) {
            case PRVNI:
                vyrobniProces.odeberPrvni();
                break;
            case POSLEDNI:
                vyrobniProces.odeberPosledni();
                break;
            case PREDCHUDCE:
                vyrobniProces.odeberPrechudce();
                break;
            case NASLEDNIK:
                vyrobniProces.odeberNaslednika();
                break;
            case AKTUALNI:
                vyrobniProces.odeberAktualni();
                break;
        }
        return pom;


    }

    @Override
    public void zobrazProcesy() {
        Iterator it = null;
        it = vyrobniProces.vytvorIterator();

        while (it.hasNext()) {
            IProces pom;
            pom = (IProces) it.next();
            System.out.println(pom.toString());
        }


    }

    @Override
    public IAbstrFIFO vytipujKandidatiReorg(int kriterium, enumReorg reorganizace) {
        Iterator it = null;
        IProces pom = null;
        IProces pom1 = null;
        IProcesManu man = null;
        IProcesManu man1 = null;
        it = vyrobniProces.vytvorIterator();
        for (Iterator it1 = it; it1.hasNext();) {
            pom = (IProces) it1.next();
            if (pom instanceof ProcesManu) {
                man = (IProcesManu) pom;
                switch (reorganizace) {
                    case AGREGACE:
                        if (it1.hasNext()) {
                            pom1 = (IProces) it1.next();
                            if (pom1 instanceof ProcesManu) {
                                man1 = (IProcesManu) pom1;
                                if (kriterium > man.getCasVykonuProcesu() && kriterium > man1.getCasVykonuProcesu()) {
                                    fronta.vloz((IProces) man);
                                    fronta.vloz((IProces) man1);
                                }
                            }
                        }
                        break;
                    case DEKOMPOZICE:
                        if (kriterium < man.getCasVykonuProcesu()) {
                            fronta.vloz((IProces) man);
                        }
                        break;
                }


            }
        }
        return fronta;
    }

    @Override
    public void reorganizace(enumReorg reorganizace, IAbstrFIFO fronta) {
        IProces prvni = vyrobniProces.zpristupniPrvni();
        Iterator itVyrobniProces = vyrobniProces.vytvorIterator();

        switch (reorganizace) {
            case AGREGACE:
                IProces pr1 = null;
                IProces pr2 = null;
                IProces pomoc = null;
                IProcesManu man1 = null;
                IProcesManu man2 = null;
                int i = 0;

                pr1 = (IProces) fronta.odeber();
                pr2 = (IProces) fronta.odeber();
                for (Iterator it = itVyrobniProces; it.hasNext();) {
                    if (pr1 == it.next()) {
                        man1 = (IProcesManu) pr1;
                        man2 = (IProcesManu) pr2;
                        IProcesManu soucet = new ProcesManu(man1.getIdObsluzneJednotky() + man2.getIdObsluzneJednotky(),
                                man1.getPocetLidskychJednotek() + man2.getPocetLidskychJednotek(),
                                man1.getCasVykonuProcesu() + man2.getCasVykonuProcesu());
                        if (pr1 == prvni) {
                            vyrobniProces.zpristupniNaslednika();
                            vyrobniProces.zpristupniNaslednika();
                            vyrobniProces.odeberPrechudce();
                            vyrobniProces.odeberPrechudce();
                            vyrobniProces.vlozPredchudce(soucet);
                        } else {
                            vyrobniProces.zpristupniPrechudce();

                            pomoc = vyrobniProces.odeberNaslednika();
                            pomoc = vyrobniProces.odeberNaslednika();
                            vyrobniProces.vlozNaslednika(soucet);
                        }
                        pr1 = (IProces) fronta.odeber();
                        pr2 = (IProces) fronta.odeber();
                    }


                }


                break;
            case DEKOMPOZICE:
                IProces proces1 = null;
                IProcesManu manual1 = null;
                IProcesManu new1 = null;
                IProcesManu new2 = null;

                proces1 = (IProces) fronta.odeber();
                for (Iterator it = itVyrobniProces; it.hasNext();) {
                    if (proces1 == it.next()) {
                        manual1 = (IProcesManu) proces1;

                        if (manual1.getCasVykonuProcesu() % 2 == 0) {
                            if (manual1.getPocetLidskychJednotek() % 2 == 0) {
                                new1 = new ProcesManu(manual1.getIdObsluzneJednotky(), manual1.getPocetLidskychJednotek() / 2, manual1.getCasVykonuProcesu() / 2);
                                new2 = new ProcesManu(manual1.getIdObsluzneJednotky() + "NEW", manual1.getPocetLidskychJednotek() / 2, manual1.getCasVykonuProcesu() / 2);
                            } else {
                                new1 = new ProcesManu(manual1.getIdObsluzneJednotky(), manual1.getPocetLidskychJednotek() / 2, manual1.getCasVykonuProcesu() / 2);
                                new2 = new ProcesManu(manual1.getIdObsluzneJednotky() + "NEW", manual1.getPocetLidskychJednotek() / 2 + 1, manual1.getCasVykonuProcesu() / 2);
                            }
                        } else {
                            if (manual1.getPocetLidskychJednotek() % 2 == 0) {
                                new1 = new ProcesManu(manual1.getIdObsluzneJednotky(), manual1.getPocetLidskychJednotek() / 2, manual1.getCasVykonuProcesu() / 2);
                                new2 = new ProcesManu(manual1.getIdObsluzneJednotky() + "NEW", manual1.getPocetLidskychJednotek() / 2, manual1.getCasVykonuProcesu() / 2 + 1);
                            } else {
                                new1 = new ProcesManu(manual1.getIdObsluzneJednotky(), manual1.getPocetLidskychJednotek() / 2, manual1.getCasVykonuProcesu() / 2);
                                new2 = new ProcesManu(manual1.getIdObsluzneJednotky() + "NEW", manual1.getPocetLidskychJednotek() / 2 + 1, manual1.getCasVykonuProcesu() / 2 + 1);
                            }
                        }

                        if (proces1 == prvni) {
                            vyrobniProces.zpristupniNaslednika();
                            vyrobniProces.odeberPrechudce();
                            vyrobniProces.vlozPredchudce(new2);
                            vyrobniProces.vlozPredchudce(new1);
                            vyrobniProces.zpristupniNaslednika();
                        } else {
                            vyrobniProces.zpristupniPrechudce();
                            vyrobniProces.odeberNaslednika();
                            vyrobniProces.vlozNaslednika(new1);
                            vyrobniProces.vlozNaslednika(new2);
                        }

                        proces1 = (IProces) fronta.odeber();
                    }
                }

                break;
        }
    }

    @Override
    public void zrus() {
        vyrobniProces.zrus();
    }

    @Override
    public void nacti() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("VyrobniProces"));
            vyrobniProces = (IAbstrDoubleList<IProces>) ois.readObject();


        } catch (IOException ex) {
            Logger.getLogger(VyrobniProces.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VyrobniProces.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    @Override
    public void uloz() {
        try {
            ObjectOutputStream uloz = new ObjectOutputStream(new FileOutputStream("VyrobniProces"));
            uloz.writeObject(vyrobniProces);
            uloz.close();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @Override
    public Iterator dejIterator() {
        Iterator it = null;
        it = vyrobniProces.vytvorIterator();
        return it;
    }

    @Override
    public Iterator dejIteratorFronta() {
        Iterator it = null;
        it = fronta.dejIterator();
        return it;
    }
}
