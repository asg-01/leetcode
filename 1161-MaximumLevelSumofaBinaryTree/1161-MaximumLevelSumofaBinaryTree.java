// Last updated: 1/6/2026, 3:12:40 PM
1
2class TreeNode {
3    int val;
4    TreeNode left;
5    TreeNode right;
6
7    TreeNode(int val) {
8        this.val = val;
9        this.left = null;
10        this.right = null;
11    }
12}
13
14class Solution {
15    public int maxLevelSum(TreeNode root) {
16        if (root == null) {
17            return 0;
18        }
19
20        Queue<TreeNode> queue = new LinkedList<>();
21        queue.add(root);
22        int maxLevel = 1;
23        int maxSum = Integer.MIN_VALUE;
24        int level = 1;
25
26        while (!queue.isEmpty()) {
27            int levelSum = 0;
28            int levelSize = queue.size();
29
30            for (int i = 0; i < levelSize; i++) {
31                TreeNode node = queue.poll();
32                levelSum += node.val;
33
34                if (node.left != null) {
35                    queue.add(node.left);
36                }
37                if (node.right != null) {
38                    queue.add(node.right);
39                }
40            }
41
42            if (levelSum > maxSum) {
43                maxSum = levelSum;
44                maxLevel = level;
45            }
46
47            level++;
48        }
49
50        return maxLevel;
51    }
52}