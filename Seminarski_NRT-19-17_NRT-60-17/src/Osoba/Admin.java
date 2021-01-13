package Osoba;
import Pice.*;
import java.util.*;

public class Admin {
    String korisnicko_ime;
    String sifra;

    public Admin(String korisnicko_ime, String sifra) {
        this.korisnicko_ime = korisnicko_ime;
        this.sifra = sifra;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
    @Override
    public String toString() {
        return korisnicko_ime + "," + sifra;
    }
    
    public static void meni(String unetoIme){
        Scanner scan = new Scanner(System.in);
        ArrayList<Pice> listaPicaUMagacinu;
        int izbor=0;        
        do{
            System.out.println("\nUlogovani ste kao admin " + unetoIme);
            System.out.println("1. Pregledajte listu pica");
            System.out.println("2. Dodaj pice");
            System.out.println("3. Izmeni pice");
            System.out.println("4. Obrisi pice");
            System.out.println("5. Izloguj se i vrati se na pocetni ekran");
            System.out.println("6. Izadji iz programa");
        
            do{
                System.out.println("\nUnesite neku od ponudjenih opcija: ");
                while(scan.hasNextInt()==false){
                    scan.next();
                }
                izbor = scan.nextInt();
            }while(izbor>6 || izbor<1);
        
        switch(izbor){
            case 1: 
                System.out.println("\nLista pica:");
                listaPicaUMagacinu = Pice.ucitajListuPica();
                for(Pice pi: listaPicaUMagacinu){
                    System.out.println(pi.ispisKonzola());  
                }
                break;
            case 2:
                Pice.dodajPice(Pice.ucitajListuPica());
                break;
            case 3:
                Pice.izmeniPice();
                break;
            case 4:
                Pice.obrisiPice();
                break;
            case 5:
                System.out.println("Izlogovani ste!");
                return;
            case 6:
                System.exit(0);
                break;
        }
        }while(izbor!=6);
    }
}
