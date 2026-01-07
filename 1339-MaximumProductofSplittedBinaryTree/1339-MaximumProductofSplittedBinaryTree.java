// Last updated: 1/7/2026, 7:38:58 PM
1class Solution {
2    long totalSum = 0;
3    long maxProd = 0;
4    static final int MOD = 1_000_000_007;
5
6    private void dfsTotal(TreeNode root) {
7        if (root == null) return;
8        totalSum += root.val;
9        dfsTotal(root.left);
10        dfsTotal(root.right);
11    }
12
13    private long dfs(TreeNode root) {
14        if (root == null) return 0;
15
16        long left = dfs(root.left);
17        long right = dfs(root.right);
18
19        long subSum = left + right + root.val;
20        maxProd = Math.max(maxProd, subSum * (totalSum - subSum));
21
22        return subSum;
23    }
24
25    public int maxProduct(TreeNode root) {
26        dfsTotal(root);
27        dfs(root);
28        return (int)(maxProd % MOD);
29    }
30}