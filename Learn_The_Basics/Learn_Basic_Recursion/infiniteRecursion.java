public class infiniteRecursion {

    //Stack Overflow condition
    
    static void infiniteRecursion(){

        System.out.println("Heyy!!");
        infiniteRecursion();

    }

    public static void main(String[] args){
        infiniteRecursion();
    }
}