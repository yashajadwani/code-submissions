class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        n=len(grid)
        visit= set()
        direction=[[1,0],[-1,0],[0,1],[0,-1]]
        def dfs(r,c):
            if(r<0 or r==n or c<0 or c==n or (r,c) in visit or 
                not grid[r][c]):
                return
            visit.add((r,c))
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c+1)
            dfs(r,c-1)
        
        def bfs():
            queue=deque(visit)
            res = 0
            while queue:
                q_len = len(queue)
                for i in range(q_len):
                    r,c = queue.popleft()
                    for dr,dc in direction:
                        cur_r = r+dr
                        cur_c = c+dc
                        if (cur_r<0 or cur_r==n or cur_c<0 or cur_c==n or (cur_r,cur_c) in visit):
                            continue
                        if grid[cur_r][cur_c]:
                            return res
                        visit.add((cur_r,cur_c))
                        queue.append([cur_r,cur_c])
                res+=1
        
        for i in range(n):
            for j in range(n):
                if grid[i][j]:
                    dfs(i,j)
                    return bfs()