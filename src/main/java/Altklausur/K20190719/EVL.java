package Altklausur.K20190719;

public class EVL<T> {
    private class Item{
        T element;
        Item next;
        Item(T e){
            this.element = e;
            this.next = null;
        }
    }

    private Item first = null;
    private int size = 0;
    public void append(T e){
        if(size == 0){
            first = new Item(e);
        }else {
        Item index = this.first;
        while(index.next != null)
            index = index.next;
        index.next = new Item(e);
        }
        ++this.size;
    }

    public T get(int p){
        if(p > this.size)
            throw new IndexOutOfBoundsException();
        Item index = this.first;
        for (int i = 0; i < p; i++)
            index = index.next;
        
        return index == null ? null : index.element;
    }

    public static <U> EVL<Paar<U>> paarliste(EVL<U> a, EVL<U> b){
        EVL<Paar<U>> ret = new EVL<>();
        int i = 0;
        while(a.get(i) != null && b.get(i) != null){
            ret.append(new Paar<U>(a.get(i), b.get(i))); 
            ++i;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] l1 = {"Heute", "hier", "morgen", "dort"};
        String[] l2 = {"Today", "here", "tomorrow", "somewhere", "else"};
        EVL<String> e = new EVL<>();
        EVL<String> f = new EVL<>();
        for (String s : l1) 
            e.append(s);
        for (String s : l2) 
            f.append(s);
        EVL<Paar<String>> test = paarliste(e, f);
        int i = 0;
        while(test.get(i) != null){
            System.out.println(test.get(i));
            ++i;
        }
    }
}
