import java.lang.NullPointerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NullPointerException {
try {


    HuffmanTree t1 = new HuffmanTree();
    HuffmanTree.HuffData[] test = new HuffmanTree.HuffData[100];
    File file = new File("freq.txt");
    int i = 0;

    try (Scanner scan = new Scanner(file)) {

        String line;
        String arr[];

        while (scan.hasNextLine()) {

            line = scan.nextLine();
            arr = line.split(" ");
            test[i]= new  HuffmanTree.HuffData(Double.parseDouble(arr[1]),arr[0].charAt(0));
            i++;
        }
        HuffmanTree.HuffData[] huff = new HuffmanTree.HuffData[i];
        for(int j=0; j<i; j++){
            huff[j]=test[j];
        }

        t1.buildTree(huff);

        System.out.println("Encode Test :");
        System.out.println(t1.decode("000101")+"-->"+t1.encode("ac"));
        System.out.println();
        System.out.println("Decode Test :");
        System.out.println(t1.encode("ac")+"-->"+t1.decode("000101"));
    }
    catch(FileNotFoundException e){

        System.out.println("Dosya okuma hatası..!!!");
        System.exit(0);

    }

}
catch(NullPointerException e){
    System.out.print("hataaaa");
}
    }
}
