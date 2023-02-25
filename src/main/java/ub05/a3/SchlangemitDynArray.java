package ub05.a3;

import a2.DynArray;
import a2.nachAufgabenStellung.Schlange;

public class SchlangemitDynArray<Typ> implements Schlange<Typ>{
    private DynArray<Typ> speicher = new DynArray<>();
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
        return speicher.getSize();
    }

    @Override
    public boolean isEmpty() {
        return speicher.getSize() == 0;
    }

    @Override
    public Typ first() {
        return speicher.get(0);
    }
    
    @Override
    public String toString() {
        return speicher.toString();
    }
}
