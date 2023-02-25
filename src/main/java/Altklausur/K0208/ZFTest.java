package Altklausur.K0208;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ZFTest {
    ZF test = new ZF();

    @AfterEach
    public void reset(){
        test = new ZF();
    }

    @Test 
    public void testGet(){
        test.append(1);
        assertEquals(1, test.get(0));
        test.append(2);
        assertEquals(2, test.get(1));
        test.append(3);
        assertEquals(3, test.get(2));
        test.append(null); 
        assertEquals(null, test.get(3));
        test.append(-1);
        assertEquals(-1, test.get(4));
    }

    @Test
    public void testExtend(){
        test.extend(-1);
        assertEquals(0, test.size()); //schleife wird nicht durchlaufen
        test.extend(0);
        assertEquals(0, test.size()); //schleife wird nicht durchlaufen
        test.extend(3);
        assertEquals(4, test.get(2));
        assertEquals(3, test.size());
        test.extend(3);
        assertEquals(6, test.size());
        assertEquals(16, test.get(4));
    }

}
