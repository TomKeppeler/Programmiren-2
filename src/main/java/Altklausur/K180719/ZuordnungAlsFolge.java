package Altklausur.K180719;
/**
 * @author Tom Keppeler
 * Aufgabe 2
 * Implementierung als DynArray
 */
public class ZuordnungAlsFolge<K, V> implements Zuordnung<K, V>{
    private K[] k = null;
    private V[] v = null;
    private int size; // zählt die Elemente der beiden Arrays
                    //da beide Arrays gleich lang sind wird nur eine Variabele gebraucht
    ZuordnungAlsFolge(){
        this.k = (K[]) new Object[1];//zunächst start der beiden arrays mit 1
        this.v = (V[]) new Object[1];
        this.size = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public V get(K k) {
        int i = 0;
        while(this.k[i++] != k){
            if(i == this.size())
                return null;
        }
        return  this.v[i];
    }

    @Override
    public void insert(K k, V v) {
        if(this.size() == this.k.length){
            K[] tmpK = (K[]) new Object[this.k.length*2];
            for (int i = 0; i < this.size(); i++) {
                tmpK[i] = this.k[i]; 
            }
            this.k = tmpK;
            V[] tmpV = (V[]) new Object[this.v.length*2];
            for (int i = 0; i < this.size(); i++) {
                tmpV[i] = this.v[i]; 
            }
            this.v = tmpV;
        }
        this.k[this.size] = k;
        this.v[this.size++] = v;
    }
    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < this.size(); i++) {
            if(i != this.size() - 1)
                s += "(" + k[i] + "," + v[i] + "),";
            else
                s += "(" + k[i] + "," + v[i] + ")";
        }
        return s + "}";
    }
    public static void main(String[] args) {
        ZuordnungAlsFolge<Integer, String> t = new ZuordnungAlsFolge<>();
        t.insert(1, "Eins");
        t.insert(2, "Zwei");
        t.insert(3, "Drei");
        t.insert(4, "Vier");
        System.out.println(t.toString());        
    }
}
