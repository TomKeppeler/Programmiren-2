package Altklausur.K180719;

public class EVL<F> {
    private class Knoten {
        F v; // Element im Knoten
        Knoten nach; // Nachfolgerknoten

        public Knoten(F data) {
            this.v = data;
        }
    }

    private Knoten erster = null; // Startknoten der Liste (oder null)

    private boolean isEmpty() {
        return erster == null;
    }

    public F removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        F d = null;
        if (this.erster.nach == null) {
            this.erster = null;
        } else {
            Knoten index = this.erster;
            while (index.nach.nach != null) {//uebernaechstes element
                index = index.nach;
            }
            d = index.v;
            index.nach = null;
        }
        return d;
    }

    public void insertLast(F f) {
        Knoten neu = new Knoten(f);
        if (isEmpty()) {
            this.erster = neu;
        }else{
            Knoten index = this.erster;
            while(index.nach != null){
                index = index.nach;
            }
            index.nach = neu;
        }
    }
    @Override
    public String toString() {
        String ret = "[";
        Knoten index = this.erster;
        while(index != null){
            if(index.nach != null){
                ret += index.v + ",";
            }else{
                ret += index.v;
            }
            index = index.nach;
        }
        return ret + "]";
    }
    public static void main(String[] args) {
        EVL<Integer> t = new EVL<>();
        for (int i = 0; i < 10; i++) {
            t.insertLast(i);
        }
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        t.removeLast();
        System.out.println(t.toString());
        
       
    }

}
