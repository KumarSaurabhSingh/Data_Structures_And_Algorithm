import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longestConsecutiveSequence {

    static boolean linearSearch(int[] array, int num){

        for(int i=0; i<array.length; i++){
            if(array[i] == num){
                return true;
            }
        }
        return false;
    }

    //The Bruete Force Approach
    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    static int brueteForce(int[] array){

        int max = 1;

        for(int i=0; i<array.length; i++){

            //int x = array[i];
            int temp =array[i];
            int count =1;
            while(linearSearch(array, temp+1) == true){
                    count ++;
                    temp++;
                    //System.out.println(temp);
            }

            max = Math.max(max, count);
            //System.out.println(max);
        }
        return max;
    }

    //The better Approach
    //Time Complexity: O(NlogN) + O(N)
    //Space Complexity - O(1)
    static int betterApproach(int[] array){

        //Sorting the Array
        Arrays.sort(array);

        int lastSmall = array[0];
        int cnt =0;
        int longest =1;

        if(array.length ==0) return 0;

        for(int i=0; i<array.length; i++){

            if(array[i]-1 == lastSmall){

                cnt+=1;
                longest = Math.max(cnt , longest);
                lastSmall =array[i];
            }

            else if(array[i] != lastSmall){

                cnt =1;
                lastSmall = array[i];
            }

            longest = Math.max(cnt , longest);
        }

        return longest;
    }


    //The optimal Approach
    //Time Complexity: O(N) + O(2*N) ~ O(3*N)
    //Space Complexity: O(N)
    static int optimalApproach(int[] array){

        if(array.length ==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<array.length; i++){
            set.add(array[i]);
        }

        int longest = 1;
        for(int it : set){

            if(!set.contains(it-1)){
                int x = it;
                int cnt =1;

                while(set.contains(x+1)){ //Complete code is same just this search - which is set search

                    x=x+1;
                    cnt++;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    /*
     * Note: The time complexity is computed under the assumption that we are using unordered_set and it is taking O(1) for the set operations.
    If we consider the worst case the set operations will take O(N) in that case and the total time complexity will be approximately O(N2).
    And if we use the set instead of unordered_set, the time complexity for the set operations will be O(logN) and the total time complexity will be O(NlogN).
     */



    public static void main(String[] args){

        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Bruete Force Approach
        System.out.println("Maximum concescutive  : " + brueteForce(array));
        

        //The better Approach
        //System.out.println("Maximum Sequence : " + betterApproach(array));
    }
}
