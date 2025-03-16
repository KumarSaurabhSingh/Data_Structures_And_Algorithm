import java.sql.Time;
import java.util.PriorityQueue;
import java.util.Scanner;

public class gas_Station {

    //The Bruete Force Approach
    //Time Complexity: O(k*n) + O(n), n = size of the given array, k = no. of gas stations to be placed.
    //Space Complexity: O(n-1) as we are using an array to keep track of placed gas stations.
    static double brueteForce(int[] array, int station){

        int n = array.length;
        int[] howMany = new int[n-1];

        for(int i=1; i<=station; i++){

            double maxAns = -1;
            int maxIndx =-1;
            for(int j=0; j<n-1; j++){

                double diff = array[j+1] - array[j];

                double selectionLength = (double)diff/(double)(howMany[j]+1);

                if(selectionLength > maxAns){
                    maxAns = selectionLength;
                    maxIndx = j;
                }
            }

            howMany[maxIndx]++;
        }

        double max = -1;
        for(int i=0; i<n-1; i++){
            double diff = array[i+1] -array[i];
            double selecMax = diff/(double)(howMany[i]+1);

            max = Math.max(selecMax,max);
        }

        return max;
    }

    public static class Pair{
        double first;
        int second;

        Pair(double first, int second){
            this.first = first;
            this.second = second;
        }
    }

    //The Better Approach(Using Heap)
    //Time Complexity: O(nlogn + klogn),  n = size of the given array, k = no. of gas stations to be placed.
    //Space Complexity: O(n-1)+O(n-1)
    static double betterApproach(int[] array, int station){

        int n = array.length;
        int[] howMany = new int[n-1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        // insert the first n-1 elements into pq
        // with respective distance values:

        for(int i=0; i<n-1; i++){
            pq.add(new Pair(array[i+1]-array[i], i));
            //Pushing Elements in the Priority Queue
        }

        for(int i=1; i<=station; i++){

            Pair tp = pq.poll(); //Storing both elements in temp preiority
            int secondID = tp.second; // Retreiving the second element

            //Inserting the current gas station
            howMany[secondID]++;

            double diff = array[secondID+1] - array[secondID];
            double newsecLen = diff/(double)(howMany[secondID]+1);

            pq.add(new Pair(newsecLen, secondID));
        }
        return pq.poll().first;
    }



    //The Most Optimal Solution (Using Binary Search)
    //Time Complexity: O(n*log(Len)) + O(n), n = size of the given array, Len = length of the answer space.
    //Space Complexity: O(1) as we are using no extra space to solve this problem.
    static double optimalApproach(int[] array, int station){

        int maxDist = -1;
        int n = array.length;
        for(int i=0; i<n-1; i++){
            maxDist = Math.max(maxDist, array[i+1] - array[i]);
        }
        
        double low = 0;
        double high = maxDist;
        double ans =-1;

        double diff = 1e-6; //10^-6

        while(high-low >diff){

            double mid = (low+high)/2;
            int cnt = (int)requiredStation(array, (int)mid);

            if(cnt >= station){
                ans = high;
                low = mid;
            }

            else{
                high = mid;
            }

        }

        return ans;
    }

    //The Method to indenify the station count
    static double requiredStation(int[] arr, int dist){
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
    

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for Number of Gas Station
        int station = input.nextInt();

        double res = brueteForce(array, station);
        System.out.println("(Bruete) The Maxi Dst : " + res);


        //Better Solution
        double res2 = betterApproach(array, station);
        System.out.println("(Better) The Maxi Dst : " + res2);

        //The Optimal Solution
        double res3 = optimalApproach(array, station);
        System.out.println("(Optimal) The Maxi Dst : "+ res3);
    }
}
