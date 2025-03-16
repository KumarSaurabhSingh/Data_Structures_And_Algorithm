import java.util.Scanner;

public class sumOfNumbers {
    
    static void sumOfNumbers(int N, int sum){

        //Parameterize recursion

        if(N<1){
            System.out.println(sum);
            return;
        }

        sumOfNumbers(N-1, sum+N);

    }

    public static void main(String[] args){

        int N;
        int sum=0;
        Scanner input = new Scanner(System.in);
        N= input.nextInt();

        sumOfNumbers(N, sum);

    }
}
