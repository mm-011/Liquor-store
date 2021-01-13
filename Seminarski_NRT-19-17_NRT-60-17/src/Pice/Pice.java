package Pice;
import Osoba.Admin;
import java.io.*;
import java.util.*;
import static java.util.Comparator.comparing;

public abstract class Pice implements Pica{
    int id;
    String naziv;
    String proizvodjac;
    double zapremina;
    double cena;
    boolean alkoholno;    

    public Pice(int id, String naziv, String proizvodjac, double zapremina, double cena, boolean alkoholno) {
        this.id = id;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.zapremina = zapremina;
        this.cena = cena;
        this.alkoholno = alkoholno;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNaziv() {
        return naziv;
    }

    @Override
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String getProizvodjac() {
        return proizvodjac;
    }

    @Override
    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    @Override
    public double getZapremina() {
        return zapremina;
    }

    @Override
    public void setZapremina(double zapremina) {
        this.zapremina = zapremina;
    }

    @Override
    public double getCena() {
        return cena;
    }

    @Override
    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public boolean isAlkoholno() {
        return alkoholno;
    }

    @Override
    public void setAlkoholno(boolean alkoholno) {
        this.alkoholno = alkoholno;
    }
    
    @Override
    public String ispisKonzola(){
        return "ID: " + id  + " Naziv: " + naziv + " Proizvodjac: "+ proizvodjac + " Zapremina: " 
                + zapremina + " Alkoholno: " + alkoholno + " Cena: " + cena;
    }
    
    public static ArrayList<Pice> ucitajListuPica() {
        Pice a = null;
        ArrayList<Pice> lista = new ArrayList<>();
            FileReader fr = null;
            BufferedReader br = null;
            try {
                 fr = new FileReader("Pica.txt");
                 br = new BufferedReader(fr);
                 String[] niz;
                 String red;
               while( (red = br.readLine())!=null){
                    niz = red.split(",");                    
                    try{
                        if(niz.length!=7)
                            throw new NepravilanUnosException();

                        if(niz[5].equals("true")){
                        a=new AlkoholnoPice(Integer.parseInt(niz[0]), niz[1], niz[2], Double.parseDouble(niz[3]),
                                Double.parseDouble(niz[4]), Boolean.parseBoolean(niz[5]), Double.parseDouble(niz[6]));
                        }
                        else if(niz[5].equals("false")){
                        a=new BezalkoholnoPice(Integer.parseInt(niz[0]),niz[1],niz[2],Double.parseDouble(niz[3]),
                                Double.parseDouble(niz[4]),Boolean.parseBoolean(niz[5]),Boolean.parseBoolean(niz[6]));
                        }
                        lista.add(a);                        
                        Collections.sort(lista, comparing(Pice::getId));//sortiranje liste po ID-u
                    } catch(NepravilanUnosException nepravilan){System.out.println("Nepravilan unos pica.");}
            }
             
            } catch (FileNotFoundException ex) {
                System.out.println("File nije otvoren za citanje!");
            } catch (IOException ex) {
                System.out.println("Problem sa citanjem fajla");
            }
            finally{
                try {
                    br.close();
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("Problem pri zatvranju fajla!");
                }
            
            }
          
        return lista;
              
    }
    
    public static void dodajPice(ArrayList<Pice> listaPica) {
            int id=0;
            int flag = 0;
            int izbor= 0;
            Scanner scan = new Scanner(System.in);
            BezalkoholnoPice novoB=null;
            AlkoholnoPice novoA = null;
            for(int i = 0; i< listaPica.size();i++){
                for(Pice a: listaPica){
                    if(id == a.getId()){
                        flag = 0;
                        break;
                    }
                    else{flag =1;}                
                }
                    if(flag==1)
                    {}
                    else
                        id++;
            }
            System.out.println("\nDa li je pice alkoholno ili bezalkoholno?");
            System.out.println("1. Dodaj alkoholno pice.");
            System.out.println("2. Dodaj bezalkoholno pice.");
            System.out.println("3. Vrati se na glavni meni");
            
            do{
                System.out.println("\nUnesite neku od ponudjenih opcija: ");
                while(scan.hasNextInt()==false){
                   scan.next();
                }
                izbor = scan.nextInt();
            }while(izbor>3 || izbor<1);
            
            if(izbor==1){
                System.out.println("\nIzabrali ste alkoholna pica!");
                System.out.println("id = " + id);
                System.out.println("Unesi naziv: ");
                scan.nextLine();
                String nazivP = scan.nextLine();
                System.out.println("Unesi proizvodjaca: ");
                String proizvodjacP = scan.nextLine();
                System.out.println("Unesi zapreminu: ");
                double zapreminaP;    
                while(!scan.hasNextDouble()){
                    String ulaz=scan.next();
                    System.out.println("! Unesi broj !");
                }
                zapreminaP=scan.nextDouble();
                System.out.println("Unesi cenu:  ");
                double cenaP;
                while(!scan.hasNextDouble()){
                    String ulaz=scan.next();
                    System.out.println("! Unesi broj !");
                }
                cenaP=scan.nextDouble();
                System.out.println("Unesi procenat alkohola: ");
                double postoP;
                while(!scan.hasNextDouble()){
                    String ulaz=scan.next();
                    System.out.println("! Unesi broj !");
                }
                postoP=scan.nextDouble();
                boolean alko = true;
                novoA = new AlkoholnoPice(id,nazivP, proizvodjacP, zapreminaP, cenaP, alko,postoP);
            }
            
            else if(izbor == 2){
                System.out.println("\nIzabrali ste bezalkoholna pica!");
                System.out.println("id = " + id);
                System.out.println("Unesi naziv: ");
                scan.nextLine();
                String nazivP = scan.nextLine();
                System.out.println("Unesi proizvodjaca: ");
                String proizvodjacP = scan.nextLine();
                System.out.println("Unesi zapreminu: ");
                double zapreminaP =0;    
                while(!scan.hasNextDouble()){
                    String ulaz=scan.next();
                    System.out.println("! Unesi broj !");
                }
                zapreminaP=scan.nextDouble();
                System.out.println("Unesi cenu:  ");
                double cenaP =0;
                while(!scan.hasNextDouble()){
                    String ulaz=scan.next();
                    System.out.println("! Unesi broj !");
                }
                cenaP=scan.nextDouble();
                System.out.println("Unesi da li je gazirano(Unesite Da ili Ne): ");
                String DaGS=scan.nextLine();
                while(DaGS.toLowerCase().equals("da")==false && DaGS.toLowerCase().equals("ne")==false){
                    System.out.println("!!! Unesite Da ili Ne !!!");
                    DaGS=scan.nextLine(); 
                }
                
                boolean DaG=true; /*= scan.nextBoolean()*/;
                if(DaGS.toLowerCase().equals("da")==true)
                    DaG=true;
                if(DaGS.toLowerCase().equals("ne")==true)
                    DaG=false;
                
                boolean alko = false;
                novoB = new BezalkoholnoPice(id, nazivP, proizvodjacP, zapreminaP, cenaP, alko,DaG);            
            }
            else if(izbor == 3){
                return;
            }
            FileWriter fw = null;
            BufferedWriter bw = null;
            try{
                fw = new FileWriter("Pica.txt",true);
                bw = new BufferedWriter(fw);
                if(izbor==1){
                bw.append(novoA.ispisDatoteka());
                    System.out.println("Uspesno ste dodali novi artikl.");}
                if(izbor==2){
                bw.append(novoB.ispisDatoteka());
                 System.out.println("Uspesno ste dodali novi artikl.");}
                bw.newLine();

            }catch (FileNotFoundException ex) {
                System.out.println("File nije otvoren za citanje!");}
            catch (IOException ex) {
                   System.out.println("IO exception kod filew i bw");
                }
                finally{
                    try {
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        System.out.println("IO exception kod filew i bw");
                    }
                }
}
    
    public static void obrisiPice() {
         ArrayList<Pice> lista = new ArrayList<>();
         lista = ucitajListuPica();
         int flag = 0;
         int idPica =0;
         int forFlag = 0;
         int brojac =0;
         Scanner scan = new Scanner(System.in);
                 
        System.out.println("\nLista pica:");
        for(Pice pi: lista){
            System.out.println(pi.ispisKonzola());  
        }       
         
         do{
                System.out.println("\nUnesite validan ID pica koje zelite da obrisete: ");
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
         
         
         for(Pice a: lista){
            
         if(a.getId()==idPica){
            lista.remove(brojac);
            flag=1;
            System.out.println("\nUspesno ste obrisali pice!");
            break;
       }
         brojac++;
       }
         
       if(flag==0){System.out.println("Ne postoji pice sa izabranim ID! Vraceni ste u glavni meni.");}
       FileWriter fw = null;
       BufferedWriter bw = null;
            try{
                fw = new FileWriter("Pica.txt");
                bw = new BufferedWriter(fw);
                for(Pice a: lista){
                if(a.isAlkoholno()==true){
                bw.write(((AlkoholnoPice)a).ispisDatoteka());
                bw.newLine();
                }
                else if(a.isAlkoholno()==false){
                bw.write(((BezalkoholnoPice)a).ispisDatoteka());
                bw.newLine();
                }
                }
               
            }catch (FileNotFoundException ex) {
                System.out.println("File nije otvoren za citanje!");}
            catch (IOException ex) {
                   System.out.println("IO exception kod filew i bw");
                }
                finally{
                try {
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("IO exception kod filew i bw");
                }
                }
        
        
    }
    
    public static void izmeniPice() {
        
        ArrayList<Pice> lista = new ArrayList<>();
        lista = ucitajListuPica();
        int flag = 0;
        int idPica =0;
        int forFlag = 0;
        int brojac =0;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nLista pica:");
        for(Pice pi: lista){
            System.out.println(pi.ispisKonzola());  
        }  
        
         do{
                System.out.println("\nUnesite validan ID pica koje zelite da izmenite: ");
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
         
         
         for(Pice a: lista){
            
         if(a.getId()==idPica){
            if(a.isAlkoholno()==true){
                System.out.println("\nIzabrali ste da izmenite alkoholno pice " + a.getNaziv() +  " !");
                System.out.println(a.ispisKonzola());
                System.out.println("\nSta zelite od atributa da izmenite?");
                System.out.println("1. Naziv");
                System.out.println("2. Proizvodjac");
                System.out.println("3. Zapremina");
                System.out.println("4. Cena");
                System.out.println("5. Procenat alkohola");
                System.out.println("6. Vrati se na glavni meni");
                int izmeni = 0;
                   
             do{
                System.out.println("Unesite neku od ponudjenih opcija: ");
                while(scan.hasNextInt()==false){
                   scan.next();
                }
                izmeni = scan.nextInt();
          }while(izmeni>6 || izmeni<1);
                AlkoholnoPice novoA  = null;
                BezalkoholnoPice novoB=null;
             switch(izmeni){
                 case 1:
                    System.out.println("Trenutni naziv je: " + a.getNaziv() + " \nUnesite novi naziv: ");
                    String nazivP = scan.nextLine();
                    nazivP = scan.nextLine();
                    a.setNaziv(nazivP);
                    novoA = new AlkoholnoPice(a.getId(),nazivP, a.getProizvodjac(), a.getZapremina(), a.getCena(), true,((AlkoholnoPice)a).getProcenatAlkohola());
                    break;
                 case 2: 
                    System.out.println("Trenutni proizvodjac je: " + a.getProizvodjac()+ " \nUnesite novog proizvodjaca: ");
                    String proizvodjacP = scan.nextLine();
                    proizvodjacP = scan.nextLine();
                    a.setProizvodjac(proizvodjacP);
                    novoA = new AlkoholnoPice(a.getId(),a.getNaziv(),proizvodjacP, a.getZapremina(), a.getCena(), true,((AlkoholnoPice)a).getProcenatAlkohola());
                    break;
                 case 3: 
                    System.out.println("Trenutna zapremina je: " + a.getZapremina()+ " \nUnesite novu zapreminu: ");
                    double zapreminaP;    
                    while(!scan.hasNextDouble()){
                        String ulaz=scan.next();
                        System.out.println("! Unesi broj !");
                    }
                    zapreminaP=scan.nextDouble();
                    a.setZapremina(zapreminaP);
                    novoA = new AlkoholnoPice(a.getId(),a.getNaziv(), a.getProizvodjac(), zapreminaP, a.getCena(), true,((AlkoholnoPice)a).getProcenatAlkohola());
                    break;
                 case 4: 
                    System.out.println("Trenutna cena je: " + a.getCena()+ " \nUnesite novu cenu: ");
                    double cenaP;
                    while(!scan.hasNextDouble()){
                        String ulaz=scan.next();
                        System.out.println("! Unesi broj !");
                    }
                    cenaP=scan.nextDouble();
                    a.setCena(cenaP);
                    novoA = new AlkoholnoPice(a.getId(),a.getNaziv(), a.getProizvodjac(), a.getZapremina(), cenaP, true,((AlkoholnoPice)a).getProcenatAlkohola());
                    break;
                 case 5: 
                    System.out.println("Trenutni procenat alkohola je: " + ((AlkoholnoPice)a).getProcenatAlkohola()+ " \nUnesite novi procenat alkohola: ");
                    double procenatAlkoholaP;
                    while(!scan.hasNextDouble()){
                        String ulaz=scan.next();
                        System.out.println("! Unesi broj !");
                    }
                    procenatAlkoholaP=scan.nextDouble();
                    ((AlkoholnoPice)a).setProcenatAlkohola(procenatAlkoholaP);
                    novoA = new AlkoholnoPice(a.getId(),a.getNaziv(), a.getProizvodjac(), a.getZapremina(), a.getCena(), true,procenatAlkoholaP);
                    break;
                 case 6: 
                    return;
             }
             
            }//kraj ifa alkoholno
            
            else  if(a.isAlkoholno()==false){
            
                 System.out.println("\nIzabrali ste da izmenite bezalkoholno pice " + a.getNaziv() +  " !");
                System.out.println(a.ispisKonzola());
                System.out.println("\nSta zelite od atributa da izmenite?");
                System.out.println("1. Naziv");
                System.out.println("2. Proizvodjac");
                System.out.println("3. Zapremina");
                System.out.println("4. Cena");
                System.out.println("5. Da li je gazirano pice");
                System.out.println("6. Vrati se na glavni meni");
                int izmeni = 0;
                   
             do{
                System.out.println("Unesite neku od ponudjenih opcija: ");
                while(scan.hasNextInt()==false){
                   scan.next();
                }
                izmeni = scan.nextInt();
          }while(izmeni>6 || izmeni<1);
                BezalkoholnoPice novoB  = null;
             switch(izmeni){
                 case 1:
                     System.out.println("Trenutni naziv je: " + a.getNaziv() + " \nUnesite novi naziv: ");
                     String nazivP = scan.nextLine();
                     nazivP = scan.nextLine();
                     a.setNaziv(nazivP);
                     novoB = new BezalkoholnoPice(a.getId(),nazivP, a.getProizvodjac(), a.getZapremina(), a.getCena(), false,((BezalkoholnoPice)a).isDaLiJeGazirano());
                     break;
                 case 2: 
                     System.out.println("Trenutni proizvodjac je: " + a.getProizvodjac()+ " \nUnesite novog proizvodjaca: ");
                     String proizvodjacP = scan.nextLine();
                     proizvodjacP = scan.nextLine();
                     a.setProizvodjac(proizvodjacP);
                    novoB = new BezalkoholnoPice(a.getId(),a.getNaziv(),proizvodjacP, a.getZapremina(), a.getCena(), false,((BezalkoholnoPice)a).isDaLiJeGazirano());
                     break;
                 case 3: 
                    System.out.println("Trenutna zapremina je: " + a.getZapremina()+ " \nUnesite novu zapreminu: ");
                    double zapreminaP;    
                    while(!scan.hasNextDouble()){
                        String ulaz=scan.next();
                        System.out.println("! Unesi broj !");
                    }
                    zapreminaP=scan.nextDouble();
                    a.setZapremina(zapreminaP);
                    novoB = new BezalkoholnoPice(a.getId(),a.getNaziv(), a.getProizvodjac(), zapreminaP, a.getCena(), false,((BezalkoholnoPice)a).isDaLiJeGazirano());
                    break;
                 case 4: 
                    System.out.println("Trenutna cena je: " + a.getCena()+ " \nUnesite novu cenu: ");
                    double cenaP;
                    while(!scan.hasNextDouble()){
                        String ulaz=scan.next();
                        System.out.println("! Unesi broj !");
                    }
                    cenaP=scan.nextDouble();
                    a.setCena(cenaP);
                    novoB = new BezalkoholnoPice(a.getId(),a.getNaziv(), a.getProizvodjac(), a.getZapremina(), cenaP, false,((BezalkoholnoPice)a).isDaLiJeGazirano());
                    break;
                 case 5: 
                    System.out.println("Pice je gazirano: " + ((BezalkoholnoPice)a).isDaLiJeGazirano()+ " \nUnesite novu vrednost: ");
                    scan.nextLine();
                    String DaGS=scan.nextLine();
                    while(DaGS.toLowerCase().equals("da")==false && DaGS.toLowerCase().equals("ne")==false){
                        System.out.println("!!! Unesite Da ili Ne !!!");
                        DaGS=scan.nextLine(); 
                    }
                    boolean DaG=true; /*= scan.nextBoolean()*/;
                    //System.out.println(DaGS.toLowerCase()+" neasdsadasd");
                    if(DaGS.toLowerCase().equals("da"))
                        DaG=true;
                    if(DaGS.toLowerCase().equals("ne"))
                        DaG=false;

                    /*boolean daLiJeGaziranoP = scan.nextBoolean();
                    ((BezalkoholnoPice)a).setDaLiJeGazirano(daLiJeGaziranoP);*/
                    novoB = new BezalkoholnoPice(a.getId(),a.getNaziv(), a.getProizvodjac(), a.getZapremina(), a.getCena(), false,DaG);
                    ((BezalkoholnoPice)a).setDaLiJeGazirano(DaG);
                    //System.out.println(DaG);
                    break;
                 case 6: 
                    return;
             }
             
            
            
            
            
            
            
            }
            
            
            flag=1;
            System.out.println("\nUspesno ste izmenili pice!");
            break;
       }
         brojac++;
       }
         
       if(flag==0){System.out.println("Ne postoji pice sa izabranim ID! Vraceni ste u glavni meni.");}
       FileWriter fw = null;
       BufferedWriter bw = null;
            try{
                fw = new FileWriter("Pica.txt");
                bw = new BufferedWriter(fw);
                for(Pice a: lista){
                if(a.isAlkoholno()==true){
                bw.write(((AlkoholnoPice)a).ispisDatoteka());
                bw.newLine();
                }
                else if(a.isAlkoholno()==false){
                bw.write(((BezalkoholnoPice)a).ispisDatoteka());
                bw.newLine();
                }
                }
               
            }catch (FileNotFoundException ex) {
                System.out.println("File nije otvoren za citanje!");}
            catch (IOException ex) {
                   System.out.println("IO exception kod filew i bw");
                }
                finally{
                try {
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("IO exception kod filew i bw");
                }
                }
        
        
    }
    
}
