package ub09.a1bis6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;



public abstract class GenericUtil {

    public static <T> T gambling(T first, T secound){ //Aufgabe 1
        return new Random().nextBoolean() ? first : secound;
    }
    
    public static <T> Schlange<T> arrayToSchlange(T[] uebergabe){ //Aufgabe 2
        Schlange<T> ret = new SchlangemitDynArray<>();
        for (int i = 0; i < uebergabe.length; i++) {
            ret.insert(uebergabe[i]);
        }
        return ret;
    }
    
    public static <T> void printAll(Iterable<T> iterable){
        for (T var : iterable) {
            System.out.println(var);
        }
    }

    public static <U> void insertInto(Puffer<U> puffer, U[] feld){
        for (int i = 0; i < feld.length; i++) {
            puffer.insert(feld[i]);
        }
    }

    public static <U> void insertInto(Puffer<U> eins, Puffer<U> zwei){
        for (U var : eins) {
            zwei.insert(var);
        }
    }

    public static <T> Folge<T> getMinima(Puffer<T> eins, Puffer<T> zwei, Comparator<T> comp){
        Folge<T> ret = new FolgemitEVL<>();
        Iterator<T> einsI = eins.iterator();
        Iterator<T> zweiI = zwei.iterator();
        while(einsI.hasNext() || zweiI.hasNext()){
            if(!einsI.hasNext())
                ret.insert(ret.size(), zweiI.next());
            if(!zweiI.hasNext())
                ret.insert(ret.size(), einsI.next());
            T a = einsI.next();
            T b = zweiI.next();
            if(comp.compare(a, b) < 0){
                ret.insert(ret.size(), a);
            }else{
                ret.insert(ret.size(), b);
            }    
        }
        return ret;
    }

    public static <T extends Comparable<T>> Folge<T> getMinima(Puffer<T> eins, Puffer<T> zwei){
        Folge<T> ret = new FolgemitEVL<>();
        Iterator<T> einsI = eins.iterator();
        Iterator<T> zweiI = zwei.iterator();
        while(einsI.hasNext() || zweiI.hasNext()){
            if(!einsI.hasNext())
                ret.insert(ret.size(), zweiI.next());
            if(!zweiI.hasNext())
                ret.insert(ret.size(), einsI.next());
            T a = einsI.next();
            T b = zweiI.next();
            if(a.compareTo(b) < 0){
                ret.insert(ret.size(), a);
            }else{
                ret.insert(ret.size(), b);
            } 
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8};
        Integer[] b = {9,10,11,12,13,14,15,16};
        SchlangemitDynArray<Integer> ret = (SchlangemitDynArray<Integer>) arrayToSchlange(a);
        System.out.println(ret.toString());
        EVL<Integer> s = new EVL<>();
        for (Integer var : a) {
            s.addLast(var);
        }
        printAll(s);
        System.out.println("-------------------");   
        SchlangemitDynArray<Integer> r1 = new SchlangemitDynArray<>();
        SchlangemitDynArray<Integer> r2 = new SchlangemitDynArray<>();
        for (Integer var : a) {
            r1.insert(var);
        }
        for (Integer var : b) {
            r2.insert(var);
        }

        Folge<Integer> test = getMinima(r1, r2, new FolgeComp());
        System.out.println(test.size());
    }
}
