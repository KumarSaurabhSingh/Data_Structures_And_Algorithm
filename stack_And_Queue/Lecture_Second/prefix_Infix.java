import java.util.Scanner;
import java.util.Stack;

public class prefix_Infix {

    //Time Complexity - O(N)  but in worst scenario O(N) + O(N) - O(N) in summing two string
    //Space Complexity - O(N)
    static String prefix_Infix(String exp){

        Stack<String> stack = new Stack<>();

        // Traverse the prefix expression from right to left
        for(int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            
            // If the character is an operand (letter or digit), push it to the stack
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }

            else{
                if(stack.size() <2){
                    return "INVALID EXPRESSION";
                }

                String top1 = stack.pop();
                String top2 = stack.pop();

                String expression = "(" + top1 + ch + top2 + ")";
                stack.push(expression);
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

        String ans = prefix_Infix(value);
        System.out.println(ans);
    }
}
