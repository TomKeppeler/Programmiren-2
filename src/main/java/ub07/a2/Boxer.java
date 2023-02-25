package ub07.a2;

public class Boxer extends Person implements Comparable<Boxer> {
    private int gewicht;

    public Boxer(String name, String vorname, int gewicht) {
        super(name, vorname);
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.getGewicht();
    }

    public int getGewicht() {
        return this.gewicht;
    }

    @Override
    public int compareTo(Boxer o) {
        if (this.getGewicht() != o.getGewicht()) {
            return this.getGewicht() - o.getGewicht();
        }
        if (!this.getName().equals(o.getName())) {
            return this.getName().compareTo(o.getName());
        }
        return this.getVorname().compareTo(o.getVorname());
    }

    @Override
    public boolean equals(Object o) {
        Boxer boxer = (Boxer) o;
        return this.getName().equals(boxer.getName()) && this.getVorname().equals(boxer.getVorname())
                && this.getGewicht() == boxer.getGewicht();
    }
}