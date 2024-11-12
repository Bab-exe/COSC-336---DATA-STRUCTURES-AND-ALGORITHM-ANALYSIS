
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
            print_Matrix(input7_1);

        System.err.println("\ninput-7-2.txt: ");
            print_Matrix(input7_2);
    }
    

    public void print_Matrix(final Adj_List_Graph GRAPH) {
        final int N = GRAPH.n;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < GRAPH.adj.get(i).size(); j++) 
                System.out.print(GRAPH.adj.get(i).get(j) + " ");
            
            System.out.println();
        
        }

    
            
    }
}
