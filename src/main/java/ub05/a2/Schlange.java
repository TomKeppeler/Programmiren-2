package ub05.a2;

import ub02.Fifo;

public class Schlange<Typ> implements Puffer<Typ> {
    private Fifo<Typ> speicher = new Fifo<Typ>(); 

    @Override
    public void insert(Typ e) {
        speicher.push(e);
    }

    @Override
    public void remove() {
        speicher.pop();
    }

    @Override
    public int size() {
        return speicher.size();
    }

    @Override
    public boolean isEmpty() {
        return speicher.size() == 0;
    }

    public Typ first(){
        return speicher.pop();
    }
    public static void main(String[] args) {
        Schlange<Integer> t = new Schlange<>();
        for (int i = 0; i < 10; i++) {
            t.insert(i);
        }
        System.out.println(t.first());
    }
}
