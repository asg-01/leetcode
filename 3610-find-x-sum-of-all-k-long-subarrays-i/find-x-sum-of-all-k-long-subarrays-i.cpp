class Solution {
public:
    vector<int> findXSum(vector<int>& nums, int k, int x) {
        
        
        int n=nums.size();
        vector<int>ans(n-k+1,0);
        vector<int>freq(51,0);
        for(int i=0;i<k;i++)
        {
            freq[nums[i]]++;
        }
        priority_queue<pair<int,int>> pq;
        for(int i=0;i<=50;i++)
        {
            if( freq[i] > 0 )
                pq.push( pair<int,int>(freq[i], i ) );
        }
        pair<int,int>temp;
        int xsum=0;
        for(int i=0;i<x&& !pq.empty();i++)
        {
            temp=pq.top();
            pq.pop();
            xsum+=temp.first*temp.second;
        }
        ans[0]=xsum;
        for(int i=1;i<n-k+1;i++)
        {
            freq[nums[i-1]]--;
            freq[nums[k+i-1]]++;
            priority_queue<pair<int,int>>pqn;
            for(int k=0;k<=50;k++)
            {
                if(freq[k]>0)
                pqn.push({freq[k],k});
            }
            pair<int,int>tm;
            int sum=0;
            for(int j=0;j<x&&pqn.size();j++)
            {
                tm=pqn.top();
                pqn.pop();
                sum+=tm.first*tm.second;
            }
            ans[i]=sum;
        }
        return ans;
    }
};