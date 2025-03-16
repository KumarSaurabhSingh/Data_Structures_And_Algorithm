import java.util.Stack;

class Node{
    int data;
    Node next;
    Node back;
    
        public Node(int data1, Node next1, Node back1) {
            this.data = data1;
            this.next = next1;
            this.back = back1;
        }
    
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
}

public class reverse_DoublyLinkedList {

    //Convert to Doubly Linked List
    static Node convertToDoublyLL(int[] array, Node head){

        if(head == null) return head;

        Node previous = head;

        for(int i=1; i<array.length; i++){
            Node temp = new Node(array[i], null, previous);
            previous.next = temp;
            previous = temp;
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




    //Reverse a doubly LinkedList
    //Time Complexity : O(2N)
    // Space Complexity : O(N) This is because we are using an external stack data structure.
    static Node reverseDLL_bruete(Node head){
        Stack<Integer> stack = new Stack<>();

        Node temp = head;

        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }


    //Reverse a Doubly Linked List Optimal Approach
    //Time Complexity : O(N) We only have to traverse the doubly linked list once, hence our time complexity is O(N).
    //Space Complexity : O(1), as the reversal is done in place.
    static Node reverse_Optimal(Node head){

        Node temp = head;
        Node last = null;

        while(temp != null){
            last = temp.back;
            temp.back = temp.next;
            temp.next = last;
            
            temp = temp.back;
        }

        return last.back;
    }
    
    public static void main(String[] args) {
        
        int[] array = { 1, 2, 3, 4, 5, 6};
        Node head = new Node(array[0]);

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);

        //Reverse a Doubly Linked List
        Node rev_DLL = reverseDLL_bruete(head);
        System.out.println("Reverse Doubly - Linked List : ");
        printLinkedList(rev_DLL);

        //Reverse a Doubly Linked List - Optimal Approach
        Node rev2_DLL = reverse_Optimal(head);
        System.out.println("(Optimal) Reverse Doubly - Linked List : ");
        printLinkedList(rev2_DLL);
    }
}
