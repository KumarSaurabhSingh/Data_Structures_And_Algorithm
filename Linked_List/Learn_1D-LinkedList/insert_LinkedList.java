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
public class insert_LinkedList {

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

    //Inserting a new Head
    private static Node insertHead(Node head, int value){
        Node temp = new Node(value, head);
        //temp.next = head;
        return temp;
    }

    //Inserting a new Tail
    private static Node insertTail(Node head, int value){
        if(head == null){
            return new Node(value);
        }

        Node newTail = new Node(value, null);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newTail;
        return head;
    }

    //Inserting at Kth position
    static Node insertKth(Node head, int pos, int value){
        Node temp = new Node(value);
        Node tempHead = head;
        int cnt =pos;

        if(head == null) return new Node(value);

        if(pos==1){
            Node temp1 = new Node(value, head);
            return head;
        }

        while(tempHead!=null){
            cnt--;
            if(cnt == 1){
                break;
            }
            tempHead = tempHead.next;
        }
        temp.next = tempHead.next;
        tempHead.next = temp;

        return head;
    }
    
    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //Inserting a new Head
        Node ist_head = insertHead(newHead, 0);
        System.out.println("Linked List with new Head : ");
        printLinkedList(ist_head);

        //Inserting a new Tail
        Node tailHead = insertTail(ist_head, 999);
        System.out.println("Linked List with new Tail : ");
        printLinkedList(tailHead);

        //Inserting new element at Kth position
        Node kthInsert = insertKth(tailHead, 3, 101);
        System.out.println("Linked List with New Entry : ");
        printLinkedList(kthInsert);

    }
}
