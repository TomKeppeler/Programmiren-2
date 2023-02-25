package ub05.a2.nachAufgabenStellung;

public interface Puffer<Typ> {
    void insert(Typ e);

    void remove();

    int size();

    boolean isEmpty();
}
