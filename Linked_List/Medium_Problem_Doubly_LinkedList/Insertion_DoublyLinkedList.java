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

public class Insertion_DoublyLinkedList {
    
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

    //Insertion at the Head
    static Node insertionHead(Node head, int value){
        Node temp = new Node(value, head, null);
        return temp;
    }

    //Inserted Tail
    static Node insertionTail(Node head, int value){

        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        Node prev = new Node(value, null, temp);
        temp.next = prev;
        
        return head;
    }

    //Insert Before Tail
    static Node insertBeforeTail(Node head, int value){

        if(head == null){
            return new Node(value);
        }

        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.back;
        Node insertNew = new Node(value, tail, prev);

        prev.next = insertNew;
        tail.back = insertNew;

        return head;
    }

    //Insert Before Kth Value
    static Node insertBefore_Kth(Node head, int kth, int value){

        if(head == null){
            return new Node(value);
        }

        if(kth ==1){
            Node tempHead = insertionHead(head, value);
            return tempHead;
        }

        Node tail = head;
        int cnt = kth;
        while(tail.next != null){
            cnt--;
            if(cnt == 1){
                break;
            }
            tail = tail.next;
        }

        Node prev = tail.back;
        Node insertNew = new Node(value, tail, prev);

        prev.next = insertNew;
        tail.back = insertNew;

        return head;
    }


    //Insert Before a Node
    static Node insertBefore_Node(Node head, Node kth_Node, int value){

        if(head == null){
            return new Node(value);
        }

        Node tail = head;
        //int cnt = kth_Node;
        while(tail.next != null){
            //cnt--;
            if(tail.data == kth_Node.data){
                break;
            }
            tail = tail.next;
        }

        Node prev = tail.back;
        Node insertNew = new Node(value, tail, prev);

        prev.next = insertNew;
        tail.back = insertNew;

        return head;
    }


    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6};
        Node head = new Node(array[0]);

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);

        //Insertion at the Head
        Node ist_Head = insertionHead(con_head, 0);
        System.out.println("Head Inserted : ");
        printLinkedList(ist_Head);

         //Insertion at the Tail
        Node ist_Tail = insertionTail(ist_Head, 0);
        System.out.println("Tail Inserted : ");
        printLinkedList(ist_Tail);

        //Insertion before the Tail
        Node ist_BeforeTail = insertionTail(ist_Tail, 99);
        System.out.println("Before Tail Inserted : ");
        printLinkedList(ist_BeforeTail);

        //Insertion before the Kth
        Node ist_BeforeKth = insertBefore_Kth(ist_Tail, 1, 11);
        System.out.println("Before Kth Inserted : ");
        printLinkedList(ist_BeforeKth);

        //Insertion before the Node
        Node ist_BeforeNode = insertBefore_Node(ist_BeforeKth, ist_BeforeKth.next.next.next, 19);
        System.out.println("Before Node Inserted : ");
        printLinkedList(ist_BeforeNode);
    }
}
