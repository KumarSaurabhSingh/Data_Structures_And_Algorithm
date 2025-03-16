import java.util.Scanner;
import java.util.Stack;


//Time Complexity: O(N)
//Space Complexity: O(N)
public class infix_Prefix {

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

    //Reverse a String
    static String reverse(char[] exp){
        int start =0;
        int end = exp.length-1;

        while(start <= end){
            char temp = exp[start];
            exp[start] = exp[end];
            exp[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(exp);
    }

    //Infix to Postfix
    static String infixToPostfix(String exp) {
        
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i =0; i<exp.length(); i++){

            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            }

            else if(ch == '('){
                stack.push(ch);
            }

            else if(ch == ')'){

                while(!stack.isEmpty() && stack.peek() !='('){
                    res.append(stack.pop());
                }
                stack.pop();
            }

            else{

                while(!stack.isEmpty() && prec(ch) <= prec(stack.peek())){
                    res.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            res.append(stack.pop());
        }
        return res.toString();
    }


    static String infix_Prefix(String exp){

        // Step 1: Reverse the infix expression
        exp = reverse(exp.toCharArray());

        // Step 2: Replace '(' with ')' and vice versa
        char[] expArr = exp.toCharArray();
        for (int i = 0; i < expArr.length; i++) {
            if (expArr[i] == '(') {
                expArr[i] = ')';
            } else if (expArr[i] == ')') {
                expArr[i] = '(';
            }
        }

        //Performing infix to postfix - steps
        String prefix = infixToPostfix(String.valueOf(expArr));

        String exp2 = reverse(prefix.toCharArray());
        return exp2;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String value = input.nextLine();

        String ans = infix_Prefix(value);
        System.out.println(ans);
    }
}
