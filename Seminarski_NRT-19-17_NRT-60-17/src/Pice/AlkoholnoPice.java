package Pice;

public class AlkoholnoPice extends Pice{
    double procenatAlkohola;
    
    public AlkoholnoPice(int id, String naziv, String proizvodjac, double zapremina, double cena, boolean alkoholno, double procenatAlkohola) {
        super(id, naziv, proizvodjac, zapremina, cena, alkoholno);
        this.procenatAlkohola = procenatAlkohola;
    }

    public double getProcenatAlkohola() {
        return procenatAlkohola;
    }

    public void setProcenatAlkohola(double procenatAlkohola) {
        this.procenatAlkohola = procenatAlkohola;
    }
    
    @Override
    public String ispisKonzola(){
        return "ID: " + id  + " Naziv: " + naziv + " Proizvodjac: "+ proizvodjac + " Zapremina: " 
                    + zapremina + " Alkoholno: " + alkoholno + " Cena: " + cena + " Procenat alkohola: " + procenatAlkohola;
    }
    
    public String ispisDatoteka(){
        return id  + "," + naziv + "," + proizvodjac + "," + zapremina + "," + cena + "," + alkoholno + "," + procenatAlkohola;
    }
}
