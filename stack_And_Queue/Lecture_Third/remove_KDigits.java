import java.util.Scanner;
import java.util.Stack;

public class remove_KDigits {

    //Time Complexity :- O(3N) + O(K)
    //Space Complexity :- O(N) + O(N)
    static String remove_K(String str, int k){

        int n = str.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){

            while(!stack.empty() && (stack.peek() - '0')>(str.charAt(i) - '0') && k>0){
                stack.pop();
                k--;
            }
            stack.push(str.charAt(i));
        }

        //if there is still elements left
        while(k != 0){
            stack.pop();
            k--;
        }

        if(stack.empty()){
            return "0";
        }

        //Build result String
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        result.reverse(); //reverse the result string

        //Removing the Leading Zeros
        while(result.length() != 0 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }

        return result.length()==0 ? "0" : result.toString();
    }
    


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        //Input for K
        int k = input.nextInt();

        //Removing K elements from the String
        System.out.println("Trimmed String: "+remove_K(str,k));
    }
}
