package ub04.a3;
public class Ringpuffer<Typ> implements RingpufferIF<Typ> {
    protected Typ[] buffer = null;
    private int size = 0;
    private int first = 0;
    public Ringpuffer(int capacity) {
        buffer = (Typ[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    @Override
    public int size() {
        return 0;
    }

    public int capacity(){
        return this.buffer.length;
    }

    @Override
    public Typ get(int pos) {
        if (pos > -1) {
            System.out.println(pos % this.getCapacity()  + "");
            if (buffer[pos % this.getCapacity()] != null) {
                return buffer[pos % this.getCapacity() ];
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Typ set(int pos, Typ e) {
        if (pos > -1) {
            if (buffer[pos % this.getCapacity()]  != null) {
                Typ ret = buffer[pos % this.getCapacity()];
                buffer[pos % this.getCapacity()] = e;
                return ret;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void addFirst(Typ e) {
        if (this.getSize() <= this.getCapacity()) {
            if (first == 0) {
                first = this.getCapacity() - 1;
            } else {
                first--;
            }
            buffer[first] = e;
            size++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addLast(Typ e) {
        if(this.size <= this.getCapacity()){
            if((this.first + this.size) > this.getCapacity()){
                this.first = this.first % this.getCapacity();
            }
            buffer[this.first + this.size++] = e;
        } else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Typ removeFirst() {
        if(this.getSize() != 0){
            Typ ret = this.buffer[this.first];
           
            buffer[this.first++] = null;
            size--;
            return ret;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Typ removeLast() {
        if(this.getSize() != 0){
            Typ ret = this.buffer[this.first + this.size];
            this.buffer[this.first + this.size--] = null;
            return ret;
        }
        throw new IllegalArgumentException();
    }

    private int getCapacity() {
        return this.buffer.length;
    }

    public static void main(String[] args) {
        Ringpuffer<Integer> speicher = new Ringpuffer<>(10);
        for (int i = 1; i < 11; i++) {
            speicher.addLast(i);
        }
        System.out.println(speicher.get(9));
        for (int i = 1; i < 11; i++) {
            System.out.println(speicher.removeFirst());
        }
    }
}
