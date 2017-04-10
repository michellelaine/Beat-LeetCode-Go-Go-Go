//BFS Time: O(n), Space: O()
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur;
        
        queue.offerLast(root);
        
        while(!queue.isEmpty()) {
           // List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                cur = queue.pollFirst();
                if(i == 0) {
                    result.add(cur.val);
                }
                if(cur.right != null){
                    queue.offerLast(cur.right);
                }
                if(cur.left != null) {
                    queue.offerLast(cur.left);
                }
            }
            
        }
        return result;
    }
    //DFS
    //Time: O(n), Space: O(n)
public class Solution {
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
}
