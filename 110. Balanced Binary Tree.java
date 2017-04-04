//Method 1: Time:O(n),Space: O(n)
public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    private int maxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        // int left = maxDepth(root.left) + 1;
        // int right = maxDepth(root.right) + 1;
        // return Math.max(left, right);
        return Math.max((maxDepth(root.left) + 1), (maxDepth(root.right) + 1));
    }

//Method 2: Time:O(n),Space: O(n)
    public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
