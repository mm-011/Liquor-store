package Racun;

import Osoba.*;
import Pice.*;
import java.io.*;
import java.util.*;

public class Racun {
    public static PiceIKolicina pregledListePicaIKupovina(){
        
        String unos = "";
        int idPica = 0,forFlag = 0,brojac = 0,flag = 0,brojKomada = 0;
        ArrayList<Pice> lista = new ArrayList<>();
        ArrayList<Pice> kupljenaPica = new ArrayList<>();
        ArrayList<Integer> listaBrojKomada = new ArrayList<>();
        FileWriter fw=null;
        BufferedWriter bw=null;
        Scanner scan = new Scanner(System.in);
        PiceIKolicina piceIKolicina;
        
        
        lista = Pice.ucitajListuPica();
        for(Pice pi: lista){
            System.out.println(  pi.ispisKonzola());  
        }
        
        do{
            System.out.println("\nDa li zelite da kupite neko pice?(Unesite da/ne) ");            
                unos = scan.nextLine();
                while(!unos.equals("da") && !unos.equals("ne")){
                    System.out.println("Molim vas unesite pravilan izbor.");
                    unos = scan.nextLine();
                }
                forFlag =0;
                if(unos.equals("da")){
                    do{
                            System.out.println("Unesite validan ID pica koje zelite da kupite: ");
                            while(scan.hasNextInt()==false){
                               scan.next();
                            }
                            idPica = scan.nextInt();
                
                            for(Pice ha: lista)
                            {
                                if(ha.getId()==idPica)
                                    forFlag =1;
                            }
                     }while(forFlag ==0);
                    
                    
                    do{
                            System.out.println("Koliko komada zelite da kupite(max 50)?");
                            while(scan.hasNextInt()==false){
                            scan.next();
                            }
                            brojKomada = scan.nextInt();
                      }while(brojKomada>50 || brojKomada<1);
                    
                    
                    for(Pice a: lista)
                    {
                        if(a.getId()==idPica){
                         kupljenaPica.add(a); 
                         listaBrojKomada.add(brojKomada);
                         flag=1;
                         System.out.println("Uspesno ste kupili pice! broj: " + brojKomada);
                         break;
                         }
                    brojac++;
                    }
                    
                
                }
         }while(!unos.equals("ne"));
        
            for(int i=0;i<kupljenaPica.size();i++){
                System.out.println(kupljenaPica.get(i).ispisKonzola());
                System.out.println(listaBrojKomada.get(i));                 
            }   
            piceIKolicina=new PiceIKolicina(kupljenaPica, listaBrojKomada);
        
        return piceIKolicina;
    
    }
    
    public static PiceIKolicina izbrisiSaRacuna(PiceIKolicina piceIKolicina) {
        Pice a = null;
        ArrayList<Pice> lista = new ArrayList<>();
        ArrayList<Integer> listaBrojKomada = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int idPica =0;
        int forFlag = 0;

        System.out.println("\nLista kupljenih pica:");
        try{
        lista=piceIKolicina.getListaPica();
        listaBrojKomada=piceIKolicina.getBrojKomada();
        }
        catch(NullPointerException e){
            System.out.println("Nema ni jednog kupljenog pica!!!");
            return piceIKolicina;
        }
        
        if(lista.isEmpty()==true)
            System.out.println("!!!Nema proizvoda na racunu!!!");
        else{
            for(int j=0;j<lista.size();j++){
                System.out.println(lista.get(j).ispisKonzola() + " Kolicina: "+listaBrojKomada.get(j));            
            }
        
            do{
                System.out.println("Unesite validan ID pica koje zelite da izbrisete: ");
                while(scan.hasNextInt()==false){
                   scan.next();
                }
                idPica = scan.nextInt();

                for(Pice ha: lista)
                {
                    if(ha.getId()==idPica)
                        forFlag =1;
                }
            }while(forFlag ==0);

            for(int j=0;j<lista.size();j++){
                if(lista.get(j).getId()==idPica){
                    lista.remove(j);
                    listaBrojKomada.remove(j);
                }
            }
            System.out.println("Stanje nakon brisanja:");
            System.out.println("**********************");
            for(int j=0;j<lista.size();j++){
                System.out.println(lista.get(j).ispisKonzola() + " Kolicina: "+listaBrojKomada.get(j));            
            }
            piceIKolicina=new PiceIKolicina(lista, listaBrojKomada);

        }
        return piceIKolicina;
    }
     
    public static void trenutnoStanjeRacuna(PiceIKolicina piceIKolicina) {
        Pice a = null;
        ArrayList<Pice> lista = new ArrayList<>();
        ArrayList<Integer> listaBrojKomada = new ArrayList<>();
        
        System.out.println("\nLista kupljenih pica:");
        try{
        lista=piceIKolicina.getListaPica();
        listaBrojKomada=piceIKolicina.getBrojKomada();
        }
        catch(NullPointerException e){
            System.out.println("Nema ni jednog kupljenog pica!!!");
            return;
        }
        if(lista.isEmpty()==true)
            System.out.println("!!!Nema proizvoda na racunu!!!");
        else{
            for(int j=0;j<lista.size();j++){
                System.out.println(lista.get(j).ispisKonzola() + " Kolicina: "+listaBrojKomada.get(j));            
            }        
            return;        
        }
    }
    
    public static PiceIKolicina naplatiRacun(PiceIKolicina piceIKolicina) {
        float suma=0;        
        Pice a = null;
        ArrayList<Pice> lista = new ArrayList<>();
        ArrayList<Integer> listaBrojKomada = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int velicina =0;
        int forFlag = 0;
        
        try{
        lista=piceIKolicina.getListaPica();
        listaBrojKomada=piceIKolicina.getBrojKomada();
        }
        catch(NullPointerException e){
            System.out.println("\nNema ni jednog kupljenog pica!!!");
            return piceIKolicina;
        }
        if(lista.isEmpty()==true)
            System.out.println("\n!!!Nema proizvoda na racunu!!!");
        else{
            for(int j=0;j<lista.size();j++){
                suma+=lista.get(j).getCena()*listaBrojKomada.get(j);                 
            }
            System.out.println("*****");
            System.out.println("Ukupna suma iznosi: "+suma+" dinara");
            System.out.println("*****");
            velicina=lista.size();
            for(int j=0;j<velicina;j++){  
                lista.remove(0);
                listaBrojKomada.remove(0);
                //System.out.println("Velicina niza je: "+lista.size());
            }
        }        
        piceIKolicina=new PiceIKolicina(lista, listaBrojKomada);
        return piceIKolicina ;
        
        
    }
}
