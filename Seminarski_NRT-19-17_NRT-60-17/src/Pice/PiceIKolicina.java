package Pice;
import java.util.*;

public class PiceIKolicina {
    ArrayList<Pice> listaPica;
    ArrayList<Integer> brojKomada;

    public PiceIKolicina(ArrayList<Pice> listaPica, ArrayList<Integer> brojKomada) {
        this.listaPica = listaPica;
        this.brojKomada = brojKomada;
    }

    public ArrayList<Pice> getListaPica() {
        return listaPica;
    }

    public void setListaPica(ArrayList<Pice> listaPica) {
        this.listaPica = listaPica;
    }

    public ArrayList<Integer> getBrojKomada() {
        return brojKomada;
    }

    public void setBrojKomada(ArrayList<Integer> brojKomada) {
        this.brojKomada = brojKomada;
    }
    
    
}
