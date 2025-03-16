import java.util.ArrayList;
import java.util.List;

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
public class even_odd_LinkedList {
    
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




    //segregate even and odd one
    static Node brueteForce(Node head){

        List<Integer> List = new ArrayList<>();

        Node temp = head;
        //Inserting the Odd numbers
        while(temp != null && temp.next != null){
            List.add(temp.data);
            temp = temp.next.next;
        }
        if(temp!= null){
            List.add(temp.data);

        }

        //Inserting the even numbers
        temp = head.next;
        while(temp != null && temp.next != null){
            List.add(temp.data);
            temp = temp.next.next;
        }
        if(temp!= null){
            List.add(temp.data);
        }

        temp = head;
        int cnt =0;
        while(temp != null){
            temp.data = List.get(cnt);
            cnt++;
            temp = temp.next;
        }

        return head;
    }


    //Optimal Approach
    static Node optimalApproach(Node head){

        if(head == null){
            return null;
        }

        Node odd = head;
        Node even = head.next;
        Node even_Temp = head.next;


        while(even != null && even.next != null){

            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = even_Temp;
        return head;
    }




    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);
        System.out.println("The Original : ");
        printLinkedList(newHead);

        //Bruete Force Approach
        Node bruete_head = brueteForce(newHead);
        System.out.println("The List is : ");
        printLinkedList(bruete_head);

        //Optimal Force Approach
        Node Opti_head = optimalApproach(newHead);
        System.out.println("The List is : ");
        printLinkedList(Opti_head);
    }
}
