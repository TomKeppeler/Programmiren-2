package ub02;

import java.nio.BufferUnderflowException;

public class Lifo<T> extends AbstractBuffer<T> {

    public Lifo(int i) {
        super(i);
    }
    public Lifo() {
        super();
    }

    @Override
    public T pop() {
        if(size <= 0){
            throw new BufferUnderflowException();
        }
        return array[--size];
    }
    
}
