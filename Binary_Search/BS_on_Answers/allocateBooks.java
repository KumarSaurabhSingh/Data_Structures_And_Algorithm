import java.util.Scanner;

/*Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book.
There are a ‘m’ number of students, and the task is to allocate all the books to the students.
Allocate books in such a way that:

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
If the allocation of books is not possible. return -1 */

public class allocateBooks {

    //Finding the Maximum of the Array
    static int maximum(int[] array){
        int n = array.length;
        int mini = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){

            mini = Math.max(mini, array[i]);
        }

        return mini;
    }

    //Finding Sum of The Array
    static int sum(int[] array){
        int n = array.length;
        int sum = 0;
        for(int i =0; i<n; i++){

            sum = sum+ array[i];
        }

        return sum;
    }
    
    //The Bruete Force Approach
    //Time Complexity: O(N * (sum(arr[])-max(arr[])+1))
    //Space Complexity:  O(1) as we are not using any extra space to solve this problem.
    static int brueteForce(int[] array, int student){

        int n = array.length;

        // book allocation impossible
        if (student > n)
            return -1;
        
        int low = maximum(array);
        int high = sum(array);
        
        for(int i= low; i<= high; i++){

            int std = studentCount(array, i);
            if(std== student){
                return i;
            }
        }
        return -1;
    }

    //Finding the Number of Students
    static int studentCount(int[] array, int limit){
        int n = array.length;
        // int low = maximum(array);
        // int high = sum(array);
        int student = 1;
        int curr = 0;

        for(int i =0; i<n; i++){
            if(curr + array[i] <= limit){
                curr = curr + array[i];
            }

            else{
                curr = array[i];
                student ++;
            }
        }

        return student;
    }



    //The Optimal Solution.
    //Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)).
    //Space Complexity:  O(1) as we are not using any extra space to solve this problem.
    static int optimalApproach(int[] array, int student){
        int n = array.length;
        int low = maximum(array);
        int high = sum(array);
        int ans = -1;

        while(low <= high){

            int mid = (low + high)/2;

            int std = studentCount(array, mid);
            if(std <= student){
                ans = mid;
                high = mid-1;
            }

            else{
                low = mid+1;
            }
        }
        return ans;
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();

        int[] array = new int[arraySize];
        for(int i=0; i<arraySize; i++){
            array[i] = input.nextInt();
        }

        //Input for Number of student
        int student = input.nextInt();

        //The Bruete Force Approach
        int res = brueteForce(array, student);
        System.out.println("(Bruete) Maxi Page Limit : " + res);

        int responce = optimalApproach(array, student);
        System.out.println("(Optimal) Maxi page limit : "+ responce);
    }
}
