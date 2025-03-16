import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class spiralMatrix {

    /*
     * Time Complexity: O(m x n) { Since all the elements are being traversed once and there are total n x m elements ( m elements in each row and total n rows) so the time complexity will be O(n x m)}.

    Space Complexity: O(n) { Extra Space used for storing traversal in the ans array }.
     */

    static List<Integer> spiralMatrix(int[][] array){

        List<Integer> mat = new ArrayList<>();

        int n = array.length;
        int m = array[0].length;
        
        int top =0;
        int right = n-1;
        int bottom = m-1;
        int left = 0;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            //left to right
            for(int i=left; i<=right; i++){
                mat.add(array[top][i]);
            }
            top++;

            //Top to bottom
            for(int i=top; i<=bottom; i++){
                mat.add(array[i][right]);
            }
            right--;

            //Right to left
            if(top <= bottom){ //To check there is only one line is left

                for(int i=right; i>=left; i--){
                    mat.add(array[bottom][i]);
                }
                bottom--;
            }

            //Bottom to top
            if(left<=right){

                for(int i=bottom; i>=top; i--){
                    mat.add(array[i][left]);
                }
                left++;
            }
        
        }


        return mat;
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
        List<Integer> ans = spiralMatrix(array);;

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}
