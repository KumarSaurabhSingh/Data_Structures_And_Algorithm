import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class unionArray {

    //Bruete force approach for Union of an array

    static ArrayList<Integer> unionArray(int[] arr1, int[] arr2){

        Set<Integer> join = new TreeSet<>();
        //Using TreeSet instead of HashSet will return the elements in a sorted order
        
        for(int i=0; i<arr1.length; i++){
            join.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            //boolean temp = join.contains(arr2[i]);
            //if(temp == false)
            //No need for the above condition since the set itself avoid duplicates
            join.add(arr2[i]);
        }

        
        ArrayList <Integer> Union = new ArrayList<>();

        for(int Iterator : join){
            Union.add(Iterator);
            //Here we are iterating over the complete set and add each of the elements in the arrayList
        }

        return Union;
    }



    //Optimal approach for Union of an Array
    //Time complexity - O(N1 + N2)
    //Space Complexity - O(N1 + N2) - This space is only used to show the answer not for solving
    static ArrayList optimalApproach(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;

        int i=0;
        int j=0;

        ArrayList<Integer> Union = new ArrayList<>();

        while(i<n1 && j<n2){

            if(arr1[i] <=arr2[j]){

                if(Union.size() ==0 || Union.get(i)!= arr1[i]){
                    Union.add(arr1[i]);
                }
            }

            else{
                if(Union.size() ==0 || Union.get(j)!= arr1[j]){
                    Union.add(arr1[j]);
                }
            }
        }

        while(i<n1){
                if(Union.size() ==0 || Union.get(i)!= arr1[i]){
                    Union.add(arr1[i]);
                }
            
        }

        while(j<n2){

                if(Union.size() ==0 || Union.get(i)!= arr1[i]){
                    Union.add(arr1[i]);
                }
        }

        return Union;
    }
    


    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking input in the array
        int[] array1 = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array1[i] = input.nextInt();
        }

        int arraySize2;
        arraySize2 = input.nextInt();

        //Taking input in the array
        int[] array2 = new int[arraySize2];
        for(int i=0; i<arraySize2; i++){
            array2[i] = input.nextInt();
        }


        //Inserting result in ArrayList
        // ArrayList<Integer> result = new ArrayList<>();
        // result = unionArray(array1, array2);

        // for(int Iterator : result){
        //     System.out.print(Iterator + "  ");
        // }


        //For optimal approach
        ArrayList<Integer> result1 = new ArrayList<>();
        result1 = unionArray(array1, array2);

        for(int Iterator1 : result1){
            System.out.print(Iterator1 + "  ");
        }
    }
}
