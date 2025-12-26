// Last updated: 12/27/2025, 2:08:34 AM
1public class Solution {
2    public int bestClosingTime(String customers) {
3        int max_score = 0, score = 0, best_hour = -1;
4        for(int i = 0; i < customers.length(); ++i) {
5            score += (customers.charAt(i) == 'Y') ? 1 : -1;
6            if(score > max_score) {
7                max_score = score;
8                best_hour = i;
9            }
10        }
11        return best_hour + 1;
12    }
13}