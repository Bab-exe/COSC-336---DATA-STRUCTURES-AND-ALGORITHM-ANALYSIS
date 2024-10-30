
/** Since only 2 files are submitted (pdf and .java) all classes are stuffed into this file */
public class Assignment6 {
    public static void main(String[] args) {
        Node root = new Node(50);


        // Creates tree
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        
        insert(root,30);
        insert(root,20);
        insert(root,40);
        insert(root,70);
        insert(root,60);
        insert(root,80);

        // Print inorder traversal of the BST
        inorder(root);
        System.out.println(
            root.key + " is the root of the tree\n" +
            root.size + " is the size of the tree\n"
        );
        
       
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

        final Node L_rotate = t.right;

        t.right = L_rotate.left;
        t.right.size -= 1; // decrease size of right child TODO: left rotate sizes

        L_rotate.left = t;

        return L_rotate;
    }

    /** opposite of leftRotate */
    static Node rightRotate(final Node t){
        if (t == null || t.left == null) return t; // no left child to rotate

        final Node R_rotate = t.left;

        t.left = R_rotate.right;
        t.left.size -= 1; // decrease size of left child TODO: right rotate sizes
        R_rotate.right = t;

        return R_rotate;
    }

    static Node insert(Node root, final int KEY) {        
        if (root == null) return new Node(KEY);
        
        
        root.size+=1;
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



    static Node delete(Node root, int x) {
        // Base case
        if (root == null) return root;

        // If key to be searched is in a subtree
        if (root.key > x) {
            root.left = delete(root.left, x);
        } else if (root.key < x) {
            root.right = delete(root.right, x);
        } else {
            // If root matches with the given key

            // Cases when root has 0 children or
            // only right child
            if (root.left == null) return root.right;
            

            // When root has only left child
            if (root.right == null) return root.left;
            

            // When both children are present
            Node parent;
            {
                Node current = root.right;
                while (current.left != null) 
                    current = current.left;
                
                parent = current;
            }
            

            root.key = parent.key;
            root.right = delete(root.right, parent.key);
        }
        return root;
    }

}
    
class Node {
    /**  keeps the number of nodes
 in the tree rooted at that node (including in the count the node itself). The constructors
 and the insertion function need to take into account the sizes of the nodes. */
    public int size;

    public int key;
    public Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
        
        size = 1;
    }

   
}

