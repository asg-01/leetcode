// Last updated: 2/13/2026, 6:21:46 PM
1class Solution {
2    public int longestBalanced(String s) {
3        char[] cs = s.toCharArray();
4        int x = calc1(cs);
5        int y = Math.max(calc2(cs, 'a', 'b'), Math.max(calc2(cs, 'b', 'c'), calc2(cs, 'a', 'c')));
6        int z = calc3(cs);
7        return Math.max(x, Math.max(y, z));
8    }
9
10    private int calc1(char[] s) {
11        int res = 0;
12        int i = 0, n = s.length;
13        while (i < n) {
14            int j = i + 1;
15            while (j < n && s[j] == s[i]) {
16                j++;
17            }
18            res = Math.max(res, j - i);
19            i = j;
20        }
21        return res;
22    }
23
24    private int calc2(char[] s, char a, char b) {
25        int res = 0;
26        int i = 0, n = s.length;
27        while (i < n) {
28            while (i < n && s[i] != a && s[i] != b) {
29                i++;
30            }
31            Map<Integer, Integer> pos = new HashMap<>();
32            pos.put(0, i - 1);
33            int d = 0;
34            while (i < n && (s[i] == a || s[i] == b)) {
35                d += (s[i] == a) ? 1 : -1;
36                Integer prev = pos.get(d);
37                if (prev != null) {
38                    res = Math.max(res, i - prev);
39                } else {
40                    pos.put(d, i);
41                }
42                i++;
43            }
44        }
45        return res;
46    }
47
48    private int calc3(char[] s) {
49        Map<Long, Integer> pos = new HashMap<>();
50        pos.put(f(0, 0), -1);
51
52        int[] cnt = new int[3];
53        int res = 0;
54
55        for (int i = 0; i < s.length; i++) {
56            char c = s[i];
57            ++cnt[c - 'a'];
58            int x = cnt[0] - cnt[1];
59            int y = cnt[1] - cnt[2];
60            long k = f(x, y);
61
62            Integer prev = pos.get(k);
63            if (prev != null) {
64                res = Math.max(res, i - prev);
65            } else {
66                pos.put(k, i);
67            }
68        }
69        return res;
70    }
71
72    private long f(int x, int y) {
73        return (x + 100000) << 20 | (y + 100000);
74    }
75}