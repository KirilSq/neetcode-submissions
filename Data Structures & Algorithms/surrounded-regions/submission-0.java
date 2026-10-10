class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        visitStartingPoints(board, rows, cols, visited, q);
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(isInRange(newRow, 0, rows)
                && isInRange(newCol, 0, cols)
                && !visited[newRow][newCol]){
                    addIfCircle(board, newRow, newCol, visited, q);
                }
            }
        }
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(!visited[row][col] && board[row][col] == 'O'){
                    board[row][col] = 'X';
                }
            }
        }
    }
    
    private void visitStartingPoints(char[][] board, int rows, int cols,
     boolean[][] visited, Queue<int[]> q){
        //Upper edge
        for(int col = 0; col < cols; col++){
            addIfCircle(board, 0, col, visited, q);
        }
        //Side edges
        for(int row = 1; row < rows - 1; row++){
            addIfCircle(board, row, 0, visited, q);
            addIfCircle(board, row, cols - 1, visited, q);
        }
        //Bottom edge
        for(int col = 0; col < cols; col++){
            addIfCircle(board, rows-1, col, visited, q);
        }
     }

     private void addIfCircle(char[][] board, int row, int col, boolean[][] visited, Queue<int[]> q){
        if(board[row][col] == 'O'){
            visited[row][col] = true;
            q.offer(new int[]{row, col});
        }
     }
     private boolean isInRange(int value, int lowerBound, int upperBound){
        return value >= lowerBound && value < upperBound;
    }
}
