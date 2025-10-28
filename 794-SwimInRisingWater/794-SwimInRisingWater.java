// Last updated: 10/29/2025, 3:08:21 AM
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            ans = Math.max(ans, cur[0]);
            int r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return ans;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc])
                    pq.add(new int[]{grid[nr][nc], nr, nc});
            }
        }
        return -1;
    }
}
