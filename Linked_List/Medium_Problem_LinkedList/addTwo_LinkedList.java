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
public class addTwo_LinkedList {
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



    //Addting two Linked list having numbers in reverse order
    //Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
    //Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1.
    static Node addTwoLinkedList(Node head1, Node head2){

        Node temp1 = head1;
        Node temp2 = head2;

        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        int carry =0;

        while(temp1 != null || temp2 != null){
            int sum =0;
            if(temp1 != null){
                sum = sum+ temp1.data;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                sum = sum+temp2.data;
                temp2 = temp2.next;
            }

            Node newNode = new Node(sum %10);
            carry = sum/10;

            curr.next = newNode;
            curr = curr.next;

        }

        if(carry != 0){
            Node newNode =new Node(carry);
            curr.next = newNode;
        }

        return dummyNode.next;
    }



    public static void main(String[] args) {
        int[] array = {1, 8, 3};
        int[] array2 = {9, 2, 4};

        Node head = new Node(array[0]);
        Node head2 = new Node(array2[0]);

        //Converting the Array to Linked List
        Node newHead = convertToLinkedlist(array);
        Node newHead2 = convertToLinkedlist(array2);

        //Addtion of two node
        Node add = addTwoLinkedList(newHead, newHead2);
        System.out.println("The summation will be : ");
        printLinkedList(add);
    }
}
