package ub07.zusatz;

import java.util.Comparator;

public class HashCodeComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.hashCode() - o2.hashCode();
    }

    
}
