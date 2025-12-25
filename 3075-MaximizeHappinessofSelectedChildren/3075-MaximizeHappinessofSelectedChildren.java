// Last updated: 12/26/2025, 1:01:14 AM
1import java.util.Arrays;
2
3public class Solution {
4    public long maximumHappinessSum(int[] v, int k) {
5        Arrays.sort(v);
6        long ans = 0;
7        int n = v.length - 1;
8        int c = 0;
9        while (n >= 0 && k > 0) {
10            if (v[n] - c >= 0) {
11                ans += v[n] - c;
12            } else {
13                break;
14            }
15            c++;
16            n--;
17            k--;
18        }
19        return ans;
20    }
21}
22