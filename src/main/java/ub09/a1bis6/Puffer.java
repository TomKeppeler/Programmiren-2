package ub09.a1bis6;
public interface Puffer<Typ> extends Iterable<Typ>{
    void insert(Typ e);

    void remove();

    int size();

    boolean isEmpty();
}
