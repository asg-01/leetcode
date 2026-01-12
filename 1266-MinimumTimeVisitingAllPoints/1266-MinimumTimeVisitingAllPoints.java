// Last updated: 1/12/2026, 4:05:02 PM
1class Solution {
2    
3    public int toTime(int[] from, int[] to) {
4        int xDiff = Math.abs(from[0] - to[0]);
5        int yDiff = Math.abs(from[1] - to[1]);
6        
7        return Math.max(xDiff, yDiff);
8    }
9    
10    public int minTimeToVisitAllPoints(int[][] points) {
11        int time = 0;
12    
13        for (int i = 1; i < points.length; i++) {
14            time += toTime(points[i - 1], points[i]);
15        }
16        
17        return time;
18    }
19}
20