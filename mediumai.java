public class mediumai extends player {
    public mediumai(String name) {
        this.name = name;
        this.mark = 'o';
    }

    void makemove() {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1; // Initialize bestMove to an invalid value

        for (int move = 0; move < 9; move++) {
            int row = move / 3;
            int col = move % 3;

            if (isvalidmove(row, col)) {
                tictactoe.arr[row][col] = 'o';
                int score = minimax(tictactoe.arr, false);
                tictactoe.arr[row][col] = ' ';

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = move;
                }
            }
        }

        int bestRow = bestMove / 3;
        int bestCol = bestMove % 3;
        tictactoe.place(bestRow, bestCol, 'o');
    }

    int minimax(char[][] board, boolean maximizing) {
        if (tictactoe.checkwin()) {
            int sum = countEmptyCells(board);
            return (tictactoe.whowon == 'x') ? -1 * (sum + 1) : 1 * (sum + 1);
        }

        if (tictactoe.checkdraw()) {
            return 0;
        }

        int bestScore = maximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!tictactoe.checkwin() && isvalidmove(i, j)) {
                    char playerMark = maximizing ? 'o' : 'x';
                    board[i][j] = playerMark;

                    int score = minimax(board, !maximizing);
                    board[i][j] = ' ';

                    if ((maximizing && score > bestScore) || (!maximizing && score < bestScore)) {
                        bestScore = score;
                    }
                }
            }
        }

        return bestScore;
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
}
