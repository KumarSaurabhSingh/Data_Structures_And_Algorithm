import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

public class mergeOverlaping {

    //The Bruete Force Approach
    static List<List<Integer>> brueteForce(int[][] array){

        int n = array.length;

        //sort the given intervals:
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        //Creating a List to Store the answers
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){

            int start = array[i][0];
            int end = array[i][1];

            //Skipping all of the Merged Elements
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){ //Checking whether the last element's second value is greater than or not
                continue;
            }

            //check the rest of the intervals:
            for(int j=i+1; j<n; j++){

                if(array[j][0] <= end){
                    end = Math.max(end, array[j][1]);
                }

                else{
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }
    

    //The Optimal Approach
    //Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
    //Space Complexity: O(N), as we are using an answer list to store the merged intervals.
    static List<List<Integer>> optimalApproach(int[][] array){

        int n = array.length;
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
            
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){

            if(ans.isEmpty() || array[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(array[i][0], array[i][1]));
            }

            else{
                ans.get(ans.size() -1).set(1, Math.max(ans.get(ans.size()-1).get(1), array[i][1]));
                
                //ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), array[i][1]));
            }
        }

        return ans;
    }

    public static void main(String[] args){

        // Scanner input = new Scanner(System.in);
        // int arraySize = input.nextInt();

        // int[] array = new int[arraySize];

        // for(int i=0; i<arraySize; i++){
        //     for()
        //     array[i] = input.nextInt();
        // }

        // //The Bruete Force Approach
        // brueteForce(array);

        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

        //The Bruete Force Approach
        //List<List<Integer>> ans = brueteForce(arr);


        //The Optimal Approach
        List<List<Integer>> ans = optimalApproach(arr);


        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }

}
