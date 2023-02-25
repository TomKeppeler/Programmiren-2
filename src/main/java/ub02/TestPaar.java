package ub02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class TestPaar {
    Paar<Integer, String> pIS = null;
    @BeforeEach
    void setup(){
        pIS = new Paar<>(1, "2");
    }

    @AfterEach
    void teardown(){
        pIS = null;
    }

    @Test
    void testsetErstes(){
        assertEquals(1, pIS.setErstes(2));
        assertEquals(2, pIS.getErstes());
    }

    @Test
    void testsetZweites(){
        assertEquals("1", pIS.setZweites("2"));
        assertEquals("2", pIS.getZweites());
    }

    @Test
    void testsetBeides(){
        pIS.setBeide(1, "1");
        assertEquals(1, pIS.getErstes());
        assertEquals("1", pIS.getZweites());
    }
    @Test
    void testEquals(){
        Paar<Integer, String> p2 = new Paar<>(1, "2");
        assertTrue(pIS.equals(p2));
    }

    @Test
    void testtoString(){
        assertEquals(pIS.toString(), "(1," + "2".toString() + ")");
    }
}
