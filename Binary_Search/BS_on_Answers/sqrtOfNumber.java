import java.util.Scanner;

public class sqrtOfNumber {
    
    static int brueteForce(int num){
        int ans = 0;

        for(int i=1; i<num; i++){

            if(i * i <= num){
                ans = i;
            }

            else{
                break;
            }
        }

        return ans;
    }

    //The Optimal Approach
    static int optimalApproach(int num){
        int ans =0;
        int low = 1;
        int high = num;

        while(low <= high){

            int  mid = (low + high)/2;

            if(mid * mid <= num){
                ans = mid;
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        //Bruete Force Approach
        int res = brueteForce(num);
        System.out.println("The floor SQRT is : " + res);

        //The Optimal Approach
        int responce = optimalApproach(num);
        System.out.println("The floor SQRT(OPT) is : "+responce);
    }
}
