import java.util.Scanner;

public class printN_Times {
    
    static void printN_Times(int N, int i){
        if(i>N){
            System.out.println("Returned");
            return;
        }

        System.out.println(i);
        //count = count +1;

        printN_Times(N, i+1);

    }

    static int sumOfSeries(int n) {
        int mul =1;
        if(n==0){
            return 0;
        }
        mul = n*n*n;
        sumOfSeries(mul);
        return (mul + sumOfSeries(n-1));
        // code here
    }


    public static void main(String[] args){
        int number;
        int iterator =1;
        Scanner input = new Scanner(System.in);
        number = input.nextInt();

        //printN_Times(number, iterator);

        int result = sumOfSeries(number);
        sumOfSeries(result);
    }
}
