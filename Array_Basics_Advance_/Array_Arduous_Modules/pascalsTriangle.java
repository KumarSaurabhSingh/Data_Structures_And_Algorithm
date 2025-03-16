import java.util.Scanner;

public class pascalsTriangle {

    //Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
    public static int varient1(int row, int col){

        int element = (int) nCr(row, col);
        return element;

    }

    //Calculating nCr for a given value
    static long nCr(int row, int col){

        long res =1;
        for(int i=0; i<col; i++){

            res = res * (row-i);
            res = res /(i+1);
        }
        return res;
    }


    //Given the row number n. Print the n-th row of Pascal’s triangle.
    //Time Complexity: O(n*r), where n is the given row number, and r is the column index which can vary from 0 to n-1.
    /*Reason: We are calculating the element for each column. Now, there are total n columns, and for each column, the calculation of the element takes O(r) time where r is the column index. */
    //Space COmplexity - O(R+1) - Used to store the answer
    static void nthRowPrint(int row){

        int[] ans = new int[row+1];

        for(int i=0; i<=row; i++){
            if(i==0 || i==row){
                //System.out.println("1");
                ans[i] = 1;
            }
            else{
                //System.out.println(nCr(row, i));
                int temp = (int) nCr(row, i);
                ans[i] = temp;
            }

        }
        printArray(ans);

    }

    //The optimal approach of varient 2
    //Time complexity = O(N)
    //Space Complexity = O(1)
    static void varient2_Optimal(int row){

        long ans =1;

        System.out.print(ans+ " ");

        for(int i=0; i<row; i++){

            ans = ans * (row-i);
            ans = ans / (i+1);
            System.out.print(ans + " ");
        }
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

        int row = input.nextInt();
        //int col = input.nextInt();

        //System.out.println(nCr(1, 1));

        //The varient 1 approach
        //int element =varient1(row, col);
        //System.out.println(element);

        //The varient 2 approach
        //nthRowPrint(row);

        //The varient 2 optimal approach
        varient2_Optimal(row);
    }
}
