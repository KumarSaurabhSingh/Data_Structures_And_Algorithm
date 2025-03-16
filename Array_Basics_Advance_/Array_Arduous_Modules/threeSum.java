import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class threeSum {

    //The bruete Force Approach
    //Time Complexity - O(N^3) -- Not impressive for the interviewer
    //Space Complexity - O( 2 * No. of unique triplets)
    static List<List<Integer>> brueteForce(int[] array){
        int n = array.length;

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){

                for(int k=j+1; k<n; k++){

                    if(array[i] +array[j] + array[k] ==0){
                        List<Integer> temp = Arrays.asList(array[i], array[j], array[k]);

                        //Sorting the list to avvoid duplications
                        temp.sort(null); //This sorting won't take much just constant time complexity
                        set.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;

        //System.out.println(set);
    }


    //The Better Approach
    //Time Complexity - O(N^2)
    //Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
    static void betterApproach(int[] array){
        int n = array.length;

        Set<List<Integer>> res = new HashSet<>();

        Set<Integer> freq = new HashSet<>();
        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){

                int rem = -(array[i] + array[j]);

                if(freq.contains(rem)){

                    List<Integer> temp = Arrays.asList(array[i], array[j], rem);

                    temp.sort(null);
                    //System.out.println(temp);
                    res.add(temp);
                }

                else{
                    freq.add(array[i]);
                }

            }
            
        }

        System.out.println(res);
    }

    /*
     * Time Complexity: O(NlogN)+O(N2), where N = size of the array.
    Reason: The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 

    Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).
     */

    static List<List<Integer>> optimalApproach(int[] array){

        int n = array.length;

        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(array);

        for(int i=0; i<n-1; i++){

            //remove duplicates:
            if (i != 0 && array[i] == array[i - 1]) continue;

            int end =n-1;
            int start = i+1;


            while(start < end){

                if(array[i] + array[start] + array[end] == 0){
                    List<Integer> temp = Arrays.asList(array[i], array[start], array[end]);
    
                    temp.sort(null);
                    res.add(temp);
                    start++;
                    end--;
                }
    
                else if(array[i] + array[start] + array[end] < 0){
                    start++;
                }
    
                else if(array[i] + array[start] + array[end] > 0){
                    end--;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(res);

       // System.out.println(" Before " +ans);
        
        return ans;
    }


    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Bruete Force Approach
        // List<List<Integer>> res = new ArrayList<>();
        // res = brueteForce(array);

        // for(List<Integer> it : res){

        //     System.out.print("[");
        //     for(Integer i : it){
        //         System.out.print(i + " ");
        //     }
        //     System.out.println("]");
        // }


        //The Better Approach
        //betterApproach(array);

        //The Optimal Approach

        List<List<Integer>> output = new ArrayList<>();

        output = optimalApproach(array);

        for(List<Integer> it : output){

            System.out.print("[");
            for(Integer i : it){
                System.out.print(i + " ");
            }

            System.out.println("]");
        }
    }
}
