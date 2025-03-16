import java.util.Scanner;
import java.util.Stack;

public class sum_SubArray {

    //The Bruete Force Approach
    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    static int brueteForce(int[] arr){

        int n = arr.length;
        int sum = 0;

        for(int i=0; i<n; i++){

            int min = arr[i];
            for(int j=i; j<n; j++){
                min = Math.min(min, arr[j]);

                sum = sum + min;
            }
        }

        return sum;
    }
    

    public static int optimizedSumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];  // How many subarrays where arr[i] is the minimum on the left
        int[] right = new int[n]; // How many subarrays where arr[i] is the minimum on the right
        Stack<int[]> stack = new Stack<>();

        // Finding the number of subarrays where arr[i] is the minimum on the LEFT
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek()[1];
            stack.push(new int[]{arr[i], i});
        }

        stack.clear();


        // Finding the number of subarrays where arr[i] is the minimum on the RIGHT
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) { // `>=` ensures uniqueness
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek()[1] - i;
            stack.push(new int[]{arr[i], i});
        }

        // Compute the final sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * left[i] * right[i];  // Each element's contribution to the total sum
        }
        return sum;
    }


    // Function to print the stack
    private static void printStack(Stack<int[]> stack) {
        System.out.print("Stack: [");
        for (int[] pair : stack) {
            System.out.print("(" + pair[0] + ", " + pair[1] + ") ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }


        //The Bruete Force
        int brueteAns = brueteForce(arr);
        System.out.println("Summation: "+ brueteAns);


        //The Optimal Approach
        int optiAns = optimizedSumSubarrayMins(arr);
        System.out.println("Sum will be : "+ optiAns);
    }


    static void print(int[] arr){
    
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}


