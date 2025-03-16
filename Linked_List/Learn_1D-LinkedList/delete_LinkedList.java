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

public class delete_LinkedList {

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

    //Remove Head from the LinkedList
    private static Node removeHead(Node head){
        if(head == null) return null;

        head = head.next;
        return head;
    }

    //Removing Tail from the LinkedList
    private static Node removeTail(Node head){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        return temp;
    }

    //Deleting the Kth Element
    public static Node deleteKthElement(Node head, int k){

        if(head == null) return head;

        if(k==1){
            head= head.next;
            return head;
        }

        else{
            Node temp = head;
            int cnt = 0;
            Node previous = null;

            while(temp!= null){

                cnt++;
                if(cnt == k){
                    previous.next = previous.next.next; //Pointing the next of previous to previous's next to next.
                    break;
                }

                previous = temp;
                temp = temp.next;
            }
        }
        return head;
    }



    public static Node deleteElement(Node head, int value){

        if(head == null) return head;

        if(value==head.data){
            head= head.next;
            return head;
        }

        else{
            Node temp = head;
            int cnt = 0;
            Node previous = null;

            while(temp!= null){

                cnt++;
                if(temp.data == value){
                    previous.next = previous.next.next; //Pointing the next of previous to previous's next to next.
                    break;
                }

                previous = temp;
                temp = temp.next;
            }
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
        int[] array = {13, 20, 3, 14, 9, 7, 90, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //Removing the head
        head = removeHead(newHead);
        System.out.println("Removed Head : ");
        printLinkedList(head);;

        //Removing the Tail
        Node tailHead = removeTail(head);
        System.out.println("Removed Tail : ");
        tailHead.next = null;
        printLinkedList(head);

        //Remove the Kth element
        Node kthHead = deleteKthElement(head, 1);
        System.out.println("Updated Linked List: ");
        printLinkedList(kthHead);

        //Remove the Element Value
        Node elHead = deleteElement(kthHead, 7);
        printLinkedList(elHead);
    }
}
