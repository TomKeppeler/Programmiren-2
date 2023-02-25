package ub02;

public class Paar<E,Z> {
    private E erstes;
    private Z zweites;
    
    public Paar(E erstes, Z zweites) {
        this.erstes = erstes;
        this.zweites = zweites;
    }

    public E getErstes() {
        return this.erstes;
    }

    public E setErstes(E erstes) {
        E temp = this.erstes;
        this.erstes = erstes;
        return temp;
    }

    public Z getZweites() {
        return this.zweites;
    }

    public Z setZweites(Z zweites) {
        Z temp = this.zweites;
        this.zweites = zweites;
        return temp;
    }
    
    public void setBeide(E erstes, Z zweites){
        this.erstes = erstes;
        this.zweites = zweites;
    }
    
    public boolean equals(Paar<E,Z> p) {
        return p.getErstes().equals(erstes) && p.getZweites().equals(zweites);
    }

    @Override
    public String toString() {
        return "(" + erstes.toString() + "," + zweites.toString() + ")";
    }

}

    
