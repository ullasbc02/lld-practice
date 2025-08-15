package games;

public class Board {
    char[][] board;
    int size;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
    }

    public boolean makeMove(Player player, int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        if (board[row][col] != '\u0000') {
            System.out.println("Cell is already occupied. Try again.");
            return false;
        }

        board[row][col] = player.getSymbol();
        return true;
    }

    public boolean checkWinner(char symbol) {
        // Check rows
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbol) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            boolean colWin = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != symbol) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }

        // Check positive diagonal
        boolean posDiagWin = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                posDiagWin = false;
                break;
            }
        }
        if (posDiagWin) return true;

        // Check negative diagonal
        boolean negDiagWin = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != symbol) {
                negDiagWin = false;
                break;
            }
        }
        return negDiagWin;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char cell = (board[i][j] == '\u0000') ? '-' : board[i][j];
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
