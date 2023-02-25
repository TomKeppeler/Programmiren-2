package ub09.a1bis6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Tom Keppeler
 * mit Iterable
 */

public class EVL<Typ> implements Iterable<Typ> {
    private class EVLIterator implements Iterator<Typ> {
        private Listenelement i = first;

        @Override
        public boolean hasNext() {
            return i.next != null;
        }

        @Override
        public Typ next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Typ ret = i.data;
            i = i.next;
            return ret;
        }
    }

    @Override
    public Iterator<Typ> iterator() {
        return new EVLIterator();
    }

    class Listenelement { // Listenelement als innere Klasse
        Typ data;
        Listenelement next = null; // Z. auf naechstes Element

        Listenelement(Typ data) { // Konstruktor
            if (data == null) {
                throw new IllegalArgumentException();
            }
            this.data = data;
        }
    }

    private Listenelement first = null; // Zeiger auf erstes Element
    private Listenelement last = null; // Zeiger auf letztes Element
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void addFirst(Typ e) {
        Listenelement element = new Listenelement(e); // neues Element
        if (isEmpty()) {
            this.last = element;
        } else {
            element.next = this.first;
        }
        this.first = element;
        size++;
    }

    public Typ removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Typ d = last.data;
        if (first == last) {
            last = null;
            first = null;
        } else {
            if (first.next == last) {
                // first.next = null;
                last = first;
                last.next = null;
            } else {
                Listenelement index = first;
                while (index.next != last) {
                    index = index.next;
                }
                index.next = null;
                last = index;
            }
        }
        size--;
        return d;
    }

    // Start des Aufgabenteils 1
    public void addLast(Typ input) {
        Listenelement element = new Listenelement(input);
        if (size == 0) {
            this.first = element;
            this.first.next = element;
            this.last = element;
        } else {
            this.last.next = element;
            this.last = element;
        }
        size++;
    }

    public Typ removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Typ ret = this.first.data;
        if (size == 1) {
            this.first = null;
            last = null;
        } else {
            this.first = first.next;
        }
        size--;
        return ret;
    }

    public void add(int pos, Typ input) {
        if (pos != 0) {
            if (pos > size) {
                throw new IllegalArgumentException("wrong position: " + pos);
            }
        }
        if (0 > pos) {
            throw new IllegalArgumentException("wrong position: " + pos);
        }
        if (pos == 0) {
            Listenelement naechstesElement = this.first;
            this.first = new Listenelement(input);
            this.first.next = naechstesElement;
        } else {
            Listenelement neu = new Listenelement(input);
            Listenelement element = this.first;
            for (int i = 1; i < pos; i++) {
                element = element.next;
            }
            neu.next = element.next;
            element.next = neu;
        }
        size++;
    }

    public Typ remove(int pos) {
        if (pos != 0) {
            if (1 + pos > size) {
                throw new IllegalArgumentException("wrong position: " + pos);
            }
        }
        if (0 > pos) {
            throw new IllegalArgumentException("wrong position: " + pos);
        }
        Typ ret = null;
        if (pos == 0) {
            return removeFirst();
        } else if (pos == size) {
            return removeLast();
        } else {
            Listenelement index = this.first;
            for (int i = 0; i < pos - 1; i++) {
                index = index.next;
            }
            ret = index.next.data;
            index.next = index.next.next;
        }
        return ret;
    }

    public String toString() {
        String out = "{";
        Listenelement index = this.first;
        while (index != null) {
            if (index != this.first) {
                out += ",";
            }
            out += index.data;
            index = index.next;
        }
        return out + "}";
    }

    public boolean contains(Typ e) {
        Listenelement index = this.first;
        while (!index.data.equals(e)) {
            if (index.next == null) {
                break;
            }
            index = index.next;
        }
        return index.data.equals(e);
    }

    public void zip(EVL<Typ> other) {
        Listenelement index = first;
        while (!other.isEmpty()) {
            Listenelement temp = new Listenelement(other.removeFirst());
            temp.next = index.next;
            index.next = temp;
            index = index.next;
            if (index.next != null) {
                index = index.next;
            }
        }
    }

    public static void main(String[] args) {
        EVL<Integer> l = new EVL<>();
        for (int i = 0; i < 20; i++) {
            l.add(i, 1);
        }
        System.out.println(l.toString());
        EVL<Integer> l1 = new EVL<>();
        for (int i = 0; i < 10; i++) {
            l1.add(i, 2);
        }
        System.out.println(l1.toString());
        l.zip(l1);
        System.out.println(l.toString());

        System.out.println();
        System.out.println();
        System.out.println();
        Iterator i = l.iterator();

        for (Integer var : l) {
            System.out.println(var);
        }
    }
}
