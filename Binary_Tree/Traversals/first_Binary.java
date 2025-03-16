class Node{

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class first_Binary {
    
    public static void main(String[] args) {
        
        //Creating a root node
        Node root = new Node(2);

        //Adding elements on the left side of the node
        root.left = new Node(3);

        //Adding elements on the right side of the node
        root.right = new Node(4);

        //Adding element on the right side of the left node
        root.left.right = new Node(5);
    }
}
