// Last updated: 2/2/2026, 2:15:42 AM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int sum=nums[0],min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
4        for(int i=1;i<nums.length;i++)
5        {
6            if(nums[i]<min1)
7            {
8                min2=min1;
9                min1=nums[i];
10            }
11            else if(nums[i]<min2)
12            {
13                min2=nums[i];
14            }
15        }
16        return sum+min1+min2;
17    }
18}