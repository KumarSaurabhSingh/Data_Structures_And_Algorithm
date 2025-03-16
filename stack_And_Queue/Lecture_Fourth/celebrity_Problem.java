import java.util.Scanner;

public class celebrity_Problem {

    //The BrueteForce Approach
    //Time COmplexity - O(N^2) + O(N)
    //Space Complexity - O(2N)

    static int BrueteForce(int[][] arr){

        int n = arr.length;
        int[] knowMe = new int[n];
        int[] iKnow = new int[n];

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        //Checking for celebrity
        for(int i=0; i<n; i++){
            if(knowMe[i] == n-1 && iKnow[i] == 0){
                return i;
            }
        }

        return -1;
    }


    //The Optimal Approach
    static int Optimal(int[][] arr){
        int n = arr.length;
        int top =0;
        int down = n-1;

        while(top < down){

            if(arr[top][down] == 1){
                top = top+1;
            }

            else if(arr[down][top] == 1){
                down = down-1;
            }

            else{
                top++;
                down--;
            }
        }

        //Checkting for celebrity
        if(top > down){
            return -1;
        }

        for(int i =0; i<n; i++){

            if(i == top){
                continue;
            }

            if(arr[top][i] == 0 && arr[i][top] == 1){
                return i;
            }
            else{
                return -1;
            }
        }
        return top;
    }
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[][] arr = new int[size][size];

        for(int i=0; i<size; i++){
            for(int j =0; j<size; j++){
                arr[i][j] = input.nextInt();
            }
        }

        //The Burte Force Approach
        int ans_bruete = BrueteForce(arr);
        System.out.println("The Bruete Force: "+ ans_bruete);

        //The Optimal Approach
        int ans_opti = Optimal(arr);
        System.out.println("Optimal Approach: "+ ans_opti);
    }
}
