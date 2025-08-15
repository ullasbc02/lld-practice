package games;

public class Board{
    char[][] board;
    int size;
    public Board(int size){
        this.size = size;
        board = new char[size][size];
    }

    public boolean makeMove(Player player, int row, int col){

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

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}