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
