import java.util.Scanner;
import java.util.Stack;

public class postfix_infix {
    
    //Time Complexity - O(N)  but in worst scenario O(N) + O(N) - O(N) in summing two string 
    //Space Complexity - O(N)
    static String postfix_infix(String exp){

        Stack<String> stack = new Stack<>();

        for(int i=0; i<exp.length(); i++){

            char ch = exp.charAt(i);
            // If the character is an operand (a-z or A-Z), push it onto the stack
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }

            else{
                if(stack.size() <2){
                    return "INVALID EXPRESSION";
                }

                String top1 =stack.pop();
                String top2 = stack.pop();

                String concate = "(" + top1 + ch + top2 + ")";
                stack.push(concate);
            }
        }

        // If there's more than one element left in stack, input was invalid
        if (stack.size() != 1) {
            return "Invalid Expression";
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();

        String ans = postfix_infix(value);
        System.out.println(ans);
    }
}
