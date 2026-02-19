// Last updated: 2/20/2026, 12:24:41 AM
class Solution {
public int countBinarySubstrings(String s) {
if (s == null || s.length() == 0) return 0;
        int preRun = 0;
        int curRun =1;
        int count = 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1)) curRun++;
            else {
                preRun = curRun;
                curRun = 1;
            }
            if (preRun >= curRun) count++;
        }
        return count;
    }
}