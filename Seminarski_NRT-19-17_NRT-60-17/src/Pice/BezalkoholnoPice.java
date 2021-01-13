package Pice;

public class BezalkoholnoPice extends Pice{
    boolean daLiJeGazirano;

    public BezalkoholnoPice(int id, String naziv, String proizvodjac, double zapremina, double cena, boolean alkoholno, boolean daLiJeGazirano) {
        super(id, naziv, proizvodjac, zapremina, cena, alkoholno);
        this.daLiJeGazirano = daLiJeGazirano;
    }

    public boolean isDaLiJeGazirano() {
        return daLiJeGazirano;
    }

    public void setDaLiJeGazirano(boolean daLiJeGazirano) {
        this.daLiJeGazirano = daLiJeGazirano;
    }
    
    @Override
    public String ispisKonzola(){
        return "ID: " + id  + " Naziv: " + naziv + " Proizvodjac: "+ proizvodjac + " Zapremina: " 
                    + zapremina + " Alkoholno: " + alkoholno + " Cena: " + cena + " Da li je gazirano: " + daLiJeGazirano;
    }
    
    public String ispisDatoteka(){
        return id  + "," + naziv + "," + proizvodjac + "," + zapremina + "," + cena + "," + alkoholno + "," + daLiJeGazirano;
    } 
}
