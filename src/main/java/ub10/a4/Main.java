package ub10.a4;

import a2.*;
import ub09.a1bis6.FolgemitEVL;
import ub09.a1bis6.Puffer;
import ub09.a1bis6.SchlangemitDynArray;
import ub10.a2unda3.*;
public class Main {
    public static void main(String[] args) {
        Person p;
        Person p1 = new Person();
        Person p2 = new Person();
        Student s1 = new Student();
        Puffer<Student> ps1 = new FolgemitEVL();
        Puffer<Student> ps2 = new SchlangemitDynArray();
        Puffer<Boxer> pb = new FolgemitEVL();
        Folge<Person> fp = new FolgemitEVL();
        Boxer b2 = new Boxer();
        Tier t = new Tier();
        Object o;
        p = GenericUtil.gambling(p1,p2);
        p = GenericUtil.gambling(p1,s1);
        p = GenericUtil.gambling(s1,b2);
        p = GenericUtil.gambling(p1,t);
        o = GenericUtil.gambling(p1,t);
        GenericUtil.insertInto(pb,ps1);
        GenericUtil.insertInto(ps1,ps2);
        GenericUtil.insertInto(ps1,pb);
        GenericUtil.insertInto(ps1,fp);
    }
}
