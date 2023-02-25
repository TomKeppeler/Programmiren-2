package ub05.a4;

import a2.nachAufgabenStellung.Folge;
import a3.Ringpuffer;

public class FolgemitRing<Typ> implements Folge<Typ> {
    private Ringpuffer<Typ> speicher = null;

    FolgemitRing(int capacity) {
        this.speicher = new Ringpuffer<>(capacity);
    }

    @Override
    public void insert(Typ e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.speicher.size();
    }

    @Override
    public boolean isEmpty() {
        return this.speicher.size() == 0;
    }

    public void insertMa(int pos, Typ e) {
        if (pos > speicher.size() || pos < 0)
            throw new IndexOutOfBoundsException();
        if (speicher.size() == speicher.capacity()) {
            Ringpuffer<Typ> puffernew = new Ringpuffer<>(speicher.capacity() * 2);
            while (speicher.size() > 0) {
                puffernew.addLast(speicher.removeFirst());
            }
            speicher = puffernew;
        }
        Ringpuffer<Typ> temp = new Ringpuffer<>(speicher.size());
        while (speicher.size() > pos) {
            temp.addFirst(speicher.removeLast());
        }
        speicher.addLast(e);
        while (temp.size() > 0) {
            speicher.addLast(temp.removeFirst());
        }
    }

    @Override
    public void insert(int pos, Typ e) {
        if (pos + 1 > this.speicher.size()) {
            if (pos == 0) {
                for (int i = 0; i < pos; i++) {
                    if (this.speicher.get(i) != null) {
                        speicher.addLast(null);
                    }
                }
                speicher.addLast(e);
            }
        } else {
            Ringpuffer<Typ> temp = new Ringpuffer<>(this.speicher.capacity());
            for (int i = 0; i < this.speicher.size(); i++) {
                if (i == pos) {
                    temp.set(i, e);
                } else {
                    temp.set(i, this.speicher.get(i));
                }
            }
            this.speicher = temp;
        }
    }

    @Override
    public Typ get(int pos) {
        return this.speicher.get(pos);
    }

    @Override
    public void set(int pos, Typ e) {
        this.speicher.set(pos, e);
    }

    @Override
    public void remove(int pos) {
        if (pos + 1 == this.speicher.size()) {
            this.speicher.removeLast();
        } else if (pos == 0) {
            this.speicher.removeFirst();
        } else {
            Ringpuffer<Typ> temp = new Ringpuffer<>(speicher.capacity());
            for (int i = 0; i < this.speicher.size(); i++) {
                if (i != pos) {
                    temp.set(i, this.speicher.get(i));
                }
            }
            speicher = temp;
        }
    }

    public static void main(String[] args) {
        FolgemitRing<Integer> speicher = new FolgemitRing<>(20);
        for (int i = 0; i < 10; i++) {
           speicher.insert(i, i);
        }
        speicher.remove(1);
        for (int i = 0; i < 10; i++) {
           System.out.println(speicher.get(i));
        }
    }
}
