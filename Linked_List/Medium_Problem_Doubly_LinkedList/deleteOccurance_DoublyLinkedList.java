import java.util.Scanner;

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
public class deleteOccurance_DoublyLinkedList {
    
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




    //Deleting All Occurance of an Element
    //Tiem Compelxity - O(N)
    //Space Complexity - O(1)
    static Node deleteOccurance(Node head, int element){

        Node temp = head;
        while(temp != null){

            if(temp.data == element){

                if(temp == head){
                    head = head.next;
                }

                Node prev = temp.back;
                Node front = temp.next;

                if(prev != null){
                    prev.next = front;
                }

                if(front != null){
                    front.back = prev;
                }

                temp = temp.next;
            }

            else
            temp = temp.next;
        }

        return head;
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] array = { 1, 2, 2, 4, 2, 6};
        Node head = new Node(array[0]);

        //System.out.println("Please Enter the Element : ");
        int element = input.nextInt();

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);

        //Delete the Occurance of an Element
        Node update_Head = deleteOccurance(con_head, element);
        System.out.println("The Updated DLL : ");
        printLinkedList(update_Head);

    }
}
