class node{

    int data;
    node next;

    //Constructor
    node(int data1, node next){
        this.data = data1;
        this.next = next;
    }

    node(int data1){
        this.data = data1;
        this.next = null;
    }
}



public class linkedList {

    private static node convertToLinkedlist(int[] array){

        node head = new node(array[0]); //Storing the arr[0] as head of LL
        node mover = head; //Stroing the first element as head

        for(int i=1; i<array.length; i++){

            node temp = new node(array[i]); //creating temp variable to store the next element address
            mover.next= temp; // Storing the address of next value
            mover = temp; //Now updating the mover with next value.
        }

        return head;
    }

    //Length of the LinkedList
    private static int lengthLiskedList(node head){
        int cnt=0;
        node temp = head;

        while(temp!= null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }


    
    public static void main(String[] args) {
        int[] array = {12, 2, 3, 4};
        node  head = convertToLinkedlist(array);
        System.out.println("Head Value will be : "+ head.data);

        //Traversing in Linked List
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        //Size of the Linked List
        int sizeOfLinkedList = lengthLiskedList(head);
        System.out.println("Length of Linked List: "+ sizeOfLinkedList);
    }
}
