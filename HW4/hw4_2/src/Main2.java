
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

  /**
   * 
   * @param filename
   * @throws IOException
   * @throws FileNotFoundException
   * verilen filedan myQueue ye okur ve her okuduğu satırıda myQueue arrayine atar,bunları reverse ederekte testresult_2 ye yazar.
   */
    public void Oku(String filename) throws IOException ,FileNotFoundException{
        
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        String arr[];
        String line;
        int sayi;
        myQueue<myQueue> myList=new myQueue<>();
        myQueue tmp= new myQueue();
        
        
        try(FileWriter fw = new FileWriter("testResult_2.csv", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter yaz = new PrintWriter(bw)){
        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine())!= null) {
                arr = line.split(",");
                
                
                myQueue<Object> mylist= new myQueue<>();
               
                for(int i=0; i<arr.length; i++){
                 
                    mylist.addLast(arr[i]);
                }
                myList.addLast(mylist);
            }
            myList=myList.reverseQueue(myList);
            
            for(int i=0; i<myList.size(); i++){
            
                tmp=myList.get(i).reverse(myList.get(i));
                Txt(yaz,tmp,myList.get(i).size());
            
            }    
                
            }
        yaz.close();
                
        }
        catch (IOException e) {
            System.out.println("Dosya Hatası...!!!");
            System.exit(0);
        }
        
        
 }
    /**
     * yazma işlemini yapan fonksiyon
     * @param yaz
     * @param list
     * @param size 
     */
     public void Txt(PrintWriter yaz,myQueue list, int size){
        
 
        {
           for(int i=0; i<size; i++){
             
            yaz.print(list.get(i));
    
            if(i<size-1){
                yaz.print(",");
            }
           }
           yaz.println();
           
        } 
        
     
 }
    public static void main(String[] args) {
       
        
        Main2 main2 = new Main2();
        
        try{
            main2.Oku("test.csv");
        }
        catch(IOException e){
            
            System.out.println("Dosya Hatası...!!!");
            System.exit(0);
        }
       
        
        /*
        System.out.println("--------------myQueue Test1------------------");
        myQueue<String> a= new myQueue<>();
        a.addFirst("ali");
        a.addLast("ayse");
        a.addLast("fatma");
        a.addLast("ardaa");
        a.addLast("babaaa");
        a.goster();
        System.out.println("------------reverse()--------------------------");
        
        a.reverse(a);
        a.goster();
        System.out.println("-----------------------------------------------");
                System.out.println("----------------myQueue Test2------------------");
       myQueue<String> b= new myQueue<>();
        b.addFirst("C++");
        b.addLast("JAVA");
        b.addLast("PYTHON");
        b.addLast("C#");
        b.addLast("HTML");
        b.goster();
        System.out.println("--------reverseQueue()(recursive)--------------");
        
        b.reverseQueue(b);
        b.goster();
        
       
       */
        
    }
    
}
