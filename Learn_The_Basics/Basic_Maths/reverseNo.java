import java.util.Scanner;

    public class reverseNo {
        
        static int reverseNo(int n){

            int rev=0;

            while(n!=0){

                int digit = n%10;

                if(rev > Integer.MAX_VALUE /10 || (rev == Integer.MAX_VALUE/10 && digit>7)){
                    System.out.println("Overflow Case -1 ");
                    return 0;

                }

                if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && digit<-8)){
                    System.out.println("Underflow Case - 2");
                    return 0;
                }

                rev = rev*10 + digit;
                n/=10;

            }
            return rev;


        }

    

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        if(!input.hasNextInt()){
            System.out.println("Please enter a valid no.");
            return;
        }
        int n = input.nextInt();
        int output = reverseNo(n);
        System.out.println("reversed no. " + output);

    }

}

