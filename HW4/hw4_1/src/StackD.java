import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class StackD<E> implements Stack<E>{
    
    
    private ArrayDeque<E> mylist = new ArrayDeque<>();
    
    public E push(E item){
        
        mylist.addLast(item);
         
       return item; 
       
    }
    public E pop() throws NoSuchElementException{
        
        E eleman;
        eleman = mylist.getLast();
        int boyut=mylist.size();
        for(int i=0; !mylist.isEmpty() && i<boyut-1; i++){
      
           mylist.addLast(mylist.remove());
           
        }
        mylist.remove();
        
        if(!mylist.isEmpty()){
            
            return eleman;
        }
        
	return eleman;
    }
   public boolean isEmpty(){
     
        return mylist.isEmpty();
    }
   
    public int size(){
        
       return mylist.size();
               
    }
    
    public void get(){
        
        int boyut=mylist.size();        
        E item;
        for(int i=0; i<boyut; i++){
            
            item=mylist.removeFirst();
            System.out.println(item);
            mylist.addLast(item);
            
        }

        
    }
   
}
