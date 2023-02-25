package Altklausur.K0208LoesungenundAntworten;
/*Dateiname : ZF.java
* Tom Keppeler , Matrikelnummer*/
public class ZF extends Liste<Integer> {
    ZF(){
    }
    private int naechsteZahl(int n){ //rechnet die folge aus
        return 2 * n - 3;
    }
    @Override
    public void extend(int n) {//fühgt neue zahlen der folge hinzu, wenn sie leer ist wird n=7 sein.
        for (int i = 0; i < n; i++) {
            if(super.size() == 0)
                super.append(7);
            else
                super.append(super.get(super.size()));//der wert der letzten position wird als n benutzt
        }
    }
}
