import java.util.Scanner;

public class checkPalindrome {

    static String checkAlphaNumeric(String str){

        StringBuilder result = new StringBuilder(); // To build the resulting string efficiently
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Check if the character is alphanumeric
            if (Character.isLetterOrDigit(c)) {
                result.append(Character.toLowerCase(c)); // Add alphanumeric character to the result
            }
        }
        return result.toString(); // Return the final string
    }



    static boolean checkPalindrome(int start,String str){

        int length = str.length();
        if(start >= str.length()/2){
            return true;
        }

        if(str.charAt(start) != str.charAt(length-1-start)){
            return false;
        }

        return checkPalindrome(start+1, str);
    }
    
    public static void main(String[] args){

        String str;
        Scanner input = new Scanner(System.in);
        str = input.nextLine();

        String res = checkAlphaNumeric(str);
        System.out.println(res);

        boolean result = checkPalindrome(0, res);
        System.out.println(result);

    }
}