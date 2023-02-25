package ub05.a2.nachAufgabenStellung;


public interface Schlange<Typ> extends Puffer<Typ> {
    //private Fifo<Typ> speicher = new Fifo<Typ>(); 

    @Override
    public void insert(Typ e); //    speicher.push(e);
    

    @Override
    public void remove(); // speicher.pop();

    @Override
    public int size();// return speicher.size();
    

    @Override
    public boolean isEmpty();//   return speicher.size() == 0;
    
    public Typ first(); // return speicher.pop();
}
