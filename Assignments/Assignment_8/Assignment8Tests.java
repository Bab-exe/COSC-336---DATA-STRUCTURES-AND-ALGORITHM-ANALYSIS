import org.junit.Test;

public class Assignment8Tests extends Assignment8{
     
    final Adj_List_Graph G1 = graph_G1();
    final Adj_List_Graph G2 = graph_G2();

    /** used to print dist[] and npath[] in detail for submission */
    void print_Answer(int[] dist, int[] npath){
        
        for (int i = 0 ; i < dist.length ; i++)
            System.err.printf("\ndist[%d] = " + dist[i] ,i);
        
        System.err.println();
        for (int i = 0 ; i < npath.length ; i++)
            System.err.printf("\nnpath[%d] = " + npath[i] ,i);  

    }
    
    /** given test for graph 1 ; testing graph 1 */
    @Test public void test_G1(){
        int[][] result = BFS(G1, 1);

        int[] dist = result[0];
        int[] npath = result[1];

        //3 shortest paths from 1 -> 7 and the distance is 3
        assert (
            dist[G1.n - 1] == 3 && 
            npath[G1.n - 1] == 3
        ) : "G1 failed BFS at Starting Node (1) : (the given test in assignment 8)" ;

        System.out.print("graph G1 results:");
        print_Answer(dist, npath);
    }

    /**g1 that starts at 2  */
    @Test public void test_G1_2(){
        int[][] result = BFS(G1, 2);

        int[] dist = result[0];
        int[] npath = result[1];

        //1 shortest paths from 2 -> 7 and the distance is 2 
        assert (
            dist[G1.n - 1] == 2 && 
            npath[G1.n - 1] == 1
        ) : "G1 failed BFS at Starting Node (2)" ;
    }

    /**g1 that starts at 3  */
    @Test public void test_G1_3(){
        int[][] result = BFS(G1, 3);

        int[] dist = result[0];
        int[] npath = result[1];

        //1 shortest path from 3 -> 7 and the distance is 2
        assert (
            dist[G1.n - 1] == 2 && 
            npath[G1.n - 1] == 1
        ) : "G1 failed BFS at Starting Node (3)" ;
    }

    /** g1 that starts at 4 */
    @Test public void test_G1_4(){
        int[][] result = BFS(G1, 4);

        int[] dist = result[0];
        int[] npath = result[1];

        // 1 shortest path from 4 -> 7 and the distance is 2
        assert (
            dist[G1.n - 1] == 2 && 
            npath[G1.n - 1] == 1
        ) : "G1 failed BFS at Starting Node (4)" ;
    }
    
    /** g1 that starts at 5 */
    @Test public void test_G1_5(){
        int[][] result = BFS(G1, 5);

        int[] dist = result[0];
        int[] npath = result[1];

        // 1 shortest path from 5-> 7 and the distance is 1 

        assert (
            dist[G1.n - 1] == 1 && 
            npath[G1.n - 1] == 1
        ) : "G1 failed BFS at Starting Node (5)" ;
        
    }
    
    /** g1 that starts at 6 */
    @Test public void test_G1_6(){
        int[][] result = BFS(G1, 6);

        int[] dist = result[0];
        int[] npath = result[1];

        // 1 shortest path from 6 -> 7 and the distance is 1
        assert (
            dist[G1.n - 1] == 1 && 
            npath[G1.n - 1] == 1
        ) : "G1 failed BFS at Starting Node (6)" ;
    }
    
