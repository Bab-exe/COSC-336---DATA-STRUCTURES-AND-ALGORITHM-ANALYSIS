
/** Since only 2 files are submitted (pdf and .java) all classes are stuffed into this file */




public class Assignment6 {
    public static void main(String[] args) {
        BinarySearchTree node = new BinarySearchTree();


        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        node.insert(50);
        node.insert(30);
        node.insert(30);
        node.insert(20);
        node.insert(40);
        node.insert(70);
        node.insert(60);
        node.insert(80);
        


        
        // Print inorder traversal of the BST
        node.inorder();
        
    }
}
class BinarySearchTree {
    private Node root;
    private int height;
    public BinarySearchTree() {
        this.root = null;
        this.height = 0;
    }

    public int getRoot() {
        return this.root.key;
    }
    public Node insert(int key) {
        if (this.root == null) return this.root = new Node(key);
        else return this.root = insert(this.root, key);    
    }

    private Node insert(Node root, int key) {        
        if (root == null) root = new Node(key); //basecase
        
        if (key < root.key) root.left = insert(root.left, key);
        if (key > root.key) root.right = insert(root.right, key);
        return root;   
    }
    
    public Node search(int key) {
        return search(this.root, key);
    }

    /** function to search a key in a BST
     * @param root
     * @param key
    */
    private Node search (Node root, int key) {
        if (root == null) return null;

        if (root.key == key) return root;
        if (key < root.key) return search(root.left, key);
        return search(root.right, key);
    }

    private void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public void inorder() {
        inorder(this.root);
    }

    public Node delete(Node root, int x) {
        
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
                while (current != null && current.left != null) 
                    current = current.left;
                
                parent = current;
            }
            

            root.key = parent.key;
            root.right = delete(root.right, parent.key);
        }
        return root;
    }
    public Node delete(int key) {
        
        return this.root = delete(this.root,key);
        
    }
    

    
}
class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

