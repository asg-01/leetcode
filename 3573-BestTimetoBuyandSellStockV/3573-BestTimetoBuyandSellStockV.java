// Last updated: 12/18/2025, 12:12:26 AM
1class Solution {
2    long[][][] dp;
3    int[] prices;
4    long mn = (long)-1e14;
5
6    public long f(int i, int k, int state) {
7        if (i == prices.length) {
8            return (state == 0) ? 0 : mn;
9        }
10        if (dp[i][k][state] != mn) return dp[i][k][state];
11
12        long p = prices[i];
13        long profit = mn;
14
15        // 1) do nothing today
16        profit = Math.max(profit, f(i + 1, k, state));
17
18        // 2) take action
19        if (state == 0) {
20            profit = Math.max(profit, f(i + 1, k, 1) - p); // buy
21            profit = Math.max(profit, f(i + 1, k, 2) + p); // sell
22        } else if (k > 0) {
23            if (state == 1) {
24                profit = Math.max(profit, f(i + 1, k - 1, 0) + p); // sell to end a buy-sell
25            } else {
26                profit = Math.max(profit, f(i + 1, k - 1, 0) - p); // buy to end a sell-buy
27            }
28        }
29
30        return dp[i][k][state] = profit;
31    }
32
33    public long maximumProfit(int[] prices, int k) {
34        this.prices = prices;
35        int n = prices.length;
36        dp = new long[n + 1][k + 1][3];
37        for (long[][] twoD : dp)
38            for (long[] oneD : twoD)
39                Arrays.fill(oneD, mn);
40
41        return f(0, k, 0);
42    }
43}