public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        boolean isNormal = true;
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                cur = queue.poll();
                list.add(cur.val);
                
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                
            }
            if(!isNormal) {
                Collections.reverse(list);
            }
            isNormal = !isNormal;
            result.add(list);
        }
        return result;
    }
