import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class Assignment6Tests extends Assignment6{

    /**   7, 10, 3, 9, 13, 11.*/
    final int[] data1 = { 7, 10, 3, 9, 13, 11};

    /**   7, 3, 10, 9, 13, 11.*/
    final int[] figure1 = {7,3,10,9,13,11};

    /**  Creates <pre>
     *         50   <br>
     *        /  \  <br>
     *       30    70  <br>
     *      /  \  /  \<br>
     *     20 40 60 80<br>
     * </pre> */
    public Node createTree(){
        Node root = new Node(50);
        insert(root, 30);
        insert(root, 70);
        insert(root, 20);
        insert(root, 40);
        insert(root, 60);
        insert(root, 80);
        return root;
    }

    public Node createTree(int... key){
        Node root = new Node(key[0]);

        for(int i = 1; i < key.length; i++)
            insert(root, key[i]);
        
        return root;
    }

    @Test 
    public void test_Insert(){
        Node root = new Node(10);

        final int KEY = root.key + 10; //right
        final int KEY2 = root.key - 10; //left

        assertNull(root.left);
        assertNull(root.right);

        insert(root, KEY);
        insert(root, KEY2);
        
        assertEquals(KEY2, root.left.key);
        assertEquals(KEY, root.right.key);

    }
    @Test
    public void test_Search(){
        Node root = createTree();
        assertNotNull(search(root, 50));
        assertNotNull(search(root, 30));
        assertNotNull(search(root, 70));
        assertNotNull(search(root, 20));
        assertNotNull(search(root, 40));
        assertNotNull(search(root, 60));
        assertNotNull(search(root, 80));
        assertNull(search(root, 19));
    }

    @Test 
    public void test_leftRotate(){
        Node root = createTree();
        root = leftRotate(root);
       
        assertEquals(70, root.key);

            assertEquals(50, root.left.key);
                assertEquals(30, root.left.left.key);
                    assertEquals(20,root.left.left.left.key);
                    assertEquals(40,root.left.left.right.key);

                
                assertEquals(60,root.left.right.key);
                
            assertEquals(80, root.right.key);
            assertNull(root.right.right);
    }
   
    @Test
    public void test_rightRotate(){
        Node root = createTree();
        root = rightRotate(root);
        assertEquals(30, root.key);
            assertEquals(20, root.left.key);
            assertEquals(50, root.right.key);
                assertEquals(40, root.right.left.key);
                assertEquals(70, root.right.right.key);
                    assertEquals(60, root.right.right.left.key);
                    assertEquals(80, root.right.right.right.key);
    }

    @Test
    public void test_Sizing(){

        Node root = createTree();
        assertEquals(7, root.size);
        assertEquals(root.left.size,root.right.size);


        root = leftRotate(root);
        assertEquals(7, root.size); 
            assertEquals(1,root.right.size);
            assertEquals(5,root.left.size);
                assertEquals(3,root.left.left.size);
                assertEquals(1,root.left.right.size);
                    assertEquals(1,root.left.left.left.size);
                    assertEquals(1,root.left.left.right.size);

        root = createTree();


        root = rightRotate(root);
        assertEquals(7, root.size);
            assertEquals(1,root.left.size);
            assertEquals(5,root.right.size);
                assertEquals(1,root.right.left.size);
                assertEquals(3,root.right.right.size);
                    assertEquals(1,root.right.right.left.size);
                    assertEquals(1,root.right.right.right.size);

        
    
    }

    @Test 
    public void test_Sizing2(){
        Node root = createTree(7,3,10,9,13,11);
        assertEquals(6, root.size);
            assertEquals(1, root.left.size);
            assertEquals(4, root.right.size);
                assertEquals(1, root.right.left.size);
                assertEquals(2, root.right.right.size);
                    assertEquals(1, root.right.right.left.size);
            
        root = leftRotate(root);
        assertEquals(6, root.size);
            assertEquals(2,root.right.size);
            assertEquals(3,root.left.size);
                assertEquals(1,root.left.left.size);
                assertEquals(1,root.left.right.size);
                   
    }
    
    @Test
    public void FileReading(){
        Node input6_1 = inputFile("input-6-1.txt");

            assertNotNull(input6_1);
            assertEquals(448,input6_1.key); //the first root is 448
            assertEquals(1000, input6_1.size);

        Node input6_2 = inputFile("input-6-2.txt");
            assertNotNull(input6_2);
            assertEquals(745,input6_2.key); //the first root is 10000
            assertEquals(10000, input6_2.size);
    }

    @Test
    public void PreOrder(){
        Node root = createTree(data1);

        System.err.println("Should print: (7,6), (3,1), (10,4), (9,1), (13, 2), (11,1) ");
        preorder(root);

        System.err.println("\n(LeftRotate) Should print:  (10,6), (7,3), (3,1), (9,1) (13,2), (11, 1)");
        preorder(leftRotate(root));
    }
}


