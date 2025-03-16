import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//HashMap has time complexity of O(LogN) for all conditions -> Best, worst and average
//But for Unordered Map-> the output will not be in sorted fashion as its in the ordered map.
//Also the time complexity will be O(1) in best and average case and O(N) for worst case but for very minimal cases
//This worst case happens because of internal collisons. (Divison Method)

public class charFrequencyHaping {
    
    static void charFrequencyHaping(int stringSize, String str){

        char[] arr = new char[stringSize];

        char[] character = str.toCharArray();

        for(int i=0; i<stringSize; i++){
            arr[i] = character[i];
        }

        HashMap<Character, Integer> element = new HashMap<>();
        
        for(int i=0; i<stringSize; i++){
            if(element.containsKey(character[i])){
                element.put(character[i], element.get(character[i]) + 1);
            }

            else{
                element.put(character[i], 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : element.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }


    public static void main(String[] args){

        String str;
        Scanner input = new Scanner(System.in);
        str =input.next();

        int stringSize = str.length();

        charFrequencyHaping(stringSize, str);

    }
}
