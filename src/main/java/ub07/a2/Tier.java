package ub07.a2;

public class Tier {
    // Animalt Atributes
    private String name;

    // Animal Constructor

    public Tier(String name){
        this.name = name;
    }

    // Animal Methods

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        Tier tier = (Tier) obj;
        return this.getName() == tier.getName();
    }

    public static void main(String[] args) {
        Tier tier = new Tier("Hund");
        System.out.println(tier);
    }

}
