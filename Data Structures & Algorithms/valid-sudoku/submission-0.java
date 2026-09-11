class Solution {
        private static final int BOARD_SIZE = 9;
        private static final Character EMPTY_CHARACTER = '.';

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];
        for (int i = 0; i < BOARD_SIZE; i++) {
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            Set<Character> rowSet = new HashSet<>();
            for (int col = 0; col < BOARD_SIZE; col++){
                Character ch = board[row][col];
                if(ch.equals(EMPTY_CHARACTER)) {
                    continue;
                }
                int currSquareIndex = (row/3)*3 + col/3;
                if(rowSet.contains(ch)
                        || cols[col].contains(ch)
                        || squares[currSquareIndex].contains(ch)
                ){
                    return false;
                }else {
                    rowSet.add(ch);
                    cols[col].add(ch);
                    squares[currSquareIndex].add(ch);
                }
            }
        }

        return true;
    }
}
