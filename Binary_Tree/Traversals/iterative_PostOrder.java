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

//Time Complexity - O(N)
//Space Complexity - O(N)
public class iterative_PostOrder {
    

    static ArrayList<Integer> traversal(Node root){

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if(root == null){
            return ans;
        }

        st.push(root);
        Node prev = null;

        while(!st.isEmpty()){
            Node curr = st.peek();

            /* go down the tree in search of a leaf an if so
            process it and pop stack otherwise move down */
            if(prev == null || prev.left == curr || prev.right == curr){

                if(curr.left != null){
                    st.push(curr.left);
                }

                else if(curr.right != null){
                    st.push(curr.right);
                }
                else{
                    st.pop();
                    ans.add(curr.data);
                }

                /* go up the tree from left node, if the
                child is right push it onto stack otherwise
                process parent and pop stack */
            }

            else if(curr.left == prev){
                if(curr.right != null){
                    st.push(curr.right);
                }
                else{
                    st.pop();
                    ans.add(curr.data);
                }
                /* go up the tree from right node and after
                coming back from right node process parent
                and pop stack */
            }

            else if(curr.right == prev){
                    st.pop();
                    ans.add(curr.data);
                
            }

            prev = curr;

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
        ArrayList<Integer> result = traversal(root);

         // Printing the postorder traversal result
        System.out.print("Postorder traversal Iterative: ");
        printList(result);
    }
}
