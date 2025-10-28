// Last updated: 10/29/2025, 3:07:11 AM
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) map.put(p, map.getOrDefault(p, 0L) + p);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = map.get(keys.get(0));
        for (int i = 1; i < n; i++) {
            long val = map.get(keys.get(i));
            dp[i] = dp[i - 1];
            int j = i - 1;
            while (j >= 0 && keys.get(i) - keys.get(j) <= 2) j--;
            long pick = val + (j >= 0 ? dp[j] : 0);
            dp[i] = Math.max(dp[i], pick);
        }
        return dp[n - 1];
    }
}
