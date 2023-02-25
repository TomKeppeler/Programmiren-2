package ub03.a6;

import a5.RDVL;

public class Josephus {
    public static int loese(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        RDVL<Integer> kreis = new RDVL<>();
        for (int i = 1; i <= n; i++) {
            kreis.add(i);
        }

        while (kreis.getSize() != 1) {
            kreis.next(k - 1);
            kreis.remove();
        }
        return kreis.element();
    }

    public static void main(String[] args) {
        System.out.println(loese(100, 2));
    }
}
