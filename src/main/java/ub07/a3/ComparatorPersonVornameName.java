package ub07.a3;

import java.util.Comparator;

import a2.Person;

public class ComparatorPersonVornameName implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        if(!o1.getVorname().equals(o2.getVorname())){
            return o1.getVorname().compareTo(o2.getVorname());
        }
        if(!o1.getName().equals(o2.getName())){
            return o1.getName().compareTo(o1.getName());
        }
        return 0;
    }
}