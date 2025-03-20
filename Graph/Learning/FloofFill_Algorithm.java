public class FloofFill_Algorithm {


    //Time Complexity - O(N x M)
    //Space COmplexity - O(N x M)
    public static void dfs(int[][] arr, int sr, int sc, int[][] ans, int newColor, int[] delRow, int[] delCol, int initialColor){
        ans[sr][sc] = newColor;
        int n = ans.length;
        int m = ans[0].length;

        for(int i=0; i<4; i++){ //Since the element should have only 4 side accessible
            int newRow = delRow[i] + sr;
            int newCol = delCol[i] + sc;
            

            // check for valid coordinate
            // then check for same initial color and unvisited pixel
            if(newRow >= 0 && newCol >= 0 && newRow<n && newCol <m &&
                arr[newRow][newCol] == initialColor && ans[newRow][newCol] != newColor){
                    dfs(arr, newRow, newCol, ans, newColor, delRow, delCol, initialColor);
                }
        }
    }


    public static int[][] floodFill(int[][] arr, int sr, int sc, int newColor){
        int initialColor = arr[sr][sc];
        int[][] ans = arr;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        dfs(arr, sr, sc, ans, newColor, delRow, delCol, initialColor);

        return ans;
    }
    
    public static void main(String[] args)
    {
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        int[][] ans = floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
