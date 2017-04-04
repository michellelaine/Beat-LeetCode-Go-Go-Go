public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        if(root.left == null && root.right == null){
            // if(sum - root.val == 0){
            //     return true;
            // }
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        //return false;
    }
}
