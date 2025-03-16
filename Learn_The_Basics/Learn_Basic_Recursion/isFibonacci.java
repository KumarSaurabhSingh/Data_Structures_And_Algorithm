import java.util.Scanner;

public class isFibonacci {

    static int imFibonacci(int num){

        if(num<=1){
        return num;
        }

        int last = imFibonacci(num-1);
        int sLast = imFibonacci(num-2);

        return last + sLast;

    }
    
    public static void main(String[] args){

        int num;
        Scanner input = new Scanner(System.in);
        num = input.nextInt();

        int output = imFibonacci(num);
        System.out.println(output);


    }
}
