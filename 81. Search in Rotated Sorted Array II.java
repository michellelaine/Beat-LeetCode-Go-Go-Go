public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            
            if(nums[mid] == target) {
                
            }
            if(nums[mid] > nums[start]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if(nums[mid] < nums[start]){
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
                
            }else {
                start++;
            }
        }
        if(nums[start] == target || nums[end] == target){
            return true;
        }
        return false;
    }
}
