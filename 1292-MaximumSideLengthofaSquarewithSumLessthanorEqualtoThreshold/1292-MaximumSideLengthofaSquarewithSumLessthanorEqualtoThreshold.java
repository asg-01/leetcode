// Last updated: 1/19/2026, 6:07:56 AM
1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3
4        // Binary search solution
5        
6        int numRows = mat.length;
7        int numCols = mat[0].length;
8        
9        // First, calculate the prefix sum matrix
10        int[][] prefixSum = new int[numRows + 1][numCols + 1];
11        // add padding so that edge cases are dealt with more smoothly.
12        // we keep the prefixSum of mat[0][0] at prefixSum[1][1] and so on
13        
14        for (int r = 1; r <= numRows; r++) {
15            for (int c = 1; c <= numCols; c++) {
16                prefixSum[r][c] = prefixSum[r - 1][c] + prefixSum[r][c-1] - prefixSum[r-1][c-1] + mat[r-1][c-1];
17            }
18        }
19        
20        int lower = 0;
21        int upper = Math.min(numRows, numCols) - 1;
22        // size = number of extended columns
23        
24        // Use binary search to guess the size 
25        while (lower <= upper) {
26            int size = lower + (upper - lower)/2;
27            // r and c of prefix sum matrix
28            int minSumSubMat = Integer.MAX_VALUE;
29            
30            // With the current size, find the smallest sum starting from different places in the matrix
31            for (int r = 1; r + size <= numRows; r++) {
32                for (int c = 1; c + size <= numCols; c++) {
33                   int sumSubMat = prefixSum[r + size][c + size] - 
34                        prefixSum[r-1][c + size] - 
35                        prefixSum[r + size][c - 1] + 
36                        prefixSum[r-1][c-1];
37                    // the added part is subtracted twice
38                    if (sumSubMat < minSumSubMat) minSumSubMat = sumSubMat;
39                }
40            }
41            
42            if (minSumSubMat <= threshold) {
43                lower = size + 1;
44            } else {
45                upper = size - 1;
46            }
47        }
48        
49        return lower;
50    }
51}