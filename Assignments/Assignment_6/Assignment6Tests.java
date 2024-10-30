import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class Assignment6Tests extends Assignment6{

    /**  Creates
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80
    */
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

    @Test 
    public void test_Insert(){
        Node root = new Node(0);

        final int KEY = 10;
    
        assertNull(search(root, KEY));

        insert(root, KEY);
        assertNotNull(search(root, KEY));

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
    public void test_Delete(){
        Node root = createTree();

        root = delete(root, 50);
        assertNull(search(root, 50));

        root = delete(root, 30);
        assertNull(search(root, 30));

        root = delete(root, 70);
        assertNull(search(root, 70));

        root = delete(root, 20);
        assertNull(search(root, 20));
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
   
}


