// Last updated: 12/17/2025, 12:08:04 AM
class Solution {

    private boolean canFit(int n, long k, int[] batteries) {
        long currBatSum = 0;
        long target = n * k;

        for (int bat : batteries) {
            if (bat < k) {
                currBatSum += bat;
            } else {
                currBatSum += k;
            }

            if (currBatSum >= target) {
                return true;
            }
        }

        return currBatSum >= target;

    }

    public long maxRunTime(int n, int[] batteries) {
        long batSum = 0;
        for (int bat : batteries) {
            batSum += bat;
        }
        
        long lower = 0;
        long upper = batSum / n;
        long res = -1;

		// binary search
        while (lower <= upper) {
            long mid = lower + (upper - lower) / 2;

            if (canFit(n, mid, batteries)) {
                res = mid;
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        return res;
    }
}