package Altklausur.K20190719;

import java.util.Comparator;
import java.util.Iterator;

public class StringLengthComp implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
    
     public static <S> Feld<Integer> giveMatchingIndices(Feld<S> a, Feld<S> b, Comparator<S> comp){
        Feld<Integer> ret = new Feld<>();
        Iterator<S> itA = a.iterator();
        Iterator<S> itB = b.iterator();
        int i = 0;
        while(itA.hasNext() && itB.hasNext()){
            if(comp.compare(itA.next(), itB.next()) == 0)
                ret.addLast(i++);
        }
        return ret;
    }
    public static void main(String[] args) {
        Feld<String> eins = new Feld<>();
        Feld<String> zwei = new Feld<>();
        String[] f1 = {"kurz", "kurz", "laenger", "Zweiundvierzig"};
        String[] f2 = {"laenger", "auch", "kurz", "Zweiundvierzig", "welt"};
        for (String var : f1) 
            eins.addLast(var);
        for (String var : f2)
            zwei.addLast(var);
        Feld<Integer> test = giveMatchingIndices(eins, zwei, new StringLengthComp());
        for (Integer var : test)
            System.out.println(var);
    }
}
