import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Tree{
    int data;
    Tree left;
    Tree right;

    public Tree(int data){
        this.data = data;
        this.left = null;
        this.right =null;
    }

    public Tree(int data, Tree left, Tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class Boundary_Traversal {

    //Methond to find the left Boundary
    static void leftBoundary(Tree root, List<Integer> list){
        Tree curr = root.left;
        while(curr != null){
            if (curr.left != null || curr.right != null) { // Exclude leaf nodes
                list.add(curr.data);
            }

            if(curr.left != null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }


    // Method to find the leaf boundary (recursive)
    static void leafBoundary(Tree root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) { // Add only leaf nodes
            list.add(root.data);
            return;
        }
        leafBoundary(root.left, list);
        leafBoundary(root.right, list);
    }


    // Method to find the right boundary (excluding leaf nodes)
    static void rightBoundary(Tree root, List<Integer> list) {
        Tree curr = root.right;
        Stack<Integer> stack = new Stack<>();
        while (curr != null) {
            if (curr.left != null || curr.right != null) { // Exclude leaf nodes
                stack.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!stack.isEmpty()) { // Add in reverse order
            list.add(stack.pop());
        }
    }


    static List<Integer> printBoundary(Tree root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // Add root node (if it's not a leaf)
        if (root.left != null || root.right != null) {
            res.add(root.data);
        }

        leftBoundary(root, res);
        leafBoundary(root, res);
        rightBoundary(root, res);

        return res;
    }

    
    public static void main(String[] args) {
        Tree root2 = new Tree(3);
        root2.left = new Tree(9);
        root2.right = new Tree(20);
        root2.right.left = new Tree(15);
        root2.right.right = new Tree(7);
        root2.left.right = new Tree(6);
        root2.left.right.left= new Tree(7);

        List<Integer> ischeck = printBoundary(root2);

        printResult(ischeck);
    }

    static void printResult(List<Integer> ans){
        for(Integer i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
