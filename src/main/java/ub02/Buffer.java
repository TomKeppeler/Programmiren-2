package ub02;

public interface Buffer<T> {
    void push(T i);
    T pop();
    int size();
    int capacity();
}
