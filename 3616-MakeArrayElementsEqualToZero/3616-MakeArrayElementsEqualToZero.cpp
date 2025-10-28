// Last updated: 10/29/2025, 3:15:07 AM
class Solution {
public:
    int countValidSelections(vector<int>& nums) {
        int res = 0;
        int n = nums.size();
        // check for all zeros

        vector<int> left(n , 0);
        vector<int> right(n , 0);

        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            left[i] += left[i - 1] + nums[i];
        }
        for(int i = n - 2; i >= 0 ; i--) {
            right[i] += right[i + 1] + nums[i];
        }

        for(int i = 0; i < n ; i++) {
            if(nums[i] == 0) {
                if(left[i] == right[i]) res += 2;
                else if(abs(left[i] - right[i]) == 1)res += 1;
            }
        }
        
        return res;
        
    }
};