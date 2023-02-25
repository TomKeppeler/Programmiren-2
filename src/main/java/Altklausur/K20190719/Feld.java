package Altklausur.K20190719;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Feld<T> implements Iterable<T>{
    private T[] feld;
    private int size = 0;
    public Feld(){
        this.feld = (T[]) new Object[100];
    } 

    public void addLast(T e){
        this.feld[this.size++] = e;
    }
    public T get(){
        return this.feld[--this.size];
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
            return feld[i++];
        }
        
    }
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

}
