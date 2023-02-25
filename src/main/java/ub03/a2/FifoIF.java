package ub03.a2;

public interface FifoIF<Typ> {
    void push(Typ e);
    Typ pop();
    Typ peek();
    int size();
    boolean isEmpty();
}
