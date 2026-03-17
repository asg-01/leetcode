// Last updated: 3/18/2026, 1:36:55 AM
1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int row = matrix.length;
4        int col = matrix[0].length;
5
6        // Calculate heights for each column
7        for (int i = 1; i < row; i++) {
8            for (int j = 0; j < col; j++) {
9                if (matrix[i][j] == 1) {
10                    matrix[i][j] += matrix[i - 1][j];
11                }
12            }
13        }
14
15        int res = 0;
16        for (int i = 0; i < row; i++) {
17            // Sort the heights in ascending order
18            Arrays.sort(matrix[i]);
19
20            // Iterate through the sorted heights
21            for (int j = 0; j < col; j++) {
22                int height = matrix[i][j];
23                int width = col - j;
24                res = Math.max(res, height * width);
25            }
26        }
27
28        return res;        
29    }
30}