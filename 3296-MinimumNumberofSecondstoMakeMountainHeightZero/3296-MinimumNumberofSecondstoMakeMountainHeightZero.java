// Last updated: 3/14/2026, 1:59:18 AM
1class Solution {
2    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
3        long low = 1, high = (long) 1e18, result = high;
4        
5        while (low <= high) {
6            long mid = (low + high) / 2;
7            
8            if (canReduceMountain(mountainHeight, workerTimes, mid)) {
9                result = mid;
10                high = mid - 1;
11            } else {
12                low = mid + 1;
13            }
14        }
15        
16        return result;
17    }
18    
19    private boolean canReduceMountain(int mountainHeight, int[] workerTimes, long maxTime) {
20        long totalReduction = 0;
21        
22        for (int time : workerTimes) {
23            long low = 1, high = mountainHeight;
24            
25            while (low <= high) {
26                long mid = (low + high) / 2;
27                long cost = (mid * (mid + 1)) / 2 * time;
28                
29                if (cost <= maxTime) {
30                    low = mid + 1;
31                } else {
32                    high = mid - 1;
33                }
34            }
35            
36            totalReduction += high;
37            if (totalReduction >= mountainHeight) {
38                return true;
39            }
40        }
41        
42        return totalReduction >= mountainHeight;
43    }
44}