import java.util.Stack;

class Node{

    int data;
    Node next;

    //Constructor
    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class reverse_LinkedList_Iterative {

    private static Node convertToLinkedlist(int[] array){

        Node head = new Node(array[0]); //Storing the arr[0] as head of LL
        Node mover = head; //Stroing the first element as head

        for(int i=1; i<array.length; i++){

            Node temp = new Node(array[i]); //creating temp variable to store the next element address
            mover.next= temp; // Storing the address of next value
            mover = temp; //Now updating the mover with next value.
        }

        return head;
    }

    //Printing the Linked List
    private static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //The BrueteForce Approach
    //Time Complexity: O(2N)
    //Space Complexity: O(N)
    static Node brueteForce(Node head){

        Node temp = head;

        Stack<Integer> stack = new Stack<>();

         // Step 1: Push the values of the
        // linked list onto the stack
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        // Step 2: Pop values from the stack
        // and update the linked list
        while(temp != null){
            // Set the current node's data
            // to the value at the top of the stack
            temp.data = stack.pop();
             // Move to the next node
            // in the linked list
            temp = temp.next;
        }

        return head;
    }

    //The Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static Node optimalApproach(Node head){

        Node temp = head;
        Node prev = new Node(-1);
        Node front = head;

        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        Node bruetNode = brueteForce(newHead);
        System.out.println("The reverse : ");
        printLinkedList(bruetNode);

        //The Optimal Approach
        Node OptiNode = brueteForce(newHead);
        System.out.println("The reverse : ");
        printLinkedList(OptiNode);
    }
}
