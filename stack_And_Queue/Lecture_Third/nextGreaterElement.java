import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElement {

    //Time Complexity - O(N^2
    //Space Complexity - O(N)
    static int[] brueteForce(int[] arr){
        int[] arrAns = new int[arr.length];

        for(int i =0; i<arr.length; i++){

            for(int j=i+1; j<arr.length; j++){
                if(arr[j] > arr[i]){
                    arrAns[i] = arr[j];
                    break;
                }

                if(j == arr.length-1 || arr[j] <= arr[i]){
                    arrAns[i] = -1;
                }
            }
            if(i== arr.length-1){
                arrAns[i] = -1;
            }
        }
        return arrAns;
    }

    //Optimal Approach - Using Stack
    //Time Complexity: O(2N) - At the worst case
    //Space Complexity: O(N)
    static int[] OptimalApproach(int[] arr){

        int nge[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int size = arr.length;

        for(int i =size-1; i>=0; i--){

            while (stack.isEmpty() == false && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (i < size) {
                if (stack.isEmpty() == false) nge[i] = stack.peek();

                else nge[i] = -1;
            }

            stack.push(arr[i]);
        }

        return nge;
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

        int[] ans2 = OptimalApproach(arr);
        System.out.println("Optimal Approach : ");
        for(int i=0; i<size; i++){
            System.out.print(ans2[i] + " ");
        }
    }
}
