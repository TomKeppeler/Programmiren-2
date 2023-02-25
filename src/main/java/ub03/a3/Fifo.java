package ub03.a3;

import java.nio.BufferUnderflowException;

public class Fifo<T> extends AbstractBuffer<T> {

    public Fifo(int i){
        super(i);
    }
    
    public Fifo() {
        super();
    }

    @Override
    public T pop() {
        if(size <= 0){
            throw new BufferUnderflowException();
        }
        T a = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        array[size - 1] = null;
        --size;
        return a;
    }
    
}
