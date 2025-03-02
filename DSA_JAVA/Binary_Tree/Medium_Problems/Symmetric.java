import java.util.List;

class Tree{

    int data;
    Tree left, right;

    public Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

//Time Complexity - O(N)
//Space Complexity - O(N)
public class Symmetric {

    static boolean isSymmetric(Tree left, Tree right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.data != right.data){
            return false;
        }

        return isSymmetric(left.right, right.left) && isSymmetric(left.right, right.left);
    } //We are moving left and right simultaeneously in both sides thats why two functions
    
    public static void main(String[] args) {
        
        // Creating a sample binary tree
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(2);
        root.left.left = new Tree(3);
        root.right.right = new Tree(3);
        root.left.right = new Tree(4);
        root.right.left = new Tree(4);

        Boolean ans = isSymmetric(root.left, root.right);
        System.out.println("Binary Tree is Symmetric: "+ ans);
    }
}
