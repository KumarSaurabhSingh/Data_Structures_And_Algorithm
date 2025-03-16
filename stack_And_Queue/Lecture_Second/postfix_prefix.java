import java.util.Scanner;
import java.util.Stack;

public class postfix_prefix {

    //Time Complexity - O(N)  but in worst scenario O(N) + O(N) - O(N) in summing two string 
    //Space Complexity - O(N)
    static String postfix_prefix(String exp){

        Stack<String> stack = new Stack<>();

        for(int i=0; i<exp.length(); i++){

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

                String expression = ch + top2 + top1;
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

        String ans = postfix_prefix(value);
        System.out.println(ans);
    }
}
