import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class myStringBuilder {

    @SuppressWarnings("rawtypes")
	private final LinkedList mylist=new LinkedList();
    
    @SuppressWarnings("unchecked")
	public void Oku(String filename) throws IOException ,FileNotFoundException{
        
    
        
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        
        String line;
        int sayi;
        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine())!= null) {
                
                
                //line = line.trim();
                sayi= Integer.parseInt(line);
                
                /*
                if (line.length() == 0) {
                System.out.println("csascacca");
                continue;
                }
                try{
                sayi=Integer.parseInt(line);
                System.out.println("sayi :");
                }
                catch(NumberFormatException e){
                System.out.println("fffffffffff");
                }
                */
                mylist.add(sayi);
                
                
            }
        }
 }
    public void Bas(){
        
        for(int i=0; i<mylist.size(); i++){
       
            System.out.println(mylist.get(i)+"\n");
        }
        
    }
    
    
    @Override
  public String toString() {
    
                return mylist.toString();
    }
    public String toString1(){
            
        int i=0;
        String result = "[";
            
        while(i<mylist.size()){
                
                result += mylist.get(i) + " ";
                i++;
            }

        result+="]";
        return result;
          

    }
    public String toString2(){
        String tmp="[";
        @SuppressWarnings("rawtypes")
		Iterator itr = mylist.iterator();
    
        while(itr.hasNext()){
            tmp+=itr.next()+" ";
        }
        tmp+="]";
        return tmp;
    }
    
        public void Txt(String file,int secenek){
        
        
        try{
               
            FileWriter filename= new FileWriter(file);
            try (PrintWriter yaz = new PrintWriter(filename)) {
                switch (secenek) {
                    case 1:
                        yaz.println("(Own LinkedListed toString)");
                        yaz.println(toString());
                        break;
                    case 2:
                        yaz.println("(index and get) LinkedListed toString");
                        yaz.println(toString1());
                        break;
                    case 3:
                        yaz.println("(iterator LinkedListed toString)");
                        yaz.println(toString2());
                        break;
                    default:
                        System.out.println("Hatalı secim...");
                        System.exit(0);
                }
            }
            }

            catch(IOException e){
            System.out.println("Dosya acilamadi!!!");
                    System.exit(0);
            }
     
  }
    
}
  

