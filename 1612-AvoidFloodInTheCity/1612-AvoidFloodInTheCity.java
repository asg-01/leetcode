// Last updated: 10/29/2025, 3:07:42 AM
import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dry.add(i);
                res[i] = 1;
            } else {
                res[i] = -1;
                if (full.containsKey(rains[i])) {
                    Integer d = dry.higher(full.get(rains[i]));
                    if (d == null) return new int[0];
                    res[d] = rains[i];
                    dry.remove(d);
                }
                full.put(rains[i], i);
            }
        }
        return res;
    }
}
