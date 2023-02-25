package ub00;

import java.nio.BufferUnderflowException;

public class Fifo extends AbstractIntegerBuffer{

    public Fifo(int s){
        super(s);
    }

    public Fifo(){
        super();
    }

    @Override
    public Integer pop() {
        if(size <= 0){
            throw new BufferUnderflowException();
        }
        Integer a = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        array[size - 1] = 0;
        --size;
        return a;
    }
    
}
