// Last updated: 12/19/2025, 2:58:38 AM
1class Solution {
2    public long maxProfit(int[] prices, int[] strat, int k) {
3        int n = prices.length;
4        int h = k / 2;
5        long[] sp = new long[n];
6        long base = 0;
7        for (int i = 0; i < n; i++) {
8            sp[i] = (long)strat[i] * prices[i];
9            base += sp[i];
10        }
11
12        if (n == k) {
13            long winOrig = base;
14            long winMod = 0;
15            for (int i = h; i < n; i++) winMod += prices[i];
16            long change = winMod - winOrig;
17            return base + Math.max(0, change);
18        }
19
20        long winOrig = 0;
21        for (int i = 0; i < k; i++) winOrig += sp[i];
22
23        long winMod = 0;
24        for (int i = h; i < k; i++) winMod += prices[i];
25
26        long maxCh = winMod - winOrig;
27
28        for (int i = 1; i <= n - k; i++) {
29            winOrig += sp[i + k - 1] - sp[i - 1];
30            winMod += prices[i + k - 1] - prices[i - 1 + h];
31            maxCh = Math.max(maxCh, winMod - winOrig);
32        }
33
34        return base + Math.max(0, maxCh);
35    }
36}
37