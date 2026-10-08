class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //Idea: simulate starting bfs from a fictive node that connects to each treasure
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()){
            int[] node = q.poll();
            int val = grid[node[0]][node[1]];
            for(int[] direction : directions){
                int row = node[0] + direction[0];
                int col = node[1] + direction[1];
                if(row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && val + 1 < grid[row][col]){
                    grid[row][col] = val + 1;
                    q.offer(new int[]{row, col});
                }
            }
        }

    }
}
