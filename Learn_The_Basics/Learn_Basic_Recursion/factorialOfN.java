import java.util.Scanner;

public class factorialOfN {
    
    static int factorialOfN(int N){
        if(N==1){
            return 1;
        }
        return (N * factorialOfN(N-1));
    }


    public static void main(String[] args){
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        int result = factorialOfN(N);
        System.out.println(result);
    }
}
