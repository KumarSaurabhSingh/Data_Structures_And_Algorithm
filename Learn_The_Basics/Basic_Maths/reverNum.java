
    import java.util.Scanner;

    public class reverNum {
        
    static int reverseNo(int n) {
        int rev = 0;

        while (n != 0) {
            int digit = n % 10;
            
            // Check for overflow/underflow before adding the digit
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow
            }
            
            rev = rev * 10 + digit;
            n /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a signed 32-bit integer: ");
        
        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a 32-bit integer.");
            return;
        }
        
        int n = input.nextInt();
        int output = reverseNo(n);
        System.out.println("Reversed number: " + output);
    }
}

