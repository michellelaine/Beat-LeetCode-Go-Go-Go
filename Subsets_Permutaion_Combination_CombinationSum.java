    //subsets I Time: O(2^n),Space: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> set = new ArrayList<Integer>();
        Arrays.sort(nums);
       // int pos = 0;
        subsetsHelper(nums, res, set, 0);
        return res;
    }
    
    private void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> set, int pos) {
        
        res.add(new ArrayList<Integer>(set));
        
        for(int i = pos; i < nums.length; i++) {
            set.add(nums[i]);
            subsetsHelper(nums, res, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

    //subsets II：contain duplicates
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> set = new ArrayList<>();
        
        Arrays.sort(nums);
        backtrack(nums, result, set, 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> set, int pos ){
        result.add(new ArrayList<Integer>(set));
        
        for(int i = pos; i < nums.length; i++){
            if(i > pos && nums[i] == nums[i - 1]){
                continue;
            }
            set.add(nums[i]);
            backtrack(nums, result, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

    //combinations
     public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(n, k, result, list, 1);
        return result;
    }
    
    private void backtrack(int n, int k, List<List<Integer>> result, List<Integer> list, int pos){
        if(list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return result;
        }
        
        for(int i = pos; i<= n; i++){
            list.add(i);
            backtrack(n, k, result, list, i + 1);
            //result.add(list);
            list.remove(list.size() - 1);
        }
    } 

    //combination sum I
    /*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    For example, If n = 4 and k = 2, a solution is:[ [2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]*/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, result, list, 0);
        return result;
    }
    
    private void backtrack(int[] candidates, int sum, List<List<Integer>> result, List<Integer> list, int pos){
        if(sum < 0) {
            return ; 
        }
        if(sum == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        
        for(int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, sum - candidates[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }
    //or
   {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combination.add(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
    //***************************************************************************************************
    //Combination sum II: contains duplicates
    public List<List<Integer>> combinationSum2(int[] candidates, int target) { 
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, result, list, 0);
        return result;
    }
    private void backtrack(int[] candidates, int sum, List<List<Integer>> result, List<Integer> list, int pos) {
        if(sum < 0) {
            return ;
        }
        if(sum == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        for(int i = pos; i < candidates.length; i++) {
            if(i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, sum - candidates[i], result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    //or
    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, target - candidates[i], results);
            combination.remove(combination.size() - 1);
        }
    }
    //**********************************************************************************************************
    //combination sum III: k's numbers' sum = n, 
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //n is the target 
        backtrack(k, n, result, list, 1);
        return result;
    }
    
    private void backtrack(int k, int remain, List<List<Integer>> result, List<Integer> list, int start) {
        if(remain < 0 || list.size() > k) {
            return ;
        }
        if(remain == 0 && list.size() == k) {
            result.add(new ArrayList<Integer>(list));
        }
        
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(k, remain - i, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }



    /*permutation
      Given a collection of distinct numbers, return all possible permutations.
      For example, [1,2,3] have the following permutations:
      [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]*/

    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0 || nums == null) {
                return result;
            }
            List<Integer> list =new ArrayList<>();
            permuteHelper(nums, result, list);
            return result;
        }
        
    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> list) {
            if(list.size() == nums.length) {
                result.add(new ArrayList<Integer>(list));
            }
            
            for (int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                permuteHelper(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    //*********************************************************************************************
    //Permutation II: Time:O(n!) Space:O(n)
    /*Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    For example,[1,1,2] have the following unique permutations:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]*/

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0 || nums == null) {
            return result;
        }
            
        Arrays.sort(nums);
            
        List<Integer> list = new ArrayList<Integer>();
            
        int[] visited = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            visited[i] = 0;
        }//not visit yet
            
        helper(nums, result, list, visited);
        return result;
    }
        
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1 || (i!= 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(nums, result, list, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }















