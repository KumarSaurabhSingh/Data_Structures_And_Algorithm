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

public class sort_LinkedList {
    
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
    //Time Complexity - O(2N)
    //Space Complexity - O(1)
    static Node brueteForce(Node head){

        if(head == null){
            return null;
        }

        int cnt0 =0;
        int cnt1 =0;
        int cnt2 =0;

        Node temp = head;

        while(temp != null){

            if(temp.data ==0) cnt0++;
            else if(temp.data ==1) cnt1++;
            else cnt2++;

            temp = temp.next;
        }

        temp = head;

        while(temp != null){

            if(cnt0 != 0){
                temp.data = 0;
                cnt0--;
            }

            else if( cnt0 ==0 && cnt1 != 0){
                temp.data =1;
                cnt1--;
            }

            else if(cnt1 ==0 && cnt2 != 0){
                temp.data =2;
                cnt2--;
            }

            temp = temp.next;
        }

        return head;
    }


    //The Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static Node optimalApproach(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;


        Node temp = head;

        while(temp != null){

            if(temp.data ==0){
                zeroHead.next = temp;
                zeroHead = zeroHead.next;
            }

            else if(temp.data ==1){
                oneHead.next = temp;
                oneHead = oneHead.next;
            }

            else{
                twoHead.next = temp;
                twoHead = twoHead.next;
            }

            temp = temp.next;
        }
        zeroHead.next = (one.next != null) ? one.next : two.next;
        
        oneHead.next = two;

        two.next = null;

        return zero.next;
    }




    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 0, 2, 2, 1};
        Node head = new Node(array[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);

        //The Bruete Force Approach
        Node bruete_head = brueteForce(newHead);
        System.out.println("The Sorted LL : ");
        printLinkedList(bruete_head);

        //The Optimal Approach
        Node opti_head = brueteForce(newHead);
        System.out.println("The Sorted LL : ");
        printLinkedList(opti_head);
    }
}
