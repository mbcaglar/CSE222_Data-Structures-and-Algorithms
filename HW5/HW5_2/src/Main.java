
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     
        FamilyTree myfamily=new FamilyTree();
        
        
        File file = new File("family.txt");

        try{
        Scanner sc = new Scanner(file);
        
        myfamily.readFamilyBinaryTree(sc);
        sc.close();
        }
        catch(FileNotFoundException e){
            
            System.out.println("Dosya okuma hatası..!!!");
            System.exit(0);
            
        }
        myfamily.printPreOrder();
        
        
    }
    
}
