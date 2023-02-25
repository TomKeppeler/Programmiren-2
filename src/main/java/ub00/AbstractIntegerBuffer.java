package ub00;

import java.util.Random;

public abstract class AbstractIntegerBuffer implements IntegerBuffer{
    protected Integer array[];
    protected int size = 0;
    public AbstractIntegerBuffer(int s) {
        if(s < 0){
            throw new IllegalArgumentException();
        }
        array = new Integer[s];
        size = 0;
    }
    
    public AbstractIntegerBuffer() {
        Random r = new Random();
        array = new Integer[r.nextInt(97) + 3];
        size = 0; 
    }

    public void push(Integer i){
        if(i == null){
            throw new IllegalArgumentException();
        }
        if (size >= capacity()){
            throw new ArrayIndexOutOfBoundsException();
        }
        array[size++] = i;
    }
    
    public int size(){
        return size;
    }
    public int capacity(){
        return array.length;
    }
}
