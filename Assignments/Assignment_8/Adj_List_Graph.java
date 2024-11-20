import java.util.ArrayList;

  
  public class Adj_List_Graph{
    int n;  // no of nodes
    ArrayList<ArrayList<Integer> > adj; 

    /** Exists for display purposes; <br> assignment 8 uses 1 based indexing <br>
     * <code>
     * INDEX_OFFSET = 0 would be 0 based indexing <br>
     * INDEX_OFFSET = 1 would be 1 based indexing <br>
     * etc
     * </code>
     */
    final int INDEX_OFFSET; //added to control indexing when displaying graphs for assignment 8
   
    
    //constructor taking as the single parameter the number of nodes
    Adj_List_Graph(int no_nodes,final int INDEX_OFFSET) {
      n = no_nodes;
      adj =  new ArrayList<ArrayList<Integer>>(n);
      for (int i = 0; i < n; i++)
        adj.add(new ArrayList<Integer>());

      this.INDEX_OFFSET = INDEX_OFFSET; //this was added for displaying assignment 8 
    }

    public Adj_List_Graph(int no_nodes) {
        this(no_nodes, 1); //INDEX_OFFSET is set to 1 by default for assignment 8
    }

    // A utility function to add an edge in an
    // undirected graph; for directed graph remove the second line
    //adjusted for assignment 8
    public void addEdge(final int U, final int V)
    {
      int u = U - (this.INDEX_OFFSET); //adjusted u
      int v = V - (this.INDEX_OFFSET); //adjusted v
      adj.get(u).add(v);
      
      //undirected for assignment 8
       adj.get(v).add(u);  //this line should be un-commented, if graph is undirected
    }
    
    /** A utility function to print the adjacency list representation of graph */
    //adjusted for assignment 8
    public void printGraph()
    {
      for (int i = 0; i < n; i++) {
        System.out.print("\nAdjacency list of vertex" + (i+this.INDEX_OFFSET) + "\thead");
        for (int j : adj.get(i)) {
          System.out.print(" -> "+ (j + this.INDEX_OFFSET));
        }
      }
    }


    /** A utility function to print the adjacency matrix representation of graph */
    public void print_AdjacencyMatrix(){
      System.out.println("\n\nAdjacency Matrix:");
      for (int u = 0;u < n ; u++){
        for (int v = 0 ; v < n ; v++){
          System.out.printf(
              "%d  ", 
              adj.get(u).contains(v) ? 1 : 0
          );
        } 
        System.out.println();
      }
    }
  }
  
  
