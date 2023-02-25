package Altklausur.K0717;

import java.util.Comparator;
import java.util.Iterator;

public class ListeUtil {
    public static <U> Paar<Liste<U>> split(Liste<U> ueber, U grenze, Comparator<U> comp){
        Liste<U> a = new ListeAlsFeld<>(ueber.size());
        Liste<U> b = new ListeAlsFeld<>(ueber.size());
        Iterator<U> uI = ueber.iterator();
        while(uI.hasNext()){
            U tmp = uI.next();
            if(comp.compare(tmp, grenze) < 0)
                a.add(tmp);
            else
                b.add(tmp);
        }
        return new Paar<Liste<U>>(a,b);
    }
    public static void main(String[] args) {
        ListeAlsFeld<Integer> t = new ListeAlsFeld<>(10);
        for (int i = 0; i < 10; i++) 
            t.add(i);
        Paar<Liste<Integer>> a = split(t, 4, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        }
        );
        System.out.println(a.toString());
    }
}
