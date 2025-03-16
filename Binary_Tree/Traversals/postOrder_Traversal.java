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
public class postOrder_Traversal {
    

    static List<Integer> traversal(Node root){
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);
        while(!st1.isEmpty()){

            root = (Node) st1.pop();
            
            st2.push(root);
            if(root.left != null){
                st1.add(root.left);
            }

            if(root.right != null){
                st2.add(root.right);
            }
        }

        // Populate the postorder traversal list by popping st2
        while (!st2.empty()) {
            ans.add(st2.pop().data);
        }

        return ans;
    }


    // Function to print the
    // elements of a list
    public static void printList(List<Integer> list) {
        // Iterate through the list
        // and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

         // Getting postorder traversal
        List<Integer> result = traversal(root);

         // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        printList(result);
    }
}
