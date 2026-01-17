// Last updated: 1/18/2026, 3:09:21 AM
1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        Arrays.sort(hBars);
4        Arrays.sort(vBars);
5
6        int maxiH = 1, maxiV = 1, maxi = 1;
7
8        for (int i = 1; i < hBars.length; i++) {
9            if (hBars[i] == hBars[i - 1] + 1) {
10                maxi++;
11            } else {
12                maxiH = Math.max(maxiH, maxi);
13                maxi = 1;
14            }
15        }
16        maxiH = Math.max(maxiH, maxi);
17
18        maxi = 1;
19
20        for (int i = 1; i < vBars.length; i++) {
21            if (vBars[i] == vBars[i - 1] + 1) {
22                maxi++;
23            } else {
24                maxiV = Math.max(maxiV, maxi);
25                maxi = 1;
26            }
27        }
28        maxiV = Math.max(maxiV, maxi);
29
30        int side = Math.min(maxiH+1, maxiV+1);
31        return side * side;
32    }
33}