import java.util.ArrayList;

class Tree{
    int data;
    Tree left, right;

    public Tree(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


//Time Complexity - O(N)
//Space COmplexity - O(N), auxiliary space.
public class LCA_Binary {

    static Tree traversal(Tree root, Tree p, Tree q){

        if(root == null || root == p || root == q){
            return root;
        }

        Tree left = traversal(root.left, p, q);
        Tree right = traversal(root.right, p, q);

        if(left == null){
            return right;
        }

        else if(right == null){
            return left;
        }

        else{
            return root;
        }
    }
    


    public static void main(String[] args) {
        
        // Creating a sample binary tree
        Tree root = new Tree(3);
        root.left = new Tree(5);
        root.right = new Tree(1);
        root.left.left = new Tree(6);
        root.left.right = new Tree(2);
        root.right.left = new Tree(0);
        root.right.right = new Tree(8);
        root.left.right.left = new Tree(7);
        root.left.right.right = new Tree(4);

        Tree p = root.left.right;
        Tree q = root.left.right.right;

        Tree ans = traversal(root, p, q);
        System.out.println("Common root will be: "+ ans.data);
    }
}
