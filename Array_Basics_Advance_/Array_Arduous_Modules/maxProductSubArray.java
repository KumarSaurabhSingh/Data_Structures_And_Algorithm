import java.util.Scanner;

public class maxProductSubArray {

    //The Bruete Force Approach
    //Time Complexity - O(N ^ 3)
    //Space Complexity - O(1)
    static void brueteForce(int[] array){

        int maxi = Integer.MIN_VALUE;
        int n = array.length;


        for(int i=0; i<n-1; i++){

            for(int j=0; j<n; j++){
                int prod = 1;

                for(int k=i+1; k<=j; k++){

                    prod *= array[k];
                    //System.out.println(prod);
                }
                maxi = Math.max(maxi, prod);
            }
        }

        System.out.println("Maximum Product (Bruete):  "+maxi);
    }
    

    //The Better Approach
    //Time Complexity: O(N2)
    //Space Complexity: O(1)
    static void betterApproach(int[] array){

        int maxi = Integer.MIN_VALUE;
        int n = array.length;


        for(int i=0; i<n-1; i++){

            int prod = 1;
            for(int j=i; j<n; j++){
                prod *= array[j];
                //System.out.println(prod);
                maxi = Math.max(maxi, prod);
            }
        }

        System.out.println("Maximum Product (Better):  "+maxi);
    }


    //The First Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static void firstOptimal(int[] array){
        int n = array.length;
        int maxi = Integer.MIN_VALUE;

        int pre = 1;
        int suf = 1;

        for(int i=0; i<n; i++){

            if(pre ==0 && suf ==0){
                pre =1;
                suf =1;
            }

            pre = pre * array[i];
            suf = suf * array[n-i-1];

            maxi = Math.max(maxi, Math.max(pre, suf));
        }

        System.out.println("Maximum Product (Optimal): "+ maxi);
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The BrueteForce Approach
        brueteForce(array);

        //The Better Approach
        betterApproach(array);

        //The First Optimal Approach
        firstOptimal(array);
    }
}
