// Last updated: 10/29/2025, 3:06:55 AM
class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String vowels = "aeiou";
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (freq[i] > 0) {
                if (vowels.indexOf(c) != -1) {
                    maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
                } else {
                    maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
                }
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }
}
