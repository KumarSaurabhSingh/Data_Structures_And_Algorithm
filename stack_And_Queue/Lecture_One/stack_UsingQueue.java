import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class stack_UsingQueue {
    static Queue<Integer> q = new LinkedList<>();


    //Pusing Elements in Stack
    //Time Complexity - O(N)
    static void push(int num){
        int size = q.size();
        q.add(num);
        
        // Rotate the queue to put the new element at the front
        for (int i = 0; i < size; i++) {
            q.add(q.poll());
        }
    }

    //Poping elements from the Stack
    //Time Complexity - O(1)
    static void pop(){
        q.poll();
    }

    //Top Elements in the Stack
    //Time Complexity - O(1)
    static int top(){
        return q.peek();
    }


    public static void main(String[] args) {
        push(1);
        push(3);
        push(9);
        push(8);
        System.out.println(q);
        //System.out.println("Stack size : "+length());
        System.out.println("Top element : "+top());
        pop();
        //System.out.println("Stack size : "+length());
        System.out.println("Top element : "+top());
        System.out.println(q);
    }
}
