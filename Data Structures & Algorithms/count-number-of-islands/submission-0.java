class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue;
        int count=0;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]) {
                    queue = new LinkedList<>();
                    count ++;
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                    while(!queue.isEmpty()) {
                        int[] node = queue.remove();
                        for(int k=0;k<directions.length;k++){
                            int nr=directions[k][0]+node[0];
                            int nc=directions[k][1]+node[1];
                            if(nr>=0 && nr<grid.length && 
                                nc>=0 && nc<grid[0].length &&
                                !visited[nr][nc] && 
                                grid[nr][nc]=='1') {
                                    queue.add(new int[]{nr,nc});
                                    visited[nr][nc]=true;
                                }
                        }
                    }
                    
                }
            }
        }
          return count;
    }
}
