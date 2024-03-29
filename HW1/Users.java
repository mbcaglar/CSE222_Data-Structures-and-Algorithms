import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;

public class Users extends Person{

    private String secim="0";
    private int indexAd;
    private int arrSecenek;
public Users(String first,String last){
        name=first;
        surname=last;
    }

public void giris(){
       
        try{
            boyut1=0;
            this.Oku("users.txt",1);

        }
        catch(IOException e){
            System.out.println("users.txt FİLE ERROR...!!!");
        }
        int count=0;
        String tamAd=name+" "+surname;
        for(int i=0; i<boyut1; i++){
            
            if((arrUser[i].indexOf(name+" "+surname))!=-1){
                
                int index1=arrUser[i].indexOf(name+" "+surname);
                int index2=arrUser[i].indexOf(",");
                String name_surname= arrUser[i].substring(index1,index2);
               
                if(tamAd.contentEquals(name_surname)){
                    count++;
                    
                    indexAd=i;
                    i=boyut1+1;
                }
                
            }
        }
        if(count==0){
            System.out.println("\nSayin "+name+" "+surname+"\nSystemimizde kayitli boyle bir kullanici bulunamadi...");
            System.out.println("LUTFEN GOREVLİYLE İLETİSİME GECİNİZ..!\n");
            return;
        }
        Scanner input=new Scanner(System.in);
        System.out.println("\nDegerli Kullanicimiz"+" "+name+" "+surname);
        System.out.println("Kitap Almak icin--------->1\n"+"Kitap teslim etmek için-->2");
        
        while (!(secim.equals("1")) && !(secim.equals("2"))) {            
      
            System.out.print("Your Choice-->");
            
            secim=input.next();
       
            System.out.println();
     
            if(!(secim.equals("1")) && !(secim.equals("2")))
            {
                System.out.println("Yanlıs bir secim yaptiniz...!\n!..Tekrar seciniz..! ");
            }
       
        }
        if(secim.equals("1")){
      
            
            if(arrUser[indexAd].indexOf("NULL")==-1){
                System.out.println("\nDegerli uyemiz elinizdeki kitabi teslim etmeden yeni bir kitap alamazsiniz..");
                Upmenu();
                
                }
            else{
            String kitap;
            System.out.print("Almak istediginiz kitabin adini giriniz = ");
            kitap=input.next(); 
            kitap+=input.nextLine();
            kitap=kitap.toUpperCase();
            SearchBook(kitap);
            }
            
        }
        else if(secim.equals("2")){
            try{
                boyut2=0;
                this.Oku("books.txt",2);
            }
            catch(IOException e){
                System.out.println("books.txt FİLE ERROR...!!!");
            }
            
            int indexvirgul;
            int k=0;
            int siraBook=0;
            indexvirgul=arrUser[indexAd].indexOf(",");
            
            if(arrUser[indexAd].indexOf("NULL")!=-1){
                System.out.println("Degerli uyemiz elinizde olmayan bir kitabi teslim edemezsiniz..! ");
                Upmenu();
                
            }
            else if(arrUser[indexAd].indexOf("NULL")==-1){

                Scanner inp =new Scanner(System.in);
                String sec;
                String sub=arrUser[indexAd].substring(indexvirgul+1);
              
                for(int i=0; i<boyut2; i++){
                    
                    if(arrBook[i].indexOf(sub)!=-1){
                       k=arrBook[i].indexOf(",");
                       String kitap_ad=arrBook[i].substring(0,k);
                       
                        if(kitap_ad.equalsIgnoreCase(sub)){
                        
                            siraBook=i;
                           
                            UpdateBookTxt(arrBook,k+1,siraBook,"NULL");
                            UpdateUserTxt("NULL");
                            
                            System.out.println("Degerli uyemiz "+name+" "+surname+", "+sub+" isimli kitap system tarafindan teslim alinmistir. ");
                            
                            kontrol(sub);                          
                            i=boyut2+1;          
                       }
                    }
                
                }          
        } 
     }
        return;
}
    public void SearchBook(String kitap){
        try{
            boyut2=0;
            this.Oku("books.txt",2);
        
        
        int count=0;
        for(int i=0; i<boyut2; i++){
           
            if((arrBook[i].indexOf(kitap))!=-1){
                
                int index1=arrBook[i].indexOf(kitap);
                int index2=arrBook[i].indexOf(",");
                String kitapAd=arrBook[i].substring(index1, index2);
                
                if(kitap.contentEquals(kitapAd)){
                
                    if((arrBook[i].indexOf("NULL"))==-1){
                    
                        System.out.println("\nSuanda "+kitap+" isimli kitap baska bir kullanicimizda olup,\nANLAYİSİNİZ İCİN TESEKKUR EDERİZ..");
                       
                        kontrol(kitap);
                        i=boyut2+1;
                    
                    }
                    else if((arrBook[i].indexOf("NULL"))!=-1){

                        int index; 

                        index=arrBook[i].indexOf("NULL");
                        String ad=name+" "+surname;
                        UpdateBookTxt(arrBook,index,i,ad);
                        UpdateUserTxt(kitap);
                    
                        System.out.println("\nDegerli uyemiz "+name +" "+surname+","+kitap+" isimli kitabimiz system tarafindan adiniza kaydedilmistir.");
                        System.out.println("Kurallar geregi alinan kitabi 1 hafta icerisinde tarafimiza teslim ediniz.");
                        
                        i=boyut2+1;
                        
                    }

                    count++;
                    
                }
            
            }             
           
        }
         if(count==0){
             System.out.println("\nSystemimizde kayitli boyle bir kitap bulunmamaktadir...");
             kontrol(kitap);
            }
    }
        catch(IOException e){
            System.out.println("HATA!!!");
        }
        return;
}
    public void UpdateBookTxt(String arr[],int index,int sira,String ad){
        
        String tmp1=arr[sira].substring(0, index);
        arr[sira]=tmp1+ad;
        
        try{
            FileWriter filename=new FileWriter("books.txt");
            PrintWriter yaz=new PrintWriter(filename);
            for(int i=0; i<boyut2; i++){
            
                yaz.println(arrBook[i]);
            }
            yaz.close();
        }
        catch(IOException e){
            System.out.println("Dosya acilamadi!!!");
            System.exit(0);
        }
        
    }
    public void UpdateUserTxt(String kitap){
        
        int index;
        String tamAd=name+" "+surname;
        for(int i=0; i<boyut1; i++){
            
            
            if((arrUser[i].indexOf(name+" "+surname))!=-1){
                
                int index1=arrUser[i].indexOf(name+" "+surname);
                int index2=arrUser[i].indexOf(",");
                String name_surname= arrUser[i].substring(index1,index2);
               
                if(tamAd.contentEquals(name_surname))
                {
                    index=arrUser[i].indexOf(",");
                    String tmp1=arrUser[i].substring(0, index+1);
                    arrUser[i]=tmp1+kitap;
                    try{
                        FileWriter filename=new FileWriter("users.txt");
                        PrintWriter yaz=new PrintWriter(filename);

                        for(int j=0; j<boyut1; j++){
            
                            yaz.println(arrUser[j]);
                        }
                        yaz.close();
                    }
                    catch(IOException e){
                        System.out.println("Dosya acilamadi!!!");
                        System.exit(0);
                    }
                    i=boyut1+1;
                }
                
            }
            
        }
            
    }
    
public void kontrol(String kitap){
    
    Scanner input=new Scanner(System.in);
                        boolean kontrol=true;
                       
                        while(kontrol){
                            
                            String sec;
                            System.out.println("\nBaşka bir kitap almak icin-->(*)");
                            System.out.println("CİKMAK İCİN---->(q)");
                            System.out.print("--------------->>");
                            sec=input.next();

                        
                        
                            if(sec.equalsIgnoreCase("q")){
                                System.out.println("\nHAYİRLİ GUNLER DİLERİZ...");
                                System.exit(0);

                            }
                            else if(sec.equalsIgnoreCase("*")){
                                
                                System.out.print("\nAlmak istediginiz kitabin adini giriniz = ");
                                kitap=input.next(); 
                                kitap+=input.nextLine();
                                kitap=kitap.toUpperCase();
                                SearchBook(kitap);
                                kontrol=false;
                            
                            }
                            else{
                                System.out.println("HATALİ SECİM YAPTİNİZ..!!!");
                                kontrol=true;
                            }
                        }
                        return;
}
public void Upmenu(){
               
    
        Scanner input=new Scanner(System.in);
        boolean kontrol=true;
                             
        while(kontrol){
                            
  
            String sec;

            System.out.println("ÜST MENÜ İCİN-->(*)");
            System.out.println("CİKMAK İCİN---->(q)");
            System.out.print("--------------->>");
            sec=input.next();

                        
                        
                        if(sec.equalsIgnoreCase("q")){
                            System.out.println("HAYİRLİ GUNLER DİLERİZ...");
                            System.exit(0);
                            
                        }
                        else if(sec.equalsIgnoreCase("*")){
                           
                            secim="0";
                            this.giris();
                            kontrol=false;
                           
                            
                        }
                        else{
                            System.out.println("HATALİ SECİM YAPTİNİZ..!!!");
                            kontrol=true;
                        }
                    }
        return;
    }

}