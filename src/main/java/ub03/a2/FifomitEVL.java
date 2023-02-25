package ub03.a2;

import a1.EVL;

public class FifomitEVL<Typ> implements FifoIF<Typ>{

    EVL<Typ> liste = new EVL<>();

    @Override
    public void push(Typ e) {
        liste.addLast(e);
    }

    @Override
    public Typ pop() {
        return liste.removeFirst();
    }

    @Override
    public Typ peek() {
        Typ ret = liste.removeLast();
        liste.addLast(ret);
        return ret;
    }

    @Override
    public int size() {
        return liste.getSize();
    }

    @Override
    public boolean isEmpty() {
        return liste.isEmpty();
    }
    
}
