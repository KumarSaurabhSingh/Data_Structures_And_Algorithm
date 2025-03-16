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
public class loopLength_LinkedList {
    
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

    //The Bruete Force Approach
    static int brueteForce(Node head){
        Node temp = head;

        Map<Node, Integer> map = new HashMap<>();
        int cnt = 0;
        while(temp != null){
            if(map.containsKey(temp)){
                int value = cnt - map.get(temp);
                return value;
            }
            map.put(temp, cnt);
            temp = temp.next;
            cnt++;
        }

        return 0;
    }


    //THe Optimal Approach - Using Tortoise & Hare Algorithm
    static int optimalApproach(Node head){
        
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return findLoop(slow, fast.next);
            }
        }
        return 0;
    }


    //FInding the loop length
    static int findLoop(Node slow, Node fast){
        int len =1;
        while(slow != fast){
            fast = fast.next;
            len++;
        }
        return len;
    }



    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        int bruete_ans = brueteForce(newHead);
        System.out.println("The Loop length is : " + bruete_ans);

        //The Optimal Force Approach
        int Opti_ans = optimalApproach(newHead);
        System.out.println("The Loop length is : " + Opti_ans);
    }
}
