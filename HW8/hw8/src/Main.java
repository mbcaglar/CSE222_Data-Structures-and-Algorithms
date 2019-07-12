

//Kitaptaki code dan yardım alınmıştır.

public class Main{

    public static void main(String args[]) {


        AVLTree<String> mytree = new AVLTree<>();

        mytree.add("Nush");
        mytree.add("ile");
        mytree.add("uslanmayani");
        mytree.add("etmeli");
        mytree.add("tekdir");
        mytree.add("tekdir");
        mytree.add("ile");
        mytree.add("uslanmayanin");
        mytree.add("hakki");
        mytree.add("kotektir");
    System.out.println(mytree.toString());
    }
}
