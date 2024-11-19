import java.util.*;
import java.io.*;



  
  public class Adj_List_Graph{
    int n;  // no of nodes
    ArrayList<ArrayList<Integer> > adj; 
    final boolean DIRECTED;
    
    //constructor taking as the single parameter the number of nodes
    Adj_List_Graph(int no_nodes, final boolean DIRECTED_GRAPH) {
      this.DIRECTED = DIRECTED_GRAPH;
      n = no_nodes;
      adj =  new ArrayList<ArrayList<Integer>>(n);
      for (int i = 0; i < n; i++)
        adj.add(new ArrayList<Integer>());
      
    }

    /** graph is undirected by default for assignment 8 */
    public Adj_List_Graph(int no_nodes) {
        this(no_nodes, false);
    }

    

    

    
    
    // A utility function to add an edge in an
    // undirected graph; for directed graph remove the second line
    public void addEdge(int u, int v)
    {
      adj.get(u).add(v);
      if (this.DIRECTED) return;

       adj.get(v).add(u);  //this line should be un-commented, if graph is undirected
    }
    
    /** A utility function to print the adjacency list representation of graph */
    //this function was not changed
    public void printGraph()
    {
      for (int i = 0; i < n; i++) {
        System.out.print("\nAdjacency list of vertex" + i);
        System.out.print("\thead");
        for (int j = 0; j < adj.get(i).size(); j++) {
          System.out.print(" -> "+adj.get(i).get(j));
        }
        System.out.println();
      }
    }

    /** A utility function to print the adjacency <b>list</b> representation of graph 
     * @param INDEX_OFFSET the starting vertex
    */
    //this function was added 
    public void printList(final int INDEX_OFFSET){

      int i = INDEX_OFFSET; //adjusted index 
      System.err.printf("\n[%d] Based Indexing:" , INDEX_OFFSET);
      final String ARROW = (this.DIRECTED) ? " -> " : " <>  ";
      for (ArrayList <Integer> u : this.adj) {
          System.out.printf("\n%d: ", i);
          
          for (int v = 0; v < u.size(); v++)
              if (u.get(v) != 0)
                  System.out.print( ARROW + (u.get(v)+INDEX_OFFSET));   
          System.out.println();
          i++;
      }
    }

  
    public void print_Adjacency_Matrix(){
      System.out.println("\nAdjacency Matrix:");
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
  
  
