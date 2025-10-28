// Last updated: 10/29/2025, 3:08:42 AM
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) max = area;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
