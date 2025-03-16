import java.util.Scanner;

public class swapTwoNumbers {

    static void swapTwoNumbers(int num1, int num2){

        int num1_new = num1 ^ num2 ^ num1;
        num2 = num1 ^ num2 ^ num2;

        System.out.println("Updated Num1 : "+ num1_new);
        System.out.println("Updated Num2 : "+ num2);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        //Swapping Two Numbers without using theird Variable
        swapTwoNumbers(num1, num2);
    }
}
