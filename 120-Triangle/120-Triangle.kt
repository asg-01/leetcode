// Last updated: 10/29/2025, 3:08:34 AM
class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = triangle.last().toMutableList()
        for (i in triangle.size - 2 downTo 0) {
            for (j in 0..i) {
                dp[j] = triangle[i][j] + minOf(dp[j], dp[j + 1])
            }
        }
        return dp[0]
    }
}
