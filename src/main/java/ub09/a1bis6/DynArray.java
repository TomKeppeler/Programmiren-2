package ub09.a1bis6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Tom Keppeler
 */

public class DynArray<Typ> implements Iterable<Typ> {
    private class DynArrayIterator implements Iterator<Typ> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < dynamisch.length;
        }

        @Override
        public Typ next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return dynamisch[i++];
        }
    }

    @Override
    public Iterator<Typ> iterator() {
        return new DynArrayIterator();
    }

    private Typ[] dynamisch = null;
    private int size = 0;

    public DynArray() {
        this.dynamisch = (Typ[]) new Object[1];
    }

    public int getSize() {
        return this.size;
    }

    public int capacity() {
        return this.dynamisch.length;
    }

    public Typ get(int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("pos is lower then zero (pos: " + pos + ")");
        }
        if (pos > this.getSize()) {
            throw new IllegalArgumentException();
        }
        return this.dynamisch[pos];
    }

    public Typ set(int pos, Typ e) {
        if (pos < 0) {
            throw new IllegalArgumentException("pos is lower then zero (pos: " + pos + ")");
        }
        if (pos + 1 > this.capacity()) {
            throw new IllegalArgumentException();
        }
        if (pos > this.getSize()) {
            throw new IllegalArgumentException();
        }
        this.increaseArray();
        Typ ret = this.dynamisch[pos];
        this.dynamisch[pos] = e;
        if (this.dynamisch[pos] == null) {
            this.size++;
        }
        return ret;
    }

    private void increaseArray() {
        if (this.capacity() == this.getSize()) {
            this.dynamisch = Arrays.copyOf(this.dynamisch, this.capacity() * 2);
        }
    }

    private void decreaseArray() {
        if (this.capacity() >= this.getSize() * 4) {
            this.dynamisch = Arrays.copyOf(this.dynamisch, this.capacity() / 2);
        }
    }

    public void addFirst(Typ e) {
        this.increaseArray();
        for (int i = this.getSize(); i > 0; i--) {
            this.dynamisch[i] = this.dynamisch[i - 1];
        }
        this.dynamisch[0] = e;
        this.size++;
    }

    public void addLast(Typ e) {
        this.increaseArray();
        this.dynamisch[this.size++] = e;
    }

    public Typ removeFirst() {
        this.decreaseArray();
        Typ ret = this.dynamisch[0];
        Typ[] temp = (Typ[]) new Object[this.capacity()];
        for (int i = this.getSize() - 1; i > 0; i--) {
            temp[i - 1] = this.dynamisch[i];
        }
        this.dynamisch = temp;
        this.size--;
        return ret;
    }

    public Typ removeLast() {
        this.decreaseArray();
        Typ ret = this.dynamisch[this.getSize() - 1];
        this.dynamisch[this.getSize() - 1] = null;
        this.size--;
        return ret;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.dynamisch);
    }

    public void printList() {
        System.out.println(this.toString());
    }

}