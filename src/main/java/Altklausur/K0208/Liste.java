package Altklausur.K0208;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

//Dateiname: Liste.java
//Tom Keppeler, 9040853
public class Liste<T> extends AListe<T>{
    T[] dyn = (T[]) new Object[1];

    public Liste() {
    }

    private void vergroessern(){
        if(super.size() == this.dyn.length){
            T[] tmp = (T[]) new Object[dyn.length * 2];   
            for (int i = 0; i < super.size(); i++) 
                tmp[i] = dyn[i];
            dyn = tmp;
          }
    }
    private void verkleinern(){
        if(super.size() * 4 == this.dyn.length){
            T[] tmp = (T[]) new Object[dyn.length / 2];   
            for (int i = 0; i < super.size(); i++) 
                tmp[i] = dyn[i];
            dyn = tmp;
        }
    }
    @Override
    public void insert(T v) {// Einfügen eines neuen Elements am Listenanfang.
        this.vergroessern();
        for (int i = super.size(); i > 0; i--) {
           this.dyn[i] = this.dyn[i-1];
        }
        this.dyn[0] = v;
        super.sizeErhoehen();
    }

    @Override
    public T removeFirst() {// Entnahme des ersten Elements. Gibt den Wert des ersten + zurück (oder 'null'
                            // bei leerer Liste)
        if(super.size() == 0)
            return null;
        T ret = dyn[super.size()-1];
        for (int i = size(); 0 < i; i--)
            dyn[i-1] = dyn[i];
        super.sizeVeringern();
        return ret;
    }

    @Override
    public void append(T v) {// Anhängen eies neuen Elements am Listenende.
        this.vergroessern();
        this.dyn[this.size()] = v;
        super.sizeErhoehen();
    }

    @Override
    public T removeLast() {// Entnahme des letzten Elements. Gibt den Wert des letzten Listenelements
                            // zurück (oder 'null' bei leerer Liste)
        if(super.size() == 0)
            return null;
        T ret = this.dyn[super.size()-1];
        this.dyn[super.size()-1] = null;
        super.sizeVeringern();
        this.verkleinern();
        return ret;   
    }

    @Override
    public T get(int i) {// Liefert den Wert an der gesuchten Position. Die erste Position is 0. Liefert
                        // null, wenn die Positon nicht existiert.
        if(i > super.size() -1 || i < 0)
            return null;
        return this.dyn[i];
    }

    @Override
    public void extend(int n) {// Erweitere die Liste am Ende um 'n' neue Werte

    }

    @Override
    public String toString() { //gibt einen String zurück mit den Werten der Liste in der Form: [wert1, wert2, ..., wertn]
        String ret = "[";
        for (int i = 0; i < super.size(); i++) {
            if(i != super.size()-1)
                ret += this.dyn[i] + ", ";
            else
                ret += this.dyn[i];
        }
        return ret + "]";
    }   
    public static void main(String[] args) {
        Liste<String> t = new Liste<>();
        for (int i = 0; i < 4; i++)
            t.insert(String.valueOf(i+1));
        System.out.println(t.toString());
    }
}
