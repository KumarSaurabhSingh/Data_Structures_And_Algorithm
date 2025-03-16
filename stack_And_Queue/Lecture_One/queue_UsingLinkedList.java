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

public class queue_UsingLinkedList { //All Operations - Time Complexity - O(1)

    static Node start = null;
    static Node end = null;
    static int size = 0;

    static void push(int num){
        Node temp = new Node(num, null);
        if(end == null){
            start = end = temp;
        }
        else{
            end.next = temp;
            end = temp;  // Update the end pointer
        }
        size++;
    }

    static void pop(){
        if(start == null){
            System.out.println("No element to pop()");
        }
        else{
            Node temp = start.next;
            start= start.next;
            start = temp;
            if (start == null) {  // If queue becomes empty, reset end
                end = null;
            }
        }
        size--;
    }

    static int length(){
        return size;
    }
    

    static int top(){
        if(start == null){
            System.out.print("No data to print!!  ");
            return -1;
        }
        return start.data;
    }

    

    public static void main(String[] args) {
        
        push(1);
        push(3);
        push(9);
        push(8);
        printLinkedList(start);
        System.out.println("Stack size : "+length());
        System.out.println("Top element : "+top());
        pop();
        System.out.println("Stack size : "+length());
        System.out.println("Top element : "+top());
        printLinkedList(start);
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
}
