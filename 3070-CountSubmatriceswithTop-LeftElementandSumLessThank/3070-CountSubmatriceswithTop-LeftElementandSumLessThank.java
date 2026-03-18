// Last updated: 3/19/2026, 12:41:19 AM
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int row = grid.length;
4        int col = grid[0].length;
5        int res = 0;
6
7        for (int i = 0; i < row; i++) {
8            for (int j = 0; j < col; j++) {
9                if (i > 0)
10                    grid[i][j] += grid[i - 1][j];
11                if (j > 0)
12                    grid[i][j] += grid[i][j - 1];
13                if (i > 0 && j > 0)
14                    grid[i][j] -= grid[i - 1][j - 1];
15
16                if (grid[i][j] <= k)
17                    res++;
18                else
19                    break;
20            }
21        }
22
23        return res;
24    }
25}