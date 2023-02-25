package ub08.a2;
import java.util.*;

public class Iterator2DArray<T> implements Iterator<T> {
    private T[][] e;
    private int pos1d, pos2d;
    private Boolean istZeilenweise, istVorwaerts;

    Iterator2DArray(T[][] e) {
        this.e = e;
        this.pos1d = 0;
        this.pos2d = 0;
    }

    Iterator2DArray(T[][] e, boolean istZeilenweise) {
        this.e = e;
        this.pos1d = 0;
        this.pos2d = 0;
        this.istZeilenweise = istZeilenweise;
        this.istVorwaerts = true;
    }

    Iterator2DArray(T[][] e, boolean istZeilenweise, boolean istVorwaerts) {
        this.e = e;
        if (istVorwaerts) {
            this.pos1d = 0;
            this.pos2d = 0;
        } else {
            this.pos1d = e.length - 1;
            this.pos2d = e[0].length - 1;
        }
        this.istZeilenweise = istZeilenweise;
        this.istVorwaerts = istVorwaerts;
    }

    @Override
    public boolean hasNext() {
        if (this.istZeilenweise) {
            if (this.istVorwaerts) {
                return this.pos1d < this.e.length;
            } else {
                return this.pos1d > -1;
            }
        } else {
            if (this.istVorwaerts) {
                return this.pos2d < this.e[0].length;
            } else {
                return this.pos2d > -1;
            }
        }
    }

    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.istZeilenweise && this.istVorwaerts) {
            T ret = e[pos1d][pos2d++];
            if (this.pos2d == this.e[0].length && this.pos1d != this.e.length) {
                this.pos2d = 0;
                ++this.pos1d;
            }
            return ret;
        } else if (!this.istZeilenweise && this.istVorwaerts) {
            T ret = e[pos1d++][pos2d];
            if (this.pos1d == this.e.length) {
                this.pos1d = 0;
                ++this.pos2d;
            }
            return ret;
        } else if (!this.istZeilenweise && !this.istVorwaerts) {
            T ret = e[pos1d--][pos2d];
            if (this.pos1d == -1) {
                this.pos1d = this.e.length - 1;
                --this.pos2d;
            }
            return ret;
        } else {
            T ret = e[pos1d][pos2d--];
            if (this.pos2d == -1) {
                this.pos2d = this.e[0].length - 1;
                --this.pos1d;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Integer[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Iterator2DArray<Integer> s1 = new Iterator2DArray<>(a, true, true);
        for (; s1.hasNext(); System.out.println(s1.next()))
            ;

        Iterator2DArray<Integer> s2 = new Iterator2DArray<>(a, true, false);
        for (; s2.hasNext(); System.out.println(s2.next()))
            ;

        Iterator2DArray<Integer> s3 = new Iterator2DArray<>(a, false, true);
        for (; s3.hasNext(); System.out.println(s3.next()))
            ;

        Iterator2DArray<Integer> s4 = new Iterator2DArray<>(a, false, false);
        for (; s4.hasNext(); System.out.println(s4.next()))
            ;

        Iterator2DArray<Integer> s5 = new Iterator2DArray<>(a, true);
        for (; s2.hasNext(); System.out.println(s2.next()))
            ;

        Iterator2DArray<Integer> s6 = new Iterator2DArray<>(a, false);
        for (; s3.hasNext(); System.out.println(s3.next()))
            ;
    }
}
