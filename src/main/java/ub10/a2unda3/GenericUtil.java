package ub10.a2unda3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import ub09.a1bis6.*;
/**
 * @Author ???? und John Meyerhoff
 */
public abstract class GenericUtil {

    public static <T> T gambling(T first, T secound) { // Aufgabe 1
        return new Random().nextBoolean() ? first : secound;
    }

    public static <T> Schlange<T> arrayToSchlange(T[] uebergabe) { // Aufgabe 2
        Schlange<T> ret = new SchlangemitDynArray<>();
        for (int i = 0; i < uebergabe.length; i++) {
            ret.insert(uebergabe[i]);
        }
        return ret;
    }

    public static <T> void printAll(Iterable<T> iterable) {
        for (T var : iterable) {
            System.out.println(var);
        }
    }

    public static <U> void insertInto(Puffer<U> puffer, U[] feld) {
        for (int i = 0; i < feld.length; i++) {
            puffer.insert(feld[i]);
        }
    }

    public static <U> void insertInto(Puffer<U> eins, Puffer<U> zwei) {
        for (U var : eins) {
            zwei.insert(var);
        }
    }

    public static <T> Folge<T> getMinima(Puffer<T> eins, Puffer<T> zwei, Comparator<? super T> comp) {
        Folge<T> ret = new FolgemitEVL<>();
        Iterator<T> einsI = eins.iterator();
        Iterator<T> zweiI = zwei.iterator();
        while (einsI.hasNext() || zweiI.hasNext()) {
            if (!einsI.hasNext())
                ret.insert(ret.size(), zweiI.next());
            if (!zweiI.hasNext())
                ret.insert(ret.size(), einsI.next());
            T a = einsI.next();
            T b = zweiI.next();
            if (comp.compare(a, b) < 0) {
                ret.insert(ret.size(), a);
            } else {
                ret.insert(ret.size(), b);
            }
        }
        return ret;
    }

    public static <T extends Comparable<T>> Folge<T> getMinima(Puffer<T> eins, Puffer<T> zwei) {
        Folge<T> ret = new FolgemitEVL<>();
        Iterator<T> einsI = eins.iterator();
        Iterator<T> zweiI = zwei.iterator();
        while (einsI.hasNext() || zweiI.hasNext()) {
            if (!einsI.hasNext())
                ret.insert(ret.size(), zweiI.next());
            if (!zweiI.hasNext())
                ret.insert(ret.size(), einsI.next());
            T a = einsI.next();
            T b = zweiI.next();
            if (a.compareTo(b) < 0) {
                ret.insert(ret.size(), a);
            } else {
                ret.insert(ret.size(), b);
            }
        }
        return ret;
    }

    public static <T> T getMaximum(Puffer<T> eins, Puffer<T> zwei, Comparator<T> comp) {
        T gross1 = null;
        int i = 0;
        for (T var : eins) {
            if(i == 0){
                gross1 = var;
            }
            ++i;
            if(comp.compare(gross1, var) > 0){
                gross1 = var;
            }
        }
        T gross2 = null;
        i = 0;
        for (T var : zwei) {
            if(i == 0){
                gross2 = var;
            }
            ++i;
            if(comp.compare(gross2, var) > 0){
                gross2 = var;
            }
        }
        return comp.compare(gross1, gross2) > 0 ? gross1 : gross2;
    }

    public static <T extends Comparable<T>> T getMaximum(Puffer<T> eins, Puffer<T> zwei) {
        T gross1 = null;
        int i = 0;
        for (T var : eins) {
            if(i == 0){
                gross1 = var;
            }
            ++i;
            if(var.compareTo(gross1) > 0){
                gross1 = var;
            }
        }
        T gross2 = null;
        i = 0;
        for (T var : zwei) {
            if(i == 0){
                gross2 = var;
            }
            ++i;
            if(var.compareTo(gross2) > 0){
                gross2 = var;
            }
        }
        return gross1.compareTo(gross2) > 0 ? gross1 : gross2;
    }
   

    public static void main(String[] args) {
        Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Integer[] b = { 9, 10, 11, 12, 13, 14, 15, 16 };
        SchlangemitDynArray<Integer> ret = (SchlangemitDynArray<Integer>) arrayToSchlange(a);
        System.out.println(ret.toString());
        EVL<Integer> s = new EVL<>();
        for (Integer vari : a) {
            s.addLast(vari);
        }
        printAll(s);
        System.out.println("-------------------");
        SchlangemitDynArray<Integer> r1 = new SchlangemitDynArray<>();
        SchlangemitDynArray<Integer> r2 = new SchlangemitDynArray<>();
        for (Integer vari : a) {
            r1.insert(vari);
        }
        for (Integer vari : b) {
            r2.insert(vari);
        }
        Folge<Integer> test = getMinima(r1, r2, new FolgeComp());
        System.out.println(test.size());
        Integer test2 = getMaximum(r1, r2);
        System.out.println(test2);
    }
}
