package ub03.a5;

public interface RDVLInterface<Typ> {
    boolean isEmpty();
    int getSize();
    void add(Typ e);
    Typ remove();
    Typ element();
    void next(int s);
    void prev(int s);
}
