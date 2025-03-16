import java.util.ArrayList;
import java.util.Scanner;

public class medianOfSortedArr {

    /*
     * Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    Reason: We traverse through both arrays linearly.
    Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    Reason: We are using an extra array of size (n1+n2) to solve this problem.
     */
    static double brueteForce(int[] array1, int[] array2){

        int n1 = array1.length;
        int n2 = array2.length;
        double ans =-1;

        int comLen = n1+n2;
        ArrayList<Integer> temp = new ArrayList<>();
        int i=0, j=0;
        while(i<n1 && j<n2){

            if(array1[i] < array2[j]){
                temp.add(array1[i]);
                i++;
            }

            else{
                temp.add(array2[j]);
                j++;
            }
        }

        while(i<n1){
            temp.add(array1[i]);
                i++;
        }

        while(j<n2){
            temp.add(array2[j]);
                j++;
        }
        System.out.println(temp);
        
        if(comLen%2 ==0){
            ans = ((double)temp.get(comLen/2) + (double)temp.get((comLen/2)-1))/2;
        }

        else {
            ans = temp.get(comLen/2);
        }

        return ans;
    }

    //The Better Approach
    //Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    //Reason: We traverse through both arrays linearly.

    //Space Complexity: O(1), as we are not using any extra space to solve this problem.
    static double betterApproach(int[] array1, int[] array2){
        int n1 = array1.length;
        int n2 = array2.length;

        int nLeng = n1+n2;
        int cnt =0;

        int ind2 = nLeng/2;
        int ind1 = ind2-1;

        int ele1 = -1;
        int ele2 = -1;

        int i = 0; //Array1 traverser
        int j = 0; //Array2 traverser

        while(i<n1 && j<n2){

            if(array1[i] <array2[j]){
                if(cnt == ind1) ele1 = array1[i];
                if(cnt == ind2) ele2 = array1[i];
                cnt++;
                i++;
            }

            else{
                if(cnt == ind1) ele1 = array2[j];
                if(cnt == ind2) ele2 = array2[j];
                cnt++;
                j++;
            }
        }

        while(i<n1){
            if(cnt == ind1) ele1 = array1[i];
            if(cnt == ind2) ele2 = array1[i];
            cnt++;
            i++;
        }

        while(j<n2){
            if(cnt == ind1) ele1 = array2[j];
            if(cnt == ind2) ele2 = array2[j];
            cnt++;
            j++;
        }

        if(nLeng%2 ==1){
            return (double)ele2;
        }

        else{
            return (double)((double)(ele1+ele2))/2.0;
        }
    }
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        int arraySize2 = input.nextInt();

        int[] array2 = new int[arraySize2];
        for(int i=0; i<arraySize2; i++){
            array2[i] = input.nextInt();
        }

        //The Bruete Force Approach
        double res1 = brueteForce(array, array2);
        System.out.println("(Bruete) The Median will be : "+ res1);

        //The Better Approach
        double res2 = betterApproach(array, array2);
        System.out.println("(Better) The Median will be : "+ res2);
    }
}
