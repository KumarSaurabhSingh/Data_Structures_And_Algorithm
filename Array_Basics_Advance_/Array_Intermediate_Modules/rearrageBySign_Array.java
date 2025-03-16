import java.util.ArrayList;
import java.util.Scanner;

public class rearrageBySign_Array {

    //Bruete Force Approach
    //Time Complexity - O(N) + O(N/2)
    //Space Complexity - O(N)
    static void brueteForce(int[] array){

        int n = array.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<n; i++){
            
            if(array[i] >=0){
                pos.add(array[i]);
            }
            else{
                neg.add(array[i]);
            }
        }

        
        for(int i=0; i<n/2; i++){
                array[2*i] = pos.get(i);

                array[2*i+1] = neg.get(i);
        }
    }

    //Optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(N)
    static int[] optimalApproach(int[] array){

        int[] tempArr = new int[array.length];

        int pos =0;
        int neg =1;

        for(int i=0; i<array.length; i++){

            if(array[i] >=0){
                tempArr[pos] = array[i];
                pos = pos +2;
            }

            else{
                tempArr[neg] = array[i];
                neg = neg +2;
            }
        }

        return tempArr;
    }


    //Varity -2 for this problem if array1 > array2 or vice versa
    //Time Complexity - O(N) + O(N) = O(2N)
    //Space Complexity - O(N)
    static void secondVariety(int[] array){

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        int n = array.length;
        for(int i=0; i<n; i++){

            if(array[i] >=0){
                pos.add(array[i]);
            }

            else{
                neg.add(array[i]);
            }
        }

        System.out.println(pos);
        System.out.println(neg);

        if(pos.size() > neg.size()){

            for(int i=0; i<neg.size(); i++){

                array[2*i] = pos.get(i);
                array[2*i +1] = neg.get(i);
            }

            int idx = 2*neg.size();
            for(int i = neg.size(); i<pos.size(); i++){
                array[idx] = pos.get(i);
                idx++;
            }
        }
        else{

            for(int i=0; i<pos.size(); i++){

                array[2*i] = pos.get(i);
                array[2*i +1] = neg.get(i);
            }

            int idx = 2*pos.size();
            for(int i = pos.size(); i<neg.size(); i++){
                array[idx] = neg.get(i);
                idx++;
            }

        }

        printArray(array);;
    }


    //Printing the array
    static void printArray(int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
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

        // brueteForce(array);
        // printArray(array);


        // int[] res =optimalApproach(array);
        // printArray(res);

        //Second Variety Question
        secondVariety(array);
    }
}
