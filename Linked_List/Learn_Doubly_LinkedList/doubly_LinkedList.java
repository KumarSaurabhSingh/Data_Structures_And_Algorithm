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
    
    public class doubly_LinkedList {
    
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
    
    
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6};
        Node head = new Node(array[0]);

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);
    }
}
