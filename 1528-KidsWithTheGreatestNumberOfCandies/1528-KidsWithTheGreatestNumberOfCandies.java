// Last updated: 10/29/2025, 3:15:19 AM
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(Integer.MIN_VALUE);
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                results.add(true);
            } else {
                results.add(false);
            }

        }
        return results;

    }
}
