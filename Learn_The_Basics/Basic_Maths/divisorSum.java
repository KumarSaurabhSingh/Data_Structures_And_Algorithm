import java.util.Scanner;

public class divisorSum {
    
    static int divisorSum(int N){
    
                int sum = 0;
        
                // Loop over all divisors
                for (int d = 1; d <= N; d++) {
                    // Count of multiples of d
                    int multiples = N / d;
                    // Add contribution of divisor d
                    sum += d * multiples;
                }
        
        
            
        
        return sum;
    }

    public static void main(String[] args){

        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        System.out.println(divisorSum(N));
    }
}
