import java.util.Scanner;
import java.util.Stack;


//Time Complexity: O(N)
//Space Complexity: O(N) for using the stack
public class infix_Postfix {


    // A utility function to return
  // precedence of a given operator
  // Higher returned value means
  // higher precedence
    static int prec(char c){
        switch(c){

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':  // Exponentiation (right-associative)
                return 3;
        }

        return -1;
    }



    static String infix_Postfix(String value){

        Stack<Character> stack = new Stack<>();
        // initializing empty String for result
        String result = new String("");

        for(int i =0; i<value.length(); i++){
            char ch = value.charAt(i); //checking the value at ith index

            if(Character.isLetterOrDigit(ch)){
                result = result +ch;
            }

            // If the scanned character is an '(',
            // push it to the stack.
            else if(ch =='('){
                stack.push(ch);
            }

            else if(ch ==')'){

                while(!stack.isEmpty() && stack.peek() != '('){
                    result = result + stack.pop();
                }
                stack.pop();
            }

            else{ // an operator is encountered
                while(!stack.isEmpty() && prec(ch) <= prec(stack.peek())){
                    result = result + stack.pop();
                }
                stack.push(ch);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();

        String ans = infix_Postfix(value);
        System.out.println(ans);
    }
}
