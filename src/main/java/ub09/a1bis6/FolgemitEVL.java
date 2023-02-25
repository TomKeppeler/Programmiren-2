package ub09.a1bis6; 
import java.util.Iterator;

public class FolgemitEVL<Typ> implements Folge<Typ>{
    private EVL<Typ> speicher = new EVL<>();
    @Override
    public void insert(Typ e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return speicher.getSize();
    }

    @Override
    public boolean isEmpty() {
        return speicher.isEmpty();
    }

    @Override
    public void insert(int pos, Typ e) {
        speicher.add(pos, e);
    }

    @Override
    public Typ get(int pos) {
        Typ temp = this.speicher.remove(pos);
        this.speicher.add(pos, temp);
        return temp;
    }

    @Override
    public void set(int pos, Typ e) {
        this.speicher.remove(pos);
        this.speicher.add(pos, e);
    }

    @Override
    public void remove(int pos) {
        this.speicher.remove(pos);
    }

    @Override
    public Iterator<Typ> iterator() {
        return speicher.iterator();
    }
}
