// Last updated: 10/29/2025, 3:07:15 AM
import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }
        int count = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) count += f;
        }
        return count;
    }
}
