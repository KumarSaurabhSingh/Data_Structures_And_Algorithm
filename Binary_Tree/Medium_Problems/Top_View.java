import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Tree{

    int data;
    Tree left, right;

    public Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair{
    Tree num;
    int value;

    public Pair(Tree num, int value){
        this.num = num;
        this.value = value;
    }
}


public class Top_View {

    static List<Integer> traversal(Tree root){

        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){

            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair pair = q.poll();
            Tree node = pair.num;
            int line = pair.value;

            // If the vertical position is not already
            // in the map, add the node's data to the map
            if(!map.containsKey(line)){
                map.put(line, node.data);
            }

            // Process left child
            if(node.left != null){
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair(node.left, line-1));
            }

            //Process right child
            if(node.right != null){
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair(node.right, line+1));
            }
        }

        // Sort keys and extract values in order
        map.keySet().stream().sorted().forEach( key -> ans.add(map.get(key)));


        return ans;
    }
    
    public static void main(String[] args) {
        
        Tree node = new Tree(2);
        node.left = new Tree(9);
        node.right = new Tree(20);
        node.right.left = new Tree(15);
        node.right.right = new Tree(7);
        node.left.right = new Tree(6);
        node.left.right.left= new Tree(7);

        // Get the top view traversal
        List<Integer> topView = traversal(node);

        // Print the result
        System.out.println("Top Vertical Traversal: ");
        for (int root : topView) {
            System.out.print(root + " ");
        }
    }
}
