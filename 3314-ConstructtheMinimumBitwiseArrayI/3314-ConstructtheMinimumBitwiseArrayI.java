// Last updated: 1/21/2026, 12:41:56 AM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int n = nums.size();
4        int[] ans = new int[n];
5        
6        for (int i = 0; i < n; i++) {
7            int x = nums.get(i);
8            if (x == 2) {
9                ans[i] = -1;
10            } else {
11                int bit = (x + 1) & -(x + 1);
12                ans[i] = x - (bit >> 1);
13            }
14        }
15        return ans;
16    }
17}