// Last updated: 3/22/2026, 5:52:19 AM
1class Solution {
2    public boolean findRotation(int[][] a, int[][] b) {
3       
4
5         int n=a.length;
6      int c90=0,c180=0,c270=0,c0=0;
7        for(int i=0;i<n;i++)
8        {
9            for(int j=0;j<n;j++)
10            {
11                if(b[i][j]==a[n-j-1][i])
12                    c90++;
13                if(b[i][j]==a[n-i-1][n-j-1])
14                    c180++;
15                if(b[i][j]==a[j][n-i-1])
16                    c270++;
17                if(b[i][j]==a[i][j])
18                    c0++;
19            }
20        }
21        
22        if(c90==n*n||c270==n*n||c180==n*n||c0==n*n)
23        return true;
24        else return false;
25        
26    }
27}
28
29
30