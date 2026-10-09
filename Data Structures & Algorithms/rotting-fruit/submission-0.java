class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;
        //boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    q.offer(new int[]{row, col, 0});
                    //visited[row][col] = true;
                }else if(grid[row][col] == 1){
                    freshCount++;
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int minutes = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            minutes = curr[2];
            for(int[] direction : directions){
                int newRow = curr[0] + direction[0];
                int newCol = curr[1] + direction[1];
                if(newRow >= 0 && newRow < grid.length
                && newCol >= 0 && newCol < grid[0].length
                && grid[newRow][newCol] == 1){
                    freshCount--;
                    grid[newRow][newCol] = 2;
                    q.offer(new int[]{newRow, newCol, minutes + 1});
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
