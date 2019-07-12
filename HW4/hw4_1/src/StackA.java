import java.util.ArrayList;

public class StackA<E> extends ArrayList<E> implements Stack<E>{
    
   public E push(E item){
        
       try{ 
       super.add(item);
       }
       catch(IndexOutOfBoundsException e){
           System.out.println("Index Hatasi !!!");
           System.exit(0);
       }
       return item;
       
    }
    
    public E pop(){
        
        E item=get(size()-1);
        super.remove(size()-1);
        
        return item;
    }
    
   @Override
    public boolean isEmpty(){
     
        return super.isEmpty();
    }
    
   @Override
    public int size(){
        
       return super.size();
               
    }
    public void get(){
        for(int i=0; i<super.size(); i++){
            
            
            System.out.println(super.get(i));
        }
    }
    
}
