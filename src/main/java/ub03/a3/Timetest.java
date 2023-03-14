package ub03.a3;

import ub03.a2.FifomitEVL;
import ub03.a4.EVL;
public class Timetest {
    public static void main(String[] args) {
        double durchschnittfifo = .0, durchschnittfifomitEVL = .0;
        for (int i = 0; i < 100; i++) {
            durchschnittfifo += testfifo(new Fifo<>(10000), 10000);
            durchschnittfifomitEVL += testfifomitEVL(new FifomitEVL<>(), 10000);
            if (i % 10 == 0) {
                System.out.print(".");
            }
        }
        System.out.println("\nDurschnitt Fifo: " + String.valueOf((durchschnittfifo / 100) / 1000) + 
                        "/s\nDurschnitt FifomitEVL: "+ String.valueOf((durchschnittfifomitEVL / 100) / 1000) + "/s");
    }

    public static long testfifo(Fifo fifo, int wdh) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= wdh; i++) {
            fifo.push(i);
        }
        for (int i = 1; i <= wdh; i++) {
            fifo.pop();
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    public static long testfifomitEVL(FifomitEVL fifomitEVL, int wdh) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= wdh; i++) {
            fifomitEVL.push(i);
        }
        for (int i = 1; i <= wdh; i++) {
            fifomitEVL.pop();
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
