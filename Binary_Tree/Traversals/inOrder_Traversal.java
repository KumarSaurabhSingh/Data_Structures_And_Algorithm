import java.util.ArrayList;
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


public class inOrder_Traversal {
    
    static void inorder(Node root, List<Integer> ans){

        if(root == null){
            return;
        }

        inorder(root.left, ans);

        ans.add(root.data);

        inorder(root.right, ans);
    }

    static List<Integer> inOrder(Node root){

        List<Integer> ans = new ArrayList<>();

        inorder(root, ans);

        return ans;
    }


    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting inorder traversal
        List<Integer> result = inOrder(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        // Output each value in the
        // inorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
