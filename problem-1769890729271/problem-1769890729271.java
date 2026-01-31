// Last updated: 2/1/2026, 1:48:49 AM
1class Solution {
2    public char nextGreatestLetter(char[] a, char x) {
3        int n = a.length;
4       
5        if (x >= a[n - 1])   x = a[0];
6        else    x++;
7        
8        int lo = 0, hi = n - 1;
9        while (lo < hi) {
10            int mid = lo + (hi - lo) / 2;
11            if (a[mid] == x)    return a[mid];
12            if (a[mid] < x)     lo = mid + 1;
13            else    hi = mid;
14        }
15        return a[hi];
16    }
17}