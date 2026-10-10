class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> q = new LinkedList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacificReachable = new boolean[rows][cols];
        prepareStartingQueue(q, pacificReachable, heights, rows, cols, 0, 0);
        bfs(q, heights, rows, cols, pacificReachable);
        boolean[][] atlanticReachable = new boolean[rows][cols];
        prepareStartingQueue(q, atlanticReachable, heights, rows, cols, rows - 1, cols - 1);
        bfs(q, heights, rows, cols, atlanticReachable);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(pacificReachable[row][col] && atlanticReachable[row][col]){
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    private void prepareStartingQueue(Queue<int[]> q, boolean[][] reachable, int[][] heights, int rows, int cols, int row, int col){
        for(int i = 0; i < rows; i++){
            reachable[i][col] = true;
            q.offer(new int[]{i, col});
        }
        for(int i = 0; i < cols; i++){
            reachable[row][i] = true;
            q.offer(new int[]{row, i});
        }
    }


    private void bfs(Queue<int[]> startingPoints, int[][] heights, int rows, int cols, boolean[][] reachable){
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!startingPoints.isEmpty()){
            int[] cur = startingPoints.poll();
            int row = cur[0];
            int col = cur[1];
            for(int[] direction : directions) {
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];
                if(isInRange(newRow, 0, rows)
                && isInRange(newCol, 0, cols)
                && heights[row][col] <= heights[newRow][newCol]
                && !reachable[newRow][newCol]){
                    reachable[newRow][newCol] = true;
                    startingPoints.offer(new int[]{newRow, newCol});
                }
            }
            
        }
    }

    private boolean isInRange(int value, int lowerBound, int upperBound){
        return value >= lowerBound && value < upperBound;
    }
}
