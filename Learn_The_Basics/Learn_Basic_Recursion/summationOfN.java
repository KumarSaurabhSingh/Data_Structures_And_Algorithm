import java.util.Scanner;

public class summationOfN {
    
    static int summationOfN(int N){

        //Non-parameterized recursion
        if(N==0){
            return 0;
        }

        return (N+summationOfN(N-1));
    }

    public static void main(String[] args){
        int N;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        int result = summationOfN(N);
        System.out.println(result);
        
    }
}
