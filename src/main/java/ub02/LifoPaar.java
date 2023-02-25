package ub02;

public class LifoPaar {
    public static void main(String[] args) {
        Lifo<Paar<Integer, String>> lifo = new Lifo<>(4);
        String[] werte = {"eins", "zwei", "drei", "vier"};
        for (int i = 0; i < lifo.capacity(); i++) {
            lifo.push(new Paar<Integer, String>(i+1, werte[i]));
        }
        int s = lifo.size();
        for (int i = 0; i < s; i++) {
            System.out.println(lifo.pop().toString());
        }
    }
}
