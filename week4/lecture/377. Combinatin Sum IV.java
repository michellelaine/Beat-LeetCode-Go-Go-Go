public class Solution {
    //memerized Search
    /*public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target + 1];
        Arrays.fill(count, -1);
        count[0] = 1;
        helper(nums, target, count);
        return count[target];
    }
    
    public int helper(int[] nums, int remain, int[] count) {
        //base case
        if(count[remain] != -1) {
            return count[remain];
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(remain >= nums[i]) {
                res += helper(nums, remain - nums[i], count);
            }
        }
        count[remain] = res;
        return res;
    }*/
    
    //DP
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target + 1];
        count[0] = 1;
        
        for(int i = 1; i < count.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0) {
                    count[i] += count[i - nums[j]];
                }
            }
        }
        return count[target];
    }
}
