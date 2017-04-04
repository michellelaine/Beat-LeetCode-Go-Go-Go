public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        pathSumHelper(root, sum, list, result);
        return result;
    }
    
    private void pathSumHelper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if(root == null) {
            return ;
        } 
        
        sum -= root.val;
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == 0) {
            //list.add(root.val);
            result.add(new ArrayList<Integer>(list));
        }else {
            pathSumHelper(root.left, sum, list, result);
            pathSumHelper(root.right, sum, list, result);
        }
        list.remove(list.size() - 1);
        
    }
