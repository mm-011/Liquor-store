package Program;

import Osoba.*;
import java.io.*;
import java.util.*;

public class Program {    
    
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);
        String provera=null,ucitaniRed;
        String[] elementiUcitanogReda = null;
        boolean  adminF=false;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Admin> listaAdmina = new ArrayList<>();
        
        do{
            adminF=false;
            do{
                System.out.println("Da li zelite da se logujete kao admin , kao korisnik ili da izadjete iz programa?\n- za admina uneti a\n- za korisnika uneti k\n- za izlaz i");
                provera = unos.nextLine();
            }while(provera.toLowerCase().equals("a")==false && provera.toLowerCase().equals("k")==false && provera.toLowerCase().equals("i")==false);
            
            if(provera.toLowerCase().equals("a")){
                try {
                    fr = new FileReader("adminLogin.txt");
                    br = new BufferedReader(fr);
                    while( (ucitaniRed = br.readLine())!=null)
                    {
                        elementiUcitanogReda=ucitaniRed.split(",");
                            if(elementiUcitanogReda.length!=2){
                                throw new NepravinoUcitaniPodaciException();
                            }
                            else{
                                listaAdmina.add(new Admin(elementiUcitanogReda[0],elementiUcitanogReda[1]));
                            }                
                    } 
                } 
                catch (FileNotFoundException ex) { System.out.println("Greska prilikom otvaranja fajla"); }
                catch (IOException es) { System.out.println("Greska prilikom citanja datoteke admin");}
                catch(NepravinoUcitaniPodaciException e){System.out.println("Greska prilikom parsiranja");}
                finally{
                    try {
                        br.close();
                        fr.close();
                    } 
                    catch (IOException ex) {System.out.println("Neuspesno zatvaranje datoteke.");}
                }

                // provera 
                    Scanner tastatura = new Scanner (System.in);
                    System.out.println("Unesite korisnicko ime:");
                    String unesiIme = tastatura.nextLine(); 
                    System.out.println("Unesite sifru: ");
                    String unesiSifru = tastatura.nextLine();  
                    
                    for(Admin a: listaAdmina){
                        if (unesiIme.equals(a.getKorisnicko_ime()) && unesiSifru.equals(a.getSifra())){
                            adminF =true ;
                            break;
                        }
                    }
                    
                    if (adminF==true) {
                        System.out.println("\nUspesno ste ulogovani kao Admin!");
                        Admin.meni(unesiIme);

                    } 
                    else {                        
                        System.out.println("\n!!! Ovo su nevalidni podaci! Vraceni ste na ponovno logovanje! Pokusajte ponovo! !!!\n");                    
                    }
            }//kraj if admin
            else if (provera.toLowerCase().equals("k")){
                //System.out.println("Dobrodosao u podrum pica: ");
                Korisnik.meni();
            }//kraj if korisnik
            
        }while(provera.toLowerCase().equals("i")==false);
    }    
}

