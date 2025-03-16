import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class sortN_LinkedList {
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
    //Time Complexity - O(N) + O(N Log N) + O(N)
    //SPace Complexity - O(N)
    static Node brueteForce(Node head){

        Node temp = head;
        List<Integer> array = new ArrayList<>();

        while(temp != null){

            array.add(temp.data);
            temp = temp.next;
        }
        //Sorting the Array
        Collections.sort(array);

        temp = head;
        int i =0;
        while(temp != null){
            temp.data = array.get(i);
            i++;
            temp = temp.next;
        }

        return head;
        
    }


    //The Optimal Approach
    //Time Complexity - O(N log N)
    //Space Compelxity - O(1)
    static Node mergeSort(Node head){
    // If the list is empty or has only one node
    // the middle is the head itself
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;

        Node middle = findMiddle(head);

        Node rightNode = middle.next;
        Node leftNode = head;

        rightNode = mergeSort(rightNode);
        leftNode = mergeSort(leftNode);

        mergeNode(rightNode, leftNode);

        return head;

    }

    //Merging two Node list - Merge Sort Alogorithm
    static Node mergeNode(Node list1, Node list2){

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(list1 != null || list2 != null){

            if(list1.data <= list2.data){
                temp.next = list1;
                list1.next = list2;
            }

            else{
                temp.next = list2;
                list2.next = list1;
            }

            temp = temp.next;
        }

        if(list1 != null){
            temp.next = list1;
        }

        else{
            temp.next = list2;
        }

        return dummyNode.next;
    }

    //Using Tortoise and Hare Algorithm
    static Node findMiddle(Node head){

        Node temp = head;
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);
        printLinkedList(newHead);

        //The Bruete Force Approach
        // Node bruete_ans = brueteForce(newHead);
        // System.out.println("The sorted Linked List : ");
        // printLinkedList(bruete_ans);


        //The Optimal Force Approach
        Node opti_ans = brueteForce(newHead);
        System.out.println("The sorted Linked List : ");
        printLinkedList(opti_ans);
    }
}
