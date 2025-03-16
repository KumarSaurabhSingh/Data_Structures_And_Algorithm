import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
public class NonDublicateNumber {

    //Bruete Force Approach
    //Time Complexity - O(N*N) - Worst Case
    //Space Complexity - O(1)
    static void brueteForceApproach(int[] array){
        int i=0;
        for(i=1; i<=array.length; i++){
            int count=0;
            
            for(int j=0; j<array.length; j++){
                if(array[j] ==i){
                    count++;
                    //System.out.println("array[j]  " +array[j]);
                }
            }
            if(count ==1){
                //return i;
                System.out.println(i);
            }
        }
    }


    //First Better Approach
    //Time Complexity = O(N) + O(N) + O(N)
    //Space Complexity = O(Maxi+1)
    static void firstBetterApproach(int[] array){

        int maxi = array[0]; //Initializing an array of zero elements

        for(int i=0; i<array.length; i++){
            maxi = Math.max(maxi, array[i]);
        } //This will help us to find what will be the ideal size of hash array
        System.out.println("Maxi  " + maxi);

        // Declare hash array of size maxi+1
        // And hash the given array:
        int[] hashArr = new int[maxi+1];

        for(int i=0; i<array.length; i++){
            
            hashArr[array[i]] ++;
        }

        for(int i=0; i<hashArr.length; i++){
            if(hashArr[i] ==1){
                System.out.println(i);
            }
        }
    }


    //Second Better Approach - Using HashMap Concept
    //Time Complexity - O(N * logM) +O(N/2 +1)  where M = size of the map i.e. M = (N/2)+1.
    //Space Complexity = O(N/2 +1)
    //In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, the time complexity will be O(N) + O(M).
    static void secondBetterApproach(int[] array){

        Map<Integer, Integer> temp = new HashMap<>();
        
        //insertion takes logM time(where M = size of the map)
        for(int i=0; i<array.length; i++){
            if(temp.containsKey(array[i])){
                temp.put(array[i], temp.get(array[i]) +1);
            }
            else{
                temp.put(array[i] , 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : temp.entrySet()){
            
            if(entry.getValue() ==1){
                System.out.println(entry.getKey());
            }

            //System.out.println(entry.getKey() + " "+ entry.getValue());
        }
    }

    //The Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static void optimalApproach(int[] array){

        int xor =0;
        for(int i=0; i<array.length; i++){
            xor = xor ^ array[i];
        }

        System.out.println(xor);
    }
    
    public static void main(String[] args){

        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Bruete Force result
        //brueteForceApproach(array);

        //Better Approach result
        //firstBetterApproach(array);

        //Second Better Approach
        //secondBetterApproach(array);

        //The Optimal Approach
        optimalApproach(array);
    }
}
