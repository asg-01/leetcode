// Last updated: 10/29/2025, 3:07:03 AM
class Solution {
public:
    int maxFrequency(vector<int>& nums, int k, int numOperations) {
        vector<pair<int,int>> check;
        sort(nums.begin(),nums.end());
        unordered_map<int,int> mp;
        int hg = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++){
            check.push_back({max(nums[i] - k,0), nums[i] + k});
            hg = max(hg, nums[i]);
            mp[nums[i]] += 1;
        }
        int i = 0;
        int j = 0;
        int mx = check[0].first;
        int ans = 1;
        int count = 0;
        while(mx <= hg){
            while(j < n && check[j].first <= mx){
                j++;
            }
            while(i < j && check[i].second < mx){
                i++;
            }
            if(j-i <= numOperations){
                ans = max(ans, j - i);
            }else{
                int ch = j - i;
                int cn = mp[mx];
                ans = max(ans, min(ch, cn + numOperations));
            }
            if((j-i == 1) && j < n){
                mx = check[j].first;
                j++;
            }else{
                mx += 1;
            }
        }
        return ans;
    }
};