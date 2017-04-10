public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    //each layer select the most right side node to add in result
    //compare depth == result.size()
    private void rightView(TreeNode cur, List<Integer> result, int curDepth){
        if(cur == null) {
            return ;
        }
        
        //current layer
        if(curDepth == result.size()){
            result.add(cur.val);
        }
        rightView(cur.right, result, curDepth + 1);
        rightView(cur.left, result, curDepth + 1);
       // rightHelper(root.left, result);
        
    }
