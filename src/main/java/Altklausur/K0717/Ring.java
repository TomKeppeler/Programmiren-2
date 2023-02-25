package Altklausur.K0717;

public class Ring<T> implements Buffer<T> {
    private class Element{
        Element next, prev;
        T data;
        public Element(T data){
            this.next = null;
            this.prev = null;
            this.data = data;
        }
    }
    private Element first = null;
    
    private int size = 0;

    @Override
    public int append(T v) {
        Element neu = new Element(v);
        if(size == 0){
            this.first = neu;
            this.first.next = neu;
            this.first.prev = neu;
        }else{            
            this.first.prev.next = neu; 
            this.first.prev = neu;
        }
        return ++size;
    }
    public int getSize() {
        return size;
    }
    @Override
    public T removeFirst() {
        T ret = this.first.data;
        if (size == 1){
            this.first = null;
        }else{
            this.first.prev.next = this.first.next;
            this.first.next.prev = this.first.prev;
            this.first = this.first.next;
        }
        --this.size;
        return ret;
    }

    @Override
    public T find(int i) {

        Element index = this.first;
        if(i < 0){
            i *= -1;
            for (int j = 0; j < i; j++)
                index = index.prev;
        } else{
            for (int j = 0; j < i; j++)
                index = index.next;
        }
        return index.data;
    }
    public static void main(String[] args) {
        Ring<Integer> test = new Ring<>();
        for (int j = 0; j < 9; j++) 
            test.append(j);
        System.out.println(test.find(1));
    }
}
