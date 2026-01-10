// Last updated: 1/10/2026, 9:46:29 PM
1class Solution {
2    public int minimumDeleteSum(String s1, String s2) {
3        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
4
5        for (int i = 1; i <= s1.length(); i++)
6            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
7        
8        for (int j = 1; j <= s2.length(); j++)
9            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
10        
11        for (int i = 1; i <= s1.length(); i++) {
12            for (int j = 1; j <= s2.length(); j++) {
13                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
14                    dp[i][j] = dp[i - 1][j - 1];
15                } else {
16                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
17                }
18            }
19        }
20        
21        return dp[s1.length()][s2.length()];
22    }
23}