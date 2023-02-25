package Altklausur.K0208;

import java.util.Comparator;

public class ZFComp<T> implements Comparator<AListe<T>>{

    @Override
    public int compare(AListe<T> o1, AListe<T> o2) {
        return o1.size() - o2.size();
    }    
    
}
