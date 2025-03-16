//Understand recursion by print something N times

public class conditionalRecursion {

    public static int count =0;
        
        static void conditionalRecursion(){

            //Breaks when count ==3 
            if(count ==3){ //This  condition is also called as base case where the recursion got stopped.
                return;
            }
            System.out.println(count);

            count= count+1;
            conditionalRecursion();

        }

    public static void main(String[] args){
        conditionalRecursion();
    }
}
