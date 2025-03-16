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

public class middle_LinkedList {
    
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
    static Node brueteForce(Node head){
        
        Node temp = head;
        int cnt =0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        int len = (cnt/2) +1;
        temp = head;

        while(len != 0){
            if(len == 1) break;
 
            temp = temp.next;
            len--;
        }

        return temp;
    }


    //The Tortoise & Hare Approach
    //The Optimal Approach
    static Node optimalApproach(Node head){

        Node temp = head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        int[] array = {13, 20, 3, 14, 9, 65, 8, 0};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        Node bruete_Head = brueteForce(newHead);
        System.out.print("The Middle is : ");
        System.out.println(bruete_Head.data);

         //The Optimal Force Approach
        Node Opti_Head = optimalApproach(newHead);
        System.out.print("The Middle is : ");
        System.out.println(Opti_Head.data);
    }
}
