// Last updated: 10/29/2025, 3:07:14 AM
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            empty -= numExchange;
            numExchange++;
            ans++;
            empty++;
        }
        return ans;
    }
}
