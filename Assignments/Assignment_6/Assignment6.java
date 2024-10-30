import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/** Since only 2 files are submitted (pdf and .java) all classes are stuffed into this file */
public class Assignment6 {
    public static void main(String[] args) {
        Node input6_1 = inputFile("input-6-1.txt");
        Node input6_2 = inputFile("input-6-2.txt");

        System.out.println("Preorder traversal of input6_1:");
        preorder(input6_1);

        
        System.out.println("\n\nPreorder traversal of input6_2:");
        preorder(input6_2);
        
       
        
    }
    
    /** reads the file and converts it to an Node with children/binarytree */
    public static Node inputFile(String filename) {
        try (Scanner console = new Scanner(new FileReader(filename))) {
            
            //size is the first number -1 cus first number is the root
            final int N = console.nextInt()-1;
            Node root = new Node(console.nextInt());

            //reads ints in the file
            for (int i = 0; i < N; i++) 
                insert(root,console.nextInt());
            
            return root;
        }catch(FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
        }

        return null;
    } 
    /** function to search a key in a BST.
     * @param root
     * @param KEY
     * @return the {@code node} with key or {@code null} if doesnt exist
     */
    static Node search(Node root, final int KEY)
    {
        // Base Cases: root is null or key is already the root
        if (root == null || root.key == KEY)
            return root;

        // Key is greater than root's key
        if (KEY > root.key)
            return search(root.right, KEY);

        // Key is smaller than root's key
        return search(root.left, KEY);
    }

   
    /** rotates the root t to the left, so that the right child of {@code t} becomes the parent of t, and symmetrically rightRotate  (Node t) 
     * @param t the node that gets rotated left
    */
    static Node leftRotate(final Node t) {
        if (t == null || t.right == null) return t; // no right child to rotate
        //TODO: SIZE calc for left 
        final Node L_rotate = t.right;
            L_rotate.size = t.size; // size of left rotate = old root;
        
        t.right = L_rotate.left;
            t.size = 1;
            if (t.right != null) t.size += t.right.size; // add size of right child
            if (t.left != null) t.size += t.left.size; // add size of left child
        L_rotate.left = t;
        
        return L_rotate;
    }

    /** opposite of leftRotate
     * @param t the node that gets rotated right
    */
    static Node rightRotate(final Node t){
        if (t == null || t.left == null) return t; // no left child to rotate

        //TODO: SIZE calc for right
        final Node R_rotate = t.left;
            R_rotate.size = t.size; // size of right rotate = old root;

        t.left = R_rotate.right;
            t.size = 1;
            if (t.right != null) t.size += t.right.size; // add size of right child
            if (t.left != null) t.size += t.left.size; // add size of left child
        

        R_rotate.right = t;
       
        return R_rotate;
    }

    /** function to insert a key in a BST
     * @param root
     * @param KEY
     * @return root node with inserted KEY
    */
    static Node insert(Node root, final int KEY) {        
        if (root == null) return new Node(KEY);
         
        if (KEY < root.key) root.left = insert(root.left, KEY); 
        else if (KEY >= root.key) root.right = insert(root.right, KEY);
       
        root.size++;

        return root;
    }

    /** prints preorder (key,size) */
    static void preorder(Node root){
        if (root == null) return; 

        System.out.printf(
            "(%d,%d) ",
            root.key, root.size
        );

        preorder(root.left);
        preorder(root.right);
    }
}
    
    class Node {
        /**  keeps the number of nodes
     in the tree rooted at that node (including in the count the node itself). The constructors
    and the insertion function need to take into account the sizes of the nodes. */
        public int size = 0;

        final public int key;

        public Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
            
            size = 1;
        }
    }

