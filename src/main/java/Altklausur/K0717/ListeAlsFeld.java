package Altklausur.K0717;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeAlsFeld<T> implements Liste<T>{
    private T[] liste;
    private int size;
    ListeAlsFeld(int s){
        liste = (T[]) new Object[s];
        this.size = 0;
    }
    private class MyIterator implements Iterator<T>{
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return liste[i++];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return liste.length;
    }

    @Override
    public boolean add(T t) {
        if(t == null){
            return false;
        }else{
            this.liste[size++] = t;
            return true;
        }
    }
    @Override
    public String toString() {
       return String.valueOf(Arrays.toString(liste));
    }
}
