class Solution {
    private boolean[] cols;
    private boolean[] posDiag;
    private boolean[] negDiag;

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        List<List<String>> res = new ArrayList<>();
        int[] queenPositions = new int[n];
        dfs(res, queenPositions, 0, n);
        return res;
    }

    private List<String> transform(int[] queenPositions) {
        int n = queenPositions.length;
        List<String> board = new ArrayList<>(n);

        for (int r = 0; r < n; r++) {
            char[] rowChars = new char[n];
            Arrays.fill(rowChars, '.'); 
            rowChars[queenPositions[r]] = 'Q'; 
            board.add(new String(rowChars));
        }

        return board;
    }

    private void dfs(List<List<String>> res, int[] queenPositions, int row, int n) {
        if (row == n) {
            res.add(this.transform(queenPositions));
        } else {
            for (int col = 0; col < n; col++) {
                if (cols[col] || posDiag[row + col] || negDiag[row - col + n]) {
                    continue;
                }

                cols[col] = true;
                posDiag[row + col] = true;
                negDiag[row - col + n] = true;
                queenPositions[row] = col;

                dfs(res, queenPositions, row + 1, n);

                cols[col] = false;
                posDiag[row + col] = false;
                negDiag[row - col + n] = false;
                queenPositions[row] = -1;
            }
        }
    }
}
