public class myQueue<E> extends KWLinkedList<E> {

    /**
     * verilen objeyi reverse eder.
     * @param a
     * @return 
     */
    public myQueue reverse(Object a){
        
        E tmp;
        
        int i1=0;
        
        int i2=(int)(((myQueue)a).size())-1;
        
        while(i1<i2){
            
            tmp=super.get(i1);

            ((myQueue)a).set(i1,(E)((myQueue)a).get(i2));
            ((myQueue)a).set(i2,tmp);
            i1++;
            i2--;
            
            
            
        }
        return (myQueue)a;
              
    }
    /**
     * verilen objeyi recursive olarak reverse eder.
     * @param a
     * @return 
     */
    public myQueue<E> reverseQueue(Object a){
        
        if((int)(((myQueue)a).size())==0){
            System.out.println("Bos bir queue nun tersini alamazsnız..!!!");
            System.exit(0);
            return null;
        }
        else{
            return reversehelper(0,a);
        }
        
    }
    /**
     * asıl recursionı yapan helper fonksiyon
     * @param i
     * @param a
     * @return 
     */
    private myQueue<E> reversehelper(int i,Object a){
        
        if(i==(int)(((myQueue)a).size())/2){
            
            return (myQueue)a;
        }
        else{
                    
            E tmp=(E)((myQueue)a).get(i);
            ((myQueue)a).set(i,(E)((myQueue)a).get((int)(((myQueue)a).size())-1-i));
            ((myQueue)a).set((int)(((myQueue)a).size())-1-i,tmp);
            return reversehelper(i+1, a);
        }
    }
    /**
     * Test için kullanılan fonksiyon
     */
    public void goster(){
        
        for(int i=0; i<super.size(); i++){
        
            System.out.println(super.get(i));
        
        }

    }
 
    
}
