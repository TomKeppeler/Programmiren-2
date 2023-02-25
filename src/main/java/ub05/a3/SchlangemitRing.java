package ub05.a3;

import a2.nachAufgabenStellung.Schlange;
import a3.temp.Ringpuffer;
public class SchlangemitRing<Typ> implements Schlange<Typ>{
    private Ringpuffer<Typ> speicher = null;

    SchlangemitRing(int capacity){
        speicher = new Ringpuffer<>(capacity);
    }

    @Override
    public void insert(Typ e) {
        speicher.addLast(e);
    }

    @Override
    public void remove() {
        speicher.removeFirst();
    }

    @Override
    public int size() {
        return speicher.size();
    }

    @Override
    public boolean isEmpty() {
        return speicher.size() == 0;
    }

    @Override
    public Typ first() {
        return speicher.get(0);
    }

}
