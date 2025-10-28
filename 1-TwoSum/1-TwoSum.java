// Last updated: 10/29/2025, 3:08:43 AM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
            for (int i = 0;i <nums.length;i++){
                for (int j = i+1; j < nums.length;j++){
                    if (nums[i] + nums[j] == target){
                        return new int []{i,j};
                    }
                }
            }
            // if no valid pair then end
            return new int[]{};
        }
}