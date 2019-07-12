import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javafx.print.Collation;

public abstract class AbstractGraphExtended extends AbstractGraph{
    
    public static final int RENKSIZ = 0;
    public static final int BEYAZ = 1;
    public static final int KIRMIZI = 2;
    private HashMap<Integer,Integer> boya=new HashMap<>();
    private boolean[] visited;
    private boolean bayrak=true;
    private ArrayList<Integer> vartex=new ArrayList<>();
    private ArrayList<Edge> myedge=new ArrayList<>();
    private int global=0;
    
    public  AbstractGraphExtended(int numV, boolean directed) {
        super(numV, directed);
    }
    
    
    public int addRandomEdgesToGraph (int edgeLimit) {
    

        Random rand = new Random();
        int count=0;

        int  n = rand.nextInt(edgeLimit)+1;
        

        int source_random;
        int destin_random;
        System.out.println("-----Random üretilen edgeler----");
        for(int i=0; i<n; i++){
            source_random=rand.nextInt(getNumV());
            destin_random=rand.nextInt(getNumV());
            Edge edge=new Edge(source_random,destin_random);
            System.out.println("("+(i+1)+") "+source_random+" "+destin_random);
            if(!isEdge(source_random,destin_random)){
                insert(edge);
                count++;
                
            }
           
        }
        return count;
}
   public int[] breadthFirstSearch(int start) {
       
    Queue <Integer> theQueue = new LinkedList < Integer > ();
    
   
    int[] parent = new int[getNumV()];
    for (int i = 0; i <getNumV(); i++) {
      parent[i] = -1;
    }
    // Declare array identified and
    // initialize its elements to false.
    boolean[] identified = new boolean[ getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
    identified[start] = true;
    theQueue.offer(start);
    /* While the queue is not empty */
    while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
      int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
      Iterator < Edge > itr =edgeIterator(current);
      while (itr.hasNext()) {
        Edge edge = itr.next();
        int neighbor = edge.getDest();
        // If neighbor has not been identified
        if (!identified[neighbor]) {
          // Mark it identified.
          identified[neighbor] = true;
          // Place it into the queue.
          theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
          parent[neighbor] = current;
        }
      }
      // Finished visiting current.
    }
    return parent;
  }
    
    
    public void writeGraphToFile (String fileName) throws IOException{
        
        ArrayList<Edge> myedges=new ArrayList<>();
        File myfile=new File(fileName);
        FileWriter yaz=new FileWriter(myfile);
        BufferedWriter bw = new BufferedWriter(yaz);

        boolean write=true;
        int control=getNumV();
        
        bw.append(Integer.toString(control));
        bw.newLine();
        
       
        
        for(int i=0; i<getNumV(); i++){
            for(int j=0; j<getNumV(); j++){
                
                if(isEdge(i, j)==true ){
                    
                    myedges.add(new Edge(i,j));
                    
                    for(int z=0; z<myedges.size(); z++){
                        if(i!=j){
                        
                            if(myedges.get(z).getSource()==j && myedges.get(z).getDest()==i){
                          
                                write=false;  
                        
                            }
                        }
                    }
                    if(write){
                    
                        bw.append(i+" "+j);
                    
                        bw.newLine();
                    
                    }
                }
                write= true;
            }
        }

        bw.close();
        yaz.close();

                   
    }
    
    public boolean isBipartiteUndirectedGraph (){
        
        
        if(isDirected()){
        
           System.out.println("The function is not undirected");
           return false;
        }
        
          for(int i=0; i<getNumV(); i++){
              boya.put(i,RENKSIZ);
          }
          
          for(int i=0; i<getNumV(); i++){
              
              if(boya.get(i).equals(RENKSIZ)){
               
                  boya.put(i,BEYAZ);
              }
              for(int j=0; j<getNumV(); j++){
                
                if(isEdge(i, j)==true){
                    
                    if(boya.get(j).equals(RENKSIZ)){
                        
                        if(boya.get(i).equals(BEYAZ)){
                            boya.put(j,KIRMIZI);
                        }
                        else{
                            boya.put(j,BEYAZ);
                        }
              
                    }
                    if(boya.get(i).equals(boya.get(j))){
                        return false;
                    }
                }
          
            }
            
          
          }
          
        return true;
    }
    
