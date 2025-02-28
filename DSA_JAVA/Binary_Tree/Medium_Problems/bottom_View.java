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
public class bottom_View {

    static List<Integer> traversal(Tree root){

        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> map = new HashMap<>();
        
        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){

            Pair node  = q.poll();
            Tree value = node.num;
            int line = node.value;

            // Update the map with the node's data
            // for the current vertical position
            map.put(line, value.data);

            // Process left child
            if(value.left != null){
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair(value.left, line-1));
            }

            if(value.right != null){
                 // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair(value.right, line+1));
            }

        }

        //Transfer values from the
        // map to the result list
        map.keySet().stream().sorted().forEach(key -> ans.add(map.get(key)));

        return ans;
    }
    
    public static void main(String[] args) {
        
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(10);
        root.left.left.right = new Tree(5);
        root.left.left.right.right = new Tree(6);
        root.right = new Tree(3);
        root.right.right = new Tree(10);
        root.right.left = new Tree(9);

        List<Integer> ans = traversal(root);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
