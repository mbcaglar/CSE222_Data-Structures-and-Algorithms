
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FamilyTree <E extends Comparable<E>> extends BinaryTree<E>
{

    public Iterator<E> iterator() {
        return new levelOrderIterator<>(root);
    }


    public void levelOrderIterator(){

        Iterator tree2=this.iterator();

        while(tree2.hasNext()){

            System.out.println(tree2.next());
        }

    }

    private class levelOrderIterator<E> implements  Iterator {

        private ArrayDeque<Node> queue = new ArrayDeque<>();



        public levelOrderIterator(Node root) {
            if (root != null) {
                queue.offer(root);
            }
        }


        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }


        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited!");
            }
            Node temp = queue.poll();


            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
            return (E)temp.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }
    }


    private class Tree_iterator<E> implements  Iterator {

        private Stack<Node> stack = new Stack<>();

        /** Constructor */
        public Tree_iterator(Node root) {
            if (root != null) {
                stack.push(root); // add to end of queue
            }
        }

        /** {@inheritDoc} */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** {@inheritDoc} */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited!");
            }

            Node res = stack.pop(); // retrieve and remove the head of queue
            if (res.right != null) stack.push(res.right);
            if (res.left != null) stack.push(res.left);

            return (E) res.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }
    }



    public FamilyTree() {
        this.root = null;
    }


    public FamilyTree(Node root) {

        this.root = root;
    }

    private class Node
    {
        String  value;     // Value stored in node
        Node left, right;  // Left and right child

        Node(String val)
        {
            value = val;
            left = null;
            right = null;
        }
        Node(String val, Node leftChild, Node rightChild)
        {
            value = val;
            left = leftChild;
            right = rightChild;
        }
    }

    private Node root;



    public FamilyTree<String> readFamilyBinaryTree(Scanner scan)throws NoSuchElementException{

        String line;
        String arr[];
        int i=0;
        while (scan.hasNextLine()) {

            line = scan.nextLine();
            arr = line.split(",");
            arr[0]=arr[0].trim();
            if(i==0){

                if(arr.length==1){
                    root=new Node(arr[0]);
                }
                else{
                    System.out.println("Baslangic icin root hatasi");
                    System.exit(0);
                }
                i=1;
            }
            else{

                add(arr[0],arr[1],arr[2]);
            }
        }



        return new FamilyTree(root);
    }


    public void add(String name,String f_name,String nick_name){

        String arr[];
        arr=nick_name.split("-");

        add(root,name,f_name,arr[1],arr[0]);


    }
    private void Right_ekle(Node current,String name){

        if(current.right== null){

            current.right = new Node(name);

        }
        else{
            Right_ekle(current.right, name);
        }


    }

    private void Ekle2(Node root,String name,String f_name,String nick_name){

        if(root.left.value.equals(f_name)){
            if(root.left.left==null){
                root.left.left=new Node(name);


            }
            else{
                System.out.println("Yanlis nicname < Hata!!! >");
            }
        }
        else if(root.left.right!=null){

            kardes_bak(root.left,name,f_name);

        }
        else{

            System.out.println("uymayan ekleme...< Hata!!! >");
            System.exit(0);
        }
    }

    private void kardes_bak(Node root,String name,String f_name){

        if(root.value.equals(f_name)){
            if(root.left==null){
                root.left=new Node(name);
            }
            else{
                Right_ekle(root.right, name);
            }

        }
        else{
            kardes_bak(root.right,name,f_name);
        }

    }

    private void Ekle(Node root,String name,String f_name,String nick_name){

        if(root.left==null){

            if(name.equals(nick_name)){


                root.left=new Node(name);


            }
            else
            {

                System.out.println("Ekleme hatasi uyumayan nickname...!!!");
                System.exit(0);

            }

        }


        else if(root.left.value.contains(nick_name)){

            Right_ekle(root.left,name);

        }
        else{


            System.out.println("Bu nickname 'e sahip person yok..HATA!!!");
            System.exit(0);
        }
    }


    private void add(Node localRoot,String name,String f_name,String nick_name,String nick){

        if(nick.equals("ebu")){

            Ekle(findNode(f_name, localRoot),name,f_name,nick_name);

        }
        else if(nick.equals("ibn")){

            Ekle2(findNode(nick_name, localRoot),name,f_name,nick_name);
        }

        /*
        if(localRoot==null){
            addReturn = true;
            return new Node(name);
        }
        else if(item==localRoot.data){
            addReturn=false;
            return localRoot;
        }
        else if(item.compareTo(localRoot.data)<0){
            localRoot.left=add(localRoot.left,item);
            return localRoot;
        }
        else{
            localRoot.right = add(localRoot.right,item);
            return localRoot;
        }*/
    }

    public Node findNode(String name, Node current)
    {


        // Visit the node
        if(current.value.equals(name)){
            return current;
        }
        // Pre-order - go left
        if(current.left!= null)
        {
            return findNode(name, current.left);
        }

        // Pre-order - go right
        if(current.right != null)
        {

            return findNode(name, current.right);
        }


        return null;
    }
    public boolean root(String x)
    {
        if (root == null){
            root =  new Node(x);
            return true;}
        else
            return false;
    }


    public boolean addLeft(String p, String x)
    {
        Node parent = locate(p);
        //Check if root is established.
        if (root == null ){
            return false;}
        //Locate desired parent and checks if child exists.
        else if (parent != null && parent.left == null){
            //Adds node
            parent.left = new Node(x);
            return true;}
        else
            return false;
    }

    /**
     The public addRight method adds a value to the
     tree by locating the desired parent and ensuring
     all requirements are met.
     @param p The desired parent. x The value to add to the tree.
     @return true.
     */
    public boolean addRight(String p, String x)
    {
        Node parent = locate(p);
        //Check if root is established.
        if (root == null ){
            return false;}
        //Locate desired parent and checks if child exists.
        else if (parent != null && parent.right == null){
            //Adds node
            parent.right = new Node(x);
            return true;}
        else
            return false;
    }

    public Node locate(String p)
    {
        // Call the private recursive method
        return locate(p, root);
    }

    private Node locate(String p, Node famTree)
    {
        //new Node result, set to null.
        Node result = null;
        if (famTree == null)
            return null;
        //if passed node contains value, return it.
        if (famTree.value.equals(p))
            return famTree;
        //if left child not null, recursively call locate with left child.
        if (famTree.left != null)
            result = locate(p,famTree.left);
        //if parent still not found, recursively call right locate passing the right child.
        if (result == null)
            result = locate(p,famTree.right);
        return result;
    }

}






/*
public class FamilyTree<E extends Comparable<E>> extends BinaryTree{

    protected Node<E> root;

    public FamilyTree(Node<E> root){

        this.root=root;
    }
    public boolean add(String name,String f_name,String nick_name){

        add(root,name,f_name,nick_name);
        return true;
    }
    private Node<E> add(Node<E> localRoot,String name,String f_name,String nick_name){

        if(localRoot==null){
            addReturn = true;
            return new Node<>((E)name);
        }
        else if(item==localRoot.data){
            addReturn=false;
            return localRoot;
        }
        else if(item.compareTo(localRoot.data)<0){
            localRoot.left=add(localRoot.left,item);
            return localRoot;
        }
        else{
            localRoot.right = add(localRoot.right,item);
            return localRoot;
        }
    }
}
*/