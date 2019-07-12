
import java.util.Scanner;

public class Screen {

    private String secenek="0";
    
    public String getSecenek(){
        return secenek;
    }
    public Screen(){
        
        giris();
    }
    public void giris(){
       
       Scanner input=new Scanner(System.in);
       
       System.out.println("For Staff->(1)\n"+"For Users->(2)");
        while ( !(secenek.equals("1")) && !(secenek.equals("2"))) {            
       System.out.print("\nYour Choice-->");
       secenek=input.next();
       System.out.println();
       if(!(secenek.equals("1")) && !(secenek.equals("2"))){
           System.out.println("Yanlıs bir secim yaptiniz...!\n!..Tekrar seciniz..! ");
       }
       }
    }
    public void secenek(){
       Scanner input=new Scanner(System.in);
        while (!(secenek.equals("1")) && !(secenek.equals("2"))) {            
       System.out.print("Your Choice-->");
       secenek=input.next();
       System.out.println();
       if(!(secenek.equals("1")) && !(secenek.equals("2"))){
           System.out.println("Yanlıs bir secim yaptiniz...!\n!..Tekrar seciniz..! ");

        }
    }
   }
    
    
}