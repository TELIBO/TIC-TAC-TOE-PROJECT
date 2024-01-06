public class HardAI extends player {
    public HardAI(String name) {
        this.name = name;
        this.mark = 'o';
    }

    void makemove() {
        int[] result = minimax(tictactoe.arr, true);
        tictactoe.place(result[1], result[2], 'o');
    }

    int[] minimax(char[][] board, boolean maximizing) {
        int[] result = new int[] { maximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE, -1, -1 };

        if (tictactoe.checkwin()) {
            int sum = countEmptyCells(board);
            if (tictactoe.whowon == 'x') {
                return new int[] { -1 * (sum + 1), -1, -1 };
            } else if (tictactoe.whowon == 'o') {
                return new int[] { 1 * (sum + 1), -1, -1 };
            }
        } else if (tictactoe.checkdraw()) {
            return new int[] { 0, -1, -1 };
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isvalidmove(board, i, j)) {
                    board[i][j] = maximizing ? 'o' : 'x';
                    int[] score = minimax(board, !maximizing);
                    board[i][j] = ' ';

                    if ((maximizing && score[0] > result[0]) || (!maximizing && score[0] < result[0])) {
                        result[0] = score[0];
                        result[1] = i;
                        result[2] = j;
                    }
                }
            }
        }

        return result;
    }

    private int countEmptyCells(char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isvalidmove(char[][] board, int row, int col) {
        return board[row][col] == ' ';
    }
}
