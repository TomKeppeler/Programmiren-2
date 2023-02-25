package ub07.a4;
/*<!---------------------------
Name: Binearbaum
File: Binearbaum.java
-----------------------------
Author: Tom Keppeler
Data:   20.5.2021, 22:25:55
---------------------------->*/

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Binaerbaum<Typ> {

    protected BaumEl<Typ> wurzel = null;

    public Binaerbaum() {
        wurzel = new BaumEl<>(null);
    }

    public Binaerbaum(Typ input, BaumEl<Typ> left, BaumEl<Typ> right) {
        this.wurzel = new BaumEl<>(input);
        this.wurzel.left = left;
        this.wurzel.right = right;
    }

    public boolean isEmpty() {
        if (wurzel == null){
            return true;
        }else{
            return wurzel.data == null;
        }
        
    }

    private int hoehe(BaumEl<Typ> wurzel) {
        if (wurzel == null) {
            return 0;
        } else {
            int l = hoehe(wurzel.left);
            int r = hoehe(wurzel.right);
            if (l > r) {
                return l + 1;
            } else {
                return r + 1;
            }
        }
    }

    public int hoehe() {
        return hoehe(this.wurzel);
    }

    public int size() {
        return size(this.wurzel);
    }

    private int size(BaumEl<Typ> wurzel) {
        if (wurzel == null){
            return 0;
        }
        if (wurzel.data == null) {
            return 0;
        }
        return size(wurzel.left) + 1 + size(wurzel.right);
    }

    public int sizeJ() {
        return sizerek(this.wurzel);
    }

    private int sizerek(BaumEl<Typ> e) {
        if (e.data == null) {
            return 0;
        }
        if (e.left == null && e.right == null) {// Ende hier
            return 1;
        }
        if (e.left == null) {// rechts safecall inhalt und left nix
            return sizerek(e.right) + 1;
        } else {
            if (e.right == null) {// left safecall inhalt und rechts nix
                return sizerek(e.left) + 1;
            } else {// IN BEIDEN ist safecall noch was drin
                int linkeseite = sizerek(e.left);
                int rechteseite = sizerek(e.right);
                return linkeseite + rechteseite + 1;
            }
        }
    }
    @Override
    public String toString() {
        return toString(this.wurzel);
    }

    private String toString(BaumEl<Typ> wurzel) {
        if (wurzel == null) {
            return "";
        }
        return "<" + toString(wurzel.left) + "><" + wurzel.data + "><" + toString(wurzel.right) + ">";
    }

    public void printTree() {
        System.out.println(this);
    }

    private String preordertoString() {
        return traveler(this.wurzel, "", 1);
    }

    private String inordertoString() {
        return traveler(this.wurzel, "", 2);
    }

    private String postordertoString() {
        return traveler(this.wurzel, "", 3);
    }

    public void preorder() {
        System.out.println(preordertoString());
    }

    public void inorder() {
        System.out.println(inordertoString());
    }

    public void postorder() {
        System.out.println(postordertoString());
    }

    private String traveler(BaumEl<Typ> wurzel, String out, int traveler) {
        if (wurzel == null) {
            return out;
        }
        switch (traveler) {
            case 1: // preorder
                out += wurzel.data;
                out = traveler(wurzel.left, out, traveler);
                out = traveler(wurzel.right, out, traveler);
                break;
            case 2: // inorder
                out = traveler(wurzel.left, out, traveler);
                out += wurzel.data;
                out = traveler(wurzel.right, out, traveler);
                break;
            case 3: // postorder
                out = traveler(wurzel.left, out, traveler);
                out = traveler(wurzel.right, out, traveler);
                out += wurzel.data;
                break;
        }
        return out;
    }

    public void insert(Typ neu) {
        if (size() == 0) {
            this.wurzel = new BaumEl<>(neu);
        } else {
            // nicht im ersten Element einzufügen
            if (istVoll(this.wurzel)) {
                BaumEl<Typ> griff = this.wurzel;
                while (griff.left != null) {
                    griff = griff.left;
                } // griff.links ist null & griff ist in der untersten Ebene ganz links
                griff.left = new BaumEl<>(neu);
            } else {
                insertWherePossible(neu, this.wurzel);
            }
        }
    }

    private String toString2(BaumEl<Typ> e) {
        if (e.left == null && e.right == null) {// Ende hier
            return e.data.toString();
        }
        if (e.left == null) {// rechts safecall inhalt und links nix
            return ("<" + e.data.toString() + "> <" + toString2(e.right)+">");
        } else {
            if (e.right == null) {// Links safecall inhalt und rechts nix
                return ("<" + e.data.toString() + "> <" + toString2(e.left)+">");
            } else {// IN BEIDEN ist safecall noch was drin
                String linkeseite = toString2(e.left);
                String rechteseite = toString2(e.right);
                return "<" + linkeseite + "> <" + e.data.toString()+ "> <"  + rechteseite + ">";
            }
        }
    }

    private boolean istVoll(BaumEl<Typ> x) {
        int tiefe = hoehe(x);
        int anzahl = this.size();
        return (anzahl == Math.pow(2, tiefe) - 1);
    }

    private void insertWherePossible(Typ element, BaumEl<Typ> e) {
        if (e.data == null){
            e.data = element;
            return;
        }
        if (e.left == null) {// rechts safecall inhalt und links nix
            e.left = new BaumEl<Typ>(element);
        } else {
            if (e.right == null) {// Links safecall inhalt und rechts nix
                e.right = new BaumEl<Typ>(element);
            } else {// IN BEIDEN ist safecall noch was drin
                if (istVoll(e.left)) {
                    insertWherePossible(element, e.right);
                } else {
                    insertWherePossible(element, e.left);
                }
            }
        }
    }
    private String repeat(String x, int amount){
        return IntStream.range(0, amount).mapToObj(i -> x).collect(Collectors.joining(""));
    }
    public String baum(){
        var out = "";
        int h = this.hoehe();
        for(int i=0; i< h;i++){
            out += "\n";
            out += repeat(" ", 4*(h-i));
            //out += this.toString2(this.wurzel);
            out += this.wurzel.slice(i);
        }
        return out;
    }
    
    public static void main(String[] args) {
        Binaerbaum<Integer> speicher = new Binaerbaum<>();
        int[] test = {1,2,3,4,5,6,7};
        for (int x : test) {
            speicher.insert(x);
        }
        System.out.println(speicher.toString2(speicher.wurzel));
        speicher.postorder();
        speicher.preorder();
        speicher.inorder();
       // System.out.println(speicher.baum());
    }
}
