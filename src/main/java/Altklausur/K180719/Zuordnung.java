package Altklausur.K180719;
/**
 * @author Tom Keppeler
 * Aufgabe 2
 */
public interface Zuordnung<K, V> {
    boolean isEmpty(); // gibt an, ob die Zuordnung leer ist

    int size(); // gibt die Anzahl der vorgesehenen Schlüssel an

    V get(K k); // liefert den dem Schlüssel k zugeordneten Wert – oder (s.o.) null, falls dem
                // Schlüssel kein Wert zugeordnet ist

    void insert(K k, V v); // fügt den Schlüssel k ein und ordnet ihm den Wert v zu
}
