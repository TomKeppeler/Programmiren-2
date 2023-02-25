package Altklausur.K0717;

public class Fahrrad implements Comparable<Fahrrad>{
    private final int serienNummer;
    Fahrrad(int serienNummer){
        this.serienNummer = serienNummer;
    }
    @Override
    public int compareTo(Fahrrad o) {
        return this.serienNummer - o.serienNummer;
    }
    
}
