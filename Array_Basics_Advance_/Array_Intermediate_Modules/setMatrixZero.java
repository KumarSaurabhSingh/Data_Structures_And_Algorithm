import java.util.Scanner;

public class setMatrixZero {


    static void brueteForce(int[][] array){
        
        for(int i=0; i<array.length; i++){

            for(int j=0; j<array.length; j++){
                if(array[i][j] ==0){
                    markCol(array, j);
                    markRows(array, i);
                }
            }
        }

        switchFlags(array);
    }

    //Marking the rows as "-1" for future referance
    static void markRows(int[][] array, int num){

        for(int i=0; i<array.length; i++){
            if(array[num][i] ==1){
                array[num][i] =-1;
            }
        }
    }

    //Marking the columns for future referance
    static void markCol(int[][] array, int num){

        for(int i=0; i<array.length; i++){
            if(array[i][num] ==1){
                array[i][num] =-1;
            }
        }
    }


    //Changing the marked flag points to "Zero"
    static void switchFlags(int[][] array){
        for(int i=0; i<array.length; i++){

            for(int j=0; j<array.length; j++){

                if(array[i][j] ==-1){
                    array[i][j] = 0;
                }
            }
        }
    }

    //Printing the array
    static void printArray(int[][] array){
        int n = array.length;
        int m = array[0].length;

        for (int i = 0; i < n; i++) {
            for(int j=0; j<m; j++){
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //The better approach
    //Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    //Reason: O(N) is for using the row array and O(M) is for using the col array.
    static void betterApproach(int[][] array){

        int n = array.length;
        int m = array[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(array[i][j] ==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(row[i]==1 || col[j]==1){
                    array[i][j] =0;
                }
            }
        }
    }


    //The optimal Approach
    static void optimalApproach(int[][] array){

        int n = array.length;
        // int[] row = new int[n];
        // int[] col = new int[n];
        int col0 =1;

        //Marking the flags inside the array itself
        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){
                if(j>0){
                    if(array[i][j] ==0){
                        array[0][j] = 0;
                        array[i][0] =0;
                    }
                }

                else{
                    col0=0;
                }
            }
        }

        //updating the array rows and columns
        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                if(array[i][0] ==0 || array[0][j]==0){
                    array[i][j] =0;
                }
            }
        }

        //updating the column zero and row zero
        if(col0 ==0){
            array[0][0] =0;
        }

        printArray(array);
    }



    public static void main(String[] args){
        int arraySize;
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        int arraySize2 = input.nextInt();

        //Taking 2D input in the array
        int[][] array = new int[arraySize][arraySize2];
        for(int i=0; i<arraySize; i++){

            for (int j = 0; j<arraySize2; j++) {
                
                array[i][j] = input.nextInt();

            }
        }
        //printArray(array);
        brueteForce(array);
        printArray(array);

        // betterApproach(array);
        // printArray(array);

        //The Optimal Approach
        //optimalApproach(array);
    }
}

/*
 * Input:-
 * 4
1 1 1 1
1 0 1 1
1 1 0 1
1 1 1 1

Output:-
1  0  0  1
0  0  0  0
0  0  0  0
1  0  0  1
 */