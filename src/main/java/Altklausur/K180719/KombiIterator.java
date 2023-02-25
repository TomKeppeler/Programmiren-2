package Altklausur.K180719;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Tom Keppeler
 * Aufgabe 1
 */
public class KombiIterator<T> implements Iterator<T>{ //Typerweiterung durch ? extends T möglich
    private Iterator<T> i1 = null, i2 = null;

    KombiIterator(Iterator<T> i1, Iterator<T> i2){
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return i1.hasNext() ? i1.next() : i2.next();
    }

    public static <T> Zuordnung<T, Integer> umkehrung(Iterable<T> a){ //Aufgabe 2
        Zuordnung<T, Integer> ret = new ZuordnungAlsFolge<>();
        int i = 0;
        for (T var : a) {
            if(ret.get(var) == null){
                ret.insert(var, i++);
            }
        }
        return ret;
    }
}