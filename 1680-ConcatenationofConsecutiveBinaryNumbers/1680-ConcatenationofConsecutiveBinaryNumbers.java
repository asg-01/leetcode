// Last updated: 2/28/2026, 11:48:25 PM
1class Solution {
2  public int concatenatedBinary(int n) {
3    final int MOD = 1_000_000_007;
4    long ans = 0;
5
6    for (int i = 1; i <= n; ++i)
7      ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;
8
9    return (int) ans;
10  }
11
12  private int numberOfBits(int n) {
13    return (int) (Math.log(n) / Math.log(2)) + 1;
14  }
15}