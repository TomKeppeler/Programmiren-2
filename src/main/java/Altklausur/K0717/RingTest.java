package Altklausur.K0717;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class RingTest {
    Ring<Integer> test = new Ring<>();
    Integer[] laenge = {1,2,3,4,5,6,7,8};
    @AfterEach
    public void reset(){
        this.test = new Ring<>();
    }
    @Test
    public void testSize(){     
        assertEquals(1, test.getSize());
        test.append(2);
        test.append(23);
        test.append(21);
        assertEquals(4, test.getSize());
        test.removeFirst();
        test.removeFirst();
        assertEquals(2, test.getSize());
    }
    @Test
    public void testAppend(){
        for (Integer var : laenge) 
            test.append(var);
        int i = 0;
        for (Integer var : laenge) 
            assertEquals(var, test.find(i++));
    }
    @Test
    public void testRemoveFirst(){
        test.append(1);
        test.append(2);
        test.append(3);
        test.removeFirst();
        assertEquals(2, test.find(0));
        test.removeFirst();
        assertEquals(3, test.find(0));
    }
}
