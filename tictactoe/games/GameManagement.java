package games;
import java.util.*;

public class GameManagement {
    private Board board;
    List<Player> players;
    boolean gameStarted;
    int numberOfPlayers;
    int currentPlayerIndex;

    public GameManagement(Board board, List<Player> players, int numberOfPlayers) {
        this.board = board;
        this.players = players;
        this.numberOfPlayers = numberOfPlayers;
        this.currentPlayerIndex = 0;
        this.gameStarted = true;
    }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers;
    }

    public void myTurn(Player player, int row, int col) {
        if (!gameStarted) {
            System.out.println("Game is not started yet.");
            return;
        }

        if (players.get(currentPlayerIndex % numberOfPlayers) != player) {
            System.out.println("It's not your turn!");
            return;
        }

        // Proceed with the player's turn
        board.makeMove(player, row, col);
        switchPlayer();
        checkWinner(player.getSymbol());
    }

    public void checkWinner(char symbol) {
        // Implement winner checking logic
        int n = board.size;
        // Check rows, columns, and diagonals for a winner
        // This is a placeholder for actual winner checking logic
        for(int i=0; i<n; i++){
            int rowCount = 0;
            int colCount = 0;
            int posDiagCount = 0;
            int negDiagCount = 0;

            for(int j=0; j<n; j++){
                if(board.board[i][j] == symbol) rowCount++;
                if(board.board[j][i] == symbol) colCount++;
                if(i == j && board.board[i][j] == symbol) posDiagCount++;
                if(i + j == n - 1 && board.board[i][j] == symbol) negDiagCount++;
                //System.out.print(board.board[i][j] + " ");
            }
            if(rowCount == n || colCount == n || posDiagCount == n || negDiagCount == n){
                System.out.println("Player with symbol " + symbol + " wins!");
                gameStarted = false;
                return;
            }
            //System.out.println();
        }
    }

}
