// Last updated: 1/1/2026, 5:33:01 AM
1class Solution {
2    public int[] plusOne(int[] digits) {
3        // Get the length of the array
4        int n = digits.length;
5
6        // Iterate from the last digit to the first
7        for (int i = n - 1; i >= 0; i--) {
8            // Increment the current digit
9            digits[i]++;
10            
11            // If the digit is less than 10, there's no carry. We're done!
12            if (digits[i] < 10) {
13                return digits;
14            }
15            
16            // If the digit became 10, set it to 0 and the loop will carry over to the next digit
17            digits[i] = 0;
18        }
19        
20        // If we get here, it means the original number was all 9s (e.g., 9, 99, 999)
21        // We need a new array with one more digit
22        int[] newNumber = new int[n + 1];
23        newNumber[0] = 1; // Set the first digit to 1
24        
25        return newNumber;
26    }
27}