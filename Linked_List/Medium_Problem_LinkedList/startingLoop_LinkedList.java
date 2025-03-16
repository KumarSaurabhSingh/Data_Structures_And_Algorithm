import java.util.HashMap;
import java.util.Map;

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
public class startingLoop_LinkedList {
    
    private static Node convertToLinkedlist(int[] array){

        Node head = new Node(array[0]); //Storing the arr[0] as head of LL
        Node mover = head; //Stroing the first element as head
        Node end = head;
        for(int i=1; i<array.length; i++){

            Node temp = new Node(array[i]); //creating temp variable to store the next element address
            mover.next= temp; // Storing the address of next value
            mover = temp; //Now updating the mover with next value.
            end = end.next;
        }

        end .next = head.next.next.next;
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


    //The Bruete Force
    static Node brueteForce(Node head){
        Node temp = head;
        Map<Node, Integer> map = new HashMap<>();


        while(temp != null){

            if(map.containsKey(temp)){
                break;
            }
            map.put(temp, 1);
            temp = temp.next;
        }

        return temp;
    }


    //The Optimal Approach - Using Tortoise & Hare Algorithm
    //Time Complexity - O(N * Half Loop Length)
    //Space Complexity - O(1)
    static Node optimalApproach(Node head){
        Node slow = head;
        Node fast = head;
        //Applying the Tortoise and Hare Method
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head; //Again Pointing the slow to head
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = {13, 20, 2, 3, 14, 9, 65, 5};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        Node bruete_ans = brueteForce(newHead);
        System.out.println("The Head of the Loop : "+ bruete_ans.data);


        //The Optimal Force Approach
        Node Opti_ans = brueteForce(newHead);
        System.out.println("The Head of the Loop : "+ Opti_ans.data);
    }
}
