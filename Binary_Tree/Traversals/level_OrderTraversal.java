import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class level_OrderTraversal {

    static List<List<Integer>> levelOrder(Node root){

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            // Create a list to store
            // nodes at the current level
            List<Integer> level = new LinkedList<>();

            for(int i =0; i<size; i++){
                // Get the front node in the queue
                Node node = q.poll();

                 // Store the node value
                // in the current level list
                level.add(node.data);
                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }

            ans.add(level);
        }

        return ans;
    }


    // Function to print
    // the elements of a list
    static void printList(List<Integer> list) {
        // Iterate through the
        // list and print each element
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

        
        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal of Tree:");

        // Printing the level order traversal result
        for (List<Integer> level : result) {
            printList(level);
        }
    }
}
