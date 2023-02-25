package ub08.a1;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {
    private int pos, stop;
    private T[] e;
    Iterator1DArray(T[] e) {
        this.e = e;
        this.pos = 0;
        stop = -1;
    }

    Iterator1DArray(T[] e, int start) {// von start bis ende
        this.e = e;
        this.pos = start;
        this.stop = -1;
    }

    Iterator1DArray(T[] e, int start, int ende) { // von start bis vor stop (exklusiv)
        this.e = e;
        this.pos = start;
        if(!(ende < e.length && ende > -1))/*falls die übergebene Länge nicht inerhalb des 
                                            Arrays liegt wird IllegalArgumentException geworfen.*/
            throw new IllegalArgumentException("Ende nicht inerhalb des Array (ende = " + ende + ")!");
        this.stop = ende;
    }

    @Override
    public boolean hasNext() {/*Falls ein spezifisches ende nicht gewünscht ist wird
                                die länge des Arrays benutzt sonnst die gewünschte länge*/
        return this.stop != -1 ? this.pos < this.stop : this.pos < e.length;
    }

    @Override
    public T next() {
        if(!this.hasNext()){
            throw new NoSuchElementException();
        }
        return e[pos++];
    }
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4};
        Iterator1DArray<Integer> speicher = new Iterator1DArray<>(a);
        for (;speicher.hasNext(); System.out.println(speicher.next()));
    }
}