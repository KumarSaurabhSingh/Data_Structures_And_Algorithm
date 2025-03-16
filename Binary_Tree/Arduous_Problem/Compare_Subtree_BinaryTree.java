
class TreeNode{
    int val;
    TreeNode left, right;

    public TreeNode(int val){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Compare_Subtree_BinaryTree {

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null){
            return false;
        }

        if(isSame (root, subRoot)){ //The root head is the subroot's head
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    public boolean isSame(TreeNode s, TreeNode t){

        if(s == null && t == null){
            return true;
        }
        
        if(s == null || t == null){
            return false;
        }

        if(s.val != t.val){
            return false;
        }

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    
}
