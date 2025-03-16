import java.util.Scanner;
import java.util.Stack;

public class largestHistogram {

    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    static void brueteForce(int[] arr){

        int n = arr.length;
        int maxArea = 0;

        for(int i =0; i<n; i++){

            int minHight = Integer.MAX_VALUE;

            for(int j=i; j<n; j++){
                minHight = Math.min(minHight, arr[j]);
                maxArea = Math.max(maxArea, minHight * ( j - i + 1 ));
            }

        }
        System.out.println("Maximum Histo Area : "+maxArea);
    }


    //The Better Approach
    //Time Complexity - O(N)
    //Space Complexity - O(3N)
    static void BetterApproach(int[] arr){

        Stack<Integer> stack = new Stack<>(); //Stack will be used to store the index
        int n = arr.length;


        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        //LeftSmall elements Array
        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if(stack.empty()){
                leftSmall[i] = 0;
            }

            else{
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        //Clearing Stack
        stack.clear();

        //RightSmall Elements Array
        for(int i = n-1; i>=0; i--){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if(stack.empty()){
                rightSmall[i] = n-1;
            }
            else{
                rightSmall[i] = stack.peek()-1;
            }
            stack.push(i);
        }


        //Finding the maximum
        int max = 0;
        for(int i =0; i<n; i++){
            max = Math.max(max, (-leftSmall[i] + rightSmall[i] + 1)* arr[i]);
        }

        System.out.println("Histo Max: "+ max);
    }

    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }


        //The Bruete Force Approach
        brueteForce(arr);

        //The Better Approach
        BetterApproach(arr);
    }
}
