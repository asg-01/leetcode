// Last updated: 10/29/2025, 3:08:38 AM
class Solution {
    public boolean canJump(int[] nums) {
        int finalposi = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= finalposi) {
                finalposi = i;
            }
        }

        
        return finalposi == 0;
    }
}