    @Test public void test_G1_7(){
        int[][] result = BFS(G1, 7);

        int[] dist = result[0];
        int[] npath = result[1];

        // 1 shortest path from 7 -> 7 and the distance is 0
        assert (
            dist[G1.n - 1] == 0 && 
            npath[G1.n - 1] == 1
        ) : "G1 failed BFS at Starting Node (7)" ;
    }
    /** testing graph 2*/
    @Test public void test_G2(){
        int[][] result = BFS(G2, 1);

        int[] dist = result[0];
        int[] npath = result[1];


        // 10 shortest paths from 1 -> 10 and the distance is 4
        assert (
            dist[G2.n - 1] == 4 && 
            npath[G2.n - 1] == 10
        ) : "G2 failed BFS at Starting Node (1)" ;

        System.out.print("graph G2 results:");
        print_Answer(dist, npath);
    }
    
    /** g2 that starts at 2 */
    @Test public void test_G2_2(){
        int[][] result = BFS(G2, 2);

        int[] dist = result[0];
        int[] npath = result[1];

        //2 shortest paths from 2 -> 10 and the distance is 3
        assert (
            dist[G2.n - 1] == 3 && 
            npath[G2.n - 1] == 2
        ) : "G2 failed BFS at Starting Node (2)" ;
    }
    /** g2 that starts at 3 */
    @Test public void test_G2_3(){
        int[][] result = BFS(G2, 3);

        int[] dist = result[0];
        int[] npath = result[1];


        //2 shortest paths from 3 -> 10 and the distance is 3
        assert (
            dist[G2.n - 1] == 3 && 
            npath[G2.n - 1] == 2
        ) : "G2 failed BFS at Starting Node (3)" ;
    }
    
    /** g2 that starts at 4 */
    @Test public void test_G2_4(){
        int[][] result = BFS(G2, 4);

        int[] dist = result[0];
        int[] npath = result[1];

        //2 shortest paths from 4 -> 10 and the distance is 3
        assert (
            dist[G2.n - 1] == 3 && 
            npath[G2.n - 1] == 2
        ) : "G2 failed BFS at Starting Node (4)" ;
    }
    
    /** g2 that starts at 6 */
    @Test public void test_G2_6(){
        int[][] result = BFS(G2, 6);
        
        int[] dist = result[0];
        int[] npath = result[1];

        //2 shortest paths from 6 -> 10 and the distance is 3
        assert (
            dist[G2.n - 1] == 3 && 
            npath[G2.n - 1] == 2
        ) : "G2 failed BFS at Starting Node (6)" ;
    }
    
    /** g2 that starts at 7 ; easy to test using graph in assignment8 */
    @Test public void test_G2_7(){
        int[][] result = BFS(G2, 7);

        int[] dist = result[0];
        int[] npath = result[1];


        //2 shortest paths from 7 -> 10 and the distance is 2
        assert (
            dist[G2.n - 1] == 2 && 
            npath[G2.n - 1] == 2
        ) : "G2 failed BFS at Starting Node (7)" ;

    }
    
    /** g2 that starts at 8 */
    @Test public void test_G2_8(){
        int[][] result = BFS(G2, 8);

        int[] dist = result[0];
        int[] npath = result[1];

        //1 shortest path from 8 -> 10 and the distance is 1
        assert (
            dist[G2.n - 1] == 1 && 
            npath[G2.n - 1] == 1
        ) : "G2 failed BFS at Starting Node (8)" ;
    }

    /** g2 that starts at 9 */
    @Test public void test_G2_9(){
        int[][] result = BFS(G2, 9);

        int[] dist = result[0];
        int[] npath = result[1];

        //1 shortest path from 9 -> 10 and the distance is 1
        assert (
            dist[G2.n - 1] == 1 && 
            npath[G2.n - 1] == 1
        ) : "G2 failed BFS at Starting Node (9)" ;
    }

    /** g2 that starts at 10 */
    @Test public void test_G2_10(){
        int[][] result = BFS(G2, 10);

        int[] dist = result[0];
        int[] npath = result[1];

        //1 shortest path from 10 -> 10 and the distance is 0
        assert (
            dist[G2.n - 1] == 0 && 
            npath[G2.n - 1] == 1
        ) : "G2 failed BFS at Starting Node (10)" ;
    }
}
