// Last updated: 12/17/2025, 12:07:09 AM
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += waviness(num);
        }

        return total;
    }

    private int waviness(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        // fewer than 3 digits → no peaks or valleys
        if (n < 3) return 0;

        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';

            // check peak
            if (curr > prev && curr > next) count++;

            // check valley
            else if (curr < prev && curr < next) count++;
        }

        return count;
    }
}
