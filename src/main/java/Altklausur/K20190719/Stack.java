package Altklausur.K20190719;
public class Stack<T> {
    private T[] stapel;
    private int s = 0; //Echte

    public Stack(int size) {
        this.stapel = (T[]) new Object[size];
    }

    public void push(T e){
        this.stapel[this.s++] = e;
    }
    
    public T pull(){
        return this.stapel[--this.s];
    }
    public static void main(String[] args) {
        Stack<String> s = new Stack<>(20);
        s.push("Welt!");
        s.push(" ");
        s.push("Hallo");
        System.out.println(s.pull() + s.pull() + s.pull());
    }
}
