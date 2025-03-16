/* Question -> GFG
 * https://www.geeksforgeeks.org/problems/count-digits5716/1
 */


public class count_Digits {
    
    static void firstCode(){

        System.out.println("Heyy!! Let's code it");

    }


// User function Template for Java
//Time complexity of the below code is Big O(log(n) at base 10) -> Here is it's divided by any other number then it will be the base
    public static void  evenlyDivides(int n) {
        int count =0;
        int lst = 0;
        int num=n;
        while (n>0){
            lst = n%10;
            System.out.println("lst" + lst);
            
            if(lst > 0 && num%lst ==0){
                count++;
                System.out.println("count" + count);
            }
            else{
                count = count;
            }
            n= n/10;
            System.out.println("num" + num);
        }
        
        System.out.println(count);
    }


    public static void main(String[] args){
        // firstCode();
        evenlyDivides(20);
    }
}