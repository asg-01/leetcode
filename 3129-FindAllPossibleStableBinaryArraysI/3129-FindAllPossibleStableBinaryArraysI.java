// Last updated: 3/10/2026, 7:54:25 PM
1class Solution {
2    static final int mod=(int)1e9+7;
3    public int numberOfStableArrays(int zero, int one, int limit) {
4        int[][][]arr=new int[201][201][2];
5        for(int i=0;i<201;i++){
6            for(int j=0;j<201;j++){
7                arr[i][j][0]=-1;
8                arr[i][j][1]=-1;
9            }
10        }
11        int zeroCase=helper(zero,one,0,limit,arr)%mod;
12        int oneCase=helper(zero,one,1,limit,arr)%mod;
13        return (zeroCase+oneCase)%mod;
14    }
15    public static int helper(int zeroLeft,int oneLeft,int lastWasOne,int limit,int[][][]dp){
16        if(oneLeft==0&&zeroLeft==0)return 1;
17        if(dp[oneLeft][zeroLeft][lastWasOne]!=-1)return dp[oneLeft][zeroLeft][lastWasOne];
18        long ans=0;
19        if(lastWasOne==1){
20            //explore 0
21            for(int i=1;i<=limit&&zeroLeft-i>=0;i++){
22                ans =(ans+helper(zeroLeft-i,oneLeft,0,limit,dp))%mod;
23            }
24        }else{
25            for(int i=1;i<=limit&&oneLeft-i>=0;i++){
26                ans=(ans+helper(zeroLeft,oneLeft-i,1,limit,dp))%mod;
27            }
28        }
29        return dp[oneLeft][zeroLeft][lastWasOne]=(int)ans;
30    }
31}