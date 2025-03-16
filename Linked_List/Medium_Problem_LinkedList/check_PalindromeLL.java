import java.util.Stack;

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

public class check_PalindromeLL {
    

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

    //Reverse Of the Linked List
    static Node reverseLinkedList(Node head){

        Node temp = head;
        Node prev = null;
        Node front = head;

        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        printLinkedList(prev);
        return prev;

    }


    //The Bruete FOrce Approach - check Palindrome
    //Time Complexity - O(2N)
    //Space Complexity - O(N)
    static boolean brueteForce(Node head){

        if(head == null || head.next == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        Node temp = head;

        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }


        temp = head;

        while(temp != null){

            if(temp.data != stack.pop()){
                return false;
            }

            temp = temp.next;
        }

        return true;
    }

    //The Optimal Approach
    //Time Complexity - O(2N)
    //Space Complexity - O(1)
    static boolean optimalApproach(Node head){

        if(head.next ==null || head == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        //Tortoise way to find the mid of the linked List
        while(fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHead = slow.next;
        Node newHead = reverseLinkedList(secondHead);
        Node temp = head;


        while(newHead != null){

            if(temp.data != newHead.data){
                return false;
            }

            temp = temp.next;
            newHead = newHead.next;
        }
        //Again reversing the modifies second half.
        reverseLinkedList(newHead);

        return true;
    }



    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 3, 20, 13};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The BrueteForce Approach
        Boolean res = brueteForce(newHead);
        System.out.println("is Palindrome : "+res);

        //The Optimal Approach
        Boolean res2 = optimalApproach(newHead);
        System.out.println("is Palindrome : "+res2);
    }
}
