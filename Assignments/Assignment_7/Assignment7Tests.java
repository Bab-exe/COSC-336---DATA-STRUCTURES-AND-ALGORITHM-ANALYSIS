
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import org.junit.Test;


public class Assignment7Tests extends Assignment7  {
    
    /** 
     * 0 1 0 <br>
     * 0 0 1 <br>
     * 0 0 0  */
    final Adj_List_Graph input7_1 = create_Graph(new int[][]{
        {0,1,0},
        {0,0,1},
        {0,0,0}
    });

    /** 
     * 0 1 0 0 0 <br>
     * 0 0 1 1 0 <br>
     * 0 0 0 0 0 <br>
     * 0 0 0 0 1 <br>
     * 0 0 0 0 0  */
    final Adj_List_Graph input7_2 = create_Graph(new int[][]{ 
        {0,1,0,0,0},
        {0,0,1,1,0},
        {0,0,0,0,0},
        {0,0,0,0,1},
        {0,0,0,0,0}
    });
   

    @Test
    public void File_Reading() {
        Adj_List_Graph test7_1 = inputFile("input-7-1.txt");
        Adj_List_Graph test7_2 = inputFile("input-7-2.txt");
       
        assert test7_1 != null; //file exists
        assert test7_1.n == 3; //3 nodes
        //all sizes should be the same
        for (ArrayList<Integer> list1 : test7_1.adj) {
            assert list1 != null;
            assert list1.size() == 3;
        }
        assertArrayEquals(input7_1.adj.toArray(),test7_1.adj.toArray());
        

        assert test7_2 != null;
        assert test7_2.n == 5;
        for (ArrayList<Integer> list2 : test7_2.adj) {
            assert list2 != null;
            assert list2.size() == 5;
        }
        assertArrayEquals(input7_1.adj.toArray(),test7_1.adj.toArray());

        System.err.println("input-7-1.txt: ");
            test7_1.printGraph();

        System.err.println("\ninput-7-2.txt: ");
            test7_2.printGraph();
    }
    
    @Test
    /** the example given in Programming Task */
    public void Test1(){
    
        //original
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

   
    
    public void Test_input7_1() {  
        Adj_List_Graph GRAPH7_1 = Compute_AdjacencyList(input7_1);

        int[][] adj7_1 = {
            {0,1,0},
            {0,1,1},
            {0,0,0}
        };

        System.err.println("\nComputed Adjacency list of input-7-1.txt: ");
        GRAPH7_1.printGraph();
        
        for (int u = 0; u < GRAPH7_1.n; u++) 
            for (int v = 0; v < GRAPH7_1.n; v++) 
                assert GRAPH7_1.adj.get(u).get(v) == adj7_1[u][v];
        
    }

    
    public void Test_input7_2(){
        Adj_List_Graph GRAPH7_2 = Compute_AdjacencyList(input7_2);
        int[][] adj7_2 = {
            {0,1,0,0,0},
            {0,0,1,1,1},
            {0,0,0,0,0},
            {0,0,0,0,1},
            {0,0,0,0,0}
        };
            
        System.err.println("\nComputed Adjacency list of input-7-2.txt: ");
            GRAPH7_2.printGraph();

        for (int u = 0; u < GRAPH7_2.n; u++) 
            for (int v = 0; v < GRAPH7_2.n; v++) 
                assert GRAPH7_2.adj.get(u).get(v) == adj7_2[u][v];
    }
}
