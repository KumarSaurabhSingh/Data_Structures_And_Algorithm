import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//The Complete Code is correct but won't give the answer in the Output. Need to check for this

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

public class intersection_LinkedList {
    
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




    //The Bruete Force Approach
    //Time Complexity - 
    static Node brueteForce(Node head1, Node head2){
        // Edge case: if either list is null, no intersection
        if (head1 == null || head2 == null) {
            return null;
        }
        
        HashSet<Node> map = new HashSet<>();
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null){
            map.add(temp1);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            if(map.contains(temp2))
                return temp2;

            temp2 = temp2.next;
        }

        return null;
    }


    //The Better Approach
    static Node betterApproach(Node head1, Node head2){

        Node temp1 = head1;
        Node temp2 = head2;

        //Finding the size of the Linked List
        int n1 =0;
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }

        //FInding the length of second linked list
        int n2 =0;
        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }

        if(n1 < n2){
            return collisonPoint(head1, head2, n2-n1);
        }

        else{
            return collisonPoint(head2, head1, n1-n2);
        }
    }


    //Method to find the collison point
    static Node collisonPoint(Node head1, Node head2, int d){  //Assuming head2 is greater
        
        Node temp1 = head1;
        Node temp2 = head2;

        while(d != 0){
            d--;
            temp2 = temp2.next;
        }

        while(temp1 != temp2){

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }


    //The Optimal Approach
    static Node optimalApproach(Node head1, Node head2){

        if(head1 == null || head2 == null)
            return null;

        Node temp1 = head1;
        Node temp2 = head2;


        while(temp1 != temp2){

            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2){
                return temp1;
            }

            if(temp1 == null) temp1 = head2;
            if(temp2 == null) temp2 = head1;
        }

        return head1;
    }



    public static void main(String[] args) {
        int[] array1 = {1,3,1,2,4};
        Node head1 = new Node(array1[0]);

        int[] array2 = {0,0,3,2,4};
        Node head2 = new Node(array2[0]);

        //Converting the Array to Linked List
        Node newHead1 = convertToLinkedlist(array1);
        Node newHead2 = convertToLinkedlist(array2);

        //The Bruete Force Method
        // Node Bruete_ans = brueteForce(newHead1, newHead2);
        // System.out.println("The intersection is : ");
        // printLinkedList(Bruete_ans);

        //The Better Approach
        // Node better_ans = betterApproach(newHead1, newHead2);
        // System.out.println("The Collison : ");
        // printLinkedList(better_ans);


        //The Optimal Approach
        Node Opti_ans = betterApproach(newHead1, newHead2);
        System.out.println("The Collison : ");
        printLinkedList(Opti_ans);
    }
}
