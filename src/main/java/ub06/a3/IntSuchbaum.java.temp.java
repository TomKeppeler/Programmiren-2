package ub06.a3;
import java.util.NoSuchElementException;

import a1.*;

public class IntSuchbaum extends Binaerbaum<Integer> {

    IntSuchbaum() {
        super();
    }

    public void insert(int i) {
        if (isEmpty()) {
            this.wurzel = new BaumEl<Integer>(i);
        } else {
            insert(i, this.wurzel);
        }
    }

    private void insert(int i, BaumEl<Integer> e) {
        if (e.data == i) {
            throw new IllegalArgumentException();
        }
        if (e.data == null) {
            e.data = i;
        }
        if (e.data > i) {
            if (e.left == null) {
                e.left = new BaumEl<Integer>(i);
            } else {
                insert(i, e.left);
            }
        } else {
            if (e.right == null) {
                e.right = new BaumEl<Integer>(i);
            } else {
                insert(i, e.right);
            }
        }
    }

    public boolean contains(int i) {
        return contains(this.wurzel, i);
    }

    public boolean contains(BaumEl<Integer> e, int i) {
        if (e == null) {
            return false;
        }
        if (e.data == null) {
            return false;
        }
        if (e.data == i) {
            return true;
        } else if (i < e.data) {
            return contains(e.left, i);
        } else { // i > e un dementsprechend right
            return contains(e.right, i);
        }
    }

    public String myToString() {
        if(wurzel == null) return "";

        StringBuilder sb = new StringBuilder();

        myToString(sb, wurzel.right, false, "");
        sb.append(wurzel.data).append('\n');
        myToString(sb, wurzel.left, true, "");

        return sb.toString();
    }

    private void myToString(StringBuilder sb, BaumEl<Integer> n, boolean left, String indent) {
        if(n == null) return;

        myToString(sb, n.right, false, indent + (left ? "│   " : "    "));

        sb.append(indent).append(left ? "└── " : "┌── ");
        sb.append(n.data).append('\n');

        myToString(sb, n.left, true, indent + (left ? "    " : "│   "));
    }

    public void remove(int i) {
        if (contains(i)) {
            if (this.wurzel.data == i) {
                if (wurzel.data == i && (wurzel.right == null && wurzel.left == null)) {
                    wurzel = new BaumEl<Integer>(null);
                } else if (wurzel.left == null && wurzel.right != null) {
                    wurzel = wurzel.right;
                } else if (wurzel.right == null && wurzel.left != null) {
                    wurzel = wurzel.left;
                } else if (wurzel.right != null && wurzel.left != null) {
                    wurzel = wurzel.left;
                    while (wurzel.right != null) {
                        wurzel = wurzel.right;
                    }
                    wurzel = new BaumEl<Integer>(null);
                }
            } else {
                remove(this.wurzel, i);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
// ja ja ja :)
    public void remove(BaumEl<Integer> tmp, int i) {
        if (tmp.data != i) { // i finden
            if (i < tmp.data) {
                if (tmp.left.data == i) {
                    if (tmp.left.data == i && (tmp.left.right == null && tmp.left.left == null)) {
                        tmp.left = null;
                    } else if (tmp.left.left == null && tmp.left.right != null) {
                        tmp.left = tmp.left.right;
                    } else if (tmp.left.right == null && tmp.left.left != null) {
                        tmp.left = tmp.left.left;
                    } else if (tmp.left.right != null && tmp.left.left != null) {
                        tmp.left = tmp.left.left;
                        while (tmp.left.right != null) {
                            tmp.left = tmp.left.right;
                        }
                        tmp.left = null;
                    }
                } else {
                    remove(tmp.left, i);
                }
            } else {
                if (tmp.right.data == i) {
                    if (tmp.right.data == i && (tmp.right.right == null && tmp.right.left == null)) {
                        tmp.right = null;
                    } else if (tmp.right.left == null && tmp.right.right != null) {
                        tmp.right = tmp.right.right;
                    } else if (tmp.right.right == null && tmp.right.left != null) {
                        tmp.right = tmp.right.left;
                    } else if (tmp.right.right != null && tmp.right.left != null) {
                        tmp.right = tmp.right.left;
                        while (tmp.right.right != null) {
                            tmp.right = tmp.right.right;
                        }
                        tmp.right = null;
                    }
                } else {
                    remove(tmp.right, i);
                }
            }
        }

    }
    public static void main(String[] args) {
        IntSuchbaum is = new IntSuchbaum();
        for (int i = 0; i < args.length; i++) {
            is.insert(i);
        }
        System.out.println(is.toString());
    }
}