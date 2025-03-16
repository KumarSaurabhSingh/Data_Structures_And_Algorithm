import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.
public class majorityElement {

    static void brueteForce(int[] array){

        int n = array.length;
        int element = Integer.MIN_VALUE;
        int freq =0;

        for(int i=0; i<n; i++){

            int count =0;

            for(int j=0; j<n; j++){

                if(array[i] == array[j]){
                    count++;
                    
                }
            }

            if(count > n/3){
                element = array[i];
                freq = count;
            }
        }

        System.out.println(element + "  Occured : " + freq + " Times");
    }

    //The Better Approach
    //Time Complexity - (N * LogN) - Log N for insertion in map and N is the no. of elements
    //Space Complexity - O(N) - Worst case
    static void betterApproach(int[] array){

        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = array.length;
        int mini =  n/3 + 1;

        for(int i=0; i<n; i++){

            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }

            else{
                map.put(array[i], 1);
            }

            if(map.get(array[i]) == mini){

                res.add(array[i]);
            }
        }

        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }

        //Checking the value which has appeared more than n/3
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            if(entry.getValue()> n/3){
                System.out.println( entry.getKey()+ " No of times occured : " + entry.getValue());
            }
        }

        //System.out.println(map);
    }


    //Optimal Approach (Extended Boyer Moore’s Voting Algorithm):
    //Time Complexity - O(N) + O(N)
    //Space Complexity - O(1) - The reason is we can store at max of two elements therefore its O(1)
    static void optimalApproach(int[] array){
        int count1 =0;
        int count2 =0;
        int ele1=0;
        int ele2 =0;

        int n= array.length;

        for(int i=0; i<n; i++){

            if(count1 ==0 && array[i] != ele2){
                ele1 = array[i];
                count1 ++;
            }

            else if(count2 ==0 && array[i] != ele1){
                ele2 = array[i];
                count2++;
            }

            else if(array[i] ==ele1) count1++;
            else if(array[i] ==ele2) count2++;


            else{
                count1--;
                count2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == ele1) count1++;
            if (array[i] == ele2) count2++;
        }

        int mini = (int)(n / 3) + 1;
        if (count1 >= mini) ls.add(ele1);
        if (count2 >= mini) ls.add(ele2);

        System.out.println(ls);
    }



    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //The Bruete Force Approach
        //brueteForce(array);

        //The better approach
        //betterApproach(array);

        //The Optimal Approach
        optimalApproach(array);
    }
}
