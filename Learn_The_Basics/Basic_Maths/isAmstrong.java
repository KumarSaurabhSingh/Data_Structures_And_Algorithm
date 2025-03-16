import java.util.Scanner;

public class isAmstrong {
    
    static boolean isAmstrong(int N){

        int ast =0;
        int i=0;
        int org =N;
        
        while (N!=0){
            
            int lst =0;
            lst = N%10;

            ast = ast + (lst*lst*lst);

            N=N/10;
        }

        if(ast == org) return true;
        
        else return false;
        
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        System.out.println(isAmstrong(N));

    }
}
