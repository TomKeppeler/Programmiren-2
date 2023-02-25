package ub00;

import java.nio.BufferUnderflowException;

public class Lifo extends AbstractIntegerBuffer{
    public Lifo(int s){
        super(s);
    }

    public Lifo(){
        super();
    }

    @Override
    public Integer pop() {
        if(size <= 0){
            throw new BufferUnderflowException();
        }
        return array[--size];
    }
    
}
