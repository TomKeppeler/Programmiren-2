package Altklausur.K0717;

public class Paar<T> {
    T erstes;
    T zweites;
    Paar(T e, T z){
        this.erstes = e;
        this.zweites = z;
    }
    public T erstes(){
        return this.erstes;
    }
    public T zweites(){
        return this.zweites;
    }

    @Override
    public String toString() {
        return"[" + erstes() + "]" + ", [" + zweites() + "]";
    }

}
