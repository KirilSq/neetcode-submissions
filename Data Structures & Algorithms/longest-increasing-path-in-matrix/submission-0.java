class Solution {
    private int[][] directions = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int row = 0; row < rows; row++){
            Arrays.fill(dp[row], -1);
        }
        int result = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                result = Math.max(result, dfs(dp, matrix, rows, cols, row, col));
            }
        }
        return result;
    }
    private int dfs(int[][] dp,int[][] matrix, int rows, int cols, int row, int col){
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int optimal = 0;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(0 <= newRow && newRow < rows 
            && 0 <= newCol && newCol < cols
            && matrix[row][col] < matrix[newRow][newCol]){
                optimal = Math.max(optimal, dfs(dp, matrix, rows, cols, newRow, newCol));
            }
        }

        return dp[row][col] = optimal + 1;
    }
}
