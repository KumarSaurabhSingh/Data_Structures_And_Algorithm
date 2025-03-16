// import java.lang.classfile.constantpool.IntegerEntry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

//Time Complexity - O(N)
//Space Complexity - O(N)
public class Zig_Zag_Traversal {

    static List<List<Integer>> traversal(Tree root){
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Tree> q = new LinkedList<>();
        q.add(root);

        Boolean leftOrRight = true;

        while(!q.isEmpty()){

            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();

            for(int i =0; i<size; i++){

                Tree top = q.poll(); //peek the top element

                if(leftOrRight){
                    list.addFirst(top.data);
                }else{
                    list.addLast(top.data);
                }

                if(top.left != null){
                    q.add(top.left);
                }

                if(top.right != null){
                    q.add(top.right);
                }
            }

            leftOrRight =! leftOrRight;

            ans.add(list);
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

        List<List<Integer>> ischeck = traversal(root2);

        printResult(ischeck);
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
