package ub01.a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferUnderflowException;

import org.junit.jupiter.api.*;

import ub00.*;

public class LifoTest {
    Lifo fLifo = null;
    Integer array[] = {5,4,3,2,1};
    
    @BeforeEach
    public void setup(){
        fLifo = new Lifo(5);
    }
   
    @AfterEach
    public void teardown(){
        fLifo = null;
    }

    @Test
    public void testPushPop(){
         for (int i = array.length; i < 0; i++) {
             fLifo.push(array[i]);
             assertEquals(1+i, fLifo.pop(), "oop das war falsch in pop()");
         }
     }
     @Test
     public void testSizeCapacity() {
         int s = 0;
         for (Integer integer : array) {
             assertEquals(fLifo.size(), s, "Größe stimmt nicht");
             assertEquals(fLifo.capacity(), fLifo.capacity(), "Kapazität stimmt nicht");
             fLifo.push(integer);
             s++;
         }
     }
     @Test
     public void testPosition(){
         int p = 0;
         for (Integer integer : array) {
             fLifo.push(integer);
             assertEquals(fLifo.pop(), array[p], "hier stimmt was nicht");
             p++;
         }
     }
     @Test
     public void testPopBUE(){
        assertThrows(BufferUnderflowException.class, () -> fLifo.pop(), "no BUE?");
    }
}
