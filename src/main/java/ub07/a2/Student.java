package ub07.a2;

public class Student extends Person implements Comparable<Student> {
    private int matrikelnummer;

    public Student(String name, String vorname, int matrikelnummer) {
        super(name, vorname);
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.getMatrikelnummer();
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public int compareTo(Student o) {
        return this.getMatrikelnummer() - o.getMatrikelnummer();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return super.equals(o) && matrikelnummer == student.matrikelnummer;
    }    
}
