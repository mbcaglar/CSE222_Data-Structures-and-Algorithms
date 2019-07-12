import java.io.IOException;

public class Main {
    
    
     public static void main(String[] args) {
      

        myStringBuilder list = new myStringBuilder();
        @SuppressWarnings("rawtypes")
		SingleLinkedList mylist=new SingleLinkedList();
      
        try{
        list.Oku("numbers.txt");
        mylist.Oku("dene.txt");
       
        }
       catch(IOException e){
        System.out.println("Okuma hatasi !!!");
       }
      
        //PART1
         System.out.println("PART1------>");
         System.out.println();
        long startTime = System.currentTimeMillis();
        
        list.Txt("result3.txt",3);
        
        long endTime = System.currentTimeMillis();
        long toplam_sure = endTime - startTime;
    
        double saniye = (double)toplam_sure/1000;
    
        System.out.println("Iterator toString için çalışma suresi => "+ saniye);
        System.out.println();  
        
        
        startTime = System.currentTimeMillis();
        list.Txt("result2.txt",2);
        endTime = System.currentTimeMillis();
        toplam_sure = endTime - startTime;
    
        saniye = (double)toplam_sure/1000;
    
        System.out.println("index ve get için toString için çalışma suresi => "+ saniye);
        System.out.println();        
        
        
        startTime = System.currentTimeMillis();
        
        list.Txt("result1.txt",1);
        
        endTime = System.currentTimeMillis();
        toplam_sure = endTime - startTime;
    
        saniye = (double)toplam_sure/1000;
    
        System.out.println("Kendi (LinkedList) toString için çalışma suresi => "+ saniye);
        
        System.out.println();
        
        //PART2
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("PART2------>");
        System.out.println();
        System.out.println(mylist.toString1());
        System.out.println();
        System.out.println("---------------------reverseToString-----------------------");
        System.out.println();
        System.out.println(mylist.reverseToString());
        
        
        
        //PART4
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("PART4------>");
        System.out.println();
         @SuppressWarnings("rawtypes")
		SingleLinkedList part4= new SingleLinkedList();
        try{
            
            part4.Oku("dene.txt");
       
        }
        catch(IOException e){
            System.out.println("Okuma hatasi !!!");
        }
        System.out.println("------ilk liste------");
        System.out.println(part4.toString1());
       

        try{
            
        
            for(int i=0; i<50; i++){
            
                part4.remove(i);
                
            
        }
        }
        catch(IndexOutOfBoundsException e){
               
            System.out.println("<< İndex hatasi...!>>");
            System.exit(0);
            
            }
       

        System.out.println();
        System.out.println("-----------sildikten sonra liste-----");
        System.out.println(part4.toString1());
        System.out.println();
        
        System.out.println("-----sildiğimiz NODLAR tutuğumuz liste----");
        System.out.println(part4.deletedToString());
        
        //for(int i=0; i<100; i++){
            try{
            part4.Oku("deneme.txt");
            }
            catch(IOException e){
                System.out.println("Okuma HAtası !!!");
                System.exit(0);
            }
        //}
        
        
        System.out.println();
        System.out.println("------------ekledikten sonra liste------");
        
        System.out.println(part4.toString1());
  }  
 
}
