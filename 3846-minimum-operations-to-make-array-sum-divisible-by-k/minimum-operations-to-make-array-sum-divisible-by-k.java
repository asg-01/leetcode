class Solution {
    public int minOperations(int[] nums, int k) {
        int total_sum = 0;
        for (int i = 0; i < nums.length; i++){
            total_sum += nums[i];
        }
        
        return total_sum % k;
    }
}