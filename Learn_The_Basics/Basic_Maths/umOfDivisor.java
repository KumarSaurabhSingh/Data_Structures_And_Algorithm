import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class umOfDivisor {

    static void sumOfDivisor(int N) {
        List<Integer> divisors = new ArrayList<>();

        int i = 1;
        // O(sqrt[n]) - Time Complexity
        while (i <= Math.sqrt(N)) {
            if (N % i == 0) {
                // Add both i and N/i if they are distinct
                divisors.add(i);
                if (N / i != i) {
                    divisors.add(N / i);
                }
            }
            i++; // Increment the loop counter
        }

        //Sorting will take -> N*logN -> N: No. of factors
        divisors.sort(Comparator.reverseOrder());
        // Print all divisors
        //While printing it will again go for no. of factors
        for (Integer element : divisors) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        int N = 10;
        sumOfDivisor(N);
    }
}
