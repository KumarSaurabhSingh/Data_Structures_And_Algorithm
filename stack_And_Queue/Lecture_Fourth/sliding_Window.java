import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class sliding_Window {

    //The Bruete Force Approach
    //Time Complexity - O(N - K) x O(K) - On worst case
    //Space Complexity - O(N - K)
    static void BrueteForce(int[] arr, int k){

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        if(k>n){
            System.out.println("INVALID INPUT");
            return;
        }

        for(int i =0; i<n-k+1; i++){

            int max = arr[i];
            int j =i;
            int cnt = k;

            while(cnt>0){
                max = Math.max(max, arr[j]);
                cnt--;
                j++;
            }
            ans.add(max);
        }

        for(Integer i : ans){
            System.out.print(i + " ");
        }
    }



    //The Optimal Approach
    //Time Complexity - O(2N)
    //Space Complexity O(N - K) + O(N)
    static void optimalApproach(int[] arr, int k){

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        //Creating a Dequeue
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){

            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }


            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }

            dq.offer(i);

            if(i >= k-1){
                ans.add(arr[dq.peekFirst()]);
            }
        }

        //Display Answer
        for(Integer i : ans){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i =0; i< size; i++){
            arr[i] = input.nextInt();
        }

        //The Sliding value
        int k = input.nextInt();

        //The Bruete Force Approach
        System.out.print("Bruete Force: ");
        BrueteForce(arr, k);

        System.out.println();
        //The Optimal Approach
        System.out.print("Optimal Approach: ");
        optimalApproach(arr, k);
    }
}
