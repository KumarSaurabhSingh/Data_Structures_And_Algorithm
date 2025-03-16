import java.util.Scanner;

public class buyAndSellStocks {

    //The most optimal Approach
    //Time Complexity - O(N)
    //Space Complexity - O(1)
    static void buyAndSellStocks(int[] price){

        int profit =0;
        int mini = price[0];
        for(int i=1; i<price.length; i++){

            int cost = price[i] - mini;

            profit = Math.max(profit, cost);  //Updating the sell status of the stock with maximum profit

            mini = Math.min(mini, price[i]); //Always updating the minimum value while buying the stock
        }

        System.out.println(profit);
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

        buyAndSellStocks(array);
    }
}
