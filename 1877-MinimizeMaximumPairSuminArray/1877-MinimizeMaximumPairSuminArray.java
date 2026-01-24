// Last updated: 1/25/2026, 3:54:47 AM
1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);
4        int max = 0;
5        int i = 0;
6        int j = nums.length - 1;
7        while(i < j){
8            max = Math.max(max, (nums[i++] + nums[j--]));
9        }
10        return max;
11    }
12}