class Tree{
    int data;
    Tree left;
    Tree right;

    public Tree(int data, Tree left, Tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

//Time Complexity - O(N)
//Space Complexity - O(N)
public class Identical_Trees {

    static Boolean checkIfsame(Tree p, Tree q){
        if(p == null && q==null){
            return p==q;
        }

        return (p.data == q.data) && checkIfsame(p.left, q.left) && checkIfsame(p.right, q.right);
    }
    

    public static void main(String[] args) {
        // Creating a sample binary tree
        Tree root = new Tree(3);
        root.left = new Tree(9);
        root.right = new Tree(20);
        root.right.left = new Tree(15);
        root.right.right = new Tree(7);
        root.left.right = new Tree(6);
        root.left.right.left= new Tree(7);

        //Second Tree
        // Creating a sample binary tree
        Tree root2 = new Tree(3);
        root2.left = new Tree(9);
        root2.right = new Tree(20);
        root2.right.left = new Tree(15);
        root2.right.right = new Tree(7);
        root2.left.right = new Tree(6);
        root2.left.right.left= new Tree(7);

        Boolean ischeck = checkIfsame(root, root2);

        System.out.println("Maximum depth of the binary tree: " + ischeck);
    }
}
