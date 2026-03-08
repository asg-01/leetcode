// Last updated: 3/9/2026, 2:59:24 AM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String t = s + s;
5
6        int ans = n;
7        int mis0 = 0;
8
9        for(int i = 0; i < 2*n; i++){
10
11            char expected = (i % 2 == 0) ? '0' : '1';
12
13            if(t.charAt(i) != expected) mis0++;
14
15            if(i >= n){
16                int left = i - n;
17                char expLeft = (left % 2 == 0) ? '0' : '1';
18                if(t.charAt(left) != expLeft) mis0--;
19            }
20
21            if(i >= n - 1){
22                int mis1 = n - mis0;
23                ans = Math.min(ans, Math.min(mis0, mis1));
24            }
25        }
26
27        return ans;
28    }
29}