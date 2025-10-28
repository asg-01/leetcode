// Last updated: 10/29/2025, 3:08:37 AM
class Solution {
    public int[] plusOne(int[] digits) {
        // Get the length of the array
        int n = digits.length;

        // Iterate from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;
            
            // If the digit is less than 10, there's no carry. We're done!
            if (digits[i] < 10) {
                return digits;
            }
            
            // If the digit became 10, set it to 0 and the loop will carry over to the next digit
            digits[i] = 0;
        }
        
        // If we get here, it means the original number was all 9s (e.g., 9, 99, 999)
        // We need a new array with one more digit
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; // Set the first digit to 1
        
        return newNumber;
    }
}