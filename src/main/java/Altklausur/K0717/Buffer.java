package Altklausur.K0717;

public interface Buffer<T> {
    int append(T v); // füge neues Element mit Wert ‘v’ am Ende des
                     // Puffers ein ; gib die Anzahl der Elemente
                    // im Puffer zurück

    T removeFirst(); // entferne das erste Element aus dem Puffer und
                     // gib dessen Wert zurück

    T find(int i); // finde das ‘i’-te Element im Puffer und
                    // gib dessen Wert zurück.
                    // i = 0 findet das erste Element
}
