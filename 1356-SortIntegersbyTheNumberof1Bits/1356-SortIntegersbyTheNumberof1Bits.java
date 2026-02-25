// Last updated: 2/26/2026, 12:45:08 AM
1public class Solution {
2    public int[] sortByBits(int[] arr) {
3        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
4        Arrays.sort(boxedArray, (a, b) -> {
5            int countA = Integer.bitCount(a);
6            int countB = Integer.bitCount(b);
7            return countA == countB ? a - b : countA - countB;
8        });
9        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
10    }
11}