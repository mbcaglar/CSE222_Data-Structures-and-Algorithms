
public class StackC<E> implements Stack<E> {
    
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
    
    public void get(){
        for(int i=0; i<this.size(); i++){
            
            
            System.out.println(this.get(i));
        }
    }
    public E push(E item){
        
            this.add(size, item);
            return item;
    }   
    public E pop(){
        
        if(!this.isEmpty()){
            E item=this.get(size-1);
            this.remove(size-1);
            return item;
        }
        else{
            System.out.println("Bos stackten eleman silemezsiniz!!!");
            System.exit(0);
            return null;
        }
        
    }
    public boolean isEmpty(){
     
        if(head==null || size==0){
            
            return true;
        }
        else{
            return false;
        }
      
    } 
    public int size(){
        return size;
    }
    public E get(int index){
        
        return this.getNode(index).data;
        
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
       
    public void addFirst(E item){
    
       
            head =new Node<>(item,head);
            size++;
    }
  
    @SuppressWarnings("unchecked")
 
    private void addAfter(Node<E> node,E item){
        
       
            node.next = new Node<>(item,node.next);
        
            size++;
        
        
        
    }
    
    public void remove(int index){
       
       if(index<0 || index>size){
           
           throw new IndexOutOfBoundsException(Integer.toString(index));
       }

       if(index==0){
           removeFirst();
           
       }
       else{           
            Node<E> node=getNode(index-1);
            removeAfter(node);
            
       }
   }
    public E removeAfter(Node<E> node){
        
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
}
