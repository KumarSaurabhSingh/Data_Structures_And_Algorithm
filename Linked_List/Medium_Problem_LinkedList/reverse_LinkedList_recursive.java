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
public class reverse_LinkedList_recursive {
    

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

    //The Recursive Approach
    //Time Complexity - O(N)
    //Space Complexity - O(N)
    static Node recursiveApproach(Node head){

        if(head == null || head.next ==null){
            return head;
        }

        Node new_head = recursiveApproach(head.next);
        //Storing the last node as head's next!!
        Node fronNode = head.next;
        //Now reverse pointing the last node to head!!
        fronNode.next = head;
        //Now updating the head's next as the last node by making its .next as null
        head.next = null;


        return new_head;
    }

    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        Node update_Head = recursiveApproach(newHead);
        System.out.println("The Reverse: ");
        printLinkedList(update_Head);
    }
}
