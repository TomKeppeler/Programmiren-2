package Altklausur.K0208;
//Dateiname: AListe.java
//Tom Keppeler, 9040853
public abstract class AListe<T> implements IListe<T> {
    private int size = 0;
    private String name = null;

    public abstract void insert(T v); // Einfügen eines neuen Elements am Listenanfang.

    public abstract T removeFirst();// Entnahme des ersten Elements. Gibt den Wert des ersten + zurück (oder 'null'
                                    // bei leerer Liste)

    public abstract T get(int i);// Liefert den Wert an der gesuchten Position. Die erste Position is 0. Liefert
                                 // null, wenn die Positon nicht existiert.

    public abstract void extend(int n);// Erweitere die Liste am Ende um 'n' neue Werte

    public int size() { // Liefert die Anzahl der gültigen Werte in der Liste (logische Länge der Liste)
        return this.size;
    }
    protected void sizeErhoehen(){
        this.size++;
    }
    protected void sizeVeringern(){
        this.size--;
    }
    public void setName(String s) { // Gibt der Liste einen Namen s
        this.name = s;
    }

    public String name() { // Liefert den Listenname, oder 'null', falls dieser nie gesetzt wurde
        return this.name;
    }
}
