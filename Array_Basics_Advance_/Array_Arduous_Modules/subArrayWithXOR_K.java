import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

public class subArrayWithXOR_K {

    //The Bruete Force Approach
    //Time Complexity - O(N ^ 3)
    //Space Complexity - O(1)
    static void brueteForce(int[] array, int num){

        int n = array.length;
        int count =0;

        for(int i=0; i<n; i++){

            for(int j=i; j<n; j++){

                int XOR =0;

                for(int k=i; k<=j; k++){

                    XOR = XOR ^ array[k];
                }

                if(XOR == num){
                    count++;
                }

            }
        }

        System.out.println("(BRUETE) NUMBER OF SUB-ARRAYS  : " + count);
    }

    //The Better Approach
    static void betterApproach(int[] array, int num){

        int n = array.length;
        int count =0;

        for(int i=0; i<n; i++){
            int XOR =0;

            for(int j=i; j<n; j++){

                XOR = XOR ^ array[j];
                // System.out.println("BEFORE FOR LOOP XOR : " +XOR);
                // System.out.println("BEFORE FOR LOOP ARR : " +array[j]);

                if(XOR == num){
                    count++;
                }
            }

        }

        System.out.println("(BETTER) NUMBER OF SUB-ARRAYS  : " + count);
    }


    //The Optimal Approach
    //Time Complexity: O(N) or O(N*logN)
    //Space Complexity: O(N) as we are using a map data structure.
    static void optimalApproach(int[] array, int num){

        int n = array.length;

        int count =0;
        Map<Integer, Integer> temp = new HashMap<>();
        temp.put(0, 1); //setting the value of 0.

        int XOR =0;

        for(int i=0; i<n; i++){

            // prefix XOR till index i:
            XOR = XOR ^ array[i];

            //By formula: x = xr^k:
            int x = XOR ^ num;

            // add the occurrence of xr^k
            // to the count:
            if(temp.containsKey(x)){
                count = count + temp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if(temp.containsKey(XOR)){

                temp.put(XOR, temp.get(XOR)+1);
            }

            else{
                temp.put(XOR, 1);
            }
        }

        System.out.println("(OPTIMAL) NUMBER OF SUB-ARRAYS  : " + count);
    }
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];

        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        // XOR value
        int num = input.nextInt();

        //The Bruete Force Approach
        //brueteForce(array, num);

        //The Better Approach
        //betterApproach(array, num);

        //The Optimal Approach
        optimalApproach(array, num);
    }
}
