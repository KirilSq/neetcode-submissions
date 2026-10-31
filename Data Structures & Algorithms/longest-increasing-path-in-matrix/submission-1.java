class Solution {
    // Shared constants: zero allocation per call
    private static final int[] DIRS = {0, 1, 0, -1, 0};

    private int[][] matrix;
    private int[][] dp;
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.dp = new int[rows][cols]; 

        int maxLen = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxLen = Math.max(maxLen, dfs(r, c));
            }
        }
        return maxLen;
    }

    private int dfs(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int maxPath = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + DIRS[i];
            int nc = c + DIRS[i + 1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                maxPath = Math.max(maxPath, 1 + dfs(nr, nc));
            }
        }

        return dp[r][c] = maxPath;
    }
}