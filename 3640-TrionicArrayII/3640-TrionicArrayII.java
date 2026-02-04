// Last updated: 2/5/2026, 2:46:57 AM
1class Solution {
2
3    public long maxSumTrionic(int[] nums) {
4        
5        int n = nums.length;
6        long res= -1 * (long)1e16;
7
8        for(int i=1;i<n-2;i++){
9
10            int a = i; 
11            int b = i; 
12
13            long net = nums[a];
14
15            while(b+1<n && nums[b+1] < nums[b]){
16                net+=(long)nums[b+1];
17                b++;
18            }
19
20            if(b==a)continue;
21
22            int c= b; 
23
24            long left = 0;
25            long right = 0;
26
27            long lx =Integer.MIN_VALUE;
28            long rx =Integer.MIN_VALUE;
29
30            while(a-1>=0 && nums[a-1] < nums[a]){
31                left+=(long)nums[a-1];
32                lx = Math.max(lx, left);
33                a--;
34            }
35
36            if(a==i)continue;
37
38            while(b+1<n && nums[b+1] > nums[b]){
39                right+=(long)nums[b+1];
40                rx = Math.max(rx, right);
41                b++;
42            }
43
44            if(b==c)continue;
45            i=b-1;
46            res = Math.max( res, lx+rx+net);
47
48        }
49        return res;
50    }
51}