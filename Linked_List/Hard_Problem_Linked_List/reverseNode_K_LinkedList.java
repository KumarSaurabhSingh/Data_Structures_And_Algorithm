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
public class reverseNode_K_LinkedList {
    
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

    static Node reverseLinkedList(Node head) {
        // Initialize'temp' at
        // head of linked list
        Node temp = head;
       // Initialize pointer 'prev' to NULL,
       // representing the previous node
        Node prev = null;
       // Traverse the list, continue till
       // 'temp' reaches the end (NULL)
        while(temp != null){
           // Store the next node in
           // 'front' to preserve the reference
            Node front = temp.next;
        
           // Reverse the direction of the
           // current node's 'next' pointer
           // to point to 'prev'
            temp.next = prev;
            
            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;
            
            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }
       // Return the new head of
       // the reversed linked list
        return prev;
    }


    // Function to get the Kth node from
    // a given position in the linked list
    static Node getKthNode(Node head, int kth){
        Node temp = head;
        kth -= 1;
        while(temp != null && kth >0){
            kth--;
            temp= temp.next;
        }

        return temp;
    }


    //The reverse a Linked List from Kth Node
    static Node reverseNode(Node head, int kth){

        Node temp = head;
        Node prev = null;

        while(temp!= null){

            Node kthNode = getKthNode(head, kth);
            if(kthNode == null){
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;

            reverseLinkedList(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                 // Link the last node of the previous
                // group to the reversed group
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }



    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5, 0, 7, 18};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);
        printLinkedList(newHead);
        int kth = 3;

        //The Reverse of an LinkedList from Kth position
        Node update_head = reverseNode(newHead, kth);
        System.out.println("Updated : ");
        printLinkedList(update_head);
    }
}
