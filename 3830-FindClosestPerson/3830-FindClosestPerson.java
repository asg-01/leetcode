// Last updated: 10/29/2025, 3:06:54 AM
class Solution {
    public int findClosest(int x, int y, int z) {
        int distX = Math.abs(x - z);
        int distY = Math.abs(y - z);


        if (distX == distY){
            return 0;
        }

        if (distX > distY) {
            return 2;

        } else {
            return 1;
        }

    }
}