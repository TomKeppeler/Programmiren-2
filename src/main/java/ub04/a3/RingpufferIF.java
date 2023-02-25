package ub04.a3;
public interface RingpufferIF<Typ> {
    int size();
    Typ get(int pos);
    Typ set(int pos, Typ e);
    void addFirst( Typ e);
    void addLast( Typ e);
    Typ removeFirst();
    Typ removeLast();
}
