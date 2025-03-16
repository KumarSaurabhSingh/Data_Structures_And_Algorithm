/* Question from Leetcode
 * https://leetcode.com/problems/palindrome-number/submissions/1474937936/
 */


import java.util.Scanner;

public class isPalindrome {

    static boolean isPalindrome(int N){

        int org = N;
        int rev =0;

        if(N<0) return false;

        while (N>0){

            int digit = N%10;

            if(rev > Integer.MAX_VALUE / 10 || ( rev == Integer.MAX_VALUE/10 && digit>7)){
                return false; //Overflow
            }
            if(rev < Integer.MIN_VALUE/ 10 || (rev == Integer.MIN_VALUE/10 && digit<-8)){
                return false; //Underflow
            }

            rev = rev*10 +digit;
            N/=10;

        }

        if(rev == org) return true;
        
        else return false;

    }

    public static void main(String[] args){

        int N;
        Scanner input = new Scanner(System.in);
       
        if(!input.hasNextInt()){
            System.out.println("Please enetr a valid no. ");
            return;
        }
        N = input.nextInt();
        System.out.println(isPalindrome(N));


    }
    
}
