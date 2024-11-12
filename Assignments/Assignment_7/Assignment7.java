import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Assignment7{

    public static void main(String[] args) {    
        Adj_List_Graph input7_1 = inputFile("input-7-1.txt");
        Adj_List_Graph input7_2 = inputFile("input-7-2.txt");

        System.err.print("input-7-1.txt: ");
          input7_1.printGraph();
        System.err.print("\n\nComputed Adjacency list of input-7-1.txt: ");
            Compute_AdjacencyList(input7_1).printGraph();
    
        System.err.print("\n\ninput-7-2.txt: ");
            input7_2.printGraph();
        System.err.print("\n\nComputed Adjacency list of input-7-2.txt: ");
            Compute_AdjacencyList(input7_2).printGraph();
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
    public static Adj_List_Graph Compute_AdjacencyList(final Adj_List_Graph G) {
        final int N = G.n;

        final Adj_List_Graph G2 = new Adj_List_Graph(N);

        /* TODO: ask if return is correct */
        int j,i;
        for (int k = 0 ; k < N*N; k++) {
            i = k / N; //computes row
            j = k % N; //computes column

            //there is an edge if the bit equals anything but 0
            if (G.adj.get(i).get(j) != 0) 
                G2.addEdge(i, j);
        }
        
        return G2;
    }

    
    /** exists for manual testing 
     * TODO Delete when submitting */
    public static Adj_List_Graph create_Graph(final int[][] MATRIX){
        Adj_List_Graph GRAPH = new Adj_List_Graph(MATRIX.length);

        final int N = MATRIX.length;

        for (int u = 0; u< N; u++)
            for (int v = 0; v < N; v++)
                GRAPH.addEdge(u, MATRIX[u][v]);//(u,v) u is the head , v is a single link

        return GRAPH;
            
    }
    
    //TODO: Copy and Paste Adj_List_Graph class when Submitting
}