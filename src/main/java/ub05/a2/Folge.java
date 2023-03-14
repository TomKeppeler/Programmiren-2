package ub05.a2;

import ub03.a4.EVL;

public class Folge<Typ> implements Puffer<Typ> {
    private EVL<Typ> speicher = new EVL<>();

    @Override
    public void insert(Typ e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
        return this.speicher.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.speicher.isEmpty();
    }

    public void insert(int pos, Typ e) {
        if (pos == 0) {
            speicher.add(0, e);
        } else {
            speicher.add(pos - 1, e);
        }
    }

    public Typ get(int pos) {
        Typ ret = speicher.remove(pos);
        speicher.add(pos, ret);
        return ret;
    }

    public void set(int pos, Typ e) {
        speicher.remove(pos);
        speicher.add(pos, e);
    }

    public void remove(int pos) {
        speicher.remove(pos);
    }
}
