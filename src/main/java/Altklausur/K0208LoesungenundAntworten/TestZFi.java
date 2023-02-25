package Altklausur.K0208LoesungenundAntworten;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestZFi {
    ZF test;

    @BeforeEach
    public void setup() {
        test = new ZF();
    }

    @AfterEach
    public void destroy() {
        test = null;
    }

    @Test
    public void nullTest() {
        test.extend(0); // Test mit 0
        assertEquals(0, test.size); // die schleife wird nicht durchlauen demnach wird auch der erste wert nich
                                    // hinzugefühgt. was dazu führt das die größe bei 0 bleibt.
    }

    @Test
    public void negativTest() {
        test.extend(-1); // Test mit -1
        assertEquals(0, test.size); // die schleife wird nicht durchlauen demnach wird auch der erste wert nich
                                    // hinzugefühgt. was dazu führt das die größe bei 0 bleibt.
    }

    @Test
    public void normalFunktionTest() {// hier wird getestet ob die methode extend das macht was sie soll
        test.extend(1);
        assertEquals(1, test.size());// wenn eine weiter folge hinzugefüght wurden ist, soll size auf 1 sein
    }

    @Test
    public void aufeinanderfolgeTest() {// die größe muss mit aufeinader folgenden extend aufrufen mit steigen
        test.extend(3);
        test.extend(5);
        assertEquals(8, test.size());
    }

}
