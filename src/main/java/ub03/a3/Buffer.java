package ub03.a3;

public interface Buffer<T> {
    void push(T i);
    T pop();
    int size();
    int capacity();
}
