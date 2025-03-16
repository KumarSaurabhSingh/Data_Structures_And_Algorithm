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


public class delete_DoublyLinkedList {

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

    //Deleting The Head of the Doubly Linked List
    static Node deleteHead(Node head){

        if(head == null || head.next == null ){
            return null;
        }
        Node previous = head; //Created a prev which stores the head's data ( value, next, prev)
        head = head.next; // head moved to next (why not prev. becz prev moved to next does not have back linking with prev but have with head)
        head.back = null;
        previous.next = null;
        return head;
    }


    //Delete the tail of Doubly Linked List
    static Node deleteTail(Node head){

        if(head == null || head.next == null ){
            return null;
        }

        Node temp = head;
        Node previous = head;

        //Iterating to point the last Element
        while(temp.next != null){
            temp = temp.next;
        }

        //Interating to spot the second last element
        while(previous.next.next != null){
            previous = previous.next;
        }

        //previous = temp.back;   // We can use this as well t avoid a new loop
        //Removing the connection from second last element perspective
        previous.next = null;

        // Removing the connection from last element frame
        temp.back = null;
        printLinkedList(temp);
        return head;
    }

    //Delete From the Kth Element
    static Node deleteKthNode(Node head, int k){
        if(head == null || head.next == null ){
            return null;
        }

        int cnt = 0;
        Node temp = head;
        Node previous = head;
        while(temp.next != null){
            cnt++;

            if(cnt == k){
                break;
            }
            previous = temp;
            temp = temp.next;
        }

        Node front = head.next;

        if(previous == null && front == null){
            return null;
        }

        else if(previous == null){
            Node del_head = deleteHead(head);
            return head;
        }

        else if(front == null){
            Node del_tail = deleteTail(head);
        }

        else{
            previous.next = temp.next;
            temp.back = null; //removing the kth element
            temp.next = null;
            front.back = previous;
        }

        return head;
    }


    //Delete the Node
    static Node deleteNode(Node head, int search){

        Node temp = head;
        Node prev = temp.back;
        Node front = temp.next;

        if(front == null){
            prev.next = null;
            temp.back = null;
            return null;
        }

        while(temp.next != null){
            if(temp.data == search){
                break;
            }
            temp = temp.next;
        }

        front = temp.next;
        prev = temp.back;

        if(prev == null){
            front.back = null;
            temp.next = null;
            return front;
        }

        if(front == null){
            temp.back = null;
            prev.next = null;
            return head;
        }

        prev.next = front;
        front.back = prev;
        temp.back = null;
        temp.next = null;

        return head;
    }



    
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6};
        Node head = new Node(array[0]);

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);

        //Delete Head
        Node del_head = deleteHead(con_head);
        System.out.println("Head Deleted : ");
        printLinkedList(del_head);

        //Delete Tail
        Node del_tail = deleteTail(del_head);
        System.out.println("Tail Deleted : ");
        printLinkedList(del_tail);

        //Delete Kth Element
        Node del_kth = deleteKthNode(del_head, 4);
        System.out.println("Kth Deleted : ");
        printLinkedList(del_kth);

         //Delete Kth Node
        Node del_Node = deleteNode(del_head, 3);
        System.out.println("Node Deleted : ");
        printLinkedList(del_Node);
    }
}
