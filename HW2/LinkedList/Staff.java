
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;


public class Staff extends Person{
    
    private String parola;

    public Staff(String sifre){
        
       parola="1234";
    }
    
    public String getParola(){
        return parola;
    }
    public void setParola(String sifre){
    
        parola=sifre;
    }
    
    public void giris(){
        try{
            boyut1=0;
            this.Oku("users.txt",1);

        }
        catch(IOException e){
            System.out.println("users.txt FİLE ERROR...!!!");
        }
        try{
            boyut2=0;
            this.Oku("books.txt",2);

        }
        catch(IOException e){
            System.out.println("books.txt FİLE ERROR...!!!");
        }
       
        this.Menu();
        
        if(secenek.equals("1")){
            
            userEkle();
        }
        else if(secenek.equals("2")){
            bookEkle();
        }
        else if(secenek.equals("3")){
            
            bookRove();
        }
        return;
    }
    /**
     * Staff menusundeki seceneklerin sunulması için tasarlanan fonksiyon.
     */
    public void Menu(){
        
        Scanner input=new Scanner(System.in);
        boolean kontrol=true;
        
        while(kontrol){
        System.out.println("\nKütüphaneye USER EKLEMEK icin---------->1");
        System.out.println("Kütüphaneye   KİTAP EKLEMEK icin------->2");
        System.out.println("Kütüphaneden  KİTAP SİLMEK  icin------->3");
        System.out.print("Your Choice----------------------------> ");
        secenek=input.next();
        
        if(secenek.equals("1") || secenek.equals("2") || secenek.equals("3")){
            kontrol=false;
        }
        else{
            System.out.println("Yanlis bir secim yaptiniz..!!!");
            System.out.println("!..Tekrar seciniz..! ");
        }
    }
    return;       
 
    }
    /**
     * Systeme user eklemek için kullanılan fonksyondur.Systeme kayıtlı olup 
     * olmadığını kontrol ederek bu işlemleri gerçekleştirir.
     */
    public void userEkle(){
        
        Scanner input=new Scanner(System.in);
        
        System.out.println("\nEklemek istediginiz kisinin,");
        System.out.print("ADI    : ");
        name=input.next();
        System.out.print("SOYADI : ");
        surname=input.next();
        name=name.toUpperCase();
        surname=surname.toUpperCase();
        String name_surname=name+" "+surname;
        int count=0; 
        for(int i=0; i<boyut1; i++){ 
            
            if((arrUser.get(i).indexOf(name_surname))!=-1){
                
                int index1=arrUser.get(i).indexOf(name_surname);
                int index2=arrUser.get(i).indexOf(",");
                String Ad=arrUser.get(i).substring(index1, index2);
                
                if(name_surname.contentEquals(Ad)){
                
                    System.out.println("\nEklemek istediğiniz "+name_surname+" isimli kullanıcı sytemimizde zaten kayıtlıdır.");
                    String sec;
                    boolean kontrol=true;
                    
                    
                    while(kontrol){
                    
                        System.out.println("\nBaska bir user eklemek icin--->( * )");
                        System.out.println("CIKMAK İCİN------------------->( q )");
                        System.out.print("Your Choice--------------------> ");
                        sec=input.next();
                        
                        if(sec.equals("*")){
                            userEkle();
                            kontrol=false;
                        }
                        else if(sec.equals("q"))
                                {
                            
                            
                            System.out.println("HAYIRLI GUNLER DİLERİZ...");
                            System.exit(0);
                        }
                        else{
                            System.out.println("HATALİ SECİM YAPTİNİZ!!!");
                        }
                        
                    }
                
                    count++;
                }
 
                
            
            }
        }
        if(count==0){
            
        String satir=(name+" "+surname+",NULL");
        
        
       arrayEkle(satir,1);

        TxtYenile("users.txt",1);
        System.out.println("Kullanıcı sistemimize basarili bir sekilde kaydedilmistir.");
        }

    }
    /**
     * Systeme kitap ekleme fonksiyonudur.Kitabın olup olmadığınıda kontrol eder.
     */
    public void bookEkle(){
        
        Scanner input=new Scanner(System.in);
        String name_kitap;
        System.out.println("\nEklemek istediginiz kitabın;");
        System.out.print("ADINI GİRİNİZ : ");
        name_kitap=input.next();
        name_kitap+=input.nextLine();
        name_kitap=name_kitap.toUpperCase();
        int count=0;
        
        for(int i=0; i<boyut2; i++){ 
            
            if((arrBook.get(i).indexOf(name_kitap))!=-1){
                
                int index1=arrBook.get(i).indexOf(name_kitap);
                int index2=arrBook.get(i).indexOf(",");
                String kitapAd=arrBook.get(i).substring(index1, index2);
                
                if(name_kitap.contentEquals(kitapAd)){
                
                    System.out.println("\nEklemek istediğiniz "+kitapAd+" isimli kitap sytemimizde zaten mevcuttur.");
                    String sec;
                    boolean kontrol=true;
                    
                    
                    while(kontrol){
                    
                        System.out.println("\nBaska bir kitap eklemek icin--->( * )");
                        System.out.println("CIKMAK İCİN------------------->( q )");
                        System.out.print("Your Choice--------------------> ");
                        sec=input.next();
                        
                        if(sec.equals("*")){
                            bookEkle();
                            kontrol=false;
                        }
                        else if(sec.equals("q"))
                                {
                            
                            
                            System.out.println("HAYIRLI GUNLER DİLERİZ...");
                            System.exit(0);
                        }
                        else{
                            System.out.println("HATALİ SECİM YAPTİNİZ!!!");
                        }
                        
                    }
                
                    count++;
                }
 
                
            
            }
        }
        if(count==0){
            
            
        String satir=name_kitap+","+"NULL";
        
        
        arrayEkle(satir,2);

        TxtYenile("books.txt",2);
        System.out.println("Kitap sistemimize basarili bir sekilde kaydedilmistir.");
        }
    }
    /**
     * kitap silme fonksiyonudur,silinecek kitabın olup olmadığını yada bir 
     * kullanılıcıdayken silmeye çalışılması durumunda gerekli hata maesajını verir.
     */
    public void bookRove(){
      
        Scanner input=new Scanner(System.in);
        String name_kitap;
        String sec;
        
        System.out.println("\nSilmek istediginiz kitabın;");
        System.out.print("ADINI GİRİNİZ : ");
        name_kitap=input.next();
        name_kitap+=input.nextLine();
        name_kitap=name_kitap.toUpperCase();
        int count=0;
        
        for(int i=0; i<boyut2; i++){ 
            
            if((arrBook.get(i).indexOf(name_kitap))!=-1){
                
                int index1=arrBook.get(i).indexOf(name_kitap);
                int index2=arrBook.get(i).indexOf(",");
                String kitapAd=arrBook.get(i).substring(index1, index2);
                
                if(name_kitap.contentEquals(kitapAd)){
                
                   if(arrBook.get(i).indexOf("NULL")==-1){
                       
                       System.out.println("\nSilmek istediginiz "+name_kitap+" isimli kitap şuanda kullanıcıda olduğu için,\n");
                       System.out.println("İŞLEMİNİZİ GERÇEKLEŞTİREMİYORUZ.");
                   
                        
                        boolean kontrol=true;


                        while(kontrol){

                            System.out.println("\nBaska bir kitap silmek icin--->(*)");
                            System.out.println("CIKMAK İCİN-------------------->(q)");
                            System.out.print("Your Choice--------------------> ");
                            sec=input.next();

                            
                            if(sec.equals("*")){
                                bookRove();
                                kontrol=false;
                            }
                            else if(sec.equals("q"))
                                    {


                                System.out.println("HAYIRLI GUNLER DİLERİZ...");
                                System.exit(0);
                            }
                            else{
                                System.out.println("HATALİ SECİM YAPTİNİZ!!!");
                            }
                        
                        }
                    }
                   
                   else if(arrBook.get(i).indexOf("NULL")!=-1){
                       
                        arraySil(i);
                        TxtYenile("books.txt",2);
                        System.out.println("Kitap sistemimizden basarili bir sekilde silinmistir.");
                   }
                
                    count++;
                }
 
                
            
            }
        }
        if(count==0){
        
            System.out.println("Systemde kayitli olmayan bir kitabi silemezsiniz!!!");
            boolean kontrol=true;


                        while(kontrol){

                            System.out.println("\nBaska bir kitap silmek icin--->( * )");
                            System.out.println("CIKMAK İCİN-------------------->(  q )");
                            System.out.print("Your Choice--------------------> ");
                            sec=input.next();

                            
                            if(sec.equals("*")){
                                bookRove();
                                kontrol=false;
                            }
                            else if(sec.equals("q"))
                                    {


                                System.out.println("HAYIRLI GUNLER DİLERİZ...");
                                System.exit(0);
                            }
                            else{
                                System.out.println("HATALİ SECİM YAPTİNİZ!!!");
                            }
                        
                    }
        }

  
    }
    /**
     * 
     * @param index_book 
     * silinecek kitabı arrayden çıkararak günceller.
     */
    public void arraySil(int index_book){
        
        for(int j=index_book; j<boyut2-1; j++){
        
            arrBook.set(j,arrBook.get(j+1));
        
        
        }
        boyut2--;
    }

    /**
     * 
     * @param file
     * @param secenek
     * Systemin tutuğu veriyi işlemler sonucunda günceller.
     * Hangi txtyi güncelleceğini de seçenek sayesinde algılar.
     */
    public void TxtYenile(String file,int secenek){
        
        
        try{
               
            FileWriter filename= new FileWriter(file);
            PrintWriter yaz=new PrintWriter(filename);
            if(secenek==1){
                for(int j=0; j<boyut1; j++){
               
                    yaz.println(arrUser.get(j));
                                
                }
            }
            else if(secenek==2){
                
                for(int j=0; j<boyut2; j++){
           
                    yaz.println(arrBook.get(j));
                }
            }
            yaz.close();
            }

            catch(IOException e){
            System.out.println("Dosya acilamadi!!!");
                    System.exit(0);
            }
     
  }  
     
}
   
