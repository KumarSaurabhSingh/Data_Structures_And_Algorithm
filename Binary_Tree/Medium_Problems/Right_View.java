import java.util.ArrayList;
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

public class Right_View {

    //Function to traverse the right side of the binary tree using recursion
    static void recursionRight(Tree root, int level, List<Integer> res){

        if(root == null){
            return;
        }

        if(res.size() == level){

            // If equal, add the value of the
            // current node to the result list
            res.add(root.data);

            // Recursively call the function for the
            // right child with an increased level
            recursionRight(root.right, level+1, res);

            // Recursively call the function for the
            // left child with an increased level
            recursionRight(root.left, level+1, res);
        }
    }
    
    public static void main(String[] args) {
        
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(10);
        root.left.left.right = new Tree(5);
        root.left.left.right.right = new Tree(6);
        root.right = new Tree(3);
        root.right.right = new Tree(10);
        root.right.left = new Tree(9);

        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);

        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
