class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        int count=0;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]==original)
                    count++;
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while(!queue.isEmpty()&&count>0){
            int[] pixel = queue.poll();
            if(image[pixel[0]][pixel[1]]==original) {
                image[pixel[0]][pixel[1]]=color;
                count--;
                for(int j=0;j<directions.length;j++) {
                    int nr=pixel[0]+directions[j][0];
                    int nc=pixel[1]+directions[j][1];
                    if(nr>=0&&nr<image.length&&nc>=0&&nc<image[0].length)
                        queue.add(new int[]{nr,nc});
                }
            }
    
        }
        return image;
    }
}