import java.sql.Time;

public class Surrounded_Region {
    
    //DFS Traversal
    //Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M), For the worst case, every element will be marked as ‘O’ in the matrix, and the DFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time. Also, we are running loops for boundary elements so it will take O(N) + O(M).

    //Space Complexity ~ O(N x M), O(N x M) for the visited array, and auxiliary stack space takes up N x M locations at max. 


    static void dfs(int row, int col, int[][] visit,
        char[][] arr, int[] delRow, int[] delCol){
            visit[row][col] = 1;
            int n = arr.length;
            int m = arr[0].length;

            //check for top, right, bottom, left
            for(int i=0; i<4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                // check for valid coordinates and unvisited Os
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                    visit[nrow][ncol] == 0 && arr[nrow][ncol] == 'O'){

                        dfs(nrow, ncol, visit, arr, delRow, delCol);
                }
            }
    }


    static char[][] fill(int n, int m, char[][] arr){
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int[][] visit = new int[n][m];

        //Traversal in the column
        for(int j=0; j<m; j++){

            if(arr[0][j] == 'O' && visit[0][j] == 0){
                dfs(0, j, visit, arr, delRow, delCol);
            }

            if(arr[n-1][j] == 'O' && visit[n-1][j] == 0){
                dfs(n-1, j, visit, arr, delRow, delCol);
            }
        }

        //Traversal Through row
        for(int i=0; i<n; i++){
            if(arr[i][0] == 'O' && visit[i][0] == 0){
                dfs(i, 0, visit, arr, delRow, delCol);
            }

            if(arr[i][m-1] == 'O' && visit[i][m-1] == 0){
                dfs(i, m-1, visit, arr, delRow, delCol);
            }
        }


        // if unvisited O then convert to X
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 'O' && visit[i][j] == 0){
                    arr[i][j] = 'X';
                }
            }
        }

        return arr;

    }




    public static void main(String[] args)
    {
        char arr[][] = {
        {'X', 'X', 'X', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'O', 'O', 'X'}, 
        {'X', 'O', 'X', 'X'}, 
        {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        char[][] ans = fill(5, 4, arr);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
