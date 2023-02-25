package ub07.zusatz;

public class App {
    public static void main(String[] args) {
        HashCodeComparator hcc = new HashCodeComparator();
        if(hcc.compare("Hello", "Welt") > 0)
            System.out.println("Groß");
        else
            System.out.println("Klein");    
    }
}
