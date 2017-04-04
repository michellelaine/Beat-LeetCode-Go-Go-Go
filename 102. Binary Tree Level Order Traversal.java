public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur;
        
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                cur = q.poll();
                list.add(cur.val);
                
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            result.add(list);
        }
        return result;
}
