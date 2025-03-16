import java.util.Scanner;
import java.util.Stack;

public class prefix_postfix {
    
    //Time Complexity - O(N)  but in worst scenario O(N) + O(N) - O(N) in summing two string 
    //Space Complexity - O(N)
    static String prefix_postfix(String exp){

        Stack<String> stack = new Stack<>();

        for(int i=exp.length()-1; i>=0; i--){

            char ch = exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }

            else{
                if (stack.size() < 2) {
                    return "Invalid Expression";
                }

                String top1 = stack.pop();
                String top2 = stack.pop();

                // Correct postfix order: operand1 operand2 operator
                String expression = top1 + top2 + ch;
                stack.push(expression);
            }
        }

        if(stack.size() != 1){
            return "INVALID EXPRESSION";
        }

        return stack.peek();
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        input.close();

        String ans = prefix_postfix(value);
        System.out.println(ans);
    }
}
