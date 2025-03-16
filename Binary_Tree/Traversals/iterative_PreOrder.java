import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

//Time Complexity - O(N)
//Space Complexity - O(N)

class Solution{

    public static List<Integer> traversal(Node root){
        
        List<Integer> ans = new LinkedList<>();

        if(root == null){
            return ans;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            root = stack.pop();
            ans.add(root.data);

            if(root.right != null){
                stack.add(root.right);
            }

            if(root.left != null){
                stack.add(root.left);
            }
        }

        // Return the preorder
        // traversal result
        return ans;
    }
}

public class iterative_PreOrder {
    
    public static void main(String[] args) {
        
        // Creating a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Initializing the Solution class
        Solution sol = new Solution();

        // Getting the preorder traversal
        List<Integer> result = sol.traversal(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    

}
