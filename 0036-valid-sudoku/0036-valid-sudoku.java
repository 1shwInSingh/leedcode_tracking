class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                
                if (ch == '.') {
                    continue;
                }

                int val = ch - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If number already seen in row, column, or 3x3 box
                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                // Mark number as seen
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }

        return true;
    }
}