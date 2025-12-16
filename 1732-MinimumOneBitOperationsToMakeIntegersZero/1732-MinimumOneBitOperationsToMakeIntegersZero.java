// Last updated: 12/17/2025, 12:08:15 AM
class Solution {
    public int minimumOneBitOperations(int n) {
        int result = 0;
        while (n > 0) {
            result ^= n;
            n = n >> 1;
        }
        
        return result;
    }
}