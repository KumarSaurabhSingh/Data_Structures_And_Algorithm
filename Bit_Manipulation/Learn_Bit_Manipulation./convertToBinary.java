import java.util.Scanner;

class convertToBinary {
    public static String convertToBinary(int num) {
        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num /= 2;
        }
        return binary;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String binary = convertToBinary(num);
        System.out.println(num + " in decimal = " + binary + " in binary.");

    }
}