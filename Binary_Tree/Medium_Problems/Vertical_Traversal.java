import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

import java.util.TreeSet;
import java.util.TreeSet;
import java.util.TreeSet;
import javax.swing.Painter;

class Tree {
    int data;
    Tree left, right;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    Tree num1;
    int x, y;

    public Pair(Tree num1, int x, int y) {
        this.num1 = num1;
        this.x = x;
        this.y = y;
    }
}


public class Vertical_Traversal {

    static List<List<Integer>> traversal(Tree root){
        
        // Map to store nodes based on
        // vertical and level information
       // Map to store nodes based on vertical and level information
        Map<Integer, Map<Integer, TreeSet<Integer>>> nodes = new TreeMap<>();


         // Queue for BFS traversal
        Queue<Pair> todo = new LinkedList<>();
        todo.add(new Pair(root, 0, 0));

        // Push the root node with initial vertical
        // and level values (0, 0)
        todo.add(new Pair(root, 0, 0));

        while(!todo.isEmpty()){
            // Retrieve the node and its vertical/level info
            Pair p = todo.poll();
            Tree temp = p.num1;
            int x = p.x; // Vertical position
            int y = p.y; // Level

             // Insert node value into the map
            nodes.computeIfAbsent(x, k -> new TreeMap<>())
            .computeIfAbsent(y, k -> new TreeSet<>())
            .add(temp.data);

            
            //Process the left child
            if(temp.left != null){
                todo.add(new Pair(temp.left, x-1, y+1));
            }

            // Process right child
            if(temp.right != null){
                todo.add(new Pair(temp.right, x+1, y+1));
            }
        }

        // Prepare the final result list
        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, TreeSet<Integer>> levelMap : nodes.values()) {
            List<Integer> col = new ArrayList<>();
            for (TreeSet<Integer> set : levelMap.values()) {
                col.addAll(set);
            }
            ans.add(col);
        }
        return ans;
        
    }
    public static void main(String[] args) {
        Tree root2 = new Tree(3);
        root2.left = new Tree(9);
        root2.right = new Tree(20);
        root2.right.left = new Tree(15);
        root2.right.right = new Tree(7);
        root2.left.right = new Tree(6);
        root2.left.right.left= new Tree(7);


        List<List<Integer>> result = traversal(root2);
        System.out.println(result);
    }
}

