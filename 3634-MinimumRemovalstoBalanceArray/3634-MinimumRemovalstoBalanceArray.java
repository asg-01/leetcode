// Last updated: 2/7/2026, 11:33:38 AM
class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0, maxsize = 0;
        for (int r = 0; r < n; r++) {
            while (l <= r && (long) nums[r] > (long) nums[l] * k)
                l++;
            if (r - l + 1 > maxsize) 
                maxsize = r - l + 1;
        }
        return n - maxsize;
    }
}