class Solution {

    int m,n,l;
    HashMap<Integer,int[]> map;
    int[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        
        this.m = m;
        this.n = n;
        this.l = strs.length;
        memo = new int[l+1][m+1][n+1];

        for(int[][] x : memo){
            for(int[] y : x){
                Arrays.fill(y,-1);
            }
        }

        map = new HashMap<>();
        for(int i = 0;i<l;i++){

            String s = strs[i];
            int zeroCount = 0;
            int oneCount = 0;

            for(int j = 0;j<s.length();j++){

                char x = s.charAt(j);
                if(x == '0'){
                    zeroCount++;
                }else{
                    oneCount++;
                }
            }

            map.put(i,new int[]{zeroCount,oneCount});
        }

        return helper(strs,0,0,0);

    }

    public int helper(String [] strs , int index , int zeros , int ones){
        
        if(memo[index][zeros][ones] != -1){
            return memo[index][zeros][ones];
        }

        if(index >= l){
            return 0;
        }

        if(zeros == m && ones == n){
            return 0;
        }

        if(zeros > m || ones > n)return 0;

        int[] arr = map.get(index);
        int zeroC = arr[0];
        int oneC = arr[1];

        int take = 0;
        int skip = 0;

        if(zeros + zeroC <= m && ones + oneC <= n){
            take = 1 + helper(strs,index+1,zeros + zeroC, ones + oneC);
            skip = helper(strs,index+1,zeros,ones);
        }
    
        skip = helper(strs,index+1,zeros,ones);
        

        return memo[index][zeros][ones] = Math.max(take,skip);
    }
}