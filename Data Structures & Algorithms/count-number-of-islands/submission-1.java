class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1'){
                    result++;
                    bfs(grid, row, col, rows, cols);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int row, int col, int rows, int cols){
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        grid[row][col] = '0';
        while(!q.isEmpty()){
            int[] coord = q.poll();
            for(int[] dir : directions){
                int newRow = coord[0] + dir[0];
                int newCol = coord[1] + dir[1];
                if(isInBounds(newRow, newCol, rows, cols) 
                && grid[newRow][newCol] == '1'){
                    q.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }

    private boolean isInBounds(int i, int j, int rows, int cols){
        return i >= 0 && i < rows
        && j >= 0 && j < cols;
    }

}
