// Last updated: 10/29/2025, 3:08:15 AM
import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // make a copy of heights
        int[] ss = Arrays.copyOf(heights, heights.length);

        // sort the copy
        Arrays.sort(ss);

        // count mismatches
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ss[i]) {
                count++;
            }
        }

        return count;
    }
}
