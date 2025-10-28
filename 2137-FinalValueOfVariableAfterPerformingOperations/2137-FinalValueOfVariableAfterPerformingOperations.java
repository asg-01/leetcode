// Last updated: 10/29/2025, 3:07:30 AM
class Solution {
    public int finalValueAfterOperations(String[] op) {
        int res = 0;
        
        for(int i = 0;i< op.length;i++)
            if(op[i].charAt(1) == '+')res++;
            else res--;
        
        return res;
    }
}