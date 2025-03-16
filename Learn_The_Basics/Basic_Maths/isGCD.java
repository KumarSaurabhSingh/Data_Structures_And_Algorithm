import java.lang.Integer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class isGCD {

    public static int isGCD(int N1, int N2){

        int min;
        if(N1 >N2) min = N2;
        else min = N1;

        int i=1;
        int gcd =1;
        while (i<= min){
            if(N1%i==0 && N2%i==0){
                gcd = i;
            }

            i++;
        }
        // System.out.println(gcd);
                return gcd;

    }


    static int isLCM(int N1, int N2){
    {
        int greater = Math.max(N1, N2);
        int smallest = Math.min(N1, N2);
        for (int i = greater;; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }
    }

    public static int checkLCM(int N1, int N2){
        //int yesLCM = 1;
        int mul = N1*N2;
        return mul/isGCD(N1,N2);
    }

    static int[] resulting(int N1, int N2){
        int ans[] = {isGCD(N1, N2), checkLCM(N1, N2)};
        return ans;
    }

    static ArrayList<Integer> checkLCM_GCD(int N1, int N2){

        int output = isLCM(N1, N2);
        int output2 = isGCD(N1, N2);
        ArrayList<Integer> result = new ArrayList<>();

        result.add(output);
        result.add(output2);
        return result;
    }

    public static void main(String[] args){
        int N1, N2;
        Scanner input = new Scanner(System.in);
        N1 = input.nextInt();
        N2 = input.nextInt();

        //System.out.println(checkLCM_GCD(N1, N2));

        int out[] = resulting(N1, N2);
        
        for(int i=0; i<2; i++){
            System.out.print(out[i]);
        }
        // for (Integer element : result){
        //     System.out.print(element + " ");
        // }
    }
    
}
