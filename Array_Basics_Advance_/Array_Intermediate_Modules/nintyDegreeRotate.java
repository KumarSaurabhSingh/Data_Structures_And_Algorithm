import java.util.Scanner;

public class nintyDegreeRotate {

    //The Bruete Force Approach
    static void brueteForce(int[][] array){

        int n =array.length;
        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){
                int t =n-i-1;

                temp[n-j-1][t] = array[i][j];
                // int swap = array[i][j];
                // array[i][j] = array[n-i-1][n-j-1];
                // array[n-i-1][n-j-1] = swap;
            }
        }

        printArray(temp);
    }

    //The Optimal Approach
    //Time Complexity - O(N*N) + O(N*N) --> One O(N*N) is for transposing the matrix and the other is for reversing the matrix.
    //Space Complexity - O(1)
    static void optimalApproach(int[][] array){
        int n = array.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                if(i!=j){
                    int swap = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = swap;
                }
            }
        }
        printArray(array);
        System.out.println("Break");

        for(int i=0; i<n; i++){

            for(int j=0; j<n/2; j++){
                int swap = array[i][j];
                array[i][j] = array[i][n-1-j];
                array[i][n-1-j] = swap;
            }
        }

        printArray(array);
    }

    //Printing the array
    static void printArray(int[][] array){

        for (int i = 0; i < array.length; i++) {
            for(int j=0; j<array.length; j++){
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //Taking 2D input in the array
        int[][] array = new int[arraySize][arraySize];
        for(int i=0; i<arraySize; i++){

            for (int j = 0; j<arraySize; j++) {
                
                array[i][j] = input.nextInt();

            }
        }

        //brueteForce(array);
        //printArray(array);

        optimalApproach(array);
    }
}
