// Last updated: 10/29/2025, 3:06:58 AM
class Solution {
    static final int MOD = 1_000_000_007;
    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int B = n + 20;
        int[] fact = new int[m + 1];
        int[] invFact = new int[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) 
            fact[i] = (int)((long)fact[i - 1] * i % MOD);
        invFact[m] = modPow(fact[m], MOD - 2);
        for (int i = m; i >= 1; i--) 
            invFact[i - 1] = (int)((long)invFact[i] * i % MOD);
        int[][][] dp = new int[m + 1][m + 1][k + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < B; i++) {
            int[][][] ndp = new int[m + 1][m + 1][k + 1];

            int[] terms = new int[m + 1];
            if (i < n) {
                long base = (nums[i] % MOD + MOD) % MOD;
                terms[0] = invFact[0];
                for (int t = 1; t <= m; t++) {
                    terms[t] = (int)((long)terms[t - 1] * base % MOD);
                }
                for (int t = 0; t <= m; t++) {
                    terms[t] = (int)((long)terms[t] * invFact[t] % MOD);
                }
            }

            for (int c = 0; c <= m; c++) {
                for (int s = 0; s <= m; s++) {
                    if (i >= n && s != m) 
                        continue;
                    for (int bits = 0; bits <= k; bits++) {
                        int cur = dp[c][s][bits];
                        if (cur == 0) 
                            continue;
                        if (i < n) {
                            int maxT = m - s;
                            for (int t = 0; t <= maxT; t++) {
                                int total = c + t;
                                int newC = total / 2;
                                int newBit = total % 2;
                                int newBits = bits + newBit;
                                if (newBits > k) 
                                    continue;
                                ndp[newC][s + t][newBits] = (int)((ndp[newC][s + t][newBits] + (long)cur * terms[t]) % MOD);
                            }
                        } else {
                            int total = c;
                            int newC = total / 2;
                            int newBit = total % 2;
                            int newBits = bits + newBit;
                            if (newBits <= k) {
                                ndp[newC][s][newBits] = (ndp[newC][s][newBits] + cur) % MOD;
                            }
                        }
                    }
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int c = 0; c <= m; c++) {
            int popc = Integer.bitCount(c);
            for (int bits = 0; bits <= k; bits++) {
                if (popc + bits == k) {
                    ans += dp[c][m][bits];
                    if (ans >= MOD) ans -= MOD;
                }
            }
        }
        ans = ans * fact[m] % MOD;
        return (int)ans;
    }

    private int modPow(long a, long e) {
        a %= MOD;
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return (int)r;
    }
}