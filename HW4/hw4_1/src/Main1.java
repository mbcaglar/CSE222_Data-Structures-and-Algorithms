import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
import java.util.Scanner;



public class Main1 {

    public void Oku(String filename) throws IOException ,FileNotFoundException{
        
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        String arr[];
        String line;
        int sayi;
        
      try(FileWriter fw = new FileWriter("testResult_1.csv", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter yaz = new PrintWriter(bw)){
                     
        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine())!= null) {
                arr = line.split(",");
                
                if(new Scanner(arr[0]).hasNextInt()){
                
                    StackA<Integer> mylist= new StackA<>();
                    for(int i=0; i<arr.length; i++){
                        
                        mylist.push(Integer.parseInt(arr[i]));
                        
                    }
                    Txt(yaz,mylist,arr.length);
                }
                
                else if(new Scanner(arr[0]).hasNext()){
                   
                    if(arr[0].length()>1){
                         
                    StackB<String> mylist= new StackB<>();
                    
                    for(int i=0; i<arr.length; i++){
                        
                            mylist.push(arr[i]);
                        }

                            Txt(yaz,mylist,arr.length);
                     
                     
                     
                    }
                    else if(arr[0].length()==1){
 
                        StackC<Character> mylist= new StackC<>();
                        for(int i=0; i<arr.length; i++){
                            
                            mylist.push(arr[i].charAt(0));
                        } 
                         Txt(yaz,mylist,arr.length);  
                    }
                   
                }
                
                
            }
        }
              yaz.close();

      }
      catch (IOException e) {
                       System.out.println("Dosya Hatası...!!!");
                        System.exit(0);
                     }
 }
    public void Txt(PrintWriter yaz,Stack list, int size){
        
       
       
        {
           for(int i=0; i<size; i++){
             
            yaz.print(list.pop());
    
            if(i<size-1){
                yaz.print(",");
            }
           }
           yaz.println();
           
        } 
        
        
     
 }
    
    
    public static void main(String[] args) {

        /*
            
        System.out.println("---------TEST STACKA------------");
        StackA<String> a= new StackA<>();
        a.push("bedo");
        a.push("sedo");
        a.push("kedo");
       
        a.get();
        a.pop();
        
        System.out.println("----POP-----");
        a.get();
        a.push("ARABA");
        a.push("VAPUR");
        System.out.println("----PUSH-----");
        a.get();
        a.pop();
        System.out.println("----POP-----");
        a.get();
         
        System.out.println("---------TEST STACKB------------");
        
        StackB<String> b= new StackB<>();
        b.push("bedo");
        b.push("sedo");
        b.push("kedo");
       
        b.get();
        b.pop();
        
        System.out.println("----POP-----");
        b.get();
        b.push("ELMA");
        b.push("ARMUT");
        System.out.println("----PUSH-----");
        b.get();
        b.pop();
        System.out.println("----POP-----");
        b.get();

        System.out.println("---------TEST STACKC------------");
        
        StackC<String> c= new StackC<>();
        c.push("bedo");
        c.push("sedo");
        c.push("kedo");
       
        c.get();
        c.pop();
        
        System.out.println("----POP-----");
        c.get();
        c.push("SİLGİ");
        c.push("KALEM");
        System.out.println("----PUSH-----");
        c.get();
        c.pop();
        System.out.println("----POP-----");
        c.get();
        
        System.out.println("---------TEST STACKD------------");
        StackD<String> d= new StackD<>();
     
        d.push("bedo");
        d.push("sedo");
        d.push("kedo");
       
        d.get();
        d.pop();
        
        System.out.println("----POP-----");
        d.get();
        d.push("BESİKTAS");
        d.push("FENER");
        System.out.println("----PUSH-----");
        d.get();
        d.pop();
        System.out.println("----POP-----");
        d.get();
        */
       
        Main1 dene= new Main1();
        try{
        dene.Oku("test.csv");
        }
        catch (IOException e){
            System.out.println("Hatalı Dosya !!!");
            System.exit(0);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ındexoutofexception hatasi...!!!");
            System.exit(0);
            
        }
     
      
    }   
}
