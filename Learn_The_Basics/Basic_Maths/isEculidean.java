public class isEculidean {
    static int[] lcmAndGcd(int a, int b) {
        // Compute GCD using the Euclidean algorithm
        int gcd = findGCD(a, b);

        // Compute LCM using the relation: LCM * GCD = a * b
        int lcm = (a / gcd) * b;

        // Store results in an int array and return
        return new int[]{lcm, gcd};
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
