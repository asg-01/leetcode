// Last updated: 3/15/2026, 1:59:33 AM
1class Solution {
2    int n2;
3    public String getHappyString(int n, int k) {
4        n2 = n;
5        return dfs(new StringBuilder(), n, k);
6    }
7    public String dfs(StringBuilder prefix, int n, int k){
8        if (n == 0)
9            return prefix.toString();
10        for (char c = 'a'; c <= 'c'; c++) {
11            if (prefix.length() > 0 && c == prefix.charAt(prefix.length() - 1))
12                continue;
13            int cnt = (int) Math.pow(2, n2 - prefix.length() - 1);
14            if (cnt >= k)
15                return dfs(prefix.append(c), n - 1, k);
16            else
17                k -= cnt;
18        }
19        return "";
20    }
21}