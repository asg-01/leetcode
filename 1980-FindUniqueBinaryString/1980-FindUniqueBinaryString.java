// Last updated: 3/9/2026, 3:02:24 AM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        StringBuilder sb = new StringBuilder();
4
5        for(int i=0;i<nums.length;i++)
6        {
7            sb.append(nums[i].charAt(i) == '0'? "1": "0");
8        }
9        return new String(sb);
10    }
11}