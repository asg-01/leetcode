// Last updated: 3/6/2026, 2:30:04 AM
1public class Solution {
2    public int minOperations(String s) {
3        int ans = 0;
4        for (int i = 0; i < s.length(); ++i) {
5            if (i % 2 == 0 && s.charAt(i) != '1') {
6                ans += 1;
7            } else if (i % 2 == 1 && s.charAt(i) != '0') {
8                ans += 1;
9            }
10        }
11        return Math.min(ans, s.length() - ans);
12    }
13}