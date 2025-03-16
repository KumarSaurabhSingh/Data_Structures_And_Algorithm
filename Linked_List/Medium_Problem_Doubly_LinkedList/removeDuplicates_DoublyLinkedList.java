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

public class removeDuplicates_DoublyLinkedList {
    
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



    //The Bruete Force Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static Node brueteForce(Node head){

        Node temp = head;
        while(temp != null && temp.next != null){

            Node nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if(nextNode != null)nextNode.back = temp;

            temp = temp.next;
        }

        return head;
    }




    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 7 , 7};
        Node head = new Node(array[0]);

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);

        //The BrueteForce Approach
        Node bruete_Head = brueteForce(con_head);
        System.out.print("Updated : ");
        printLinkedList(bruete_Head);

    }
}
