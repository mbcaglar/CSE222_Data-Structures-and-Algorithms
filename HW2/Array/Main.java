
/*

   ****** M.BEDİRHAN ÇAĞLAR ******
            
     ------- 25.02.2017 ---------

Bu program basit bir Librar systemidir.System çalıştığında ki ara yüz takip
edildiğinde Staff ve Users secenekleri gelmektedir.

~ Staff secildiginde,sadece stafflerin kullandıgı sifre ile giris yapilir ve 
sonra 3 yeni secenek gelir. User ekleme,kitap ekleme ve de kitap silme.Systeme 
kayitli olan users ve kitaplar kontrol edilerek islemler yapilir.Örneğin systeme
kayıtlı olanlar için uyarı mesajı verir zaten systemde kayıtlı olduğu söylenir.
Kitap silerken ise eger kitap bir üyede kayıtlı ise onun silinmesini önleyerek 
uyarı verir,ayrıca olmayan bir kitabi silemez.

~ Users secildiginde ise yeni bir ara yüz gelir ve name,surname tale eder,eger 
boyle bir üye yoksa staffa basvurmasını üye olmadıgını söyler.Eger üye ise,
2 yeni secenek sunar;Kitap almak yada teslim etmek için kullanıcıdan input bekler.
Eger elinde kitap varken yeni bir kitap almak isterse uyarı verir alamayacagını 
soyler veya elinde kitap yokken teslim et secenegini girerse yine hata mesajını
kullanıcıya sunar.



@param 


*/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
 
public class Main {
    
    public static void main(String[] args) {
 
       String name;
       String surname;
       
       Scanner input=new Scanner(System.in);
       System.out.println("WELCOME tO Library System Management... ");
      
       boolean control=true;
       
       while(control){
          
        Screen library=new Screen();
           
        if(library.getSecenek().equals("1")){
           
           String sifre;
           boolean kontrol=true;
           System.out.println("Systeme Staff olarak giris yapmak icin parola girmeniz gerekmektedir.");
           System.out.print("Lutfen parola giriniz----> ");
           sifre=input.next();
           Staff staff=new Staff(sifre);
           int k=0;
           while(kontrol){
                if(k!=0){
                System.out.print("Lutfen parola giriniz----> ");
                
                sifre=input.next();
                }

                if(sifre.equals(staff.getParola())){

                    staff.setParola(sifre);
                    staff.giris();
                    kontrol=false;

                }
                else{
                    k++;
                    if(k==3){
                        System.out.println();
                        System.out.println("3 kere yanlış giriş yaptiniz..!!!");
                        System.out.println("System otomatik olarak kapandı.");
                        kontrol=false;
                    }
                    else{
                        System.out.println("YANLIŞ ŞİFRE("+k+")\n");
                    }
                    
                 }
           }
       }
       else if(library.getSecenek().equals("2")){
            System.out.print("NAME----->");
            name =input.next();
            System.out.print("SURNAME-->");
            surname =input.next();
        
            name=name.toUpperCase();
            surname=surname.toUpperCase();

           Users user=new Users(name,surname);
           user.giris();
       }
           boolean cikis=true;
          
           String sec;
          while(cikis){
           System.out.println("\nILK MENUYE DONMEK İCİN--->(*)");
           System.out.println("CIKMAK İCİN-------------->(q)");
           System.out.print("Your Choice-----------------> ");
           sec=input.next();
           
           if(sec.equals("q")){
               System.out.println("\nHAYİRLİ GUNLER DİLERİZ...");
               control=false;
               cikis=false;
           }
           else if(sec.equals("*")){
               cikis=false;
               control=true;
           }
           else{
               System.out.println("HATALİ SECİM YAPTİNİZ!!!");
               
           }
        }
     }

    }
}