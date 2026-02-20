// Last updated: 2/21/2026, 1:58:39 AM
1class Solution {
2    public void sortColors(int[] nums) {
3        HashMap<Integer, Integer> count = new HashMap<>();
4        count.put(0, 0);
5        count.put(1, 0);
6        count.put(2, 0);
7
8        for (int num : nums) {
9            count.put(num, count.get(num) + 1);
10        }
11
12        int idx = 0;
13        for (int color = 0; color < 3; color++) {
14            int freq = count.get(color);
15            for (int j = 0; j < freq; j++) {
16                nums[idx] = color;
17                idx++;
18            }
19        }        
20    }
21}