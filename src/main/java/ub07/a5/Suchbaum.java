package ub07.a5;

import ub07.a2.Boxer;

import java.util.Comparator;
import java.util.NoSuchElementException;

/*<!---------------------------
Name: IntSuchbaum
File: IntSuchbaum.java
-----------------------------
Author: Klara Golubovic und John Meyerhoff
Data:   1.6.2021, 11:38:40
---------------------------->*/

public class Suchbaum<Typ> extends Binaerbaum<Typ> {
    Comparator<Typ> comp =null;

    Suchbaum() {
        super();
    }

    Suchbaum(Comparator<Typ> comp) {
        super();
        this.comp = comp;
    }

    public void insert(Typ i) {
        if (isEmpty()) {
            this.wurzel = new BaumEl<Typ>(i);
        } else {
            insert(i, this.wurzel);
        }
    }

    private void insert(Typ i, BaumEl<Typ> e) {
        if (this.helpCompare(e.data, i) == 0) { // Wenn gleich dann gibt compereTo 0 zurück
            throw new IllegalArgumentException();
        }
        if (e.data == null) {
            e.data = i;
        }
        if (this.helpCompare(e.data, i) > 0) { // wenn data größer dann gibt compareTo einen Positiven Wert zurück
            if (e.left == null) {
                e.left = new BaumEl<Typ>(i);
            } else {
                insert(i, e.left);
            }
        } else {
            if (e.right == null) {
                e.right = new BaumEl<Typ>(i);
            } else {
                insert(i, e.right);
            }
        }
    }

    public boolean contains(Typ i) {
        return contains(this.wurzel, i);
    }

    public boolean contains(BaumEl<Typ> e, Typ i) {
        if (e == null) {
            return false;
        }
        if (e.data == null) {
            return false;
        }
        if (this.helpCompare(e.data, i) == 0) { // Wenn gleich dann gibt compereTo 0 zurück
            return true;
        } else if (this.helpCompare(i, e.data) < 0) { // wenn data kleiner dann gibt compareTo einen Negativen
                                                               // Wert zurück
            return contains(e.left, i);
        } else { // i > e un dementsprechend right
            return contains(e.right, i);
        }
    }

    public String myToString() {
        if (wurzel == null)
            return "";

        StringBuilder sb = new StringBuilder();

        myToString(sb, wurzel.right, false, "");
        sb.append(wurzel.data).append('\n');
        myToString(sb, wurzel.left, true, "");

        return sb.toString();
    }

    private void myToString(StringBuilder sb, BaumEl<Typ> n, boolean left, String indent) {
        if (n == null)
            return;

        myToString(sb, n.right, false, indent + (left ? "│   " : "    "));

        sb.append(indent).append(left ? "└── " : "┌── ");
        sb.append(n.data).append('\n');

        myToString(sb, n.left, true, indent + (left ? "    " : "│   "));
    }

    public void remove(Typ i) {
        if (contains(i)) {
            if (this.helpCompare(this.wurzel.data, i) == 0) {
                if (this.helpCompare(this.wurzel.data, i) == 0 && (wurzel.right == null && wurzel.left == null)) {
                    wurzel = new BaumEl<Typ>(null);
                } else if (wurzel.left == null && wurzel.right != null) {
                    wurzel = wurzel.right;
                } else if (wurzel.right == null && wurzel.left != null) {
                    wurzel = wurzel.left;
                } else if (wurzel.right != null && wurzel.left != null) {
                    wurzel = wurzel.left;
                    while (wurzel.right != null) {
                        wurzel = wurzel.right;
                    }
                    wurzel = new BaumEl<Typ>(null);
                }
            } else {
                remove(this.wurzel, i);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    // ja ja ja :)
    public void remove(BaumEl<Typ> tmp, Typ i) {
        if (tmp.data != i) { // i finden
            if (this.helpCompare(i, tmp.data) < 0) {
                if (tmp.left.data == i) {
                    if (this.helpCompare(tmp.left.data, i) == 0 && (tmp.left.right == null && tmp.left.left == null)) {
                        tmp.left = null;
                    } else if (tmp.left.left == null && tmp.left.right != null) {
                        tmp.left = tmp.left.right;
                    } else if (tmp.left.right == null && tmp.left.left != null) {
                        tmp.left = tmp.left.left;
                    } else if (tmp.left.right != null && tmp.left.left != null) {
                        tmp.left = tmp.left.left;
                        while (tmp.left.right != null) {
                            tmp.left = tmp.left.right;
                        }
                        tmp.left = null;
                    }
                } else {
                    remove(tmp.left, i);
                }
            } else {
                if (this.helpCompare(tmp.right.data, i) == 0) {
                    if (this.helpCompare(tmp.right.data, i) == 0 && (tmp.right.right == null && tmp.right.left == null)) {
                        tmp.right = null;
                    } else if (tmp.right.left == null && tmp.right.right != null) {
                        tmp.right = tmp.right.right;
                    } else if (tmp.right.right == null && tmp.right.left != null) {
                        tmp.right = tmp.right.left;
                    } else if (tmp.right.right != null && tmp.right.left != null) {
                        tmp.right = tmp.right.left;
                        while (tmp.right.right != null) {
                            tmp.right = tmp.right.right;
                        }
                        tmp.right = null;
                    }
                } else {
                    remove(tmp.right, i);
                }
            }
        }
    }
    private int helpCompare(Typ a, Typ b){
        if (comp == null){
            Comparable c =  (Comparable) a;             //sehr gefährlich, kann sein dass T garkein Comparable implementiert hat
            return c.compareTo(b);
        }
        else{
            return comp.compare(a, b);
        }
    }

    public static void main(String[] args) {
        Suchbaum<Boxer> b = new Suchbaum();
        b.insert(new Boxer("Mohamed",  "Ali", 100));
        b.insert(new Boxer("Mohamed",  "Bli", 300));
        b.insert(new Boxer("Aohamed",  "Ali", 300));
        System.out.println(b.toString());
    }
}