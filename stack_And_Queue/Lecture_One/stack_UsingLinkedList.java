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

public class stack_UsingLinkedList {  //For every single element the time complexity will be O(1)

    static Node top = null; //Creating a top
    static int size =0;

    static void push(int num ){
        Node temp = new Node(num);
        temp.next = top;
        top = temp;
        size++;
    }

    static void pop(){
        Node temp = top.next;
        top.next = null;
        top = temp;
        size--;
    }

    static Node top(){
        return top;
    }

    static int length(){
        return size;
    }
    public static void main(String[] args) {
        
        push(1);
        push(3);
        push(9);
        push(8);
        System.out.println("Stack size : "+length());
        System.out.println("Top element : "+top.data);
        pop();
        System.out.println("Stack size : "+length());
        System.out.println("Top element : "+top.data);
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
