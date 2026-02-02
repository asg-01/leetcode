// Last updated: 2/3/2026, 2:36:49 AM
1class Solution {
2    public long minimumCost(int[] nums, int k, int dist) {
3        
4        long result = Long.MAX_VALUE, windowSum = 0l;
5        int n = nums.length;
6        TreeSet<Integer> using = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
7        TreeSet<Integer> waiting = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
8        
9        // Add dist + 1 num into the using set
10        for(int i = 1; i <= dist + 1; i++){
11            using.add(i);
12            windowSum += nums[i];
13        }
14        // We need only k - 1 nums, move others to waiting set because we might need them in the future
15        while(using.size() > k - 1){
16            int i = using.pollLast();
17            windowSum -= nums[i];
18            waiting.add(i);
19        }
20        // windowSum is the sum of k - 1 nums 
21        result = Math.min(result, windowSum);
22        for(int i = 1; i + dist + 1 < n; i++){
23            
24            // window slided so add new num to the waiting set
25            waiting.add(i + dist + 1);
26            
27            // i is the left most num in the window, will be removed from window
28                
29            if(using.contains(i)){
30                // i is one of the k - 1 num
31                // remove and update windowSum
32                // poll one num from waiting set and add
33                windowSum -= nums[i];
34                using.remove(i);
35                int j = waiting.pollFirst();
36                windowSum += nums[j];
37                using.add(j);
38            }else{
39                // i is not one of the k - 1 num, it is in the waiting set
40                // remove from waiting 
41                // check minimum num of the waiting set is lower than maximum num of the using set
42                // If so, add to the using set, remove from waiting set
43                // update window accordingly
44                waiting.remove(i);
45                int j1 = waiting.first(), j2 = using.last();
46                if(nums[j1] < nums[j2]){
47                    windowSum -= nums[j2];
48                    using.remove(j2);
49                    waiting.add(j2);
50                    
51                    windowSum += nums[j1];
52                    using.add(j1);
53                    waiting.remove(j1);
54                }
55            }
56            
57            result = Math.min(result, windowSum);
58        }
59        return result + nums[0];
60    }
61}
62