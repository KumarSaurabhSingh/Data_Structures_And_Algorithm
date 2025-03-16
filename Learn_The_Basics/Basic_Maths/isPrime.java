import java.util.Scanner;

public class isPrime {

    static void isPrime(int N){

        int count =0;
        int i=1;
        while (i*i <= N)
        {
            if (N%i ==0){
                count ++;
            }

        i++;
        }

        if(count >1) System.out.println(N + " : is not a prime");

        else System.out.println(N+ " : is a prime");

    }

    public static void main(String[] args){

        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        isPrime(N);

    }
    
}
