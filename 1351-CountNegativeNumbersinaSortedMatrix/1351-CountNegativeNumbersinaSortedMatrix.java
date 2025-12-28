// Last updated: 12/28/2025, 1:00:57 PM
class Solution {
    public int countNegatives(int[][] grid) {
        
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            count += findNegativeNums(grid[i]);
        }
        
        return count;
    }
    
	// simple binary search (our target is first negative number)
    public int findNegativeNums(int[] row) {
        
        int left = 0;
        int right = row.length;
        
        while (left < right) {
            int middle = left + (right - left) / 2;
            
            if (row[middle] < 0) right = middle;
            else left = middle + 1;
        }
        
        return row.length - left;
    }
}