import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class Assignment6Tests extends Assignment6{
    @Test
    /** Tests the functionality of the Binary Search Tree */
    public void BST_Functionality() {
        BinarySearchTree tree = new BinarySearchTree();

        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 35 60 80
        // /     \     \ 
     //   5      40    105

     //ends in 5 = delete
        tree.insert(50);
        tree.insert(30);
        tree.insert(30);
            tree.insert(35);
        tree.insert(20);
        tree.insert(40);

        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
            tree.insert(5);
            tree.insert(30); // duplicate
            tree.insert(105);

        System.err.print("In Order Traversal: ");
        tree.inorder();

       
        
        // Test search functionality
        
        assertNotNull(tree.search(50)); // 50 should be in tree
        assertNotNull(tree.search(30)); // 30 should be in tree
        assertNotNull(tree.search(20)); // 20 should be in tree
        assertNotNull(tree.search(40)); // 40 should be in tree
        assertNotNull(tree.search(70)); // 70 should be in tree
        assertNotNull(tree.search(60)); // 60 should be in tree
        assertNotNull(tree.search(80)); // 80 should be in tree
        
        assertNull(tree.search(Integer.MIN_VALUE)); //not in tree 
        
        assert(tree.getRoot() == 50); // root should be 50

        // Test delete functionality

        tree.delete(105);
        assertNull(tree.search(100)); // 100 should be deleted

        tree.delete(5);
        assertNull(tree.search(5)); // 5 should be deleted
        

        
        
    }    


}


