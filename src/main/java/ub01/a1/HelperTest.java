package ub01.a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ub00.Fifo;
import ub00.Helper;

class HelperTest {
    Fifo f = null;
    Integer feld[] = {1,2,3,4,5,6,7,8};

    @BeforeEach
    void setup() {
        f = new Fifo(8);
        for(Integer inhalt: feld) {  //geht durch Schleife durch, i wird erstellt, ein Wert aus Feld wird reingetan
            f.push(inhalt);
        }
    }

    @AfterEach
    void teardown() {
        f = null;
    }

    @Test
    void testMove() {
        Fifo f2 = new Fifo(10);  //mehr als source
        Helper.move(f, f2);
        for(Integer inhalt: feld) {
            assertEquals(inhalt,f2.pop());
        }
    }

    @Test
    void testIAE() {
        Fifo f2 = new Fifo(5); //kleiner als 8(source)
        assertThrows(IllegalArgumentException.class,()-> Helper.move(f,f2));
    }
}
