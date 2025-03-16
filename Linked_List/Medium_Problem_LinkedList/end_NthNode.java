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

public class end_NthNode {
    
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

    
    //The Bruete Force Approach
    //Time Complexity: O(L)+O(L-N), We are calculating the length of the linked list and then iterating up to the (L-N)th node of the linked list, where L is the total length of the list.
    //Space Complexity:  O(1), as we have not used any extra space.
    static Node brueteForce(Node head, int kth){

        if(head == null){
            return null;
        }

        Node temp = head;
        int cnt =0;
        while(temp.next!=null){
            cnt++;
            temp = temp.next;
        }

        //If the kth position is equal to the number of entries
        if (cnt == kth) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }

        temp = head;

        int counter =0;
        while(temp.next != null){

            if(counter == cnt -kth){
                break;
            }
            counter++;
            temp = temp.next;
        }

        Node del_Node = temp.next;
        Node front = temp.next.next;
        temp.next = front;
        del_Node.next =null;

        return head;

    }


    //The Optimal Approach
    //Time Complexity: O(N) since the fast pointer will traverse the entire linked list, where N is the length of the linked list.
    //Space Complexity: O(1), as we have not used any extra space.
    static Node optimalApproach(Node head, int kth){

        Node temp = head;

        // Move the fastp pointer N nodes ahead
        for(int i=0; i<kth; i++){
            temp = temp.next;
        }

        Node front = temp;
        Node slow = head;

        // If fastp becomes null, the Nth node from the end is the head
        if(front == null){
            return head.next;
        }

        // Move both pointers until fastp reaches the end
        while(front.next != null){
            front = front.next;
            slow = slow.next;
        }


        // Delete the Nth node from the end
        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;

        return head;
    }

    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        Node bruNode = brueteForce(newHead, 1);
        System.out.println("The Updated LL: ");
        printLinkedList(bruNode);

        //The Optimal Approach
        Node OptiNode = optimalApproach(newHead, 1);
        System.out.println("The Updated LL: ");
        printLinkedList(OptiNode);
    }
}
