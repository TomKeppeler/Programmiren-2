package ub01.a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.BufferUnderflowException;

import org.junit.jupiter.api.*;

import ub00.*;

public class FifoTest {
    Fifo f = null;
    static Integer ai[] = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        f = new Fifo(5);
    }
    @AfterEach
    void teardown(){
        f = null;
    }

   @Test
   public void testPushPop(){
        for (int i = 0; i < ai.length-1; i++) {
            f.push(ai[i]);
            assertEquals(1+i, f.pop(), "oop das war falsch in pop()");
        }
    }
    @Test
    public void testSizeCapacity() {
        int s = 0;
        for (Integer integer : ai) {
            assertEquals(f.size(), s, "Größe stimmt nicht");
            assertEquals(f.capacity(), f.capacity(), "Kapazität stimmt nicht");
            f.push(integer);
            s++;
        }
    }
    @Test
    public void testPosition(){
        int p = 0;
        for (Integer integer : ai) {
            f.push(integer);
            assertEquals(f.pop(), ai[p], "hier stimmt was nicht");
            p++;
        }
    }
    @Test
    public void testPopBUE(){
        assertThrows(BufferUnderflowException.class, () -> f.pop(), "no BUE?");
    }
}
