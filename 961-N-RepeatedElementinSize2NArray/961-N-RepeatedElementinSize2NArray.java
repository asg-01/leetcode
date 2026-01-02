// Last updated: 1/3/2026, 12:25:25 AM
1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        int n = nums.length - 1;
4        if(nums[0] == nums[n]) return nums[0];
5        for(int i = 0; i < n; i++) {
6            if(nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) return nums[i];
7        }
8        return nums[0];
9    }
10}