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

public class Diameter_BinaryTree { //Longest distance betwwen any two Nodes


    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static int findDiameter(Tree root, int maxi){
        if(root == null){
            return 0;
        }

        int left = findDiameter(root.left, maxi);
        int right = findDiameter(root.right, maxi);

        maxi = Math.max(maxi, left+right);

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

        int depth = findDiameter(root, 0);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
