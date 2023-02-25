package ub03.a1;

import java.util.NoSuchElementException;

/*Prog2: Aufgabenblatt 03
<!---------------------------
Name: einfach Verkettete Listen
File: EVL.java
-----------------------------
Author: Tom Keppeler
Data:   27.4.2021, 17:39:25
---------------------------->*/

public class EVL<Typ> {
    class Listenelement { // Listenelement als innere Klasse
        Typ data;
        Listenelement next = null; // Z. auf naechstes Element

        Listenelement(Typ data) { // Konstruktor
            if (data == null){
                throw new IllegalArgumentException();
            }
            this.data = data;
        }
    }

    private Listenelement first = null; // Zeiger auf erstes Element
    private Listenelement last = null; // Zeiger auf letztes Element
    private int size = 0;

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return this.first == null;
    }

    public void addFirst(Typ e) {
        Listenelement element = new Listenelement(e); // neues Element
        if (isEmpty()) {
            this.last = element;
            this.first = element;
        } else {
            element.next = this.first;
        }
        this.first = element;
        size++;
    }

    public Typ removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        Typ d = last.data;
        if (first == last) {
            last = null;
            first = null;
        } else {
            if (first.next == last) {
                // first.next = null;
                last = first;
                last.next = null;
            } else {
                Listenelement index = first;
                while (index.next != last) {
                    index = index.next;
                }
                index.next = null;
                last = index;
            }
        }
        size--;
        return d;
    }

    // Start des Aufgabenteils 1
    public void addLast(Typ input) {
        Listenelement element = new Listenelement(input);
        if (size == 0) {
            this.first = element;
            //this.first.next = element;
            this.last = element;
        } else {
            this.last.next = element;
            this.last = element;
        }
        size++;
    }

    public Typ removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Typ ret = this.first.data;
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
        }
        this.size--;
        return ret;
    }

    public void add(int pos, Typ input) {
        if (pos != 0){
            if(pos > this.size){
                throw new IllegalArgumentException("wrong position: " + pos); 
            }
        }
        if (0 > pos){
            throw new IllegalArgumentException("wrong position: " + pos);    
        }
        if (pos == 0) {
            Listenelement naechstesElement = this.first;
            this.first = new Listenelement(input);
            this.first.next = naechstesElement;
        } else {
            Listenelement neu = new Listenelement(input);
            Listenelement element = this.first;
            for (int i = 1; i < pos; i++) {
                element = element.next;
            }
            neu.next = element.next;
            element.next = neu;
        }
        size++;
    }

    public Typ remove(int pos) {
        if (pos != 0){
            if(1 + pos > size){
                throw new IllegalArgumentException("wrong position: " + pos); 
            }
        }
        if (0 > pos){
            throw new IllegalArgumentException("wrong position: " + pos);    
        }
        if (pos == 0) {
           return removeFirst();
        } else if (pos == size-1) {
           return removeLast();
        } 
        Listenelement index = this.first;
        for (int i = 0; i < pos-1; i++) {
            index = index.next;
        }
        Typ ret = index.next.data;
        index.next = index.next.next;
        return ret;
    }

    public String toString() {
        String out = "{";
        Listenelement index = this.first;
        while (index != null) {
            if (index != this.first) {
                out += ",";
            }
            out += index.data;
            index = index.next;
        }
        return out + "}";
    }

    public boolean contains(Typ e){
        Listenelement index = this.first;
        while(index.next != null){
            if(index.data.equals(e)){
                return true;
            }
            index = index.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        EVL<Integer> liste = new EVL<>();
        for (int i = 0; i < 10; i++) {
            liste.add(i, 2);
        }
        System.out.println(liste.toString());
    }
}
