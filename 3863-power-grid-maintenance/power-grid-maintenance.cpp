class Solution {
public:
    vector<bool>vis = vector<bool>(100001);
    map<int,int>mp;
    vector<set<int>> vs;
    vector<vector<int>> df{100001};

    void dfs(int x, set<int>& curTree, int &ctr) {
        if(!vis[x]){
            curTree.insert(x);
            mp[x]=ctr;
        } 
        vis[x]=true;
        for(auto a: df[x]){
            if(!vis[a]){
                dfs(a,curTree,ctr);
            }
        }
    }

    vector<int> processQueries(int c, vector<vector<int>>& connections, vector<vector<int>>& queries) {
        vector<int> ans;

        // cout<<df.size()<<"\n";

        for(auto x: connections){
            df[x[0]].push_back(x[1]);
            df[x[1]].push_back(x[0]);
        }

        // for(int i=0;i<=c;i++){
        //     cout<<"\n" << i<< " ";
        //     for(auto x: df[i]){
        //         cout<<x<<" ";
        //     }
        // }   
        int ctr=1;     
        for(int i=1;i<=c;i++){
            // not recommended since it will initalized always the set
            // set<int> s;
            // dfs(i,s,ctr);
            // if(s.size()>0){
            //     vs.push_back(s);
            //     ctr++;
            // }
            //recommended by AI
            if(!vis[i]){
                // 1. Create the final set in place
                vs.push_back(set<int>()); 
                
                // 2. Fill the final set directly. 
                //    vs.back() gets a reference to the last element (the new set).
                dfs(i, vs.back(), ctr); 
                
                // 3. Increment component ID
                ctr++;
            }
            // cout<<s.size()<<"\n";
        }
        // for(auto x: mp){
        //     cout<<x.second<<"\n";
        // }
        // cout<<vs.size()<<"\n";

        for (int i=0;i<queries.size();i++){
            int val = queries[i][1];
            int findset= mp[val]-1;

            // cout<<val<< " "<<findset <<"\n"; 
            if(queries[i][0]==1){
                int check= vs[findset].count(val);
                if (check) ans.push_back(val);
                else if (vs[findset].size()) ans.push_back(*vs[findset].begin());
                else ans.push_back(-1);
            } else{
                vs[findset].erase(val);
            }
        }

        return ans;
    }
};