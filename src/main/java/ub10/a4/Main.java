package ub10.a4;

import ub07.a2.Boxer;
import ub07.a2.Person;
import ub07.a2.Student;
import ub07.a2.Tier;
import ub09.a1bis6.Folge;
import ub09.a1bis6.FolgemitEVL;
import ub09.a1bis6.Puffer;
import ub09.a1bis6.SchlangemitDynArray;
import ub10.a2unda3.GenericUtil;
public class Main {
    public static void main(String[] args) {
        Person p;
        Person p1 = new Student("Mustermann1", "Max1", 9043235);
        Person p2 = new Student("Mustermann2", "Max2", 9045235);
        Student s1 = new Student("Mustermann3", "Max3", 9043275);
        Puffer<Student> ps1 = new FolgemitEVL();
        Puffer<Student> ps2 = new SchlangemitDynArray();
        Puffer<Boxer> pb = new FolgemitEVL();
        Folge<Person> fp = new FolgemitEVL();
        Boxer b2 = new Boxer("Meyerhoff", "John", 80);
        var t = new Tier("Hund");
        Object o;
        p = GenericUtil.gambling(p1,p2);
        p = GenericUtil.gambling(p1,s1);
        p = GenericUtil.gambling(s1,b2);
        p = (Person) GenericUtil.gambling(p1,t);
        o = GenericUtil.gambling(p1,t);
        GenericUtil.insertInto(ps2,ps1);
        GenericUtil.insertInto(ps1,ps2);
    }

    // method that calculats the greates same dividor with negativ imputs

}
