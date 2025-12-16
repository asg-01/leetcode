// Last updated: 12/17/2025, 12:08:03 AM
class Solution
{
    public int findFinalValue(int[] nums, int original)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
            if(i >= original)
                set.add(i);
        while(true)
            if(set.contains(original))
                original *= 2;
            else
                break;
        return original;
    }
}