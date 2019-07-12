import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        BinaryTree<Integer> mytree = new BinaryTree<>();
        File file = new File("test.txt");

        try{
        Scanner sc = new Scanner(file);
        
        mytree.readBinaryTree(sc);
        sc.close();
        }
        catch(FileNotFoundException e){
            
            System.out.println("Dosya okuma hatası..!!!");
            System.exit(0);
            
        }

        System.out.println("--------------Q1-) PART1 <PRE ORDER ITERATOR> -------------");
        System.out.println();
        //System.out.println("BinaryTree :  ");
        //System.out.print(mytree.toString());
        //System.out.println("   --> Tree için toString metodu kitap kodundan alınmıştır.");

        mytree.printPreOrder();
        System.out.println();
        
        System.out.println("--------------Q1-) PART2 <LEVEL ORDER ITERATOR>-------------");

        
        BinarySearchTree mytree2 = new BinarySearchTree<>();
        try{
            Scanner scan=new Scanner(file);
            mytree2.readBinaryTree(scan);
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Dosya Hatasi...!!!");
            System.exit(0);
        }
        //System.out.println(mytree2.toString());
        //System.out.println("");
        System.out.println();
        mytree2.levelOrderIterator();
        
        
    }
    
}
