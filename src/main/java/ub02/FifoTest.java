package ub02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferUnderflowException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class FifoTest {
    Fifo<Integer> fifo = null;
    Integer array[] = {1,2,3,4,5};
    Fifo<String> fifoS = null;
    String arrayS[] = {"1", "2", "3", "4", "5"};
    
    @BeforeEach
    public void setup(){
        fifo = new Fifo<>(5);
        fifoS = new Fifo<>(5);
    }

    @AfterEach
    public void teardown(){
        fifo = null;
        fifo = null;
    }

    @Test
    public void testPushPopS(){
        for (int i = 0; i < arrayS.length-1; i++) {
            fifoS.push(arrayS[i]);
            assertEquals(String.valueOf(1+i), fifoS.pop(), "oop das war falsch in testPushPopS()");
        }
    }

    @Test
   public void testPushPop(){
        for (int i = 0; i < array.length-1; i++) {
            fifo.push(array[i]);
            assertEquals(1+i, fifo.pop(), "oop das war falsch in pop()");
        }
    }
    @Test
    public void testSizeCapacityS(){
        int s = 0;
        for (String i : arrayS) {
            assertEquals(fifoS.size, s, "Größe stimmt nicht");
            fifoS.push(i);
            ++s;
        }
    }
    @Test
    public void testSizeCapacity() {
        int s = 0;
        for (Integer integer : array) {
            assertEquals(fifo.size(), s, "Größe stimmt nicht");
            fifo.push(integer);
            s++;
        }
    }
    @Test
    public void testPositionS(){
        int p = 0;
        for (String i : arrayS) {
            fifoS.push(i);
            assertEquals(fifoS.pop(), arrayS[p], "hier stimmt was nicht");
            p++;
        }
    }   
    @Test
    public void testPosition(){
        int p = 0;
        for (Integer integer : array) {
            fifo.push(integer);
            assertEquals(fifo.pop(), array[p], "hier stimmt was nicht");
            p++;
        }
    }
    @Test
    public void testPopBUEString(){
        assertThrows(BufferUnderflowException.class, () -> fifoS.pop(), "no BUE?");
    } 
    @Test
    public void testPopBUE(){
        assertThrows(BufferUnderflowException.class, () -> fifo.pop(), "no BUE?");
    }    

}
