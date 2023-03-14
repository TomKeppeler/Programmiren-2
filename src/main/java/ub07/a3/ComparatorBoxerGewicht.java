package ub07.a3;

import ub07.a2.Boxer;

import java.util.Comparator;


public class ComparatorBoxerGewicht implements Comparator<Boxer> {
    @Override
    public int compare(Boxer o1, Boxer o2) {
        return o1.getGewicht() - o2.getGewicht();
    }
}
