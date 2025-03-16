import java.util.Scanner;

public class print1ToN {
    
    static void printNos(int N) {

        if(N <1){
            return;
        }
        
        printNos(N-1);

        System.out.print(N + " ");
        // //count = count +1;
    }

    public static void main(String[] args){

        int number;
        int iterator =1;
        Scanner input = new Scanner(System.in);
        number = input.nextInt();

        printNos(number);
    }
}
