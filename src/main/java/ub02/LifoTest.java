package ub02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferUnderflowException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class LifoTest {
    Lifo<Integer> lifo = null;
    Integer array[] = {1,2,3,4,5};
    Lifo<String> lifoS = null;
    String arrayS[] = {"1", "2", "3", "4", "5"};
    @BeforeEach
    public void setup(){
        lifo = new Lifo<>(5);
        lifoS = new Lifo<>(5);
    }

    @AfterEach
    public void teardown(){
        lifo = null;
        lifo = null;
    }

    @Test
    public void testPushPopS(){
        for (int i = 0; i < arrayS.length-1; i++) {
            lifoS.push(arrayS[i]);
            assertEquals(String.valueOf(1+i), lifoS.pop(), "oop das war falsch in testPushPopS()");
        }
    }

    @Test
   public void testPushPop(){
        for (int i = 0; i < array.length-1; i++) {
            lifo.push(array[i]);
            assertEquals(1+i, lifo.pop(), "oop das war falsch in pop()");
        }
    }
    @Test
    public void testSizeCapacityS(){
        int s = 0;
        for (String i : arrayS) {
            assertEquals(lifoS.size, s, "Größe stimmt nicht");
            lifoS.push(i);
            ++s;
        }
    }
    @Test
    public void testSizeCapacity() {
        int s = 0;
        for (Integer integer : array) {
            assertEquals(lifo.size(), s, "Größe stimmt nicht");
            lifo.push(integer);
            s++;
        }
    }
    @Test
    public void testPositionS(){
        int p = 0;
        for (String i : arrayS) {
            lifoS.push(i);
            assertEquals(lifoS.pop(), arrayS[p], "hier stimmt was nicht");
            p++;
        }
    }   
    @Test
    public void testPosition(){
        int p = 0;
        for (Integer integer : array) {
            lifo.push(integer);
            assertEquals(lifo.pop(), array[p], "hier stimmt was nicht");
            p++;
        }
    }
    @Test
    public void testPopBUEString(){
        assertThrows(BufferUnderflowException.class, () -> lifoS.pop(), "no BUE?");
    } 
    @Test
    public void testPopBUE(){
        assertThrows(BufferUnderflowException.class, () -> lifo.pop(), "no BUE?");
    }    

}
