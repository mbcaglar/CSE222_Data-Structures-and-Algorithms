import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person implements Library{
    
    protected String name;
    protected String surname;
    protected String secenek;
    protected int boyut1;
    protected int boyut2;
    protected ArrayList<String> arrUser=new ArrayList<String>();
    protected ArrayList<String> arrBook=new ArrayList<String>();
    
    public Person(){
        name="bos";
        surname="bos";
    }
     public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public void setName(String first){
         name=first;
    }
    public void setSurname(String last){
        surname=last;
    }
    public String getSecenek(){
        return secenek;
    }
    public void setSecenek(String deger){
         secenek=deger;
    }
    
    /**
     * Bu fonksiyon genel düzeneğin döndüğü fonksiyondur.Name ve surname sorarak
     * sistemin inter facesi üzerinden seçenekler sunar.
     */
    public void giris(){
     
        Scanner input=new Scanner(System.in);
       System.out.println("WELCOME tO Library System Management.. ");
       System.out.print("NAME----->");
       name =input.next();
       System.out.print("SURNAME-->");
       surname =input.next();
       System.out.println("For Staff->(1)\n"+"For Users->(2)");
       
       System.out.print("Your Choice-->");
       secenek=input.next();
       System.out.println();
      
    }
    /**
     * 
     * @param name
     * @param secenek 
     * 
     * Bu fonksiyon girilen seçenek doğrultusunda book veya user arrayine eleman
     * ekler
     */
        public void arrayEkle(String name,int secenek){
        
        
        if(secenek==1){
            
            arrUser.add(name);
            boyut1++;
         /*   if(boyut1>=SIZE1){
                String tmp[]=new String[SIZE1];
                for(int i=0; i<boyut1; i++){
                    
                    tmp[i]=arrUser[i];
                }
                SIZE1=SIZE1*2;
                arrUser=new String[SIZE1];
                
                for(int i=0; i<boyut1; i++){
                    arrUser[i]=tmp[i];
                }        
                arrUser[boyut1]=name;
                
                return arrUser;
            }
            else{
                arrUser[boyut1]=name;
                boyut1++;
                return arrUser;
            }*/
        }
        else if(secenek==2){
  
            arrBook.add(name);
            boyut2++;
            
        } 
}
        /**
         * 
         * @param filename
         * @param arrSecenek
         * @throws IOException
         * @throws FileNotFoundException
         * girilen secenek doğrultusunda book veya user filenı okuyup, yine book 
         * veya user arrayini doldurur.
         */
    public void Oku(String filename,int arrSecenek)throws IOException ,FileNotFoundException {
    
     try{
        
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);

        String line;

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            
            if(arrSecenek==1){
                arrayEkle(line,arrSecenek);
            }    
            else if(arrSecenek==2){
               arrayEkle(line,arrSecenek);;
            }
        }
    br.close();
}
    catch(FileNotFoundException e){
        System.out.println("File is not found !!!");
        System.exit(0);
    }
    catch(IOException e){
        System.out.println("hata");
    }
 }
    
    

}