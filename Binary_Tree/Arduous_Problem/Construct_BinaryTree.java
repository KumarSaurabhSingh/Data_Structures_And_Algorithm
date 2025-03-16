import java.util.HashMap;

class TreeNode{
    int data;
    TreeNode left, right;

    public TreeNode(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class Construct_BinaryTree {
    private int postindex;
    private HashMap<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int inorderLength = inorder.length;
        postindex = postorder.length - 1;
        inorderMap = new HashMap<>();

        for(int i=0; i< inorderLength; i++){
            inorderMap.put(inorder[i], i);
        }

        return TreeBuilder(postorder, 0, inorderLength-1);
    }

    public TreeNode TreeBuilder(int[] postorder, int start, int end){

        if(start > end){
            return null;
        }

        int temp = postorder[postindex--];
        TreeNode root = new TreeNode(temp);

        int inOrderIndx = inorderMap.get(temp);

        root.right = TreeBuilder(postorder, inOrderIndx + 1, end);
        root.left = TreeBuilder(postorder, start, inOrderIndx -1);

        return root;

    }
}
