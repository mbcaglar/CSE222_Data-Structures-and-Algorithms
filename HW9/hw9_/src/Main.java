
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, Exception {

        try {


            File graphData = new File("graph_1.txt");

            Scanner scnr = new Scanner(graphData);




            ListGraph lgObj = (ListGraph) AbstractGraph.createGraph(scnr, false, "List");


            System.out.println("--------------------TEST (addRandomEdgesToGraph) Function------------------");
            System.out.println("Grapha eklenen edge sayi---> " + lgObj.addRandomEdgesToGraph(10));
            scnr.close();
            System.out.println();
            System.out.println();

            System.out.println("--------------------TEST (breadthFirstSearch) Function------------------");

            scnr = new Scanner(graphData);
            lgObj = (ListGraph) AbstractGraph.createGraph(scnr, false, "List");
            int array[] = lgObj.breadthFirstSearch(0);

            for (int i = 0; i < array.length; i++) {

                System.out.println(i + "->" + array[i]);
            }


            lgObj.writeGraphToFile("graph_1_m1.txt");

            System.out.println();
            System.out.println();


            System.out.println("----------------TEST (isBipartiteUndirectedGraph) Function------------------");
            System.out.println("-----> " + lgObj.isBipartiteUndirectedGraph());


            System.out.println();
            System.out.println();

            System.out.println("-----------------TEST (getConnectedComponentUndirectedGraph) Function---------");


            Graph dene2[] = lgObj.getConnectedComponentUndirectedGraph();

            if (dene2 != null) {
                Iterator<Edge> v = dene2[0].edgeIterator(0);

                for (int k = 0; k < dene2.length; k++) {

                    System.out.println("-------Graph (" + (k + 1) + ")-------- ");
                    for (int i = 0; i < dene2[k].getNumV(); i++) {

                        for (int j = 0; j < dene2[k].getNumV(); j++) {

                            if (dene2[k].isEdge(i, j)) {
                                System.out.println(i + " " + j);
                            }
                        }
                    }
                }

            }
        } 

		catch (Exception e) {

            System.out.println(e.toString());
        }
    }
}
