import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElement2 {

    //Time Complexity - O(N^2)
    //Space Complexity - O(N)
    static int[] brueteForce(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        for(int i =0; i<n; i++){

            for(int j=i+1; j<i+n-1; j++){ //i+n-1 so that we can traverse back to the same element from backward. to form a cirular array
                int index = j%n;

                if(arr[index] > arr[i]){
                    ans[i] = arr[index];
                    break;
                }

                if(j== (i+n-1)-1){
                    ans[i] = -1;
                }
            }
        }

        return ans;
    }


    //Optimal Approach
    //Time Complexity - O(4N)
    //Space Complexity - O(2N)
    static int[] OptimalApproach(int[] arr){

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>(); //Storing O(2N)

        for(int i = 2*n -1; i>=0; i--){ //O(2N) traversing

            while(stack.empty() == false && stack.peek() < arr[i%n]){
                stack.pop();
            }

            if(i<n){
                ans[i] = stack.empty() ? -1 : stack.peek(); //inline statement
            }

            stack.push(arr[i%n]); //O(2N) pushing
        }

        return ans;
    }


    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }

        int[] ans = brueteForce(arr);
        System.out.println("Bruete Force : ");
        for(int i=0; i<size; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();


        int[] ans2 = brueteForce(arr);
        System.out.println("Optimal Approach : ");
        for(int i=0; i<size; i++){
            System.out.print(ans2[i] + " ");
        }
    }
}
