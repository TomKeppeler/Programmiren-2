package Altklausur.K0208;
//Dateiname: IListe.java
//Tom Keppeler, 9040853
public interface IListe<T> {
    public void append(T v); //Anhängen eines neuen Elements am Listenende.
    public T removeLast(); //Entnahme des letzten Elements. gibt den Wert des letzten Listenelements zurück (oder 'null' bei leerer Liste).
}
