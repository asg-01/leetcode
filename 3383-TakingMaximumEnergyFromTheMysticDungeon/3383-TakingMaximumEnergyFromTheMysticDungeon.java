// Last updated: 10/29/2025, 3:07:12 AM
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i];
            if (i + k < n) dp[i] += dp[i + k];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
