import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/** Since only 2 files are submitted (pdf and .java) all classes are stuffed into this file */
public class Assignment6 {
    public static void main(String[] args) {
        Node root = inputFile("input-6-1.txt");

        System.out.println("Inorder traversal of the given tree");
        inorder(root);
       
        
    }
    
    /** reads the file and converts it to an Node with children/binarytree */
    public static Node inputFile(String filename) {
        try (Scanner console = new Scanner(new FileReader(filename))) {
            
            //size is the first number -1 cus first number is the root
            final int N = console.nextInt()-1;
            Node root = new Node(console.nextInt());

            //reads ints in the file
            for (int i = 0; i < N-1; i++) 
                insert(root,console.nextInt());
            
            return root;
        }catch(FileNotFoundException e) {
            System.err.println("File not found: '" + filename + "'");
        }

        return null;
    } 
    /** function to search a key in a BST. */
    static Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at
        // root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

   
    /** rotates the root t to the left, so that the right child of {@code t} becomes the parent of t, and symmetrically rightRotate  (Node t) 
     * @param t the node that gets rotated left
    */
    static Node leftRotate(final Node t) {
        if (t == null || t.right == null) return t; // no right child to rotate
        //TODO: SIZE calc for left 
        final Node L_rotate = t.right;

        t.right = L_rotate.left;
        

        L_rotate.left = t;
       
        return L_rotate;
    }

    /** opposite of leftRotate */
    static Node rightRotate(final Node t){
        if (t == null || t.left == null) return t; // no left child to rotate

        //TODO: SIZE calc for right
        final Node R_rotate = t.left;

        t.left = R_rotate.right;
        

        R_rotate.right = t;
       
        return R_rotate;
    }

    static Node insert(Node root, final int KEY) {        
        if (root == null) return new Node(KEY);
        
        
        root.size++;
        if (KEY < root.key) root.left = insert(root.left, KEY); 
        else if (KEY >= root.key) root.right = insert(root.right, KEY);
       

        

        return root;
        
    }

    /** function to search a key in a BST
     * @param root
     * @param key
    */
    static void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }



    
}
    
    class Node {
        /**  keeps the number of nodes
     in the tree rooted at that node (including in the count the node itself). The constructors
    and the insertion function need to take into account the sizes of the nodes. */
        public int size;

        final public int key;

        public Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
            
            size = 1;
        }

    
    }

