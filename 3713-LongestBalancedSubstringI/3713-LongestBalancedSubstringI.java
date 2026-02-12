// Last updated: 2/12/2026, 9:08:23 AM
1import java.util.*;
2
3class Solution {
4    public boolean solve(HashMap<Character, Integer> mp) {
5        int mini = Integer.MAX_VALUE, maxi = 0;
6        for (int val : mp.values()) {
7            mini = Math.min(mini, val);
8            maxi = Math.max(maxi, val);
9        }
10        return mini == maxi;
11    }
12
13    public int longestBalanced(String s) {
14        int n = s.length();
15        int ans = 0;
16        for (int i = 0; i < n; i++) {
17            HashMap<Character, Integer> mp = new HashMap<>();
18            for (int j = i; j < n; j++) {
19                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
20                if (solve(mp)) {
21                    int l = j - i + 1;
22                    ans = Math.max(ans, l);
23                }
24            }
25        }
26        return ans;
27    }
28}
29