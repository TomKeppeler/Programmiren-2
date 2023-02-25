package Altklausur.K0208LoesungenundAntworten;
/*
* Dateiname : IListe . java
* Tom Keppeler , Matrikelnummer
*
* Implementieren Sie eine generische Schnittstelle IListe für eine
Liste von Elementen des Typs T.
* Die Schnittstelle soll folgende Methoden fordern :
*
* public void append (T v) // Anhä ngen eines neuen Elements am
Listenende
* public T removeLast () // Entnahme des letzten Elements ; gibt
den Wert des letzten Listenelements zurück ( oder ’null ’ bei
leerer Liste )
*
*/

public interface IListe<T> {
    public void append(T v); // Anhängen eines neuen Elements am Listenende

    public T removeLast(); /*
                            * Entnahme des letzten Elements ; gibt den Wert des letzten Listenelements
                            * zurück ( oder ’null ’ bei leerer Liste )
                            */
}
