package Altklausur.K0208LoesungenundAntworten;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ZFi extends ZF implements Iterable<Integer>{
    private class IteratorZFi implements Iterator<Integer>{//interne Klasse von ZFi implementiert Iterator
        int i = 0; //interner zähler
            @Override
            public boolean hasNext(){
                return get(i) != null;//wenn an der stelle kein wert ist wird false zurückgegeben
            }
            @Override
            public Integer next() {
                if(hasNext())
                    throw new NoSuchElementException();
                return get(i++);//rückgbae des wertes an der stelle des zählers
            }
    }
    @Override
    public Iterator<Integer> iterator() {//gibt die interne klasse nach außen weiter.
        return new IteratorZFi();
    }
    
}
