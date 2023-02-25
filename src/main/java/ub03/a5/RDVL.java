package ub03.a5;
/*<!---------------------------
Name: ub03
File: RDVL.java
-----------------------------
Author: Tom Keppeler
Data:   2.5.2021, 18:24:23
---------------------------->*/
public class RDVL<Typ> implements RDVLInterface<Typ>{
    class Listenelement { // Listenelement als innere Klasse
        Typ data;
        Listenelement prev = null; // Z. auf vorheriges Element
        Listenelement next = null; // Z. auf naechstes Element

        Listenelement(Typ data) { // Konstruktor
            if (data == null){
                throw new IllegalArgumentException();
            }
            this.data = data;
        }
    }
    private Listenelement entry = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return this.entry == null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void add(Typ e) {
        Listenelement input = new Listenelement(e);
        if(this.isEmpty()){
            this.entry = input;
            this.entry.prev = input;
            this.entry.next = input;
        }else{
            Listenelement vorEntry = this.entry.prev;
            this.entry.prev = input;
            input.next = this.entry;
            vorEntry.next = input;  
            input.prev = vorEntry;
        }
        size++;
    }

    @Override
    public Typ remove() {
        Typ ret = null;
        if (!this.isEmpty()){
            ret = this.entry.data;
            this.entry.prev.next = this.entry.next;
            this.entry.next.prev = this.entry.prev;
            this.entry = this.entry.next;
            this.size--;
        }
        return ret;
    }

    @Override
    public void next(int s) {
        for(int i = 0; i < s; i++){
            this.entry = this.entry.next;
        }
    }

    @Override
    public void prev(int s) {
        Listenelement index = this.entry;
        for(int i = 0; i < s; i++){
            index = index.prev;
        }
        this.entry = index;
    }

    @Override
    public Typ element() {
        Typ ret = null;
        if (!this.isEmpty()){
            ret = this.entry.data;
        }
        return ret;
    }

    @Override
    public String toString() {
        String out = "{";
        Listenelement index = this.entry;
        for (int i = 0; i < this.getSize(); i++) {
            out += index.data;
            if(i != this.getSize()-1){
                out += ",";
            }
            index = index.next;
        }
        return out + "}";
    }
    public void printList(){
        System.out.println(this.toString());
    }
    public static void main(String[] args) {
        RDVL<Integer> list = new RDVL<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        System.out.println(list.element());
        list.next(2);
        System.out.println(list.element());
    }
}
