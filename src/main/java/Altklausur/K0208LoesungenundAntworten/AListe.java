package Altklausur.K0208LoesungenundAntworten;
/*
* Dateiname : AListe . java
* Tom Keppeler , Matrikelnummer
*
* Implementieren Sie eine generische abstrakte Klasse AListe für
eine Liste von Elementen des Typs T.
* Die Klasse soll die Schnittstelle IListe implementieren .
* Die Klasse soll von daraus abgeleiteten Klassen folgende Methoden
fordern :
*
* public void insert (T v) // Einf ü gen eines neuen Elements am
Listenanfang
* public T removeFirst () // Entnahme des ersten Elements ; gibt den
Wert des ersten + zurück ( oder ’null ’ bei leerer Liste )
*
* public void append (T v) // Anhä ngen eines neuen Elements am
Listenende
* public T removeLast () // Entnahme des letzten Elements ; gibt
den Wert des letzten Listenelements zur ück ( oder ’null ’ bei
leerer Liste )
*
* public T get(int) // Liefert den Wert an der gesuchten
Position . Die erste Position ist 0. Liefert null , wenn die
Position nicht existiert .
* public void extend (int n) // Erweitere die Liste am Ende um ’n’
neue Werte
*
* public int size () // Liefert die Anzahl der gü ltigen Werte in
der Liste ( logische Länge der Liste )
* public void setName ( String s) // Gibt der Liste einen Namen s
* public String name () // Gibt die Bezeichnung einer Liste zur ü
ck ( oder ’null ’, falls kein Name festgelegt wurde )
* Die Klasse soll folgende Methoden vollst ä ndig implementieren :
*
* public int size () // Anzahl der tats ä chlichen Elemente in der
Liste (ggf. ohne leere Listenelemente )
* public void setName ( String s) // Name für diese Liste
* String name () // Liefert den Listennamen , oder ’null ’,
falls dieser nie gesetzt wurde
*/

public abstract class AListe<T> implements IListe<T>{
    private String name = null;
    protected int size = 0; // damit ich es in der Klasse Liste verändern kann aber trotzdem von außen nur über size() erreichbar ist

    public void setName(String s){
        this.name = s;  
    }
    public int size(){
        return this.size;
    }
    public abstract void insert(T v); // Einf ü gen eines neuen Elements am Listenanfang

    public abstract T removeLast(); /*
                                     * Entnahme des letzten Elements ; gibt den Wert des letzten Listenelements zur
                                     * ück ( oder ’null ’ bei leerer Liste )
                                     */

    public abstract T get(int n); /*
                                   * Liefert den Wert an der gesuchten Position . Die erste Position ist 0.
                                   * Liefert null , wenn die Position nicht existiert .
                                   */

    public abstract void extend(int n); // Erweitere die Liste am Ende um ’n’ neue Werte
}
