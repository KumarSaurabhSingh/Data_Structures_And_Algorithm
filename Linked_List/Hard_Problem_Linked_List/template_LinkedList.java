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
public class template_LinkedList {
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

    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);
    }

}
