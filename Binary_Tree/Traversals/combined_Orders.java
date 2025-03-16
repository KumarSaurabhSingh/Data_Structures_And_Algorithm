import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair{
    Node x;
    int y;

    public Pair(Node x, int y){
        this.x = x;
        this.y = y;
    }
}


//Time Complexity: O(3N)
//Space Complexity: O(4N) where N is the number of nodes in the Binary Tree.

public class combined_Orders {

    static List<List<Integer>> traversal(Node root){

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        if(root == null){
            return new ArrayList<>();
        }

        while(!st.empty()){

            Pair it = st.pop();

            if(it.y==1){
                pre.add(it.x.data);
                it.y++;
                st.push(it);

                if(it.x.left != null){
                    st.push(new Pair(it.x.left, 1));
                }
            }

            else if(it.y ==2){
                in.add(it.x.data);
                it.y++;
                st.push(it);

                if(it.x.right != null){
                    st.push(new Pair(it.x.right, 1));
                }
            }

            else{
                post.add(it.x.data);
                
            }
        }

        // Returning the traversals
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;

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

        // Getting the pre-order, in-order,
        // and post-order traversals
        List<Integer> pre, in, post;
        List<List<Integer>> traversals = traversal(root);

        // Extracting the traversals
        // from the result
        pre = traversals.get(0);
        in = traversals.get(1);
        post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}
