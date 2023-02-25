package ub09.a1bis6;

import java.util.Comparator;

public class FolgeComp implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
    
}
