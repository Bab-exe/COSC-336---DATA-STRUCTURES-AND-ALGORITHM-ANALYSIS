import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Assignment8{
    public static void main(String[] args) {   
        
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

    /** exists for manual testing */
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