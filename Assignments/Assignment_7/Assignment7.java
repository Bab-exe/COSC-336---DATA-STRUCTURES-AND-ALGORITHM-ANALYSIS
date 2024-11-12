import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Assignment7{

    public static void main(String[] args) {
        
        Adj_List_Graph input7_1 = inputFile("input-7-1.txt");
        Adj_List_Graph input7_2 = inputFile("input-7-2.txt");

        System.err.print("input-7-1.txt: ");
            input7_1.printGraph();
           
        System.err.print("\ninput-7-2.txt: ");
            input7_2.printGraph();
    }

    /** reads the file and converts it to an {@link Adj_List_Graph} */
    public static Adj_List_Graph inputFile(String filename) {
        try (Scanner console = new Scanner(new FileReader(filename))) {
            //node count
            int N = console.nextInt();
            
            //birth of graph of size N
            final Adj_List_Graph GRAPH = new Adj_List_Graph(N);

            //add edges
            for (int u = 0 ; u < N;u++)
                for (int v = 0; v < N; v++)
                    GRAPH.addEdge(u, console.nextInt()); //(u,v) u is the head , v is a single link
                   
            return GRAPH;
        }catch(FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
        }

        return null;
    } 

    /** computes the adjacency list of a directed graph */
    public static Adj_List_Graph Compute_AdjacencyList(final Adj_List_Graph GRAPH) {
        /** The n nodes are labeled 0,1,...,n −1. If the i×n+j-th bit in the sequence is
 1, then there is an edge from node i to node j, and if the i × n+j-th bit in the sequence
 is 0, then there is no edge from node i to node j. In other words, if the n2 bits are indexed
 with indices 0,1,...,n2 − 1, from the bit with index k, you compute i = k/n and j = k
 (mod n) and if bit with index k is 1, then there exists an edge (i,j), and if it is 0, then
 there is no edge (i,j). For example, the graph G above has n = 4 and the edges are given
 by the following n2 = 16 bits: 0 1 0 0 0 0 1 0 0 0 0 1 0 0 0 0.  */

        final int N = GRAPH.n;

        int j = 0 , k = 0;
        for (int i = 0; i < N*N; i++){
            /** If the i×n+j-th bit in the sequence is
 1, then there is an edge from node i to node j,  */
            k = i * N + j;
            
           
        }
        
        return null;
    }

    
    
    //TODO: Copy and Paste Adj_List_Graph class when Submitting
}