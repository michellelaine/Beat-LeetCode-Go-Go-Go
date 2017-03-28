public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        //List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++) {
            //avoid duplicate
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            //twoSum(nums, target,list, result, left, right);
            twoSum(nums, target, result, left, right);

        }
        
        return result;
    }
    
    private void twoSum(int[] nums, int target, List<List<Integer>> result, int left, int right) {
        // int left = 0;
        // int right = nums.length - 1;
        
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(-target);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                
                left++;
                right--;
                //avoid duplicate
                while(left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while(left < right && nums[right] == nums[right + 1]) {
                    right --;
                }
            } else if(nums[left] + nums[right] > target) {
                right--;
            }else {
                left++;
            }
        }
    }
}
