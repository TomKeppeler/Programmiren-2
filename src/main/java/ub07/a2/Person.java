package ub07.a2;
public abstract class Person {
    private String name, vorname;
    public Person(String name, String vorname){
        this.name = name;
        this.vorname = vorname;
    }
    public String getName(){
        return this.name;
    }
    
    public String getVorname(){
        return this.vorname;
    }
    
    @Override
    public String toString(){
        return this.getName() + ", " + this.getVorname();
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return this.getName() == person.getName() && this.getVorname() == person.getVorname(); 
    }
}
