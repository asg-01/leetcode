// Last updated: 12/17/2025, 12:07:14 AM
class Solution {
    int getMoves(int[] nums,int digit){
        int n = nums.length;
        int moves = 0;
        //to point to the updated next value in array
        int next = nums[0];
        for(int i = 0;i<n-1;i++){
            if(next== digit){
                next = nums[i+1]*-1;
                moves++;
            }
            else next = nums[i+1];
        }
        return (next == digit?Integer.MAX_VALUE:moves);
    }
    public boolean canMakeEqual(int[] nums, int k) {
        //get moves if the elements in array are to be all 1
        int a = getMoves(nums,1);
        //get moves if the elements in array are to be all -1
        int b = getMoves(nums,-1);
        //check the given condition
        return Math.min(a,b)<=k;
    }
}

