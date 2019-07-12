
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.BiConsumer;


public class BinaryTree<E extends Comparable<E>>  implements Iterable<E>{

    public Iterator<E> iterator() {
        return new Tree_iterator<>(root);
    }

    public Iterator<E> iterator(int a) {
        return new levelOrderIterator<>(root);
    }


    public void levelOrderIterator(){

        Iterator tree2=this.iterator(1);

        while(tree2.hasNext()){

            System.out.println(tree2.next());
        }

    }

    private class levelOrderIterator<E> implements  Iterator {

        private ArrayDeque<Node> queue = new ArrayDeque<>();



        public levelOrderIterator(Node root) {
            if (root != null) {
                queue.offer(root); // add to end of queue
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
            return (E)temp.data;
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

            return (E) res.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }
    }
    protected static class Node<E>{

        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data){

            this.data=data;
            left=null;
            right=null;
        }

        public String toString(){

            return data.toString();
        }
    }

    protected Node<E> root;
    protected boolean addReturn= true;




    public BinaryTree(){

        root=null;
    }

    protected BinaryTree(Node root){

        this.root=root;

    }
    public BinaryTree(E data,BinaryTree<E> leftTree,BinaryTree<E> rightTree){

        root=new Node<>(data);
        if(leftTree!=null){
            root.left=leftTree.root;

        }
        else{

            root.left=null;
        }

        if(rightTree!=null){
            root.right=rightTree.root;
        }
        else{

            root.right=null;
        }
    }

    public BinaryTree<String> readBinaryTree(Scanner scan)throws NoSuchElementException{

        Integer line;
        int i=0;
        while (scan.hasNextInt()) {
            line = scan.nextInt();
            root=add(root,(E)line);
        }



        return new BinaryTree<>(root);
    }
    private Node<E> add(Node<E> localRoot,E item){

        if(localRoot==null){
            addReturn = true;
            return new Node<>(item);
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


    /*
    public BinaryTree<String> readBinaryTree(Scanner scan){

        return readBinaryTree(scan,root);
    }

    public BinaryTree<String> readBinaryTree(Scanner scan,Node root){

        String data;
        if(!scan.hasNextLine()){
            return null;
        }
        else{
            if(root==null){
                root=new Node((E)scan.next());
                readBinaryTree(scan,root);
            }
            else{

                    if(root.right==null){

                        root.right=new Node((E)scan.next());

                    }
                    else if(root.left==null){
                        root.left=new Node((E)scan.next());
                    }

                    if(deapth==1){
                        Node tmp=root;
                        readBinaryTree(scan,root.left);
                        deapth++;

                    }
                    else if(deapth==2){
                        deapth=1;
                        readBinaryTree(scan,root.right);

                    }

            }


            }
    }*/

    public BinaryTree<E> getLeftSubtree(){

        if(root!=null && root.left != null){

            return new BinaryTree<>(root.left);
        }
        else{
            return null;
        }

    }
    public BinaryTree<E> getRighttSubtree(){

        if(root!=null && root.right != null){

            return new BinaryTree<>(root.right);
        }
        else{
            return null;
        }

    }

    public boolean isLeaf(){

        return (root.left==null && root.right==null);
    }

    public String toString(){

        return toString(root);
    }

    private String toString(Node r) {
        String str = "";
        if(r == null) {
            return str;
        }
        str += r.data;
        str += " (" + toString(r.left) + ") (" + toString(r.right) + ")";
        return str;
    }
//recursively printing out the nodes

/*
    public static String toString(Node r){
if(r==null)
return "";
else
return toString(r.left) + " " +r.data + " " +toString(r.right);
}
    */
   /*
    public String toString() {
    StringBuilder string = new StringBuilder();
    toString(this.root, string);
    return string.toString();
}
private static <T> void toString(Node<T> node, StringBuilder string) {
    string.append('{');
    if (node != null) {
        string.append(node.getData());
        string.append(", ");
        toString(node.getLeft(), string);


        string.append(", ");
        toString(node.getRight(), string);
    }
    string.append('}');
}
*/


    /*
    public String toString(){

        StringBuilder sb=new StringBuilder();
        toString(root,1,sb);
        return sb.toString();
    }

    private void toString(Node<E> node,int depth,StringBuilder sb){

        for(int i=1; i<depth; i++){
            sb.append(" ");

        }
        if(node==null){
            sb.append("null\n");

        }
        else{
            sb.append(node.data);
            sb.append("\n");
            toString(node.left,depth+1,sb);
            toString(node.right,depth+1,sb);
        }
    }
    */

    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    /*
private void postOrderTraversal(Node<E> node, int depth,
                                          StringBuilder sb) {
     if(node == null) {
         for(int i = 1; i < depth; i++)
             sb.append(".");

         sb.append("null\n");
         return;
     } else {
         postOrderTraversal(node.left, depth + 1, sb);
         postOrderTraversal(node.right, depth + 1, sb);
         for(int i = 1; i < depth; i++)
             sb.append(".");

         sb.append(node.data);
         sb.append("\n");
     }
 }*/
    public E getData() {
        if(root == null)
            return null;
        else
            return root.data;
    }

}
