
import java.util.ArrayList;


public class StackB<E> implements Stack<E>{

    private ArrayList<E> mylist;

    public StackB() {
        this.mylist = new ArrayList<>();
    }
    
    public E push(E item){
       try{ 
       mylist.add(item);
       }
       catch(IndexOutOfBoundsException e){
           System.out.println("Index Hatasi !!!");
           System.exit(0);
       }
       return item;
    }
    
    public E pop(){
        
        E item=mylist.get(size()-1);
        mylist.remove(mylist.size()-1);
        
        return item;
    }
    public boolean isEmpty(){
     
        return mylist.isEmpty();
    }
    
    public int size(){
        
       return mylist.size();
               
    }
    public void get(){
        for(int i=0; i<mylist.size(); i++){
            
            
            System.out.println(mylist.get(i));
        }
    }
    
}
