// Last updated: 1/22/2026, 1:48:00 AM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int[] ans = new int[nums.size()];
4
5        for (int i = 0; i < nums.size(); i++) {
6            int num = nums.get(i);
7
8            if (num == 2) {
9                ans[i] = -1;
10                continue;
11            }
12
13            int numCopy = num;
14            int count = 0;
15
16            // Count consecutive 1s from the right
17            while ((num & 1) == 1) {
18                count++;
19                num >>= 1;
20            }
21
22            // [count]th bit is the position of the last 1, like 100111 (count = 3)
23            // Subtract the bit                                     ^
24            ans[i] = numCopy - (1 << (count - 1));
25        }
26
27        return ans;
28    }
29}