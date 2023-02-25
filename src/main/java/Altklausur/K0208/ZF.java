package Altklausur.K0208;
//Dateiname: ZF.java
//Tom Keppeler, 9040853
public class ZF extends Liste<Integer>{
    private int nextValue(int n){
        return n*n;
    }
    @Override
    public void extend(int n) {
        for (int i = 0; i < n; i++)
            super.append(this.nextValue(super.size()));
    }
    public static void main(String[] args) {
        ZF t = new ZF();
        t.extend(10);
        System.out.println(t.toString());
    }
}