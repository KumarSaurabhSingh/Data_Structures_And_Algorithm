//Print name N times using recursion
//Time Complexity -> O(n)

import java.util.Scanner;

public class nTimesName {
    static int count =1;

    static void nTimesName(int N, int i){

        if(i>N){
            System.out.println("Returned");
            return;
        }

        System.out.println("Saurabh");
        //count = count +1;

        nTimesName(N, i+1);


    }
    
    public static void main(String[] args){

        int number;
        int iterator =1;
        Scanner input = new Scanner(System.in);
        number = input.nextInt();

        nTimesName(number, iterator);

    }
}
