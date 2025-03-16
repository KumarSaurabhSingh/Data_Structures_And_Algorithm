class Node{

    int data;
    Node next;

    //Constructor
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class search_LinkedList {


    //Search i Linked List
    private static boolean search_LinkedList(Node head, int search){

        Node temp = head;
        while(temp != null){
            if(temp.data == search){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

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

    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = new Node(array[0]);

        //Convert to Linked List
        Node head_new = convertToLinkedlist(array);

        System.out.println(search_LinkedList(head_new, 5));
    }
}
