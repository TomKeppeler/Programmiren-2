package Altklausur.K0717;

public interface Liste<T> extends Iterable<T>{
    boolean add(T t); //true wenn das element erfolgreich hinzugefügt wurde, am ende der liste.
    int size();
}
