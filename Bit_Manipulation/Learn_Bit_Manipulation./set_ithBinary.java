import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class set_ithBinary {
    
    static void set_ithBinary(int num, int set){

        //Converting to Binary
        Stack stack = new Stack<>();
        int i=0;
        while(num > 0){
            stack.push(num%2);
            num = num/2;
        }

        List<Integer> list = new ArrayList<>(stack);
        int size = list.size();
        size = size - set;
        int cnt =0;


        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext() && set >0) {
            size--; cnt++;
            if(size-1 ==0){
                if(iterator.next()==0){
                    list.set(cnt, 1);
                }
                else{
                    break;
                }
            }
            cnt++;
        }

        //Reversing a list
        Collections.reverse(list);
        printBinary(list);
    }

    static void printBinary(List<Integer> list){

        Iterator it = list.iterator();
        System.out.print("Updated Binary: ");
        while(it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int setValue = input.nextInt();
        set_ithBinary(num, setValue);
    }
}
