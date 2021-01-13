package Osoba;

import Pice.*;
import Racun.*;
import java.util.*;

public class Korisnik {
    public  static void meni() {
        Scanner scan = new Scanner(System.in);
        int izbor=0;
        ArrayList<Pice> listaDostupnihPica = new ArrayList<>();
        ArrayList<Pice> listaKupljenihPica = new ArrayList<>();
        ArrayList<Integer> listaBrojKomada = new ArrayList<>();
        PiceIKolicina piceIKolicina=null;
        do{
            System.out.println("\nUlogovani ste kao korisnik:" );
            System.out.println("1. Pregledajte listu dostupnih pica i kupi");
            System.out.println("2. Izbrisi sa racuna");
            System.out.println("3. Trenutno stanje racuna");
            System.out.println("4. Naplati racun");
            System.out.println("5. Izloguj se i vrati se na pocetni ekran");
            System.out.println("6. Izadji iz programa");

            do{
                System.out.println("Unesite neku od ponudjenih opcija: ");
                while(scan.hasNextInt()==false){
                    scan.next();
                }
                izbor = scan.nextInt();
            }while(izbor>6 || izbor<1);

            switch(izbor){
                case 1:   
                    System.out.println("\nLista pica:");
                    piceIKolicina=Racun.pregledListePicaIKupovina(); 
                    listaKupljenihPica=piceIKolicina.getListaPica();
                    listaBrojKomada=piceIKolicina.getBrojKomada();
                    break;
                case 2:
                    piceIKolicina=Racun.izbrisiSaRacuna(piceIKolicina);
                    break;
                case 3:
                    Racun.trenutnoStanjeRacuna(piceIKolicina);
                    break;
                case 4:
                    piceIKolicina=Racun.naplatiRacun(piceIKolicina);
                    break;
                case 5:
                    System.out.println("Izlogovani ste!");
                    return;
                case 6:
                    System.exit(0);
                    break;
            }
            
        }while(izbor!=5);
    }
}
