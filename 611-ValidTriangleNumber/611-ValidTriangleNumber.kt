// Last updated: 10/29/2025, 3:08:30 AM
class Solution {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var count = 0
        for (i in nums.size - 1 downTo 2) {
            var l = 0
            var r = i - 1
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l
                    r--
                } else {
                    l++
                }
            }
        }
        return count
    }
}
