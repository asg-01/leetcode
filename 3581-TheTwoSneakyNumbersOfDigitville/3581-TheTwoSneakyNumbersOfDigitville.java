// Last updated: 10/31/2025, 10:48:10 PM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int index = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]) res[index++] = nums[i];
            }
        }

        return res;
    }
}