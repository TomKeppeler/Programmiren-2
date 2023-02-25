package Altklausur.K0208LoesungenundAntworten;

/*
* Dateiname : Liste . java
* Tom Keppeler , Matrikelnummer
*
* Implementieren Sie die Klasse Liste als eine generische einfach
verkettete Liste .
* Die einzelnen Listenelemente sollen als interne Klasse E
implementiert werden .
*
* Die Klasse soll die Klasse AListe erweitern und alle notwendigen
Methoden implementieren . Dabei hat die Methode ’extend () ’ keine
Funktion .
* Dar über hinaus sollen folgende Methoden implementiert werden :
* Liste () // Konstruktor
* String toString () // Liefert den Inhalt der Liste in folgender
Form : [wert1 , wert2 , ... , wertn ]
*
*/

public class Liste<T> extends AListe<T> {

    private class E {
        E next;
        T data;

        public E(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private E first = null;

    public Liste() {
    }

    private boolean isEmpty() {
        return first == null;
    }

    @Override
    public void append(T v) {
        E neu = new E(v);
        if (this.isEmpty()) {
            this.first = neu;
        } else {
            E index = this.first;
            while (index.next != null)
                index = index.next;
            index.next = neu;
            //this.first = index;
        }
        ++super.size;
    }

    @Override
    public void insert(T v) {
        E neu = new E(v);
        if (this.isEmpty()) {
            this.first = neu;
        } else {
            neu.next = this.first;
            this.first = neu;
        }
        ++super.size;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty())
            throw new IllegalArgumentException();
        T ret = null;
        if(super.size == 1){
            ret = first.data;
            first = null;
        }else{
        E index = this.first;
        while (index.next.next != null){
            index = index.next;
        }
        ret = index.next.data;
        index.next = null;
        }
        --this.size;
        return ret;
    }

    @Override
    public T get(int n) {
        if (super.size() == 0 || n >= super.size())
            return null;
        E index = this.first;
        for (int i = 0; i < n; i++) {
            index = index.next;
        }
        return index.data;
    }

    @Override
    public void extend(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(){
        E index = this.first;
        String ret = "[";
        while (index != null) {
            if (index != this.first) {
                ret += ", ";
            }
            ret += index.data;
            index = index.next;
        }
        return ret + "]";
    }
    public static void main(String[] args) {
        Liste<Integer> speicher = new Liste<>();
        for(int i = 0; i<5; i++)
            speicher.append(i);
        System.out.println(speicher.toString());
        for(int i = 0; i<5; i++)
            System.out.println(speicher.removeLast());
        System.out.println(speicher.toString());
    }
}
