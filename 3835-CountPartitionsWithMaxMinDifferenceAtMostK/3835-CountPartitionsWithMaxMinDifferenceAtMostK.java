// Last updated: 12/17/2025, 12:07:21 AM
class Solution {
    // 6 6 3 2 1
    int mod = (int)1e9 + 7;
    public int countPartitions(int[] nums, int k) {
        long[] dp = new long[nums.length + 1];
        long sum = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int s = nums.length - 1;
        dp[dp.length - 1] = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(map.lastKey() - map.firstKey() > k){
                Integer c = map.get(nums[s]);
                if(c == 1){
                    map.remove(nums[s]);
                }else{
                    map.put(nums[s], c - 1);
                }
                sum = (sum + mod - dp[s + 1]) % mod;
                s--;
            }
            dp[i] = sum;
            sum += sum;
            sum %= mod;
        }
        
        return (int)(dp[0] % mod);
    }
}