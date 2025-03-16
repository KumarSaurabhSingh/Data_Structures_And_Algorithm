import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class checkIfSet_Bit {

    static void convertToBinary(int num, int set){
        Stack ans = new Stack<>();
        int i=0;
        while(num > 0){
            ans.push(num%2);
            num = num/2;
        }
        int setValue = set;
        Iterator<Integer> it = ans.iterator();
        while (it.hasNext()) {
            setValue--;
            if(setValue ==0 && it.next() ==1){
                System.out.println("The Value is Set");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int setValue = input.nextInt();
        convertToBinary(num, setValue);
    }
}
