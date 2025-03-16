import java.util.Stack;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//Time Complexity - O(1)
//Space Complexity - O(2 X N)
class stack{
    
    static Stack<Pair> st = new Stack<>();

    //Minimum of Stack
    public  int min(){
        return st.peek().y;
    }

    //Pop item from the stack
    public static void pop(){
        if(st.isEmpty()){
            return;
        }
        st.pop();
    }

    //Top element of the Stack
    public static Pair top(){
        return st.peek();
    }

    public static void push(int num){
        int min;
        if(st.isEmpty()){
            min = num;
        }
        else{
            min = Math.min(num, st.peek().y);
        }

        st.push(new Pair(num, min));
    }
}

public class minStack {

    public static void main(String[] args) {
        stack st = new stack();
        st.push(10);
        st.push(2);
        st.push(12);
        st.push(99);
        st.push(1);
        System.out.println("Top Element : "+st.top().x);
        System.out.println("Min Value : "+st.min());
        st.pop();;
        System.out.println("Top Element : "+st.top().x);
    }
}
