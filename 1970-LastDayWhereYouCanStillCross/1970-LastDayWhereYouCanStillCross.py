# Last updated: 12/31/2025, 6:11:57 AM
1class Solution:
2    def isPossible(self, row, col, cells, day):
3        grid = [[0] * col for _ in range(row)]
4        queue = collections.deque()
5        
6        for r, c in cells[:day]:
7            grid[r - 1][c - 1] = 1
8            
9        for i in range(col):
10            if not grid[0][i]:
11                queue.append((0, i))
12                grid[0][i] = -1
13
14        while queue:
15            r, c = queue.popleft()
16            if r == row - 1:
17                return True
18            for dr, dc in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
19                nr, nc = r + dr, c + dc
20                if 0 <= nr < row and 0 <= nc < col and grid[nr][nc] == 0:
21                    grid[nr][nc] = -1
22                    queue.append((nr, nc))
23                    
24        return False
25    
26    
27    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
28        left, right = 1, row * col
29        
30        while left < right:
31            mid = right - (right - left) // 2
32            if self.isPossible(row, col, cells, mid):
33                left = mid
34            else:
35                right = mid - 1
36                
37        return left