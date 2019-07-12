import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SingleLinkedList<E> {

    
private static class Node<E> {

        private E data;
        private Node<E> next;
    
        private Node(E dataItem){
        
            data = dataItem;
            next = null;
        }
        private Node(E dataItem,Node<E> nodeRef){
        
            data = dataItem;
            next = nodeRef;
        }
        private Node<E> getNext(){
            return next;
        }
        private void setNext(Node<E> eleman){
            next=eleman;
        }
}
    
    private Node<E> head=null;
    private int size=0;
    @SuppressWarnings("rawtypes")
	private ArrayList<Node> removeList= new ArrayList<>();
    

    
    @SuppressWarnings("unchecked")
	public void addFirst(E item){
    
        if(removeList.isEmpty()){
        
            head =new Node<>(item,head);
            size++;
        }
        else{
           
            Node<E> tmp=head;
            
            head = removeList.get(0);
            head.data = item;
            head.next = tmp;       
            removeList.remove(0);
            size++;
        }
    }
    public int size(){
        return size;
    }
    @SuppressWarnings("unchecked")
	private void addAfter(Node<E> node,E item){
        
        if(removeList.isEmpty()){
        
            node.next = new Node<>(item,node.next);
        
            size++;
        }
        else{
            
            Node<E> tmp=node.next;
            
            node.next = removeList.get(0);
            node.next.data=item;
            node.next.next=tmp;
            removeList.remove(0);
            size++;
         
        
        }
    }
    private E removeAfter(Node<E> node){
        
        Node<E> temp = node.next;
        
        if(temp!=null){
            
            node.next = temp.next;
            size--;
            return temp.data;
        }
        else{
            
            return null;
        }
    }
    
    private E removeFirst(){
        
        Node<E> temp = head;
        
        if(head != null){
            
            head = head.next;
        }
        if( temp !=null){
            size--;
            return temp.data;
        }
        else{
            return null;
        }
        
    }
    private Node<E> getNode(int index){
        Node<E> node=head;
        for(int i=0; i<index && node!=null; i++){
            node=node.next;
        }
        return node;
    }
    
    public E get(int index){
        
        if(index<0 || index>=size){
            
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        
        Node<E> node = getNode(index);
        
        return node.data;
    }
    
   public E set(int index,E newValue){
        
       if(index<0 || index>=size){
           
           throw new IndexOutOfBoundsException(Integer.toString(index));
       }
       
       Node<E> node = getNode(index);
       
       E result = node.data;
       node.data= newValue; 
       return result;
   }
   public void add(int index,E item){
       
       if(index<0 || index>size){
           
           throw new IndexOutOfBoundsException(Integer.toString(index));
       }
       if(index==0){
           addFirst(item);
       }
       else{
           
            Node<E> node=getNode(index-1);
            addAfter(node,item);
            
       }
   }
   public void remove(int index){
       
       if(index<0 || index>size){
           
           throw new IndexOutOfBoundsException(Integer.toString(index));
       }

       if(index==0){
           removeList.add(getNode(index));
          
           removeFirst();
           
       }
       else{
            
           removeList.add(getNode(index));           
            Node<E> node=getNode(index-1);
            removeAfter(node);
            
       }
   }
   
   public boolean add(E item){
       
       add(size,item);
       return true;
   }
   
   public String toString1(){
            
        int i=0;
        String result = "[";
            
        while(i<size){
                
                result +=get(i) + " ";
                i++;
            }
        result +="]";
            return result;
          
    }
    
    //
    public String reverseToString(){
        
    return "["+ reverseList(head)+"]";
        
    
    }
    private String reverseList(@SuppressWarnings("rawtypes") Node current) {
    
        if (current == null) {
       
            return "";
    
        }

        return reverseList(current.next)+current.data+" ";
        
}
    public String deletedToString(){
        
        String result="[";
        
        for(int i=0; i<removeList.size(); i++){
            
            result+=removeList.get(i).data+" ";
            
        }
        result+="]";
        return result;
    }
    
    
    @SuppressWarnings("unchecked")
	public void Oku(String filename) throws IOException ,FileNotFoundException{
        
    
        
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        
        String line;
        Integer sayi;
    try (BufferedReader br = new BufferedReader(fileReader)) {
        int i=0;
        while ((line = br.readLine())!= null) {
            
           
            //line = line.trim();
            sayi= Integer.parseInt(line);
            
            this.add(i,(E)sayi);
            i++;
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
            
   
        }
    }     
 }
   /* private Node<E> reverseList(Node<E> current){
        if(current==null){
            return null;
        }
        Node<E> sonraki=reverseList(current.getNext());        
        sonraki.setNext(current);
        return current;
    }
   */
}
