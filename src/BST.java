import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Kate Little
 * @version: Date 04/21/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        BSTNode current = root;
        return searchRecurse(current, val);
    }
    // Helper recursive method for search
    public boolean searchRecurse(BSTNode current, int val){
        // Base case — if the current node equals value
        if (current.getVal() == val){
            return true;
        }
        if (current.getLeft() == null && current.getRight() == null){
            return false;
        }
        // If current is greater than val, go to left child
        else if (current.getVal() > val){
            current = current.getLeft();
        }
        // If current is less than val, go to right child
        else{
            current = current.getRight();
        }
        return searchRecurse(current, val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> roots = new ArrayList<BSTNode>();
        BSTNode current = root;
        inorderRecurse(current, roots);
        return roots;
    }

    // Helper recursion method for getinorder method
    public void inorderRecurse(BSTNode current, ArrayList<BSTNode> roots){
        // Base case
        // If current exists
        if (current == null){
            return;
        }

        //By recursing first on the left root, it will exhaust all left possibilities first
        inorderRecurse(current.getLeft(), roots);
        // Adds current value to arraylist
        roots.add(current);
        inorderRecurse(current.getRight(), roots);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> roots = new ArrayList<BSTNode>();
        BSTNode current = root;
        preorderRecurse(current, roots);
        return roots;
    }
    // Helper recursion method for getPreorder method
    public void preorderRecurse(BSTNode current, ArrayList<BSTNode> roots){
        // Base case
        // If current exists
        if (current == null){
            return;
        }
        // Adds current value to arraylist
        roots.add(current);

        //By recursing first on the left root, it will exhaust all left possibilities first
        preorderRecurse(current.getLeft(), roots);
        preorderRecurse(current.getRight(), roots);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> roots = new ArrayList<BSTNode>();
        BSTNode current = root;
        postorderRecurse(current, roots);
        return roots;
    }
    // Helper recursion method for getPostorder method
    public void postorderRecurse(BSTNode current, ArrayList<BSTNode> roots){
        // If current exists
        if (current == null){
            return;
        }

        //By recursing first on the left root, it will exhaust all left possibilities before moving to the right
        postorderRecurse(current.getLeft(), roots);
        postorderRecurse(current.getRight(), roots);
        // Adds current value to arraylist
        roots.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        root = insertRecurse(val, root);
    }

    // Helper recursion method for insert
    public BSTNode insertRecurse(int val, BSTNode current){
        // If current already exists at this location in the tree
        if (current != null && val == current.getVal()){
            return root;
        }
        // If it has reached a child that doesn't exist, aka the position where val
        // Would be if it were in the tree, insert val here
        if (current == null){
            current = new BSTNode(val);
            return current;
        }
        // If val is less than current, go left
        if (val < current.getVal()){
            current.setLeft(insertRecurse(val, current.getLeft()));
        }
        // If val is greater than current, go right
        else if (val > current.getVal()){
            current.setRight(insertRecurse(val, current.getRight()));
        }
        return current;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
