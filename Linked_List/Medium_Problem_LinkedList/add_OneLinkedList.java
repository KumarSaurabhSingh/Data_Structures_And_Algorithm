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

public class add_OneLinkedList {

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
        return prev;

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

    //Printing the Linked List
    private static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    //The BrueteForce Approach
    //Time Complexity - O(3N)
    //SPace Complexity - O(1)
    static Node brueteForce(Node head){
        if(head == null){
            return new Node(1);
        }

        Node rev_temp = reverseLinkedList(head);  // O(N)
        Node temp = rev_temp;

        int carry = 1; //adding one to the number
        while(rev_temp != null){                    //O(N)
            rev_temp.data = rev_temp.data + carry;

            if(rev_temp.data < 10){
                carry =0;
                break;
            }

            else{
                rev_temp.data =0;
                carry =1;
            }

            rev_temp = rev_temp.next;
        }

        temp = reverseLinkedList(temp);             //O(N)

        if(carry == 1){
            Node newNode = new Node(carry);
            newNode.next = temp;
            temp = newNode;
        }
        return temp;
    }



    //The Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(N)   Because you are storing the values in recursive stack space.
    static Node optimalApproach(Node head){

        int carry = helper(head);

        if(carry ==1){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
            return newNode;
        }

        return head;
    }

    //Helper Funtion to find the last carry
    static int helper(Node head){

        Node temp = head;
        if(temp == null){
            return 1;
        }

        int carry = helper(temp.next);
        temp.data = temp.data + carry;

        if(temp.data < 10){
            return 0;
        }
        
        temp.data = 0;
        return 1;
    }



    public static void main(String[] args) {
        int[] array = {9, 9, 9};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        Node new_Head = brueteForce(newHead);
        System.out.println("The new LL : ");
        printLinkedList(new_Head);


        //The Optimal Approach
        Node opti_Head = optimalApproach(newHead);
        System.out.println("The new LinkedList : ");
        printLinkedList(opti_Head);
    }
}
