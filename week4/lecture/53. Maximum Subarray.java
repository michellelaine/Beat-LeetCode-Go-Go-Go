public class Solution {
    public int maxSubArray(int[] nums) {
    //     if(nums == null || nums.length == 0){
    //         return 
    // }
        int maxSum = nums[0];
        int lastSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            lastSum = Math.max(lastSum + nums[i], nums[i]);
            maxSum = Math.max(lastSum, maxSum);
        }
        return maxSum;
    }
}
