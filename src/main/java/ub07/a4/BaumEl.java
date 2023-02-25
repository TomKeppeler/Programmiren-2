package ub07.a4;
public class BaumEl<Typ> {
    public BaumEl<Typ> left, right;
    public Typ data;

    public BaumEl(Typ input) {
        this.data = input;
        this.left = null; 
        this.right = null;
    }

    public String toString() {
        return data.toString();
    }
    public String slice (int ebene){
        int pad = 3;
        //todo einzelne schicht zurückgeben
        int a = 0;
        String padded = String.format("%-"+pad+"s", "{ }");
        String middle;
        if(ebene%2==0){
             middle= String.format("%-"+(pad-1)+"s", "-");
        }else{
             middle = String.format("%-"+(pad-1)+"s", "_");
        }
        
        if(a == ebene){
            padded = String.format("%-"+pad+"s", "{"+data.toString()+"}");
            return padded;
        }
        if(a < ebene){
            if (this.left == null && this.right == null) {// Ende hier
            return padded;
            }
            if (this.left == null) {// rechts safecall inhalt und links nix
                return padded+middle+ this.right.slice(ebene-1);
            } else {
                if (this.right == null) {// Links safecall inhalt und rechts nix
                    return this.left.slice(ebene-1)+middle+ padded;
                } else {// IN BEIDEN ist safecall noch was drin
                    return this.left.slice(ebene-1)+middle+ this.right.slice(ebene-1);
                }
            }
        }else{
            return "fehler";
        }
    }
}