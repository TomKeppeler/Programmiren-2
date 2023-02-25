package ub02;

import java.util.Random;

public abstract class AbstractBuffer<T> implements Buffer<T>{
    protected int size = 0;
    protected T[] array;


    public AbstractBuffer(int i) {
        if(i < 0){
            throw new IllegalArgumentException();
        }
        array = (T[]) new Object[i];
    }
    
    public AbstractBuffer() {
        Random r = new Random();
        array = (T[]) new Object[r.nextInt(97) + 3];
    }
    @Override
    public void push(T i) {
        if(i == null){
            throw new IllegalArgumentException();
        }
        array[size++] = i;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return array.length;
    }

}