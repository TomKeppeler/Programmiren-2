package Altklausur.K20190719;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FeldFixIterable<T> implements Iterable<T> {
    T[] feld;
    int size;

    private class MyIterator implements Iterator<T>{
        private int i = 0;
        @Override
        public boolean hasNext() {
            return this.i < size;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return feld[i++];
        }

    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new MyIterator();
    }
    public FeldFixIterable(){
        this.feld = (T[]) new Object[10];
        this.size = 0;
    }
    public void add(T o){
        this.feld[this.size++] = o;
    }
    public static void main(String[] args) {
        FeldFixIterable<String> obj = new FeldFixIterable<>();
        obj.add("Hello ");
        obj.add("Welt");

        Iterator<String> i = obj.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
