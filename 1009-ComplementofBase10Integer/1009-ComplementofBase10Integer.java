// Last updated: 3/12/2026, 1:58:27 AM
1class Solution {
2    public int bitwiseComplement(int n) {
3        if(n == 0) return 1; // Checking for base case
4        int res = 0;
5        int fac = 1; // keep for 2 basically
6        
7        while(n != 0){
8            // first we need to check what is our bit in 2 by taking modulo
9            res += fac * (n % 2 == 0 ? 1 : 0);
10            // res is the number convert back to decimal + factor * n % 2 if comes 0 then we take 1 otherwise 0 this is our complement
11            
12            fac *= 2;
13            n /= 2;
14        }
15        return res;
16    }
17}