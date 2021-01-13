package Pice;

public interface Pica {    
    public int getId() ;
    public void setId(int id);
    public String getNaziv();
    public void setNaziv(String naziv);
    public String getProizvodjac();
    public void setProizvodjac(String proizvodjac);
    public double getZapremina();
    public void setZapremina(double zapremina) ;
    public double getCena();
    public void setCena(double cena);
    public boolean isAlkoholno();
    public void setAlkoholno(boolean alkoholno);
    public String ispisKonzola();
}
