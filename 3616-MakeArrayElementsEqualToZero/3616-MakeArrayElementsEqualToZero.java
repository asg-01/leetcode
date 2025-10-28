// Last updated: 10/29/2025, 3:15:04 AM
class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length, c=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == 0)
            {
                int temp[]=Arrays.copyOf(nums, n);
                if(solve(temp, i, 1))
                    c++;
                temp=Arrays.copyOf(nums, n);
                if(solve(temp, i, -1))
                    c++;
            }
        }
        return c;
    }
    public boolean solve(int nums[], int curr, int dir)
    {
        if(curr<0 || curr>=nums.length)
        {
            for(int i=0; i<nums.length; i++)
                if(nums[i] != 0)
                    return false;
            return true;
        }

        if(nums[curr] == 0)
            return solve(nums, curr+dir, dir);
        else
        {
            nums[curr]--;
            if(dir == 1)
                dir=-1;
            else
                dir=1;
            return solve(nums, curr+dir, dir);
        }
    }
}