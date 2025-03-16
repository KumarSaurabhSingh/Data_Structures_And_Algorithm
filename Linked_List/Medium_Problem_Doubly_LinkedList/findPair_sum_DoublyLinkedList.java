import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class findPair_sum_DoublyLinkedList {
    
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


    //The Bruete FOrce Approach
    //Time Complexity - Near about O(N^2)
    //Space Complexity - O(N)
    static List<int[]> BrueteForce(Node head, int sum){

        Node temp = head;
        List<int[]> store = new ArrayList<>();

        while(temp != null){
            
            Node temp2 = temp.next;

            while(temp2 != null && temp.data + temp2.data <= sum){

                if(temp.data + temp2.data == sum){
                    // Add the pair to the list
                    store.add(new int[]{temp.data, temp2.data});
                }

                temp2 = temp2.next;
            }

            temp = temp.next;
        }

        return store;
        
    }



    //The Optimal Approach
    //Time Compelexity = O(N)
    //SPace Complexity - O (N)
    static List<int[]> OptimalApproach(Node head, int sum){

        Node temp = head;
        Node slow = temp;

        List<int[]> store = new ArrayList<>();

        while(temp.next != null ){
            temp = temp.next;
        }
        Node fast = temp;
        temp = head;

        while(slow.data <= fast.data){

            if(slow.data + fast.data == sum){
                store.add(new int[]{slow.data, fast.data});
                slow= slow.next;
                fast = fast.back;
            }

            else if(slow.data + fast.data < sum){ //There's reason to use Else if here
                slow = slow.next;
            }

            else{
                fast = fast.back;
            }
        }

        return store;
    }




    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6};
        Node head = new Node(array[0]);

        //Convert to Doubly Linked List
        Node con_head = convertToDoublyLL(array, head);
        System.out.println("Doubly - Linked List : ");
        printLinkedList(con_head);

        //The Sum Value
        int sum = 5;


        //The Bruete FOrce Approach
        List<int[]> ans = BrueteForce( head, sum);
        System.out.println("The Brurte Force : ");
        for(int[] pair : ans){
            System.out.println(pair[0] + " + "+ pair[1] + " "+ "= "+ sum);
        }


        //The Optimal FOrce Approach
        List<int[]> ans_Optimal = OptimalApproach( head, sum);
        System.out.println("The Optimal Approach : ");
        for(int[] pair : ans_Optimal){
            System.out.println(pair[0] + " + "+ pair[1]+ " "+ "= "+ sum);
        }
    }
}
