// Last updated: 2/24/2026, 8:47:34 PM
1class Solution {
2    public int ans = 0;
3    
4    public void search(TreeNode node, int pre) {
5        if (node.left == null && node.right == null) // node is a leaf node, return the sum of path from root to node
6            // this.ans += pre << 1 | node.val; // also work
7            this.ans += pre * 2 + node.val; 
8            
9        if (node.left != null) // node.left is not None, recursively find the sum node to leaf
10            // search(node.left, pre << 1 | node.val); // also work
11            search(node.left, pre * 2 + node.val);
12        
13        if (node.right != null) // node.right is not None, recursively find the sum node to leaf
14            // search(node.right, pre << 1 | node.val); // also work
15            search(node.right, pre * 2 + node.val);
16    }
17    
18    public int sumRootToLeaf(TreeNode root) {
19        search(root, 0);
20        return this.ans;
21    }
22}