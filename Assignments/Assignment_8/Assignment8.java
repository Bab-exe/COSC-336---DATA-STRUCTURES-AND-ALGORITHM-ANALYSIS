import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Assignment8{
    public static void main(String[] args) {   
        /*  
G1
	0   1	1	1	0	0	0
	1	0	0	0	1	0	0
	1	0	0	0	1	0	0
	1	0	0	0	0	1	0
	0	1	1	0	0	1	1
	0	0	0	1	1	0	1
	0	0	0	0	1	1	0

 
*/ 
        Adj_List_Graph G1 = graph_G1();

         
       
        
        
        G1.printGraph();
        G1.printList(1);
        G1.print_Adjacency_Matrix();
        

        BFS(G1, 0,1);
    }

    
    /** Bread First Search sourced from notes 10 
     * Program is required to <b>print</b> the two arrays dist[] and npath[]. 
     * @param G the graph
     * @param S the starting node
     * @param INDEX_OFFSET for displaying like assignment 8 ; 0 is 0 based indexing and 1 would be 1 based indexing etc
    */
    public static void BFS(final Adj_List_Graph G,final int S,final int INDEX_OFFSET){
        if (G == null || S > G.n || 0 > S){
            System.err.println("Starting Node is out of range");
            return;
        }
        /*it will print for every node v the length of the shortest path from s to v
 and also the number of shortest paths from s to v. Thus, you’ll have two arrays dist and
 npath, and for each vertex v, at the end of the program, dist[v] will be equal to the length
 of a shortest path from s to v (like in the basic version of BFS), and npath[v] will be equal
 to the number of shortest paths from s to v. */
        final int UNSEEN = Integer.MIN_VALUE; //used like the constant infinity in notes 10
        final int N = G.n; //size

        int[] dist = new int[N]; //keeps track of how far from the starting node and whether the node has been seen yet
        int[] npath = new int[N]; //n amount of shortest paths
        int[] prev = new int[N]; //previous index

        Queue<Integer> queue = new LinkedList<>(); //each node is queued and dequenced once 

        queue.add(S); // javas version of enqueue

        //all nodes set to unseen
        for (int v = 0; v < N; v++){
            dist[v] = UNSEEN;
            prev[v] = -1; //no previous
            npath[v] = 0;
        }
            
        dist[S] = 0; //distance from S to S is 0
        
        Integer u;
        while(!queue.isEmpty()){
            u = queue.remove(); //javas built in version of dequeue
            
            //visit u
            for (int v = 0 ; v < N; v++){
                    if (dist[v] == UNSEEN){ //checking if node has been seen 
                        queue.add(v);
                        dist[v] = dist[u] + 1; //setting node to seen and recording the distance
                        npath[v] = npath[u];
                        prev[v] = u;
                    }
                    //TODO: test this
                    else if (dist[v] == dist[u] + 1)
                        npath[v] += npath[u]; //incrementing the number of shortest paths
            }
        }

       

        System.out.println(npath[N-1] + " Shortest paths from " + (S + INDEX_OFFSET) + " to " + (N-1 + INDEX_OFFSET));
    }
    /** reads the file and converts it to an {@link Adj_List_Graph} */
    public static Adj_List_Graph inputFile(String filename) {
        try (Scanner console = new Scanner(new FileReader(filename))) {
            //node count
            final int N = console.nextInt();
            
            //birth of graph of size N
            Adj_List_Graph GRAPH = new Adj_List_Graph(N);

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
    
    /** creates the undirected graph of G1 from assign8 */
    public static Adj_List_Graph graph_G1(){
        Adj_List_Graph G1 = new Adj_List_Graph(7); 
        
        //0 based indexing
        G1.addEdge(0,1); // 1 -> 2
        G1.addEdge(0,2); // 1 -> 3
        G1.addEdge(0,3); // 1 -> 4
        
        G1.addEdge(1,4); // 2 -> 5
        
        G1.addEdge(2,4); // 3 -> 5
        
        G1.addEdge(3,5); // 4 -> 6
        G1.addEdge(4,5); // 5 -> 6
        G1.addEdge(4,6); // 5 -> 7

        G1.addEdge(5,6); // 6 -> 7


        return G1;
    }
    
    /** creates the undirected graph of G2 from assign8 */
    public static Adj_List_Graph graph_G2(){
        Adj_List_Graph G2 = new Adj_List_Graph(10);
        
        //0 based indexing
        G2.addEdge(0,1);// 1 -> 2 
        G2.addEdge(0,2);// 1 -> 3 
        G2.addEdge(0,3);// 1 -> 4
        G2.addEdge(0,4);// 1 -> 5
        G2.addEdge(0,5);// 1 -> 6
       
        G2.addEdge(1,6);// 2 -> 7

        G2.addEdge(2,6);// 3 -> 7

        G2.addEdge(3,6);// 4 -> 7

        G2.addEdge(4,6);// 5 -> 7

        G2.addEdge(5,6);// 6 -> 7

        G2.addEdge(6,7);// 7 -> 8
         
        G2.addEdge(7,9);// 8 -> 10

        G2.addEdge(8,9);// 9 -> 10

        return G2;
    
    }
    
}