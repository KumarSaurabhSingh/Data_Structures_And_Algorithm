import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//Time Complexity: O(1 )
//Space Complexity: O(2N)
public class queue_UsingStack {

    static Stack<Integer> input = new Stack<>();
    static Stack<Integer> ouput = new Stack<>();

    //Adding elements in Queue
    static void push(int num){
        input.add(num);
    }

    //Poping elements from the Queue
    static int pop(){

        //If the ouput is empty
        if(ouput.empty()){
            while(!input.empty()){
                ouput.push(input.peek());
                input.pop();
            }
        }
        int x = ouput.peek();
        ouput.pop();
        return x;
    }

    /** Get the front element. */
    static  int peek() {
        // shift input to output
        if (ouput.empty())
            while (input.empty() == false) {
                ouput.push(input.peek());
                input.pop();
            }
        return ouput.peek();
    }
    int size() {
        return (ouput.size() + input.size());
    }
    
    public static void main(String[] args) {
        push(1);
        push(3);
        push(9);
        push(8);
        //System.out.println("Stack size : "+length());
        System.out.println("Top element : "+peek());
        pop();
        //System.out.println("Stack size : "+length());
        System.out.println("Top element : "+peek());

        //Printing the Queeu in Stack template
        Iterator it = ouput.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
            
        }
    }
}
