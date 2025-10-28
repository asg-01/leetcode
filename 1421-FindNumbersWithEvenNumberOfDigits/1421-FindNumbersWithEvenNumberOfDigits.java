// Last updated: 10/29/2025, 3:15:21 AM
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
           if (String.valueOf(num).length()% 2 ==0){
            count ++ ; 

           }
               
            
            
        }return count;
    }
}