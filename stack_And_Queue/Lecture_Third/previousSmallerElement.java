import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class previousSmallerElement {
    
    //Time Complexity - O(N^2)
    //Space Complexity - O(N)
    static int[] brueteForce(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            if(i==0){
                ans[i] = -1;
                //break;
            }

            else{
                for(int j=0; j<i; j++){
                    if(arr[i] > arr[j]){
                        min = Math.min(min, arr[j]);
                        break;
                    }
                    else if(j == i-1){
                        min =-1;
                    }
                }
                ans[i] = min;
            }
        }
        return ans;
    }


    //Optimal Approach
    //Time Complexity - O(2N)
    //Space Complexity - O(N)
    static int[] OptimalApproach(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){

            while(stack.empty() == false && stack.peek()> arr[i]){
                stack.pop();
            }

            if(i<n){
                if(stack.empty() == false && stack.peek() < arr[i]){
                    ans[i] = stack.peek();
                }
                else{
                    ans[i] = -1;
                }
            }
            stack.push(arr[i]);
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

        int[] ans2 = OptimalApproach(arr);
        System.out.println("Optimal Approach : ");
        for(int i=0; i<size; i++){
            System.out.print(ans2[i] + " ");
        }
    }
}
