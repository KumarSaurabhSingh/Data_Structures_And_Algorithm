import java.util.ArrayList;
import java.util.List;

class Tree{

    int data;
    Tree left, right;

    public Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Left_View {

    void recursionLeft(Tree root, int level, List<Integer> res){

        if(root == null){
            return;
        }

        if(res.size() == level){

            res.add(root.data);

            recursionLeft(root.left, level+1, res);

            recursionLeft(root.right, level+1, res);
        }
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

        List<Integer> res = new ArrayList<>();

        
        Left_View obj = new Left_View();
        obj.recursionLeft(root, 0, res);

        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
