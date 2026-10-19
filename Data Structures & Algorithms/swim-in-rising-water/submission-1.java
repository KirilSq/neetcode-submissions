class Solution {
    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));
        int maxElevation = grid[0][0];
        pq.offer(new int[]{0, 0});
        visited[0][0] = false;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            maxElevation = Math.max(grid[row][col], maxElevation);
            if(row == rows - 1 && col == cols - 1){
                break;
            }
            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(areValidCoordinates(newRow, newCol, rows, cols)
                && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    pq.offer(new int[]{newRow, newCol});
                }
                
            }
        }
        return maxElevation;
    }

    private boolean areValidCoordinates(int row, int col, int rows, int cols){
        return 0 <= row && row < rows
        && 0 <= col && col < cols;
    }
}
