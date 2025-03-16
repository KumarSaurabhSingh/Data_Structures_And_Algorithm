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
//Space COmplexity - O(1)
public class Maximum_Path_Sum {

    static int findMaxPath(Tree root, int[] maxi){
        
        if( root == null){
            return 0;
        }

        int left = findMaxPath(root.left, maxi);
        int right = findMaxPath(root.right, maxi);

        maxi[0] = Math.max(maxi[0], right + left + root.data);

        return Math.max(left, right) + root.data;
    }

    static int maxPathSum(Tree root){

        if(root == null){
            return 0;
        }

        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;


        findMaxPath(root, maxi);

        return maxi[0];
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

        int depth = maxPathSum(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
