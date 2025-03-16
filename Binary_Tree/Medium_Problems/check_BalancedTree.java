class Tree{
    int data;
    Tree left;
    Tree right;

    public Tree(int data, Tree left, Tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

//Time Complexity - O(N)
//Space Complexity - O(1)
public class check_BalancedTree {

    static int findBalanced(Tree root){

        if(root == null){
            return 0;
        }

        int left = findBalanced(root.left);
        if(left == -1) return -1;

        int right = findBalanced(root.right);
        if(right == -1) return -1;

        // Check if the difference in height between
        // left and right subtrees is greater than 1
        // If it's greater, the tree is unbalanced,
        // return -1 to propagate the unbalance status
        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
    
    public static void main(String[] args) {
        // Creating a sample binary tree
        Tree root = new Tree(3);
        root.left = new Tree(9);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(7);
        root.left.right = new Tree(6);
        root.left.right.left= new Tree(7);

        int depth = findBalanced(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