    /*
    public Graph [] getConnectedComponentUndirectedGraph () throws FileNotFoundException, IOException{
        
        ArrayList<Integer> edge_distance = new ArrayList<>();
        
        Graph total[]=new Graph[25];
        File graphData = new File("graph_1.txt");
        int control=0;
        int p=0;
        int k=0;
        
        boolean var_yok=false;
        
        Scanner scnr = new Scanner(graphData );
        
        total[k]=(ListGraph) AbstractGraph.createGraph(scnr, false, "List");
        
        for(int i=0; i<total[k].getNumV(); i++){
            
            for(int j=0; j<total[k].getNumV(); j++){
                
                if(isEdge(i, j)==true){
                    
                   p++;
                }
            }
        }
       
       Edge temp[]=new Edge[p];
       p=0;
        for(int i=0; i<total[k].getNumV(); i++){
            
            for(int j=0; j<total[k].getNumV(); j++){
                
                if(total[0].isEdge(i, j)==true){
                    
                    temp[p]=new Edge(i,j);
                    edge_distance.add(j);
                    
                    if(control!=0){
                        
                        int max=edge_distance.get(0);
                        for (int count=0; count<edge_distance.size()-1; count++){ 
                            
                            if(temp[p].getSource()==edge_distance.get(count) ||temp[p].getDest()== edge_distance.get(count)){
                                
                                var_yok=true;
                                control=0;
                                break;
                            }
                            
                            if(edge_distance.get(count)>max){
                                max=edge_distance.get(count);
                            }
                        }
                        
                        if(var_yok==false){
                          
                            k++;
                            total[k]=new ListGraph(max,false);
                            for(int count=0; count<edge_distance.size()-1; count++){
                                
                                total[k].insert(temp[count]);
                            }
                            edge_distance.clear();
                           p=0;
                           temp[p]=new Edge(i,j);
                           
                           edge_distance.add(j);
                           control=0;
                        }
                        
                    }
                    
                    p++;
                }
                               
            }
            control++;
        }
        
    }
    
    */
    
    public Graph [] getConnectedComponentUndirectedGraph (){
        
        int index_source=0;
        int index_dest=0;
        
        boolean src=false;
        boolean dst=false;
        
        int source_;
        int dest_;
        
       if(isDirected()){
        
           System.out.println("The function is not undirected");
           return null;
        }
        
        ArrayList<Graph> total=new ArrayList<>();
        
       int k=0;
        int n = getNumV();
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            visited[i]=false;
        }

        for (int i = 0; i < n; i++) {
      
            if (!visited[i]) {

                depthFirstSearch(i);
                if (global != 1) {

                    total.add(new ListGraph(vartex.size(), false));


                    for (int y = 0; y < myedge.size(); y++) {


                        source_ = myedge.get(y).getSource();

                        dest_ = myedge.get(y).getDest();

                        for (int x = 0; x < vartex.size(); x++) {

                            if (vartex.get(x).equals(source_) && src == false) {
                                index_source = x;
                                src = true;

                            }
                            if (vartex.get(x).equals(dest_) && dst == false) {
                                index_dest = x;
                                dst = true;
                            }

                        }
                        src = false;
                        dst = false;
                        total.get(k).insert(new Edge(index_source, index_dest));

                    }
                    k++;
                    vartex.clear();
                    myedge.clear();

                }
                global=0;
            }
        }
        
        int r=0;

        for(int i=0; i<total.size(); i++){
            
            if(total.get(i).getNumV()!=0){
                 
                 r++;
            }
        
        }
        
        Graph result[]=new Graph[r];
        
        for(int i=0; i<r; i++){
            
            if(total.get(i).getNumV()!=0){
                 result[i]=total.get(i);
                
            }
            
        }
        return result;
    }
    public void depthFirstSearch(int current) {
  
    visited[current] = true;
   global++;
    
    Iterator < Edge > itr = edgeIterator(current);
    while (itr.hasNext()) {
      
        int neighbor = itr.next().getDest();
        
      for(int i=0; i<vartex.size(); i++){
          
          if(vartex.get(i).equals(current)){
              bayrak=false;
              break;
          }
      }
      if(bayrak){
      
          vartex.add(current);
      }
      bayrak=true;
      
      for(int i=0; i<vartex.size(); i++){
          
          if(vartex.get(i).equals(neighbor)){
              bayrak=false;
              break;
          }
      }
      if(bayrak){
      
          vartex.add(neighbor);
      }
      bayrak=true;      
        Collections.sort(vartex);
      
      myedge.add(new Edge(neighbor,current));
      if (!visited[neighbor]) {
           
        depthFirstSearch(neighbor);
      }
       
    }
   
  }
       
}
