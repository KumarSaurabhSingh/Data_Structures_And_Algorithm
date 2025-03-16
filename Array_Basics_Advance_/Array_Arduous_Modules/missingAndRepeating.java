import java.util.Scanner;

public class missingAndRepeating {

    //The Bruete Force Approach
    //Time Complexity: O(N2), where N = size of the given array.
    //Space Complexity: O(1) as we are not using any extra space.
    static void brueteForce(int[] array, int num){

        int n =array.length;
        int reapeating = -1;
        int missing = -1;

        for(int i=0; i<=num; i++){
        int count =0;
            for(int j=0; j<n; j++){

                if(array[j] == i){
                    count++;
                }
            }

            if(count == 2){
                reapeating =i;
            }

            else if(count ==0){
                missing =i;
            }
        }

        System.out.println(" Repeating No. : " +reapeating + "  Missing No. : "+missing);
    }
    


    //The Better Approach
    static void betterApproach(int[] array, int num){

        int n = array.length;
        int[] hash = new int[n+1];

        int missing =-1;
        int reapeating = -1;

        for(int i=0; i<num; i++){

            hash[array[i]] ++;
        }

        for(int i=1; i<hash.length; i++){
            if(hash[i] ==0){
                missing=i;
            }

            else if(hash[i] ==2){
                reapeating =i;
            }
        }

        if(reapeating ==-1 && missing ==-1){
            System.out.println("NO MISSING AND REPEATING ELEMENT");
        }

        
        System.err.println("Missing Element is :  "+ missing + "  Repeating ELement is : " + reapeating);
    }


    //The First Optimal Approach
    //Time Complexity: O(N), where N = the size of the given array.
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    static void firstOptimal(int[] array, int num){

        long n = array.length;

        long sn = (n * (n+1))/2;
        long s2n = (n * (2*n +1) * (n + 1))/6;

        long sn_array =0;
        long s2n_array =0;
        for(int i=0; i< n; i++){
            sn_array += array[i];
            s2n_array += (long)array[i] * (long)array[i];
        }

        long val1 = sn_array - sn;
        long val2 = s2n_array - s2n;

        val2 = val2 / val1;

        long x = (val1 + val2) /2;
        long y = x - val1;

        System.out.println("Repeated Element :  "+(int)x);
        System.out.println("Missing Elment : "+(int)y);
    }

    //The Most Optimal Approach Using Bit Manipulation
    //Time Complexity: O(N), where N = the size of the given array.
    //Space Complexity: O(1) as we are not using any extra space to solve this problem.
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length; // size of the array
        int xr = 0;

        //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: Find the differentiating bit number:
        int number = (xr & ~(xr - 1));

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }

    public static void main(String[] args){

        //Array Input
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for the number of the array
        int num = input.nextInt();

        //The BrueteForce Approach
        //brueteForce(array, num);

        //The Better Approach
        //betterApproach(array, num);

        //First Optimal Approach
        firstOptimal(array, num);
    }





    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
