
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

        insert(root,50);
        insert(root,30);
        insert(root,30);
        insert(root,20);
        insert(root,40);
        insert(root,70);
        insert(root,60);
        insert(root,80);

        // Print inorder traversal of the BST
        inorder(root);
        
        // Searching for keys in the BST
        System.out.println(search(root, 19) != null
                               ? "Found"
                               : "Not Found");
        System.out.println(search(root, 80) != null
                               ? "Found"
                               : "Not Found");
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

   
    /** rotates the root t to the left, so that the right child of t (if there is one; otherwise the rotation does not do anything) becomes the parent of t, and symmetrically rightRotate  (Node t) */
 static Node leftRotate(Node root,final Node t) {
    Node r = t.right;
    t.right = r.left;
    r.left = t;
    return r;
}

static Node insert(Node root, int key) {        
    if (root == null) root = new Node(key); //basecase
    
    if (key < root.key) root.left = insert(root.left, key);
    if (key > root.key) root.right = insert(root.right, key);
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
    int size;
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

