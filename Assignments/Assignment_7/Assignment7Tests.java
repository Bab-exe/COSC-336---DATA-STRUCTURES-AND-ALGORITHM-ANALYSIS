
import static org.junit.Assert.assertEquals;

import java.awt.PrintGraphics;
import java.util.ArrayList;
import org.junit.Test;


public class Assignment7Tests extends Assignment7  {
    @Test
    public void File_Reading() {
        Adj_List_Graph input7_1 = inputFile("input-7-1.txt");
        Adj_List_Graph input7_2 = inputFile("input-7-2.txt");
       
        assert input7_1 != null; //file exists
        assert input7_1.n == 3; //3 nodes
           
        //all sizes should be the same
        for (ArrayList<Integer> list1 : input7_1.adj) {
            assert list1 != null;
            assert list1.size() == 3;


        }

        assert input7_2 != null;
        assert input7_2.n == 5;
        for (ArrayList<Integer> list2 : input7_2.adj) {
            assert list2 != null;
            assert list2.size() == 5;
        }

        System.err.println("input-7-1.txt: ");
            input7_1.printGraph();

        System.err.println("\ninput-7-2.txt: ");
            input7_2.printGraph();
    }
    
    @Test
    /** the example given in Programming Task */
    public void Test1(){
    
    
        int[][] test = {
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1},
            {0,0,0,0}
        };

        //correct adjency list of test 
        int[][] test_adj = {
            {0,1,1,0},
            {0,0,1,1},
            {0,0,0,1},
            {0,0,0,0}
        };

        final int N = 4;
        Adj_List_Graph GRAPH = create_Graph(test); //original graph
        Adj_List_Graph GRAPH2 = create_Graph(test_adj); //raw adjacency list of GRAPH
        Adj_List_Graph GRAPH3 = Compute_AdjacencyList(GRAPH); //computed adjacency list using Compute_AdjacencyList

        assert GRAPH.n == N;
        assert GRAPH2.n == N;
        assert GRAPH3.n == N;

        //check each value of the lists
        for (int u = 0; u < N; u++) 
            for (int v = 0; v < N; v++) {
                //Checks create graph method ; if any of these throw an exception then there is a problem with create_Graph
                assert GRAPH.adj.get(u).get(v) == test[u][v]; 
                assert GRAPH2.adj.get(u).get(v) == test_adj[u][v];

                //Checks Compute_AdjacencyList method ; if any of these throw an exception then there is a problem with Compute_AdjacencyList
                assert GRAPH3.adj.get(u).get(v) == test_adj[u][v];
            }
                
            

        
    }

    /** matrix must be squarable*/
    public Adj_List_Graph create_Graph(final int[][] MATRIX){
        Adj_List_Graph GRAPH = new Adj_List_Graph(MATRIX.length);

        final int N = MATRIX.length;
        
        for (int u = 0 ; u < N;u++)
                for (int v = 0; v < N; v++)
                    GRAPH.addEdge(u, MATRIX[u][v]);
                   
        
        return GRAPH;
                
    }
   
}
