import java.util.ArrayList;

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
//Space COmplexity - O(N)
//O(H): In the average case or for a balanced tree, the maximum number of nodes that could be in the stack at any given time would be roughly the height of the tree hence O(log2N).
public class Root_To_Node {

    static boolean traversal(Tree node, ArrayList<Integer> ans, int key){

        if(node == null){
            return false;
        }

        ans.add(node.data);
        if(node.data == key){
            return true;
        }

        if(traversal(node.left, ans, key) || traversal(node.right, ans, key)){
            return true;
        }

        ans.remove(ans.size() - 1);
        return false;
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

        ArrayList<Integer> arr = new ArrayList<>();
        int key = 9;

        Boolean ans = traversal(root, arr, key);
        System.out.println("Binary Tree is Consist the Key: "+ ans);
    }
}
